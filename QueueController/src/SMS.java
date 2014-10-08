
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
            PreparedStatement ps = con.prepareStatement("select * from QUEUETBL where DATE=? order by VIP desc, NUM asc", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            ResultSet rs = ps.executeQuery();
            
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
        }
        return nResult;
    }
    
    public static void sendSMS(String strMSISDN, String strMessage) {
        String strAccountId  = "CI00136581";  // Put your AccountId here
        String strEmail      = "ipa3kjoshua@gmail.com";  // Put your Email address here (Used for authentication and replies)
        String strPassword   = "gmF6oHn5";  // Put your Password here
        int nResult;
        StringBuffer strResponse = new StringBuffer();
        
        nResult = SendSMS(strAccountId,strEmail,strPassword,strMSISDN,strMessage,strResponse);

        System.out.println("Result Code = " + nResult + "\n");
        System.out.println("Response Text = " + strResponse + "\n");
    }

}
