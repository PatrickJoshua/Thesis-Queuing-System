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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>VIP Login</title>");            
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            Connection con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
            String username = request.getParameter("username");     //inputted username
            String password = request.getParameter("password");     //inputted password
            if(validateCredentials(con,username,password))          //run the code to validate user credentials
            {
                out.println("<h2>Welcome</h2><b>" + name + "</b>");
                out.println("<br><br>Your mobile number is: ");
                out.println("<form name=viploginsuccess action=getVIPNumberServlet>");      //do not modify
                out.println("<input type=text name=cellNo value=" + mobilenumber + ">");    //do not modify
                out.println("<br><font size=\"2\"><i>Format: +639XXXXXXXXX</i></font> <br>");   
                out.println("<input type=hidden name=name value=\"" + name + "\">");    //do not modify
                con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
                out.println(Common.getTransactions(con));
                out.println("<br>");
                out.println("<input type=\"checkbox\" name=\"prioritize\" checked>Prioritize me<br>");
                out.println("<input type=checkbox name=sms checked>Send me SMS Notifications<br>");
                out.println("<input type=submit value=\"Get VIP Number\">");        //do not modify
                out.println("<br><br><hr width=\"50%\"><br>");      //horizontal line
                con = Common.connectToDatabase("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");    //connect to server
                out.println("<h2>Now Serving:</h2>");
                out.println(Common.getNowServingCounters(con));
                out.println("<br><h3>On Queue:</h3>");
                out.println("<table><tr><td align=center>");
                out.println("VIP: " + Common.getTotal(con, false, true));
                out.println("</td><td align=center>");
                out.println("Guests: " + Common.getTotal(con, false, false));
                out.println("</td></tr><td colspan=2 align=center>");
                out.println("<br>Total persons on queue: " + Common.getTotal(con, true, true));
                out.println("</td></tr></table>");
            }
            else    //if not valid
            {
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Invalid username or password');");      //display pop up message
                out.println("window.history.back();");                      //go back to login page
                out.println("</script>");
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
