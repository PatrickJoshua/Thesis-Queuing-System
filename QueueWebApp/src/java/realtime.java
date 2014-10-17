/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PatrickJoshua
 */
@WebServlet(urlPatterns = {"/realtime"})
public class realtime extends HttpServlet {

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
        response.setIntHeader("Refresh", 5);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Real-time Queue</title>");            
//            out.println("<meta charset=\"UTF-8\">");
//            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<center>");
//            Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
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
//            out.println("</center>");
//            out.println("</body>");
//            out.println("</html>");
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>Real-time Queue - CSA Queuing System Web App</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no\">\n"
                    + "        <link rel=\"stylesheet\" media=\"(max-width: 768px)\" href=\"../mobile.css\">\n"
                    + "        <link rel=\"stylesheet\" media=\"(min-width: 769px)\" href=\"../desktop.css\">\n"
                    + "<meta http-equiv=\"refresh\" content=\"5\" >"
                    + "        <script src=\"../jquery-2.1.1.js\"></script>\n"
                    + "    </head>\n"
                    + "    <body class=\"segoe\">\n"
                    + "        <div class=\"lightpink\" id=\"header\">\n"
                    + "            <a href=\"/QueueWebApp\"><img id=\"imgheader\" src=\"../logo.png\"></a>\n"
                    + "            <div id=\"menu\" class=\"darkpink\">\n"
                    + "                <div id=\"menubar\">\n"
                    + "                    <div id=\"menuitem\">\n"
                    + "                        <a href=\"/QueueWebApp\">\n"
                    + "                            <img src=\"../home.png\" class=\"navicon\">&nbsp;&nbsp;&nbsp;Home\n"
                    + "                        </a>\n"
                    + "                    </div>\n"
                    + "                    <div id=\"menuitem\">\n"
                    + "                        <a href=\"/QueueWebApp/vip\">\n"
                    + "                            <img src=\"../vip.png\" class=\"navicon\">&nbsp;&nbsp;&nbsp;VIP\n"
                    + "                        </a>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"darkerpink\" id=\"menuitem\">\n"
                    + "                        <a href=\"/QueueWebApp/realtime\">\n"
                    + "                            <img src=\"../clock.png\" class=\"navicon\">&nbsp;&nbsp;&nbsp;Real-time\n"
                    + "                        </a>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "        <div id=\"spacer\"></div>\n"
                    + "        <div id=\"content\" style=\"width:auto;margin-left:5%;margin-right:5%;\">\n");

            int vip, guest;
            String ticket;

            Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
            try {
                PreparedStatement ps = con.prepareStatement("select NUM,VIP,COUNTER,TRANS from QUEUETBL where DATE=? AND COUNTER IS NOT NULL ORDER BY COUNTER ASC", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    out.println("<div id=\"start\" class=\"segoe\">Now Serving</div><br>");
                    out.println("<div id=\"tilecontainer\">");
                    rs.beforeFirst();
                    while (rs.next()) {
                        if (rs.getBoolean("VIP")) {
                            ticket = "V" + rs.getInt("NUM");
                        } else {
                            ticket = "N" + rs.getInt("NUM");
                        }

                        out.println("             <div class=\"tile\">\n"
                                + "                    <div id=\"left\">\n"
                                + "                        <p style=\"font-size:1em;\">Counter " + rs.getInt("COUNTER") + "</p>\n"
                                + "                        <br><br>\n"
                                + "                        <p style=\"font-size:.8em;\">" + rs.getString("TRANS") + "</p>\n"
                                + "                    </div>\n"
                                + "                    <div id=\"right\" class=\"segoe\">" + ticket + "</div>\n"
                                + "                </div>");
                    }
                    out.println("</div><br><br><br>");
                    rs.close();
                    ps.close();
                } else {
                    //store is now closed
                    int currentTime = Integer.parseInt(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()));
                    if (currentTime > 9 && currentTime < 21) //9AM to 9PM
                    {
                        out.println("<div id=\"start\" class=\"segoe\">Status:<br>Not Serving Anyone</div><br>");
                    } else {
                        out.println("<div id=\"start\" class=\"segoe\">Clinic is now Closed</div>"
                                + "<div id=\"sublabel\" class=\"segoe\">Clinic opens from 9AM to 9PM</div><br>");
                    }
                }
                //start of upcoming queue
                out.println("<div id=\"start\" class=\"segoe\">On Queue</div>");

                //start of VIP
                ps = con.prepareStatement("select NUM,TRANS from QUEUETBL where DATE=? AND VIP=true AND COUNTER IS NULL ORDER BY COUNTER ASC", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                rs = ps.executeQuery();
                if (rs.last()) {    
                    out.println("<div id=\"sublabel\" class=\"segoe\">VIP - " + rs.getRow() + "</div><br>");
                    rs.beforeFirst();
                    while(rs.next()) {
                        out.println("<div class=\"upcomingtile\">\n"
                                + "                    <p id=\"num\" class=\"segoe\">V" + rs.getInt("NUM") + "</p>\n"
                                + "                    <p id=\"smalltrans\">" + rs.getString("TRANS") + "</p>\n"
                                + "                </div>");
                    }
                    out.println("<br><br>");
                }
                rs.close();
                ps.close();

                //start of guests
                ps = con.prepareStatement("select NUM,TRANS from QUEUETBL where DATE=? AND VIP=false AND COUNTER IS NULL ORDER BY COUNTER ASC", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                rs = ps.executeQuery();
                if (rs.last()) {  
                    out.println("<div id=\"sublabel\" class=\"segoe\">Guests - " + rs.getRow() + "</div><br>");
                    rs.beforeFirst();
                    while(rs.next()) {
                        out.println("<div class=\"upcomingtile\">\n"
                                + "                    <p id=\"num\" class=\"segoe\">N" + rs.getInt("NUM") + "</p>\n"
                                + "                    <p id=\"smalltrans\">" + rs.getString("TRANS") + "</p>\n"
                                + "                </div>");
                    }
                    out.println("<br><br>");
                }
                rs.close();
                ps.close();

            } catch (SQLException x) {
                System.err.println(x.getMessage());
            }
            out.println("</div>\n" +
"        <script>\n" +
"            jQuery(window).scroll(function(){\n" +
"                var fromTopPx = 80; // distance to trigger\n" +
"                var scrolledFromtop = jQuery(window).scrollTop();\n" +
"                if(scrolledFromtop > fromTopPx){\n" +
"                    jQuery('#imgheader').attr('id','scrolled');\n" +
"                }else{\n" +
"                    jQuery('img#scrolled').attr('id','imgheader');\n" +
"                }\n" +
"            });</script>\n" +
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
