import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PatrickJoshua
 */
@WebServlet(urlPatterns = {"/getNumberServlet"})
public class getNumberServlet extends HttpServlet {

    int ref;
    
    public static int  SendSMS(String strAccountId,String strEmail,String strPassword,String strMSISDN,String strMessage,StringBuffer strResponse)
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
    
    public void sendSMS(String strMSISDN, String strMessage) {
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Queuing Successful - Queuing System Web App</title>");         
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");   
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h2>Thank you!</h2>");
            String cellNo = request.getParameter("cellNo");     //do not modify
            String trans = request.getParameter("trans");      //do not modify
            Boolean sms = true;
            String checkbox = request.getParameter("sms");
            if(checkbox==null)
                sms = false;
            if(!(cellNo.substring(0, 3)).equals("+63") || (cellNo.trim().length()!=13))     //if mobile number is incorrect format
            {
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Mobile Number not valid. Please use this format: +639XXXXXXXXX');");      //display pop up message
                out.println("window.history.back();");                      //go back to get number page
                out.println("</script>");
            }
            else
            {
                Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
                int num = Common.add2DB(con,cellNo,"",false,trans,sms);
                out.println("Your number is: <b>N" + num + "</b><br>Reference Number: " + Common.ref + "<br><br>");
                out.println("Please wait for the text confirmation.");
                out.println("<form name=\"cancelrequest\" action=\"CancelRequest\"><br>");
                out.println("<input type=hidden name=num value=" + num + ">");
                out.println("<input type=hidden name=vip value=false>");
                out.println("<input type=submit value=\"Cancel Request\">");
                out.println("<br><br><hr width=\"50%\"><br>");      //horizontal line
                con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
                try {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from QUEUETBL where VIP=false and NUM=" + num);
                    rs.next();
                    String smsnotif = "";
                    if(rs.getBoolean("SMSNOTIFICATION"))
                        smsnotif = " SMS Notifications are enabled.";
                    sendSMS(rs.getString("MOBILENUM"), "Welcome to CSA Queuing System. Your number is N" + rs.getInt("NUM") + ". Reference number: " + rs.getInt("REF")
                            + " Transaction: " + rs.getString("TRANS") + smsnotif);
                    rs.close();
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
                out.println("<h2>Now Serving:</h2>");
                out.println(Common.getNowServingCounters(con));
                out.println("<br><h3>On Queue:</h3>");
                out.println("<table><tr><td align=center>");
                out.println("VIP: " + Common.getTotal(con, false, true));
                out.println("</td><td align=center>");
                out.println("Guests: " + Common.getTotal(con, false, false));
                out.println("</td></tr><td colspan=2 align=center>");
                out.println("<br>Total persons on queue: " + Common.getTotal(con, true, true));
                out.println("</td></tr></table>");
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
