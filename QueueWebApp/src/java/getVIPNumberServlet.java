/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PatrickJoshua
 */
@WebServlet(urlPatterns = {"/getVIPNumberServlet"})
public class getVIPNumberServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    int ref;
        
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
            String cellNo = request.getParameter("cellNo");
            String name = request.getParameter("name");
            String trans = "";
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
                out.println("Your number is: <b>V" + Common.add2DB(con,cellNo,name,true,trans) + "</b><br>Reference Number: " + Common.ref + "<br><br>");
                out.println("Please wait for the text confirmation.");
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
