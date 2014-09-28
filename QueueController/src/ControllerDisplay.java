
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author PatrickJoshuaSaguinsin
 */
public class ControllerDisplay extends javax.swing.JFrame {

    public static Connection con = null;
    
    public ControllerDisplay() {
        initComponents();
        Connect2DB.pack();
        Connect2DB.setLocationRelativeTo(null);
        Connect2DB.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Connect2DB = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        hostTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordTF = new javax.swing.JPasswordField();
        connectBT = new javax.swing.JButton();
        Display = new javax.swing.JFrame();
        dNowServing = new javax.swing.JLabel();
        servingLBL = new javax.swing.JLabel();
        cNowServing = new javax.swing.JLabel();
        nextBT = new javax.swing.JButton();
        mobilenumLBL = new javax.swing.JLabel();
        refLBL = new javax.swing.JLabel();
        nameLBL = new javax.swing.JLabel();
        transLBL = new javax.swing.JLabel();

        Connect2DB.setTitle("Connect to Database");
        Connect2DB.setModal(true);

        jLabel1.setText("Database URL:");

        hostTF.setText("jdbc:derby://localhost:1527/QueueDB");
        hostTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostTFActionPerformed(evt);
            }
        });

        jLabel2.setText("Username:");

        usernameTF.setText("dbadmin");
        usernameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTFActionPerformed(evt);
            }
        });

        jLabel3.setText("Password:");

        passwordTF.setText("dba");
        passwordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTFActionPerformed(evt);
            }
        });

        connectBT.setText("Connect");
        connectBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Connect2DBLayout = new javax.swing.GroupLayout(Connect2DB.getContentPane());
        Connect2DB.getContentPane().setLayout(Connect2DBLayout);
        Connect2DBLayout.setHorizontalGroup(
            Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Connect2DBLayout.createSequentialGroup()
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Connect2DBLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hostTF, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(usernameTF)
                            .addComponent(passwordTF)))
                    .addGroup(Connect2DBLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(connectBT)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        Connect2DBLayout.setVerticalGroup(
            Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Connect2DBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(hostTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(connectBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Display.setTitle("Now Serving");
        Display.setBackground(new java.awt.Color(255, 255, 255));
        Display.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                DisplayComponentResized(evt);
            }
        });

        dNowServing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dNowServing.setText("Now Serving");

        servingLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        servingLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servingLBL.setText("0");

        javax.swing.GroupLayout DisplayLayout = new javax.swing.GroupLayout(Display.getContentPane());
        Display.getContentPane().setLayout(DisplayLayout);
        DisplayLayout.setHorizontalGroup(
            DisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dNowServing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(servingLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DisplayLayout.setVerticalGroup(
            DisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dNowServing, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servingLBL, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CSA Queuing System");

        cNowServing.setText("None");

        nextBT.setText("Next");
        nextBT.setEnabled(false);
        nextBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBTActionPerformed(evt);
            }
        });

        mobilenumLBL.setText("Mobile Number");

        refLBL.setText("Reference Number");

        nameLBL.setText("Name");

        transLBL.setText("Transaction");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nextBT)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cNowServing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(refLBL)
                            .addComponent(mobilenumLBL)
                            .addComponent(nameLBL)
                            .addComponent(transLBL))
                        .addGap(115, 115, 115))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(nameLBL)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cNowServing)
                    .addComponent(mobilenumLBL))
                .addGap(18, 18, 18)
                .addComponent(refLBL)
                .addGap(18, 18, 18)
                .addComponent(transLBL)
                .addGap(7, 7, 7)
                .addComponent(nextBT)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTFActionPerformed
        connectBTActionPerformed(evt);
    }//GEN-LAST:event_usernameTFActionPerformed

    private void connectBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBTActionPerformed
        connectToDatabase(hostTF.getText(),usernameTF.getText(),passwordTF.getText());
    }//GEN-LAST:event_connectBTActionPerformed

    private void passwordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTFActionPerformed
        connectBTActionPerformed(evt);
    }//GEN-LAST:event_passwordTFActionPerformed

    private void DisplayComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_DisplayComponentResized
        resizeDisplay();
    }//GEN-LAST:event_DisplayComponentResized

    //start of developer-creaed methods
    void deletePreviouslyServed() {
        try {
            con.createStatement().executeUpdate("delete from QUEUETBL where NOWSERVING=true");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error deleting previously served number.\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);   
        }
    }
            
    void updateLabels(ResultSet rs)
    {
        try {
            if(rs.getBoolean("VIP"))   //transfer data from db to GUI labels on controller
                cNowServing.setText("V" + rs.getInt("NUM"));    //if VIP
            else
                cNowServing.setText("N" + rs.getInt("NUM"));    //non-vip guest
            mobilenumLBL.setText(rs.getString("MOBILENUM"));    
            refLBL.setText(rs.getInt("REF") + "");
            nameLBL.setText(rs.getString("NAME"));
            transLBL.setText(rs.getString("TRANS"));
            rs.close();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update QUEUETBL set NOWSERVING=true where MOBILENUM='" + mobilenumLBL.getText() + "'"); //set now serving field to true
            stmt.close();
            servingLBL.setText(cNowServing.getText());   //set now serving on display
            //play tone
            //insert SMS code here
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error retreiving data\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void nextBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBTActionPerformed
        try {
            deletePreviouslyServed();
            PreparedStatement ps = con.prepareStatement("select * from QUEUETBL where DATE=? and VIP=true");    //query to get VIP first
            ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));   //get current date
            ResultSet rs = ps.executeQuery();   //execute SQL statement
            if(rs.next()) {    //if there is a VIP on queue
                updateLabels(rs);   //transfer retrieved DB data to GUI
            }
            else {
                ps = con.prepareStatement("select * from QUEUETBL where DATE=? and VIP=fals");  //get non-vip guest
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));   //get current date
                rs = ps.executeQuery();
                if(rs.next()) {    //if there is a non-vip guest on queue
                    updateLabels(rs);
                }
                else {  //if queue is empty
                    cNowServing.setText("None");//transfer data from db to GUI labels on controller
                    mobilenumLBL.setText("-");    
                    refLBL.setText("-");
                    nameLBL.setText("-");
                    transLBL.setText("-");
                    servingLBL.setText("None");
                }
            }
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error retreiving data\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nextBTActionPerformed

    private void hostTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostTFActionPerformed
        connectBTActionPerformed(evt);
    }//GEN-LAST:event_hostTFActionPerformed

    public static void connectToDatabase(String host, String user, String pw)
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(host, user, pw);
            //con = DriverManager.getConnection("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClassNotFoundException cnfe)
        {
            JOptionPane.showMessageDialog(null, cnfe.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            cnfe.printStackTrace();
        }
        if(con != null)
        {
            Connect2DB.hide();
            Display.pack();
            Display.setLocationRelativeTo(null);
            Display.setVisible(true);
            nextBT.setEnabled(true);
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Display resizing code ">
    static void resizeDisplay()
    {
        Font labelFont = dNowServing.getFont();
        String labelText = dNowServing.getText();

        int stringWidth = dNowServing.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = dNowServing.getWidth();

        // Find out how much the font can grow in width.
        double widthRatio = (double)componentWidth / (double)stringWidth;

        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = dNowServing.getHeight();

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentHeight);

        // Set the label's font size to the newly determined size.
        dNowServing.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));

        //Number
        Font labelFont1 = servingLBL.getFont();
        String labelText1 = servingLBL.getText();

        int stringWidth1 = servingLBL.getFontMetrics(labelFont1).stringWidth(labelText1);
        int componentWidth1 = servingLBL.getWidth();

        // Find out how much the font can grow in width.
        double widthRatio1 = (double)componentWidth1 / (double)stringWidth1;

        int newFontSize1 = (int)(labelFont1.getSize() * widthRatio1);
        int componentHeight1 = servingLBL.getHeight();

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse1 = Math.min(newFontSize1, componentHeight1);

        // Set the label's font size to the newly determined size.
        servingLBL.setFont(new Font(labelFont1.getName(), Font.PLAIN, fontSizeToUse1));
    }
    //</editor-fold>
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControllerDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControllerDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControllerDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControllerDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControllerDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDialog Connect2DB;
    public static javax.swing.JFrame Display;
    public static javax.swing.JLabel cNowServing;
    private javax.swing.JButton connectBT;
    public static javax.swing.JLabel dNowServing;
    private javax.swing.JTextField hostTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mobilenumLBL;
    private javax.swing.JLabel nameLBL;
    public static javax.swing.JButton nextBT;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JLabel refLBL;
    private static javax.swing.JLabel servingLBL;
    private javax.swing.JLabel transLBL;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
