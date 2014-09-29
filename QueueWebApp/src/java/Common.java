
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
    
    public static void add2History(Connection con, int num, String cellNo, boolean vip, int ref, String name, String trans)
    {
        try
        {
            PreparedStatement ps = con.prepareStatement("insert into RECORDSHISTORY values (" + num + ",'" + cellNo + "'," + vip + "," + ref + ",'" + name + "',?,?,'" + trans + "')");
            
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
        System.out.println(lastNumber);
        return lastNumber;
    }
    
    public static int add2DB(Connection con, String cellNo, String name, boolean vip, String trans)
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
                lastNumber++;   //temporarily increment to actual position
                PreparedStatement insert = con.prepareStatement("insert into QUEUETBL values (" + lastNumber + ",'" + cellNo + "'," + vip + "," + ref + ",'" + name + "',?,'" + trans + "',NULL)");
                insert.setDate(1, sqlDate);
                insert.executeUpdate();
                add2History(con,lastNumber,cellNo,vip,ref,name,trans);    //add to reccordshistory table
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
            System.err.println(sqle.getMessage() + sqle.getSQLState());
        }
        lastNumber++;
        return lastNumber;  //return number
    }
    
    public static String getNowServing(Connection con) throws SQLException
    {
        String nowserving;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select NUM,VIP from QUEUETBL where NOWSERVING=true");
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
        con.close();
        return nowserving;
    }
}
