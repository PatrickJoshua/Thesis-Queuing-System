
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author PatrickJoshuaSaguinsin
 */
public class ControllerDisplay extends javax.swing.JFrame {

    public static Connection con = null;
    DefaultTableModel model;
    
    public ControllerDisplay() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object [] {"Number","Mobile"});
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
        viewDatabase = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        sqlTF = new javax.swing.JTextField();
        sqlBT = new javax.swing.JButton();
        cNowServing = new javax.swing.JLabel();
        nextBT = new javax.swing.JButton();
        mobilenumLBL = new javax.swing.JLabel();
        refLBL = new javax.swing.JLabel();
        nameLBL = new javax.swing.JLabel();
        transLBL = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        viewDB = new javax.swing.JMenuItem();
        viewRecords = new javax.swing.JMenuItem();
        viewVIP = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cleanup = new javax.swing.JMenuItem();
        clearQueue = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        launchDisplay = new javax.swing.JMenuItem();

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
        servingLBL.setText("None");

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

        viewDatabase.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        viewDatabase.setTitle("View Database");

        table.setModel(model);
        jScrollPane1.setViewportView(table);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("SQL Statement"));

        sqlBT.setText("Execute SQL");
        sqlBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqlBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sqlTF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqlBT)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sqlTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sqlBT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout viewDatabaseLayout = new javax.swing.GroupLayout(viewDatabase.getContentPane());
        viewDatabase.getContentPane().setLayout(viewDatabaseLayout);
        viewDatabaseLayout.setHorizontalGroup(
            viewDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDatabaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        viewDatabaseLayout.setVerticalGroup(
            viewDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDatabaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CSA Queuing System");

        cNowServing.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jMenu1.setText("Menu");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Database");

        jMenu4.setText("View Tables");

        viewDB.setText("View Queue");
        viewDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDBActionPerformed(evt);
            }
        });
        jMenu4.add(viewDB);

        viewRecords.setText("View Records History");
        viewRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRecordsActionPerformed(evt);
            }
        });
        jMenu4.add(viewRecords);

        viewVIP.setText("View VIP List");
        viewVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewVIPActionPerformed(evt);
            }
        });
        jMenu4.add(viewVIP);

        jMenu2.add(jMenu4);
        jMenu2.add(jSeparator1);

        cleanup.setText("Cleanup Queue");
        cleanup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanupActionPerformed(evt);
            }
        });
        jMenu2.add(cleanup);

        clearQueue.setText("Clear Queue");
        clearQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearQueueActionPerformed(evt);
            }
        });
        jMenu2.add(clearQueue);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Window");

        launchDisplay.setText("Launch Display");
        launchDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchDisplayActionPerformed(evt);
            }
        });
        jMenu3.add(launchDisplay);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
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
                .addContainerGap(92, Short.MAX_VALUE))
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

    private void viewDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDBActionPerformed
        executeSQL("QUEUETBL");
        viewDatabase.pack();
        viewDatabase.setLocationRelativeTo(null);
        viewDatabase.setVisible(true);
    }//GEN-LAST:event_viewDBActionPerformed

    private void cleanupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanupActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "This will remove all records on queue dated before today.\nDo you want to continue?", "Potential Data Loss Warning", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          try {
          PreparedStatement ps = con.prepareStatement("delete from QUEUETBL where DATE<>?");
          ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
          JOptionPane.showMessageDialog(null, ps.executeUpdate() + " row(s) deleted", "Cleanup success", JOptionPane.INFORMATION_MESSAGE);
          ps.close();
          } catch (SQLException sqle) {
              JOptionPane.showMessageDialog(null, "Cannot delete old records.\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
          }
        }
    }//GEN-LAST:event_cleanupActionPerformed

    private void clearQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearQueueActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Warning: You are about erase the entire queue.\nNote: This process is irrevesible.\nDo you want to continue?", "Potential Data Loss Warning", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          try {
          PreparedStatement ps = con.prepareStatement("delete from QUEUETBL");
          JOptionPane.showMessageDialog(null, ps.executeUpdate() + " row(s) deleted", "Successfully Deleted Queue", JOptionPane.INFORMATION_MESSAGE);
          ps.close();
          } catch (SQLException sqle) {
              JOptionPane.showMessageDialog(null, "Cannot delete all records on Queue.\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
          }
        }
    }//GEN-LAST:event_clearQueueActionPerformed

    private void sqlBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqlBTActionPerformed
        executeSQL("QUEUETBL");
    }//GEN-LAST:event_sqlBTActionPerformed

    private void viewRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRecordsActionPerformed
        executeSQL("RECORDSHISTORY");
        viewDatabase.pack();
        viewDatabase.setLocationRelativeTo(null);
        viewDatabase.setVisible(true);
    }//GEN-LAST:event_viewRecordsActionPerformed

    private void viewVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewVIPActionPerformed
        executeSQL("VIPCLIENTSTBL");
        viewDatabase.pack();
        viewDatabase.setLocationRelativeTo(null);
        viewDatabase.setVisible(true);
    }//GEN-LAST:event_viewVIPActionPerformed

    private void launchDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchDisplayActionPerformed
        Display.pack();
        Display.setLocationRelativeTo(null);
        Display.setVisible(true);
    }//GEN-LAST:event_launchDisplayActionPerformed

    public void connectToDatabase(String host, String user, String pw)
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
            
            //retrieve now serving
            try {    
                PreparedStatement ps = con.prepareStatement("select * from QUEUETBL where DATE=? and NOWSERVING=true");
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                    updateLabels(rs);
                rs.close();
                ps.close();
            } catch (SQLException sqle) {
              JOptionPane.showMessageDialog(null, "There was a problem retrieving the number currently being served.\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    void executeSQL(String DBtable) {
        try {
            sqlTF.setText("select * from " + DBtable);
            Statement stmt = con.createStatement();
            ResultSet rs;
            if(sqlTF.getText().startsWith("select"))
                rs = stmt.executeQuery(sqlTF.getText());
            else {
                stmt.execute(sqlTF.getText());
                rs = stmt.executeQuery("select * from " + DBtable);
            }
            //String [] columnHeader = {"Number", "Mobile Number", "VIP", "Reference Number", "Name", "Date", "Transaction", "Currently Serving"};
            table.setModel(DbUtils.resultSetToTableModel(rs));
            //JTableHeader
            //table.setTableHeader(null);
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error executing statement: " + sqlTF.getText() + "\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JMenuItem cleanup;
    private javax.swing.JMenuItem clearQueue;
    private javax.swing.JButton connectBT;
    public static javax.swing.JLabel dNowServing;
    private javax.swing.JTextField hostTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem launchDisplay;
    private javax.swing.JLabel mobilenumLBL;
    private javax.swing.JLabel nameLBL;
    public static javax.swing.JButton nextBT;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JLabel refLBL;
    private static javax.swing.JLabel servingLBL;
    private javax.swing.JButton sqlBT;
    private javax.swing.JTextField sqlTF;
    private javax.swing.JTable table;
    private javax.swing.JLabel transLBL;
    private javax.swing.JTextField usernameTF;
    private javax.swing.JMenuItem viewDB;
    public static javax.swing.JFrame viewDatabase;
    private javax.swing.JMenuItem viewRecords;
    private javax.swing.JMenuItem viewVIP;
    // End of variables declaration//GEN-END:variables
}
