/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.prefs.Preferences;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PatrickJoshua
 */
public class admin extends HttpServlet {

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
            Preferences prefs = Preferences.userRoot();
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Admin Page - CSA Queuing System Web App</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no\">\n" +
"        <link rel=\"stylesheet\" media=\"(max-width: 768px)\" href=\"../mobile.css\">\n" +
"        <link rel=\"stylesheet\" media=\"(min-width: 769px)\" href=\"../desktop.css\">\n" +
                     "<link rel=\"shortcut icon\" type=\"image/png\" href=\"../favicon.png\"/>" +
"        <script src=\"../jquery-2.1.1.js\"></script>\n" +
"    </head>\n" +
"    <body class=\"segoe\">\n" +
"        <div class=\"lightpink\" id=\"header\">\n" +
"            <a href=\"/QueueWebApp\"><img id=\"imgheader\" src=\"../logo.png\"></a>\n" +
"            <p align=\"center\" style=\"font-size:20px; font-weight:lighter; color:white; padding-bottom: 10px;\">Administrator Module</p>\n" +
"            <div id=\"menu\" class=\"darkpink\">\n" +
"                <div id=\"menubar\">\n" +
"                    <div id=\"menuitem\">\n" +
"                        <a href=\"/QueueWebApp\">\n" +
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
"            <div id=\"spacer\" style=\"padding-top: 250px;\"></div>\n" +
"            <div id=\"login\">\n" +
"                Enter your administrative password:<br><br>\n" +
"                <input type=\"password\" id=\"password\" placeholder=\"Password\" onkeydown=\"if (event.keyCode == 13) document.getElementById('bt').click()\"><br><br>\n" +
"                <center><button type=\"button\" id=\"bt\" onclick=\"verify()\">Confirm</button></center>\n" +
"                <script type=\"text/javascript\">\n" +
"                    function verify() {\n" +
"                        var pw = document.getElementById(\"password\").value;\n" +
"                        if(pw == '" + prefs.get("WEBPW", "") + "') {\n" +
"                            document.getElementById(\"login\").style.visibility='hidden';\n" +
"                            document.getElementById(\"spacer\").style.visibility='hidden';\n" +
"                            document.getElementById(\"login\").style.display='none';\n" +
"                            document.getElementById(\"spacer\").style.display='none';\n" +
"                            document.getElementById(\"loginform\").style.display='block';\n" +
"                            document.getElementById(\"loginform\").style.visibility='visible';\n" +
"                        } else {\n" +
"                            alert(\"Incorrect Password\");\n" +
"                        }\n" +
"                    }\n" +
"                </script>\n" +
"            </div>\n" +
"            <div id=\"loginform\">\n" +
"                <p id=\"Welcome\">Administrator Module</p>\n" +
"                <p id=\"bottomspaced\">Enter your mobile number:</p>\n" +
"                <form action=\"/QueueWebApp/saveChanges\">\n" +
"                    <input id=\"centered\" type=\"password\" name=\"pw\" value=\"" + prefs.get("WEBPW", "") + "\" placeholder=\"Type your password\" onfocus=\"document.getElementById('note').style.display='block'\" onblur=\"document.getElementById('note').style.display='none'\">\n" +
"                    <div id=\"note\">\n" +
"                        <p id=\"format\"><i>Leave it as it is if you don't wish to change your password</i></p>\n" +
"                    </div>\n" +
"                    <p id=bottomspaced>Opening time:</p>\n" +
"                    <select id=\"centered\" name=\"opening\">\n");
//"                        <option value=\"5\">5:00 AM</option>\n" +
//"                        <option value=\"6\">6:00 AM</option>\n" +
//"                        <option value=\"7\">7:00 AM</option>\n" +
//"                        <option value=\"8\">8:00 AM</option>\n" +
//"                        <option value=\"9\">9:00 AM</option>\n" +
//"                        <option value=\"10\">10:00 AM</option>\n" +
//"                        <option value=\"11\">11:00 AM</option>\n" +
//"                        <option value=\"12\">12:00 NN</option>\n" +
//"                        <option value=\"13\">1:00 PM</option>\n" +
//"                        <option value=\"14\">2:00 PM</option>\n" +
//"                        <option value=\"15\">3:00 PM</option>\n" +
//"                        <option value=\"16\">4:00 PM</option>\n" +
//"                        <option value=\"17\">5:00 PM</option>\n" +
//"                        <option value=\"18\">6:00 PM</option>\n" +
//"                        <option value=\"19\">7:00 PM</option>\n" +
//"                        <option value=\"20\">8:00 PM</option>\n" +
//"                        <option value=\"21\">9:00 PM</option>\n" +
//"                        <option value=\"22\">10:00 PM</option>\n" +
//"                        <option value=\"23\">11:00 PM</option>\n" +
//"                        <option value=\"0\">12:00 MN</option>\n" +
//"                        <option value=\"1\">1:00 AM</option>\n" +
//"                        <option value=\"2\">2:00 AM</option>\n" +
//"                        <option value=\"3\">3:00 AM</option>\n" +
//"                        <option value=\"4\">4:00 AM</option>\n" +
            String time=null;
            for(int i=0; i<24; i++) {
                if(i==0)
                    time = "12:00 MN";
                else if(i>0 && i<12)
                    time = i + ":00 AM";
                else if(i==12)
                    time = "12:00 NN";
                else if(i>12 && i<24)
                    time = i-12 + ":00 PM";
                
                if(i == Integer.parseInt(prefs.get("OPENING", "9")))
                    out.println("<option value=\"" + i + "\" selected>" + time + "</option>\n");
                else
                    out.println("<option value=\"" + i + "\">" + time + "</option>\n");
            }
