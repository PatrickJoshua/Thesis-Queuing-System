
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PatrickJoshua
 */
public class Information extends Thread {
    
    String message;
    boolean blink;
    
    public Information(String msg, boolean blnk) {
        message = msg;
        blink = blnk;
    }
    
    @Override
    public void run() {
        try {
            ControllerDisplay.info.setText("Information: " + message);
            if(blink) {
                Color origColor = new Color(51,51,51);
                ControllerDisplay.info.setForeground(Color.red);
                Thread.sleep(1000);
                ControllerDisplay.info.setForeground(origColor);
            }
            Thread.sleep(5000);
            ControllerDisplay.info.setText("Information: ");
        } catch (InterruptedException ie) {
            System.out.println("Cannot display this error message on GUI: " + message);
            System.err.println("Reason: " + ie.getMessage());
        }
    }
}
