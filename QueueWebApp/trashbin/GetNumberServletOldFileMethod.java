/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/getNumberServlet"})
public class GetNumberServletOldFileMethod extends HttpServlet {

    String cellphoneGlobal;
    int positionGlobal,refGlobal;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public int generateReferenceNo()
    {
        Random random = new Random();
        return random.nextInt(999999999);       //9 digit random number
    }
    
    public int getPosition(File file)
    {
        int counter = 1;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for(counter = 1; (br.readLine() != null); counter++);         //loop to get last line
            br.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("Cannot get position. File " + file.getName() + " not found.");
        }
        catch (IOException ioe)
        {
            System.err.println("IOException while getting position");
        }
        return counter;
    }
    
    public boolean checkDuplicate(String incomingCellNo, File file)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line,split = ",";
            while((line = br.readLine()) != null)
            {
                String[] data = line.split(split);
                if(data[1].equals(incomingCellNo))
                {
                    System.err.println("Duplicate detected");
                    br.close();
                    positionGlobal = Integer.parseInt(data[0]);
                    cellphoneGlobal = data[1];
                    refGlobal = Integer.parseInt(data[2]);
                    return true;
                }
            }
            br.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("Cannot check for duplicate. File " + file.getName() + " not found.");
        }
        catch (IOException ioe)
        {
            System.err.println("IOException while checking for duplicate.");
        }
        return false;
    }
    
    public boolean add2queue(String cellNo)
    {
        File folder = new File(System.getProperty("user.home") + "/WebAppFiles");    //folder
        if(!folder.exists())
            if(!folder.mkdir())
                System.out.println("Cannot create directory.");
        File queueFile = new File(System.getProperty("user.home") + "/WebAppFiles/QueueFile.csv");    //file
        int ref = generateReferenceNo();
        int position = getPosition(queueFile);
        try
        {
            if(!queueFile.exists())                     //create new file if it doesn't exist
                queueFile.createNewFile();
            if(!checkDuplicate(cellNo,queueFile))       //verify duplicate
            {    
                BufferedWriter queueWriter = new BufferedWriter(new FileWriter(queueFile,true));
                queueWriter.append(position + "," + cellNo + "," + ref);    //write position, cellNo, and referenceNo to file
                queueWriter.newLine();
                queueWriter.close();
                positionGlobal = position;
                cellphoneGlobal = cellNo;
                refGlobal = ref;
            }
            else
                return true;            //return true if duplicate
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("Queue File not found.");
        }
        catch (IOException ioe)
        {
            System.err.println("IOException occured while trying to add to the queue file.");
        }
        return false;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Queuing System Web App</title>");         
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            String cellNo = request.getParameter("cellNo");
            if(add2queue(cellNo))
                out.println("<b><font>Record Found</font></b>");
            else
                out.println("<b><font>You have been added to the queue</font></b>");
            out.println("<br><br><br>Cellphone Number: " + cellphoneGlobal);
            out.println("<br><h3>Your queue number is " + positionGlobal + " </h3>");
            out.println("Reference Number: " + refGlobal + "<br>");
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
