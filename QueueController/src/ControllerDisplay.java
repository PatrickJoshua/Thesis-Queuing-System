
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        nowServingLBL = new javax.swing.JLabel();
        servingLBL = new javax.swing.JLabel();

        Connect2DB.setTitle("Connect to Database");
        Connect2DB.setModal(true);

        jLabel1.setText("Database URL:");

        hostTF.setText("jdbc:derby://localhost:1527/QueueDB");

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

        nowServingLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nowServingLBL.setText("Now Serving");

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
                    .addComponent(nowServingLBL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(servingLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DisplayLayout.setVerticalGroup(
            DisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nowServingLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servingLBL, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CSA Queuing System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            //resizeDisplay();
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Display resizing code ">
    static void resizeDisplay()
    {
        Font labelFont = nowServingLBL.getFont();
        String labelText = nowServingLBL.getText();

        int stringWidth = nowServingLBL.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = nowServingLBL.getWidth();

        // Find out how much the font can grow in width.
        double widthRatio = (double)componentWidth / (double)stringWidth;

        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = nowServingLBL.getHeight();

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentHeight);

        // Set the label's font size to the newly determined size.
        nowServingLBL.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));

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
    private javax.swing.JButton connectBT;
    private javax.swing.JTextField hostTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel nowServingLBL;
    private javax.swing.JPasswordField passwordTF;
    private static javax.swing.JLabel servingLBL;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
