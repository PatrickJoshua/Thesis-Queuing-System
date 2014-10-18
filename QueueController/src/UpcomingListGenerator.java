
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author PatrickJoshua
 */
public class UpcomingListGenerator extends Thread {
    
    Connection con;
    
    public UpcomingListGenerator(Connection conn) {
        con = conn;
    }
    
    @Override
    public void run() {
        boolean emptyVIP = true;
        boolean emptyGuest = true;
        int previousVIPList = 0;
        int previousGuestList = 0;
        String trans = null;
        
        while(true) {
            try {
                boolean nextIsVIP = false;
                //Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                PreparedStatement ps = con.prepareStatement("select NUM,TRANS from QUEUETBL where VIP=true AND DATE=? and COUNTER IS NULL ORDER BY NUM",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                ResultSet rs = ps.executeQuery();
                if(rs.last()) {     //go to last; determine number of rows returned
                    String [] list = new String[rs.getRow()];   //create array
                    rs.beforeFirst();   //go back to first
                    for(int i=0; rs.next(); i++) {    //transfer returned data to an array
                        list[i] = "V" + rs.getInt(1);
                        if(i==0)
                            trans = rs.getString(2);
                    }
                    ControllerDisplay.vipList.setListData(list);
                    ControllerDisplay.nextLBL.setText("Next: " + list[0] + " (" + trans + ")");
                    nextIsVIP = true;
                    if(list.length != previousVIPList) {
                        //play tone
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("newvip.wav"));
                            Clip tone = AudioSystem.getClip();
                            tone.open(ais);
                            tone.start();
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException x) {
                            System.err.println("Error playing notification tone. " + x.getMessage());
                        }
                        previousVIPList = list.length;
                    }
                }
                else {
                    ControllerDisplay.vipList.setListData(new String[]{"     "});
                }
                
                //for guest list
                ps = con.prepareStatement("select NUM,TRANS from QUEUETBL where VIP=false AND DATE=? and COUNTER IS NULL ORDER BY NUM",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                rs = ps.executeQuery();
                if(rs.last()) {     //go to last; determine number of rows returned
                    String [] list = new String[rs.getRow()];   //create array
                    rs.beforeFirst();   //go back to first
                    for(int i=0; rs.next(); i++) {    //transfer returned data to an array
                        list[i] = "N" + rs.getInt(1);
                        if(i==0)
                            trans = rs.getString(2);
                    }
                    ControllerDisplay.guestList.setListData(list);
                    if(!nextIsVIP)
                        ControllerDisplay.nextLBL.setText("Next: " + list[0] + " (" + trans + ")");
                    //play tone
                    if(list.length != previousGuestList) {
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("newguest.wav"));
                            Clip tone = AudioSystem.getClip();
                            tone.open(ais);
                            tone.start();
                            System.out.println("Play tone guest");
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException x) {
                            System.err.println("Error playing notification tone. " + x.getMessage());
                        }
                        previousGuestList = list.length;
                    }
                }
                else {
                    ControllerDisplay.guestList.setListData(new String[]{"     "});
                    if(!nextIsVIP)
                        ControllerDisplay.nextLBL.setText("Next: None");
                    emptyGuest = true;
                }
                
                //repeat after 5 seconds
                Thread.sleep(5000);
            } catch (SQLException sqle) {
                System.err.println("Failed refreshing upcoming list. " + sqle.getMessage());
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }
        }
    }
}
