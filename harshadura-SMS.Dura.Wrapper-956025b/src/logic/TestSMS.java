package logic;

import com.harshadura.gsm.smsdura.GsmModem;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author     : Harsha Siriwardena  <harshadura@gmail.com>
 * @copyrights : www.Durapix.org     <http://www.durapix.org>
 * @license    : GNU GPL v3          <http://www.gnu.org/licenses/>
 *
 * Example on how to simply send a SMS using the smsdura API Wrapper.
 */
public class TestSMS {

    private static String port = "COM17"; //Modem Port.
    private static int bitRate = 115200; //this is also optional. leave as it is.
    private static String modemName = "Huwawei"; //this is optional.
    private static String modemPin = "0000"; //Pin code if any have assigned to the modem.
    private static String SMSC = "+639170000130"; //Message Center Number ex. Mobitel

    public static void main(String[] args) {
        try {
            GsmModem gsmModem = new GsmModem();
            GsmModem.configModem(port, bitRate, modemName, modemPin, SMSC);
            gsmModem.Sender("+639234026357", "Test Message"); // (tp, msg)
        } catch (Exception ex) {
            System.out.println("Error while sending SMS");
            ex.printStackTrace();
        }
    }
}
