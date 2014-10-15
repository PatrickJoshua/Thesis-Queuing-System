import java.io.IOException;
import java.io.PrintWriter;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Queuing Successful - Queuing System Web App</title>");         
//            out.println("<meta charset=\"UTF-8\">");
//            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");   
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<center>");
//            out.println("<h2>Thank you!</h2>");
//            String cellNo = request.getParameter("cellNo");     //do not modify
//            String trans = request.getParameter("trans");      //do not modify
//            Boolean sms = true;
//            String checkbox = request.getParameter("sms");
//            if(checkbox==null)
//                sms = false;
//            if(cellNo.equals("") || !(cellNo.substring(0, 3)).equals("+63") || (cellNo.trim().length()!=13))     //if mobile number is incorrect format
//            {
//                out.println("<script type=\"text/javascript\">");  
//                out.println("alert('Mobile Number not valid. Please use this format: +639XXXXXXXXX');");      //display pop up message
//                out.println("window.history.back();");                      //go back to get number page
//                out.println("</script>");
//            }
//            else
//            {
//                Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
//                int num = Common.add2DB(con,cellNo,"",false,trans,sms);
//                out.println("Your number is: <b>N" + num + "</b><br>Reference Number: " + Common.ref + "<br><br>");
//                out.println("Please wait for the text confirmation.");
//                out.println("<form name=\"cancelrequest\" action=\"CancelRequest\"><br>");
//                out.println("<input type=hidden name=num value=" + num + ">");
//                out.println("<input type=hidden name=vip value=false>");
//                out.println("<input type=submit value=\"Cancel Request\">");
//                out.println("<br><br><hr width=\"50%\"><br>");      //horizontal line
//                con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
//                try {
//                    Statement stmt = con.createStatement();
//                    ResultSet rs = stmt.executeQuery("select * from QUEUETBL where VIP=false and NUM=" + num);
//                    rs.next();
//                    String smsnotif = "";
//                    if(rs.getBoolean("SMSNOTIFICATION"))
//                        smsnotif = ". SMS Notifications are enabled";
//                    Common.sendSMS(rs.getString("MOBILENUM"), "Welcome to CSA Queuing System. Your number is N" + rs.getInt("NUM")
//                            + ". Reference number: " + rs.getInt("REF") + " for " + rs.getString("TRANS") + smsnotif
//                            + ". View the queue in real-time anywhere! Go to http://patrickjoshua.ddns.net/realtime");
//                    rs.close();
//                    stmt.close();
//                } catch (SQLException e) {
//                    System.err.println(e.getMessage());
//                    e.printStackTrace();
//                }
//                out.println("<h2>Now Serving:</h2>");
//                out.println(Common.getNowServingCounters(con));
//                out.println("<br><h3>On Queue:</h3>");
//                out.println("<table><tr><td align=center>");
//                out.println("VIP: " + Common.getTotal(con, false, true));
//                out.println("</td><td align=center>");
//                out.println("Guests: " + Common.getTotal(con, false, false));
//                out.println("</td></tr><td colspan=2 align=center>");
//                out.println("<br>Total persons on queue: " + Common.getTotal(con, true, true));
//                out.println("</td></tr></table>");
//            }
//            out.println("</center>");
//            out.println("</body>");
//            out.println("</html>");

            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>Thank You! - CSA Queuing System Web App</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no\">\n"
                    + "        <link rel=\"stylesheet\" media=\"(max-width: 768px)\" href=\"../mobile.css\">\n"
                    + "        <link rel=\"stylesheet\" media=\"(min-width: 769px)\" href=\"../desktop.css\">\n"
                    + "        <script src=\"../jquery-2.1.1.js\"></script>\n"
                    + "    </head>\n"
                    + "    <body class=\"segoe\">\n"
                    + "        <div class=\"lightpink\" id=\"header\">\n"
                    + "            <a href=\"/QueueWebApp\"><img id=\"imgheader\" src=\"../logo.png\"></a>\n"
                    + "            <div id=\"menu\" class=\"darkpink\">\n"
                    + "                <div id=\"menubar\">\n"
                    + "                    <div class=\"darkerpink\" id=\"menuitem\">\n"
                    + "                        <a href=\"/QueueWebApp\">\n"
                    + "                            <img src=\"../home.png\" class=\"navicon\">&nbsp;&nbsp;&nbsp;Home\n"
                    + "                        </a>\n"
                    + "                    </div>\n"
                    + "                    <div id=\"menuitem\">\n"
                    + "                        <a href=\"/QueueWebApp/vip\">\n"
                    + "                            <img src=\"../vip.png\" class=\"navicon\">&nbsp;&nbsp;&nbsp;VIP\n"
                    + "                        </a>\n"
                    + "                    </div>\n"
                    + "                    <div id=\"menuitem\">\n"
                    + "                        <a href=\"/QueueWebApp/realtime\">\n"
                    + "                            <img src=\"../clock.png\" class=\"navicon\">&nbsp;&nbsp;&nbsp;Real-time\n"
                    + "                        </a>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "        <div id=\"content\">\n"
                    + "            <div id=\"main\">\n"
                    + "                <p id=\"Welcome\" style=\"font-size: 1.5em;\">Your Number:</p>\n");
            String cellNo = request.getParameter("cellNo");     //do not modify
            String trans = request.getParameter("trans");      //do not modify
            Boolean sms = true;
            String checkbox = request.getParameter("sms");
            if (checkbox == null) {
                sms = false;
            }
            if (cellNo.equals("") || !(cellNo.substring(0, 3)).equals("+63") || (cellNo.trim().length() != 13)) //if mobile number is incorrect format
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Mobile Number not valid. Please use this format: +639XXXXXXXXX');");      //display pop up message
                out.println("window.history.back();");                      //go back to get number page
                out.println("</script>");
            } else {
                Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
                int num = Common.add2DB(con, cellNo, "", false, trans, sms);
                out.println("<p id=\"Welcome\" style=\"padding-top:0;font-size:5em\">N" + num + "</p>");
                out.println("<p id=\"bottomspaced\" align=\"center\">Reference number: <b>" + Common.ref + "</b></p>\n");
                out.println("<p id=\"smalldesc\" style=\"padding-bottom:0;padding-left:0\" align=\"center\">Please wait for the text confirmation</p>\n");
                out.println("<form name=\"cancelrequest\" action=\"CancelRequest\"><br>");
                out.println("<input type=hidden name=num value=" + num + ">");
                out.println("<input type=hidden name=vip value=false>"
                        + "<p id=\"topspaced\" style=\"padding-top:30px;padding-bottom:50px;\" align=\"center\"><input type=\"submit\" value=\"Cancel Request\"></p>"
                        + "            </div>");

                con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
                try {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from QUEUETBL where VIP=false and NUM=" + num);
                    rs.next();
                    String smsnotif = "";
                    if (rs.getBoolean("SMSNOTIFICATION")) {
                        smsnotif = ". SMS Notifications are enabled";
                    }
                    Common.sendSMS(rs.getString("MOBILENUM"), "Welcome to CSA Queuing System. Your number is N" + rs.getInt("NUM")
                            + ". Reference number: " + rs.getInt("REF") + " for " + rs.getString("TRANS") + smsnotif
                            + ". View the queue in real-time anywhere! Go to http://patrickjoshua.ddns.net/realtime");
                    rs.close();
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }

                out.println("<div id=\"queue\">\n"
                        + "            <center>\n"
                        + "                <div id=\"nowserving\">\n"
                        + "                    <p id=\"nowservingtxt\">Now Serving</p>\n"
                        + "                    <table class=\"counter\">");

            String [] nowServing = Common.getNowServingCounters(con);
            try {
                for(int i=0; i<nowServing.length; i++) {
                    if(nowServing.length > 3) {
                        out.println("<tr><td>" + nowServing[i] + "</td>");
                        out.println("<td>" + nowServing[++i] + "</td></tr>");
                    }
                    else
                        out.println("<tr><td>" + nowServing[i] + "</td></tr>");
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException x) {
                out.println("</tr>");
            }
            
                out.println("</table>\n"
                        + "                </div>\n"
                        + "                <div id=\"upcomingvip\">\n"
                        + "                    <p id=\"number\">");
                out.println(Common.getTotal(con, false, true));
                out.println("</p><p id=\"queuelabel\">VIP on Queue</p>\n"
                        + "                </div>\n"
                        + "                <div id=\"upcomingguest\">\n"
                        + "                    <p id=\"number\">");
                out.println(Common.getTotal(con, false, false));
                out.println("</p>Guests\n"
                        + "                </div>\n"
                        + "            </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "            <div id=\"footer\">\n"
                        + "                <p style=\"margin-bottom:1%\">Capstone Project 2014</p>\n"
                        + "                <p style=\"margin-bottom: 5%\">Patrick Saguinsin | Maidy Santos | Justine Diza | Jasmine Eve</p>\n"
                        + "            </div>\n"
                        + "        </div>\n");
            }
            out.println("        <script>\n" +
"            jQuery(window).scroll(function(){\n" +
"                var fromTopPx = 80; // distance to trigger\n" +
"                var scrolledFromtop = jQuery(window).scrollTop();\n" +
"                if(scrolledFromtop > fromTopPx){\n" +
"                    jQuery('#imgheader').attr('id','scrolled');\n" +
"                }else{\n" +
"                    jQuery('img#scrolled').attr('id','imgheader');\n" +
"                }\n" +
"            });</script></body></html>");
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
