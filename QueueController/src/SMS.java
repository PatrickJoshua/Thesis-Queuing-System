
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.prefs.Preferences;


/**
 *
 * @author PatrickJoshua
 */
public class SMS extends Thread {
    
    Connection con;
    
    public SMS (Connection con) {
        this.con = con;
    }
    
    @Override
    public void run() {
        try {
            PreparedStatement ps = con.prepareStatement("select * from QUEUETBL where DATE=? and COUNTER IS NULL order by VIP desc, NUM asc", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            ResultSet rs = ps.executeQuery();
            int i;
            for(i = 1; rs.next(); i++) {
                rs.absolute(i);
                if(rs.getBoolean("SMSNOTIFICATION")) {
                    String num;
                    if(rs.getBoolean("VIP"))
                        num = "V" + rs.getInt("NUM");
                    else
                        num = "N" + rs.getInt("NUM");
                    
                    if(i==1) {
                        sendSMS(rs.getString("MOBILENUM"),"CSA Queuing System Update: You are next person to be served. Thank you for using CSA Queuing System!");
                        System.out.println("Message sent to " + num);
                    }
                    else if(i==2 || i==3 || i==4 || (i%ControllerDisplay.SMSINTERVAL)==0) {
                        int x = i-1;
                        sendSMS(rs.getString("MOBILENUM"), "CSA Queuing System Update: There are " + x + " persons before your turn. Please be at the clinic before your turn. Thank you! View the queue in real-time anywhere! Go to http://csaqueueonline.com/realtime");
                        System.out.println("Message sent to " + num);
                    }
                }
            }
            rs.close();
            ps.close();
        } catch (SQLException x) {
            System.err.println("Error while retrieving data for sending SMS. " + x.getMessage());
        }
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
                System.err.println("Exception caught sending SMS\n"); 
                nResult = -2;
                e.printStackTrace();
        }
        return nResult;
    }
    
    public static void sendSMS(String strMSISDN, String strMessage) {
        Preferences prefs = Preferences.userRoot();
        String strAccountId  = prefs.get("ACCOUNTID", "");  // Put your AccountId here
        String strEmail      = prefs.get("EMAIL", "");  // Put your Email address here (Used for authentication and replies)
        String strPassword   = prefs.get("SMSPASSWORD", "");  // Put your Password here
        int nResult;
        StringBuffer strResponse = new StringBuffer();
        
        nResult = SendSMS(strAccountId,strEmail,strPassword,strMSISDN,strMessage,strResponse);

        System.out.println("Result Code = " + nResult + "\n");
        System.out.println("Response Text = " + strResponse + "\n");
    }

}
