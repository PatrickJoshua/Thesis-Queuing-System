
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PatrickJoshua
 */
class TicketPrinter implements Printable {
    
    String ticket,trans;
    int ref;
    
    public TicketPrinter(String ticket, String trans, int ref) {
        this.ticket = ticket;
        this.trans = trans;
        this.ref = ref;
    }
    
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if(page > 0)
            return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        BufferedImage img = null;
        ImageIcon icon = new ImageIcon("../printlogo.png");
        
        //g.setColor(Color.RED);
        g.drawString("CSA Derm Centre", 175, 10);
        
        g.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        g.drawString(ticket, 205, 38);
        
        g.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        g.drawString(trans, 175, 55);
        
        g.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        g.drawString("Ref#: " + ref, 175, 70);
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyy");
        g.drawString(sdf.format(new java.util.Date()) + "", 175, 85);
        
        return PAGE_EXISTS;
    }
}

public class PrintTicket {
    public PrintTicket (String ticket, String trans, int ref) {
        //printing module
        java.awt.print.PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new TicketPrinter(ticket, trans, ref));
        //boolean doPrint = job.printDialog();
        if(true) {
            try {
                job.print();
            } catch (PrinterException e) {
                System.err.println("Error printing the number. " + e.getMessage());
            }
        }
    }
}