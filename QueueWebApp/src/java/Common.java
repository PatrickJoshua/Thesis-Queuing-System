
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PatrickJoshua
 */
public class Common {
    
    public static int ref;
    
    public static int generateReferenceNo()
    {
        Random random = new Random();
        return random.nextInt(999999999);       //9 digit random number
    }
    
    public static Connection connectToDatabase(String host, String user, String pw)
    {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection(host, user, pw);
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle.getMessage());
        }
        return con;
    }
    
    public static void add2History(Connection con, int num, String cellNo, boolean vip, int ref, String name)
    {
        try
        {
            PreparedStatement ps = con.prepareStatement("insert into RECORDSHISTORY values (" + num + ",'" + cellNo + "'," + vip + "," + ref + ",'" + name + "',?,?)");
            
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());  //get current date
            ps.setDate(1, sqlDate);     //set date on SQL statement
            
            java.sql.Time sqlTime = new java.sql.Time(new java.util.Date().getTime());  //get current time
            ps.setTime(2, sqlTime);     //set time on SQL statement
            
            ps.executeUpdate();     //execute SQL statement
            ps.close();
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle.getMessage());
        }
    }
    
    public static int add2DB(Connection con, String cellNo, String name, boolean vip)
    {
        int lastNumber = 0;     //holds the last number in the DB
            
        try
        {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM QUEUETBL WHERE VIP=" + vip);      //execute sql statement, and place result on rs
            
            boolean duplicate = false;
            //detect duplicate
            while(rs.next())    //loop until reached the last VIP
            {
                if(vip)
                {
                    if(cellNo.equals(rs.getString("MOBILENUM")) || name.equalsIgnoreCase(rs.getString("NAME")))      //true if duplicate
                        duplicate = true;
                }
                else
                {
                    if(cellNo.equals(rs.getString("MOBILENUM")))      //true if duplicate
                        duplicate = true;
                }
                
                if(duplicate)
                {
                    lastNumber = rs.getInt("NUM");     //set last number from db
                    lastNumber--;       //temporarily decrement (will be incremented before return)
                    ref = rs.getInt("REF");
                    duplicate = true;
                    break;
                }
            }
            
            if(!duplicate)      //continue if no duplicate detected
            {
                ref = Common.generateReferenceNo();
                if(!rs.last())      //if no one in queue is VIP
                {
                    stmt.executeUpdate("insert into QUEUETBL values (1,'" + cellNo + "'," + vip + "," + ref + ",'" + name + "')");  //insert value to table (1)            
                    add2History(con,1,cellNo,vip,ref,name);     //add to recordshistory table
                }
                else
                {
                    lastNumber = rs.getInt("NUM");       //change this in the future to get last value from a history table
                    lastNumber++;   //use actual position, and write to database
                    stmt.executeUpdate("insert into QUEUETBL values (" + lastNumber + ",'" + cellNo + "'," + vip + "," + ref + ",'" + name + "')");  //insert value to table
                    add2History(con,lastNumber,cellNo,vip,ref,name);    //add to reccordshistory table
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
        return lastNumber;  //return number
    }
}
