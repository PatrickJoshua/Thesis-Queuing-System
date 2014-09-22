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
    
    String add2DB(Connection con, String cellNo, String name)
    {
        int lastNumber = 0;     //holds the last number of VIP in the DB
            
        try
        {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM QUEUETBL WHERE VIP=TRUE");      //execute sql statement, and place result on rs
            
            boolean duplicate = false;
            //detect duplicate
            while(rs.next())    //loop until reached the last VIP
            {
                if(cellNo.equals(rs.getString("MOBILENUM")) || name.equalsIgnoreCase(rs.getString("NAME")))      //true if duplicate
                {
                    lastNumber = rs.getInt("NUM");     //set last number from db
                    lastNumber--;       //temporarily decrement (will be incremented before return)
                    ref = rs.getInt("REF");
                    duplicate = true;
                }
            }
            if(!duplicate)      //continue if no duplicate detected
            {
                ref = Common.generateReferenceNo();
                if(!rs.last())      //if no one in queue is VIP
                    stmt.execute("insert into QUEUETBL values (1,'" + cellNo + "',true," + ref + ",'" + name + "')");  //insert value to table (1)            
                else
                {
                    lastNumber = rs.getInt("NUM");       //change this in the future to get last value from a history table
                    lastNumber++;   //use actual position, and write to database
                    stmt.execute("insert into QUEUETBL values (" + lastNumber + ",'" + cellNo + "',true," + ref + ",'" + name + "')");  //insert value to table
                    lastNumber--;   //revert to lastNumber after writing to database
                }
            }
            //close necessary objects
            rs.close();     
            stmt.close();
            con.close();
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle.getMessage());
        }
        lastNumber++;
        return "V" + lastNumber;  //return number, like "V1"
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
            String cellNo = request.getParameter("cellNo");
            String name = request.getParameter("name");
            Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
            out.println("Your number is: <b>V" + Common.add2DB(con,cellNo,name,true) + "</b><br>Reference Number: " + Common.ref + "<br><br>");
            out.println("Please wait for the text confirmation.");
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