out.print("                    </select>\n" +
"                    <p id=bottomspaced>Closing time:</p>\n" +
"                    <select id=\"centered\" name=\"closing\">\n");
//"                        <option value=\"17\">5:00 PM</option>\n" +
//"                        <option value=\"18\">6:00 PM</option>\n" +
//"                        <option value=\"19\">7:00 PM</option>\n" +
//"                        <option value=\"20\">8:00 PM</option>\n" +
//"                        <option value=\"21\">9:00 PM</option>\n" +
//"                        <option value=\"22\">10:00 PM</option>\n" +
//"                        <option value=\"23\">11:00 PM</option>\n" +
//"                        <option value=\"0\">12:00 MN</option>\n" +
//"                        <option value=\"1\">1:00 AM</option>\n" +
//"                        <option value=\"2\">2:00 AM</option>\n" +
//"                        <option value=\"3\">3:00 AM</option>\n" +
//"                        <option value=\"4\">4:00 AM</option>\n" +
//"                        <option value=\"5\">5:00 AM</option>\n" +
//"                        <option value=\"6\">6:00 AM</option>\n" +
//"                        <option value=\"7\">7:00 AM</option>\n" +
//"                        <option value=\"8\">8:00 AM</option>\n" +
//"                        <option value=\"9\">9:00 AM</option>\n" +
//"                        <option value=\"10\">10:00 AM</option>\n" +
//"                        <option value=\"11\">11:00 AM</option>\n" +
//"                        <option value=\"12\">12:00 NN</option>\n" +
//"                        <option value=\"13\">1:00 PM</option>\n" +
//"                        <option value=\"14\">2:00 PM</option>\n" +
//"                        <option value=\"15\">3:00 PM</option>\n" +
//"                        <option value=\"16\">4:00 PM</option>\n" +
            time=null;
            for(int i=0; i<24; i++) {
                if(i==0)
                    time = "12:00 MN";
                else if(i>0 && i<12)
                    time = i + ":00 AM";
                else if(i==12)
                    time = "12:00 NN";
                else if(i>12 && i<24)
                    time = i-12 + ":00 PM";
                
                if(i == Integer.parseInt(prefs.get("CLOSING", "21")))
                    out.println("<option value=\"" + i + "\" selected>" + time + "</option>\n");
                else
                    out.println("<option value=\"" + i + "\">" + time + "</option>\n");
            }
out.print("                    </select>\n" +
"                    <p id=bottomspaced>Real-time Module Auto-Update Interval:</p> <input type=text name=interval value=\"" + prefs.get("WEBINTERVAL", "5") + "\">\n" +
        "" +
"                    <p id=\"topspaced\" style=\"padding-top:30px;padding-bottom:20px;\" align=\"center\"><input type=\"submit\" value=\"Save Preferences\"></p>\n" +
"                </form>\n" +
"                <br><br>\n" +
"            </div>\n" +
"            \n" +
"\n" +
"            <div id=\"footer\" style=\"padding-top:50px;\">\n" +
"                <p style=\"margin-bottom:1%\">Capstone Project 2014-2015</p>\n" +
"                <p style=\"margin-bottom: 5%\">Patrick Saguinsin | Maidy Santos | Justine Diza | Jasmine Eve</p>\n" +
"            </div>\n" +
"        </div>\n" +
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
