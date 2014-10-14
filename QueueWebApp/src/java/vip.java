/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PatrickJoshua
 */
public class vip extends HttpServlet {

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
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet vip</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet vip at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            out.println("<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>VIP Log In</title>\n" +
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
"                    <div id=\"menuitem\">\n" +
"                        <a href=\"\">\n" +
"                            Home\n" +
"                        </a>\n" +
"                    </div>\n" +
"                    <div class=\"darkerpink\" id=\"menuitem\">\n" +
"                        <a href=\"/vip\">\n" +
"                            VIP\n" +
"                        </a>\n" +
"                    </div>\n" +
"                    <div id=\"menuitem\">\n" +
"                        <a href=\"/realtime\">\n" +
"                            Real-time\n" +
"                        </a>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"        <div id=\"spacer\"></div>\n" +
"        <div id=\"loginbody\">\n" +
"        	<img src=\"../vipimg.jpg\" id=\"vipbg\">\n" +
"        	<div id=\"content\">\n" +
"	        	<div id=\"loginbox\">\n" +
"	        		<div id=\"logincontent\">\n" +
"	        			<p id=\"viplogintxt\">VIP Log In</p>\n" +
"						<br><br>\n" +
"	        			Log in using the account credentials given to you when you availed your VIP status.\n" +
"	        			<br><br><br>\n" +
"	        			<p id=\"bottomspaced\">Username:</p>\n" +
"	        			<input type=\"text\" name=\"username\" placeholder=\"Username\">\n" +
"	        			<br><br>\n" +
"	        			<p id=\"bottomspaced\">Password:</p>\n" +
"	        			<input type=\"password\" name=\"password\" placeholder=\"Password\">\n" +
"	        			<br><br><br>\n" +
"	        			<p align=\"center\"><input type=\"submit\" value=\"Log In\"></p>\n" +
"	        			<br><br>\n" +
"	        			<hr width=\"50%\">\n" +
"	        			<br>\n" +
"	        			<p style=\"font-size: .8em;\">Get in touch with our personnels anytime when you want to inquire or make changes to your account.</p>\n" +
"	        		</div>\n" +
"	        	</div>\n" +
"        	</div>\n" +
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
