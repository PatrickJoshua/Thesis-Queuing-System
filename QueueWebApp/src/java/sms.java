/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PatrickJoshua
 */
import com.harshadura.gsm.smsdura.GsmModem;
public class sms {
    private static String port = "COM17"; //Modem Port.
    private static int bitRate = 115200; //this is also optional. leave as it is.
    private static String modemName = "Huwawei"; //this is optional.
    private static String modemPin = "0000"; //Pin code if any have assigned to the modem.
    private static String SMSC = "+639170000130"; //Message Center Number ex. Mobitel
    String receiver,message;
    
    public sms(String r, String m) {
        receiver = r;
        message = m;
        try {
            GsmModem gsmModem = new GsmModem();
            GsmModem.configModem(port, bitRate, modemName, modemPin, SMSC);
            gsmModem.Sender(receiver, message); // (tp, msg)
        } catch (Exception ex) {
            System.out.println("Error while sending SMS");
            ex.printStackTrace();
        }
    }
}
