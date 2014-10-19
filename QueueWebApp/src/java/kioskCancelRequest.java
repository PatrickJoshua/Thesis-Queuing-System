/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(urlPatterns = {"/kioskCancelRequest"})
public class kioskCancelRequest extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Request Cancelled</title>");            
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");   
            out.println("</head>");
            out.println("<body>");
            /*Do not modify all codes below this */
            int num = Integer.parseInt(request.getParameter("num"));
            boolean vip = Boolean.parseBoolean(request.getParameter("vip"));
            try {
                Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");
                Statement stmt = con.createStatement();
                System.out.println("Removed " + stmt.executeUpdate("delete from QUEUETBL where NUM=" + num + " and VIP=" + vip));
                stmt.close();
                con.close();
                //out.println("<center>Your number has been removed from the queue</center>");
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Your number has been removed from the queue. Press OK to go back to the homepage');");      //display pop up message
                out.println("window.location = '/QueueWebApp/kiosk';");                      //go back to login page
                out.println("</script>");
            } catch (SQLException sqle) {
                //out.println("Cannot cancel request. " + sqle.getMessage());
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Cannot cancel request. " + sqle.getMessage() +"');");      //display pop up message
                out.println("window.location = '/QueueWebApp/kiosk';");                      //go back to login page
                out.println("</script>");
            }
            /*End of do not modify*/
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
