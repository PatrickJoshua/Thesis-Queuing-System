
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PatrickJoshua
 */
public class Common {
    
    public static int ref;
    
    public static int generateReferenceNo()
    {
        Random random = new Random();
        return random.nextInt(999999999);       //9 digit random number
    }
    
    public static Connection connectToDatabase(String host, String user, String pw)
    {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection(host, user, pw);
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle.getMessage());
        }
        return con;
    }
    
    public static void add2History(Connection con, int num, String cellNo, boolean vip, int ref, String name, String trans, Boolean sms)
    {
        try
        {
            PreparedStatement ps = con.prepareStatement("insert into RECORDSHISTORY values (" + num + ",'" + cellNo + "'," + vip + "," + ref + ",'" + name + "',?,?,'" + trans + "'," + sms + ")");
            
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());  //get current date
            ps.setDate(1, sqlDate);     //set date on SQL statement
            
            java.sql.Time sqlTime = new java.sql.Time(new java.util.Date().getTime());  //get current time
            ps.setTime(2, sqlTime);     //set time on SQL statement
            
            ps.executeUpdate();     //execute SQL statement
            ps.close();
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle.getMessage());
        }
    }
    
    public static int getLastNumber(Connection con, boolean vip)
    {
        int lastNumber = 0;
        try
        {
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            PreparedStatement ps = con.prepareStatement("select NUM from RECORDSHISTORY where DATE=? AND VIP=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ps.setDate(1, sqlDate);
            ps.setBoolean(2, vip);
            ResultSet rs = ps.executeQuery();
            if(rs.last())
                lastNumber = rs.getInt("NUM");
            ps.close();
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle.getMessage());
        }
        return lastNumber;
    }
    
    public static int add2DB(Connection con, String cellNo, String name, boolean vip, String trans, boolean sms)
    {
        int lastNumber = 0;     //holds the last number in the DB
            
        try
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM QUEUETBL WHERE VIP=" + vip + " AND DATE=?");
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            ps.setDate(1, sqlDate);
            ResultSet rs = ps.executeQuery();
            
            boolean duplicate = false;
            //detect duplicate
            while(rs.next())    //loop until reached the last VIP
            {
                if(vip)
                {
                    if(cellNo.equals(rs.getString("MOBILENUM")) || name.equalsIgnoreCase(rs.getString("NAME")))      //true if duplicate
                        duplicate = true;
                }
                else
                {
                    if(cellNo.equals(rs.getString("MOBILENUM")))      //true if duplicate
                        duplicate = true;
                }
                
                if(duplicate)
                {
                    lastNumber = rs.getInt("NUM");     //set last number from db
                    lastNumber--;       //temporarily decrement (will be incremented before return)
                    ref = rs.getInt("REF");
                    duplicate = true;
                    break;
                }
            }
            
            if(!duplicate)      //continue if no duplicate detected
            {
                ref = Common.generateReferenceNo();         //generate reference number
                lastNumber = getLastNumber(con,vip);        //get last number from records history within the day
                
                /*Delete record from previous day*/
                PreparedStatement psd = con.prepareStatement("select MOBILENUM from QUEUETBL where MOBILENUM='" + cellNo + "'");
                ResultSet rsd = psd.executeQuery();
                if(rsd.next()) { 
                    PreparedStatement delete = con.prepareStatement("delete from QUEUETBL where MOBILENUM='" + cellNo + "'");
                    System.err.println(delete.executeUpdate() + " old record on queue has been automatically deleted. Please use the Cleanup Queue function to delete old records that might interfere with current operations.");
                    delete.close();
                }
                rsd.close();
                psd.close();
                /*end of record delete*/
                
                lastNumber++;   //temporarily increment to actual position
                PreparedStatement insert = con.prepareStatement("insert into QUEUETBL values (" + lastNumber + ",'" + cellNo + "'," + vip + "," + ref + ",'" + name + "',?,'" + trans + "',NULL," + sms + ")");
                insert.setDate(1, sqlDate);
                insert.executeUpdate();
                add2History(con,lastNumber,cellNo,vip,ref,name,trans,sms);    //add to reccordshistory table
                lastNumber--;   //revert to lastNumber after writing to database
                insert.close();
            }
            //close necessary objects
            rs.close();     
            ps.close();
            con.close();
        }
        catch (SQLException sqle)
        {
            System.err.println("Exception while adding to queue - " + sqle.getMessage() + sqle.getSQLState());
        }
        lastNumber++;
        return lastNumber;  //return number
    }
    
    public static String getNowServing(Connection con)
    {
        String nowserving = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select NUM,VIP,COUNTER from QUEUETBL where COUNTER IS NOT NULL");
            if(rs.next())
            {
                if(rs.getBoolean("VIP"))
                    nowserving = "V" + rs.getInt("NUM");
                else
                    nowserving = "N" + rs.getInt("NUM");
            }
            else
            {
                int currentTime = Integer.parseInt(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()));
                if(currentTime > 9 && currentTime < 21)     //9AM to 9PM
                    nowserving = "None";
                else
                    nowserving = "Store is closed";
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            System.err.println("Exception at getLastNumber - " + sqle.getMessage());
        }
        return nowserving;
    }
    
    public static String[] getNowServingCounters(Connection con) {
        String [] nowserving = null;
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select NUM,VIP,COUNTER from QUEUETBL where COUNTER IS NOT NULL ORDER BY COUNTER ASC");
            if(rs.last()) {
                nowserving = new String[rs.getRow()];
                rs.beforeFirst();
                for(int i = 0; rs.next(); i++) {
                    if(rs.getBoolean("VIP"))
                        nowserving[i] = "Counter " + rs.getInt("COUNTER") + ": V" + rs.getInt("NUM");
                    else
                        nowserving[i] = "Counter " + rs.getInt("COUNTER") + ": N" + rs.getInt("NUM");
                }
            }
            else
            {
                int currentTime = Integer.parseInt(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()));
                if(currentTime > 9 && currentTime < 21)     //9AM to 9PM
                    nowserving = new String[]{"None"};
                else
                    nowserving = new String[]{"Store is closed"};
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            System.err.println("Exception at getLastNumber - " + sqle.getMessage());
        }
        return nowserving;
    }
    
    public static int getTotal(Connection con, boolean all, boolean vip)
    {
        int total = 0;
        try {
            PreparedStatement ps;
            ResultSet rs;
            if(all)
                ps = con.prepareStatement("SELECT COUNT(NUM) FROM QUEUETBL WHERE DATE=? AND COUNTER IS NULL");
            else
                ps = con.prepareStatement("SELECT COUNT(NUM) FROM QUEUETBL WHERE DATE=? AND COUNTER IS NULL AND VIP=" + vip);
            ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            rs = ps.executeQuery();
            rs.next();
            total = rs.getInt(1);
            rs.close();
            ps.close();
        } catch (SQLException sqle) {
            System.err.println("Exception at getTotal - " + sqle.getMessage());
        }
        return total;
    }
    
    public static int getTotalCounters(Connection con) {
        int total = 0;
        try {
            PreparedStatement ps;
            ResultSet rs;
                ps = con.prepareStatement("SELECT COUNT(COUNTER) FROM QUEUETBL WHERE DATE=?");
            ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            rs = ps.executeQuery();
            rs.next();
            total = rs.getInt(1);
            rs.close();
            ps.close();
        } catch (SQLException sqle) {
            System.err.println("Exception at getTotalCounters - " + sqle.getMessage());
        }
        return total;
    }
    
    public static String getTransactions(Connection con) {
        String x = "<select name=trans id=centered>";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select TRANSACTIONTYPE from TRANSACTIONSTBL");
            while(rs.next())
                x = x + "<option value=\"" + rs.getString(1) + "\">" + rs.getString(1) + "</option>";
            x = x + "</select>";
        } catch (SQLException y) {
            System.err.println("Cannot retrieve transactions. " + y.getMessage());
        }
        return x;
    }
    
    public static int SendSMS(String strAccountId,String strEmail,String strPassword,String strMSISDN,String strMessage,StringBuffer strResponse)
    {
        String  sRequestURL;
        String  sData;
        int nResult = -1;

        sRequestURL = "http://www.redoxygen.net/sms.dll?Action=SendSMS";

        try
        {		

                sData  = ("AccountId="  + URLEncoder.encode(strAccountId,"UTF-8"));
                sData += ("&Email="     + URLEncoder.encode(strEmail,"UTF-8"));
                sData += ("&Password="  + URLEncoder.encode(strPassword,"UTF-8"));
                sData += ("&Recipient=" + URLEncoder.encode(strMSISDN,"UTF-8"));
                sData += ("&Message="   + URLEncoder.encode(strMessage,"UTF-8"));



                URL urlObject = new URL(sRequestURL); 

                HttpURLConnection con = (HttpURLConnection) urlObject.openConnection();
                con.setRequestMethod("POST");
                con.setDoInput (true);
                con.setDoOutput (true);


                DataOutputStream out;
                out = new DataOutputStream(con.getOutputStream());
                out.writeBytes (sData);
                out.flush();
                out.close();

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 

                String inputLine; 
                StringBuffer responseBuffer = new StringBuffer(); 

                while ((inputLine = in.readLine()) != null)
                {
                      responseBuffer = responseBuffer.append(inputLine);
                      responseBuffer = responseBuffer.append("\n\n\n");
                }

                strResponse.replace(0,0,responseBuffer.toString());

                String sResultCode = strResponse.substring(0,4);
                nResult = Integer.parseInt(sResultCode);

                in.close();
        }

        catch (Exception e)
        {
                System.out.println("Exception caught sending SMS\n"); 
                nResult = -2;
        }
        return nResult;
    }
    
    public static void sendSMS(String strMSISDN, String strMessage) {
        String strAccountId  = "CI00136581";  // Put your AccountId here
        String strEmail      = "ipa3kjoshua@gmail.com";  // Put your Email address here (Used for authentication and replies)
        String strPassword   = "gmF6oHn5";  // Put your Password here
        //String strMSISDN     = "+639151272800";   // Put a recipient mobile number here
        //String strMessage    = "Test SMS via Red Oxygen API";  // Put your SMS message text here
        int nResult;
        StringBuffer strResponse = new StringBuffer();
        
        nResult = SendSMS(strAccountId,strEmail,strPassword,strMSISDN,strMessage,strResponse);

        System.out.println("Result Code = " + nResult + "\n");
        System.out.println("Response Text = " + strResponse + "\n");
    }
}
