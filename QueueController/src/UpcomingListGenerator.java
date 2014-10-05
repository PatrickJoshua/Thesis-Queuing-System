
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        while(true) {
            try {
                //Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                PreparedStatement ps = con.prepareStatement("select NUM from QUEUETBL where VIP=true AND DATE=? and NOWSERVING IS NULL",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                ResultSet rs = ps.executeQuery();
                if(rs.last()) {     //go to last; determine number of rows returned
                    String [] list = new String[rs.getRow()];   //create array
                    rs.beforeFirst();   //go back to first
                    for(int i=0; rs.next(); i++)    //transfer returned data to an array
                        list[i] = "V" + rs.getInt(1);
                    ControllerDisplay.vipList.setListData(list);
                }
                else
                    ControllerDisplay.vipList.setListData(new String[0]);
                
                //for guest list
                ps = con.prepareStatement("select NUM from QUEUETBL where VIP=false AND DATE=? and NOWSERVING IS NULL",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                rs = ps.executeQuery();
                if(rs.last()) {     //go to last; determine number of rows returned
                    String [] list = new String[rs.getRow()];   //create array
                    rs.beforeFirst();   //go back to first
                    for(int i=0; rs.next(); i++)    //transfer returned data to an array
                        list[i] = "N" + rs.getInt(1);
                    ControllerDisplay.guestList.setListData(list);
                }
                else
                    ControllerDisplay.guestList.setListData(new String[0]);
                
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