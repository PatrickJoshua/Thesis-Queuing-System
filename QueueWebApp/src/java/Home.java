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
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" media=\"(max-width: 768px)\" href=\"../mobile.css\">\n" +
"        <link rel=\"stylesheet\" media=\"(min-width: 769px)\" href=\"../desktop.css\">\n" +
"    </head>\n" +
"    <body class=\"segoe\">\n" +
"        <div class=\"lightpink\" id=\"header\">\n" +
"            <img id=\"imgheader\" src=\"../logo.png\">\n" +
"            <div id=\"menu\" class=\"darkpink\">\n" +
"                <div id=\"menubar\">\n" +
"                    <div class=\"darkerpink\" id=\"menuitem\">\n" +
"                        <a href=\"\">\n" +
"                            Home\n" +
"                        </a>\n" +
"                    </div>\n" +
"                    <div id=\"menuitem\">\n" +
"                        <a href=\"vip\">\n" +
"                            VIP\n" +
"                        </a>\n" +
"                    </div>\n" +
"                    <div id=\"menuitem\">\n" +
"                        <a href=\"realtime\">\n" +
"                            Real-time\n" +
"                        </a>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"        <div id=\"content\">\n" +
"            <div id=\"main\">\n" +
"                <p id=\"Welcome\">Welcome</p>\n" +
"                <br>\n" +
"                <p id=\"bottomspaced\">Enter your mobile address:</p>\n" +
"                <form action=\"getNumberServlet\">\n" +
"                    <input id=\"centered\" type=\"text\" name=\"cellNo\" value=\"+63\">\n" +
"                    <p id=\"format\"><i>Format: +639XXXXXXXXXX</i></p>\n" +
"                    <br>\n" +
"                    <p id=bottomspaced>Service to be availed:</p>");
            Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
            out.println(Common.getTransactions(con));
            out.println("<p id=\"topspaced\"><input type=\"checkbox\" name=\"sms\" checked> Send me SMS Notifications</p>\n" +
"                    <center><input type=\"submit\" value=\"Enter Queue\"></center>\n" +
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
"            <div id=\"footer\">\n" +
"                <p style=\"margin-bottom:1%\">Capstone Project 2014-2015</p>\n" +
"                <p style=\"margin-bottom: 5%\">Patrick Saguinsin | Maidy Santos | Justine Diza | Jasmine Eve</p>\n" +
"            </div>\n" +
"        </div>\n" +
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
