/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PatrickJoshua
 */
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Queuing System Web App</title>");            
//            out.println("<meta charset=\"UTF-8\">");
//            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");   
//            out.println("<link rel = stylesheet href = \"thesis.css\" type = \"text/css\">");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<center>");
//            out.println("<font face=\"Segoe UI Light\" size=50>Welcome</font><br><br>");
//            out.println("<form action=getNumberServlet>");
//            out.println("<input type=\"text\" name=\"cellNo\" style = \"font-size: 20px;\">");
//            out.println("<p><input type=\"checkbox\" name=\"sms\" checked>Send me SMS Notifications</p>");
//            Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
//            out.println(Common.getTransactions(con));
//            out.println("<br><br>");
//            out.println("<input type=\"image\" src=../resources/getnumber.PNG alt=\"Get Number\"/>");
//            out.println("</form>");
//            out.println("<br><br><hr width=\"50%\"><br>");      //horizontal line
//            out.println("<a href=vip>VIP Login</a>");
//            out.println("<br>");
//            out.println("<a href=realtime>Real-time Queue Status</a>");
//            out.println("<br>");
//            con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
//            out.println("<h2>Now Serving:</h2>");
//            out.println(Common.getNowServingCounters(con));
//            out.println("<br><h3>On Queue:</h3>");
//            out.println("<table><tr><td align=center>");
//            out.println("VIP: " + Common.getTotal(con, false, true));
//            out.println("</td><td align=center>");
//            out.println("Guests: " + Common.getTotal(con, false, false));
//            out.println("</td></tr><td colspan=2 align=center>");
//            out.println("<br>Total persons on queue: " + Common.getTotal(con, true, true));
//            out.println("</td></tr></table>");
//            out.println("");
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>CSA Queuing System Web App</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no\">\n" +
"        <link rel=\"stylesheet\" media=\"(max-width: 768px)\" href=\"../mobile.css\">\n" +
"        <link rel=\"stylesheet\" media=\"(min-width: 769px)\" href=\"../desktop.css\">\n" +
                    "<link rel=\"shortcut icon\" type=\"image/png\" href=\"../favicon.png\"/>" +
                    "<script src=\"../jquery-2.1.1.js\"></script>" +
"    </head>\n" +
"    <body class=\"segoe\">\n" +
"        <div class=\"lightpink\" id=\"header\">\n" +
"            <a href=\"/QueueWebApp\"><img id=\"imgheader\" src=\"../logo.png\"></a>\n" +
"            <div id=\"menu\" class=\"darkpink\">\n" +
"                <div id=\"menubar\">\n" +
"                    <div class=\"darkerpink\" id=\"menuitem\">\n" +
"                        <a href=\"\">\n" +
"                            <img src=\"../home.png\" class=\"navicon\">&nbsp;&nbsp;&nbsp;Home\n" +
"                        </a>\n" +
"                    </div>\n" +
"                    <div id=\"menuitem\">\n" +
"                        <a href=\"/QueueWebApp/vip\">\n" +
"                            <img src=\"../vip.png\" class=\"navicon\">&nbsp;&nbsp;&nbsp;VIP\n" +
"                        </a>\n" +
"                    </div>\n" +
"                    <div id=\"menuitem\">\n" +
"                        <a href=\"/QueueWebApp/realtime\">\n" +
"                            <img src=\"../clock.png\" class=\"navicon\">&nbsp;&nbsp;&nbsp;Real-time\n" +
"                        </a>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"        <div id=\"content\">\n" +
"            <div id=\"main\">\n" +
"                <p id=\"Welcome\">Welcome</p>\n" +
"                <p id=\"bottomspaced\">Enter your mobile number:</p>\n" +
"                <form action=\"/QueueWebApp/getNumberServlet\">\n" +
                    "<input id=\"centered\" type=\"text\" name=\"cellNo\" value=\"+63\" placeholder=\"Ex. +639151272800\" onfocus=\"document.getElementById('note').style.display='block'\" onblur=\"document.getElementById('note').style.display='none'\">\n" +
"                    <div id=\"note\">\n" +
"                        <p id=\"format\"><i>Format: +639XXXXXXXXXX</i></p>\n" +
"                    </div>" +
"                    <p id=bottomspaced>Service to be availed:</p>");
            Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
            out.println(Common.getTransactions(con));
            out.println("<p id=\"topspaced\"><input type=\"checkbox\" name=\"sms\" value=\"Send me SMS Notifications\" checked> Send me SMS Notifications</p>\n" +
                    "<p id=\"smalldesc\">You will receive text message updates regarding the status of the queue</p>" +
"                    <p id=\"topspaced\" style=\"padding-top:30px;padding-bottom:20px;\" align=\"center\"><input type=\"submit\" value=\"Enter Queue\"></p>\n" +
"                </form>\n" +
"                <br><br>\n" +
"            </div>\n" +
"            <div id=\"queue\">\n" +
"            <center>\n" +
"                <div id=\"nowserving\">\n" +
"                    <p id=\"nowservingtxt\">Now Serving</p>\n" +
"                    <table class=\"counter\">");
            
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
"            <div id=\"footer\">\n" +
"                <p style=\"margin-bottom:1%\">Capstone Project 2014</p>\n" +
"                <p style=\"margin-bottom: 5%\">Patrick Saguinsin | Maidy Santos | Justine Diza | Jasmine Eve</p>\n" +
"            </div>\n" +
"        </div>\n" +
         "<script>\n" +
"            jQuery(window).scroll(function(){\n" +
"                var fromTopPx = 80; // distance to trigger\n" +
"                var scrolledFromtop = jQuery(window).scrollTop();\n" +
"                if(scrolledFromtop > fromTopPx){\n" +
"                    jQuery('#imgheader').attr('id','scrolled');\n" +
"                }else{\n" +
"                    jQuery('img#scrolled').attr('id','imgheader');\n" +
"                }\n" +
"            });</script>" +
"    </body>\n" +
"</html>");
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
