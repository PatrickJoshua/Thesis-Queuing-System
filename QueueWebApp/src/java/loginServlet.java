import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author PatrickJoshua
 */
@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    String name, mobilenumber;
    
    boolean validateCredentials(Connection con, String username, String password)
    {
        String dbusername, dbpassword;      //database username and password
        boolean valid = false;      //user credential found
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM VIPCLIENTSTBL");      //execute sql statement, and place result on rs

            while(rs.next())    //loop until user credential is found
            {
                dbusername = rs.getString("USERNAME");      //parse username from returned sql result
                dbpassword = rs.getString("PASSWORD");      //parse password from returned sql result

                if(dbusername.equalsIgnoreCase(username) && dbpassword.equals(password))
                {
                    valid = true;
                    break;
                }
            }
            if(valid)
            {
                name = rs.getString("FULLNAME");
                mobilenumber = rs.getString("MOBILENUMBER");
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle.getMessage());
        }
        
        return valid;   //returns true if user account is found
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>VIP Login</title>");            
//            out.println("<meta charset=\"UTF-8\">");
//            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<center>");
//            Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
//            String username = request.getParameter("username");     //inputted username
//            String password = request.getParameter("password");     //inputted password
//            if(validateCredentials(con,username,password))          //run the code to validate user credentials
//            {
//                out.println("<h2>Welcome</h2><b>" + name + "</b>");
//                out.println("<br><br>Your mobile number is: ");
//                out.println("<form name=viploginsuccess action=getVIPNumberServlet>");      //do not modify
//                out.println("<input type=text name=cellNo value=" + mobilenumber + ">");    //do not modify
//                out.println("<br><font size=\"2\"><i>Format: +639XXXXXXXXX</i></font> <br>");   
//                out.println("<input type=hidden name=name value=\"" + name + "\">");    //do not modify
//                con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
//                out.println(Common.getTransactions(con));
//                out.println("<br>");
//                out.println("<input type=\"checkbox\" name=\"prioritize\" checked>Prioritize me<br>");
//                out.println("<input type=checkbox name=sms checked>Send me SMS Notifications<br>");
//                out.println("<input type=submit value=\"Get VIP Number\">");        //do not modify
//                out.println("<br><br><hr width=\"50%\"><br>");      //horizontal line
//                con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
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
//            else    //if not valid
//            {
//                out.println("<script type=\"text/javascript\">");  
//                out.println("alert('Invalid username or password');");      //display pop up message
//                out.println("window.history.back();");                      //go back to login page
//                out.println("</script>");
//            }
//            out.println("</center>");
//            out.println("</body>");
//            out.println("</html>");
            
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>[VIP]CSA Queuing System Web App</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no\">\n" +
"        <link rel=\"stylesheet\" media=\"(max-width: 768px)\" href=\"../mobile.css\">\n" +
"        <link rel=\"stylesheet\" media=\"(min-width: 769px)\" href=\"../desktop.css\">\n" +
"        <script src=\"../jquery-2.1.1.js\"></script>\n" +
"    </head>\n" +
"    <body class=\"segoe\">\n");
            Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
            String username = request.getParameter("username");     //inputted username
            String password = request.getParameter("password");     //inputted password
            if(validateCredentials(con,username,password))          //run the code to validate user credentials
            {
                out.println("<div class=\"lightpink\" id=\"header\">\n" +
"            <a href=\"/QueueWebApp\"><img id=\"imgheader\" src=\"../logo.png\"></a>\n" +
"            <div id=\"menu\" class=\"darkpink\">\n" +
"                <div id=\"menubar\">\n" +
"                    <div id=\"menuitem\">\n" +
"                        <a href=\"/QueueWebApp\">\n" +
"                            Home\n" +
"                        </a>\n" +
"                    </div>\n" +
"                    <div class=\"darkerpink\" id=\"menuitem\">\n" +
"                        <a href=\"/QueueWebApp/vip\">\n" +
"                            VIP\n" +
"                        </a>\n" +
"                    </div>\n" +
"                    <div id=\"menuitem\">\n" +
"                        <a href=\"/QueueWebApp/realtime\">\n" +
"                            Real-time\n" +
"                        </a>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"        <div id=\"content\">\n" +
"            <div id=\"main\">\n" +
"                <p id=\"Welcome\">Welcome Back</p>\n" +
"                <p id=\"name\">");
                out.println(name);
                out.println("</p>\n" +
"                <p id=\"bottomspaced\">Your mobile number on file:</p>\n" +
"                <form action=\"getVIPNumberServlet\">\n" +
"                    <input id=\"centered\" type=\"text\" name=\"cellNo\" value=\"");
                out.println(mobilenumber);
                out.println("\" placeholder=\"Ex. +639151272800\" onfocus=\"document.getElementById('note').style.display='block'\" onblur=\"document.getElementById('note').style.display='none'\">\n" +
"                    <div id=\"note\">\n" +
"                        <p id=\"format\"><i>Format: +639XXXXXXXXXX</i></p>\n" +
"                        <br>\n" +
"                        You can change this number to whatever phone number you're using now. Talk to our personnels if you want to update your mobile number on file.\n" +
"                    </div>\n" +
"                    <p id=bottomspaced>Service to be availed:</p>");
            con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
            out.println(Common.getTransactions(con));
            out.println("<p id=\"topspaced\"><input type=\"checkbox\" name=\"prioritize\" checked> Prioritize Me</p>\n" +
"                    <p id=\"smalldesc\">You'll be placed on a prioritized queue where VIP's are always served first before guests. Uncheck if you want to queue regularly.</p>\n" +
"                    <p id=\"topspaced\"><input type=\"checkbox\" name=\"sms\" checked> Send me SMS Notifications</p>\n" +
"                    <p id=\"smalldesc\">You will receive text message updates regarding the status of the queue</p><br>\n" +
"                    <input type=\"hidden\" name=\"name\" value=\"");
            out.println(name + "\">\n" +
"                    <p id=\"topspaced\" style=\"padding-top:30px;padding-bottom:20px;\" align=\"center\"><input type=\"submit\" value=\"Enter Queue\"></p>\n" +
"                </form>\n" +
"                <br><br>\n" +
"            </div>\n" +
"            <div id=\"queue\">\n" +
"            <center>\n" +
"                <div id=\"nowserving\">\n" +
"                    <p id=\"nowservingtxt\">Now Serving</p>\n" +
"                    <table class=\"counter\">");
            
            //table here
            
            out.println("</table>\n" +
"                </div>\n" +
"                <div id=\"upcomingvip\">\n" +
"                    <p id=\"number\">");
            out.println(Common.getTotal(con, false, true));
            out.println("</p><p id=\"queuelabel\">VIP on Queue</p>\n" +
"                </div>\n" +
"                <div id=\"upcomingguest\">\n" +
"                    <p id=\"number\">");
            out.println(Common.getTotal(con, false, false));
            out.println("</p>Guests\n" +
"                </div>\n" +
"            </center>\n" +
"            </div>\n" +
"\n" +
"            <div id=\"footervip\">\n" +
"                <p style=\"margin-bottom:1%\">Capstone Project 2014-2015</p>\n" +
"                <p style=\"margin-bottom: 5%\">Patrick Saguinsin | Maidy Santos | Justine Diza | Jasmine Eve</p>\n" +
"            </div>\n" +
"        </div>\n" +
         "<script>\n" +
"            jQuery(window).scroll(function(){\n" +
"                var fromTopPx = 80; // distance to trigger\n" +
"                var scrolledFromtop = jQuery(window).scrollTop();\n" +
"                if(scrolledFromtop > fromTopPx){\n" +
"                    jQuery('img').removeAttr('id');\n" +
"                    jQuery('img').attr('id','scrolled');\n" +
"                }else{\n" +
"                    jQuery('img').removeAttr('scrolled');\n" +
"                    jQuery('img').attr('id','imgheader');\n" +
"                }\n" +
"            });</script>");
            }
            else    //if not valid
            {
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Invalid username or password');");      //display pop up message
                out.println("window.history.back();");                      //go back to login page
                out.println("</script>");
            }
            out.println("</body></html>");
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
