import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author PatrickJoshuaSaguinsin
 */
public class ControllerDisplay extends javax.swing.JFrame {

    public static Connection con = null;
    DefaultTableModel model;
    Preferences prefs;
    String currentTBL;
    public static int counter;
    public static int SMSINTERVAL;
    ResultSet previousRS = null;
    ResultSet currentRS = null;
    PreparedStatement previousPS = null;
    PreparedStatement currentPS = null;
    boolean undoed = false;
    String [] previous,current;
    Thread upcominglistgeneratorThread = new Thread();

    public ControllerDisplay() {
        initComponents();
        
        //for logging
        DefaultCaret caret = (DefaultCaret)log.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        PrintStream out = new PrintStream(new Log(log));
        System.setOut(out);
        System.setErr(out);
        System.out.println("Welcome to Queuing Management System Controller");
        
        //retrieve preferences
        prefs = Preferences.userRoot();
        hostTF.setText(prefs.get("DBHOST", "jdbc:derby://localhost:1527/QueueDB"));
        usernameTF.setText(prefs.get("DBUSERNAME", "dbadmin"));
        passwordTF.setText(prefs.get("DBPASSWORD", "dba"));
        counterSpinner.setValue(Integer.parseInt(prefs.get("COUNTER", "1")));
        intervalSpinner.setValue(Integer.parseInt(prefs.get("SMSINTERVAL", "5")));
        updateInterval.setValue(Integer.parseInt(prefs.get("CONTROLLERINTERVAL", "5000")));
        accountID.setText(prefs.get("ACCOUNTID", ""));
        email.setText(prefs.get("EMAIL", ""));
        smsPassword.setText(prefs.get("SMSPASSWORD", ""));
        if(prefs.get("COUNTER", "0").equals("0")) {
            hostTF.setText(prefs.get("DBHOST", "jdbc:derby://localhost:1527/QueueDB"));
            usernameTF.setText(prefs.get("DBUSERNAME", "dbadmin"));
            passwordTF.setText(prefs.get("DBPASSWORD", "dba"));
            counterSpinner.setValue(Integer.parseInt(prefs.get("COUNTER", "1")));
            updateInterval.setValue(Integer.parseInt(prefs.get("CONTROLLERINTERVAL", "5000")));
            Connect2DB.pack();
            Connect2DB.setLocationRelativeTo(null);
            Connect2DB.setVisible(true);
        } else
            connectToDatabase(hostTF.getText(), usernameTF.getText(), passwordTF.getText(), counterSpinner.getValue().toString(), intervalSpinner.getValue().toString(), updateInterval.getValue().toString(), accountID.getText(), email.getText(), smsPassword.getText());
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
        counterSpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        cancelPrefsBT = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        intervalSpinner = new javax.swing.JSpinner();
        updateInterval = new javax.swing.JSpinner();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        accountID = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        smsPassword = new javax.swing.JPasswordField();
        Display = new javax.swing.JFrame();
        nowServingLBL = new javax.swing.JLabel();
        dNowServing = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        viewDatabase = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        sqlTF = new javax.swing.JTextField();
        sqlBT = new javax.swing.JButton();
        addVIPDiag = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        mn = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        pw = new javax.swing.JPasswordField();
        cpw = new javax.swing.JPasswordField();
        addVIPOK = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        editVIPDiag = new javax.swing.JDialog();
        combo = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        fne = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        mne = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        une = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        pwe = new javax.swing.JPasswordField();
        editVIPBT = new javax.swing.JButton();
        deleteVIPBT = new javax.swing.JButton();
        editTransDiag = new javax.swing.JDialog();
        comboTrans = new javax.swing.JComboBox();
        editTransBT = new javax.swing.JButton();
        deleteTransBT = new javax.swing.JButton();
        logFrame = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        selectedDiag = new javax.swing.JDialog();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        selectedSMS = new javax.swing.JCheckBox();
        selectedRef = new javax.swing.JLabel();
        selectedTrans = new javax.swing.JLabel();
        selectedNum = new javax.swing.JLabel();
        selectedName = new javax.swing.JLabel();
        changeAdminDiag = new javax.swing.JDialog();
        jLabel30 = new javax.swing.JLabel();
        pw1 = new javax.swing.JPasswordField();
        jLabel31 = new javax.swing.JLabel();
        pw2 = new javax.swing.JPasswordField();
        changePasswordBT = new javax.swing.JButton();
        cNowServing = new javax.swing.JLabel();
        nextBT = new javax.swing.JButton();
        mobilenumLBL = new javax.swing.JLabel();
        refLBL = new javax.swing.JLabel();
        nameLBL = new javax.swing.JLabel();
        transLBL = new javax.swing.JLabel();
        nextLBL = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        callAgainBT = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        guestList = new javax.swing.JList();
        scroll = new javax.swing.JScrollPane();
        vipList = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        previousBT = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenu1 = new javax.swing.JMenu();
        connectToDatabaseAgain = new javax.swing.JMenuItem();
        preferences = new javax.swing.JMenuItem();
        changeAdminMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        logMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        viewDB = new javax.swing.JMenuItem();
        viewRecords = new javax.swing.JMenuItem();
        viewVIP = new javax.swing.JMenuItem();
        add = new javax.swing.JMenu();
        addVIP = new javax.swing.JMenuItem();
        addTrans = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        editDeleteVIP = new javax.swing.JMenuItem();
        editTrans = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        cleanup = new javax.swing.JMenuItem();
        clearQueue = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        clrHistory = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        launchDisplay = new javax.swing.JMenuItem();
        fullscreen = new javax.swing.JMenuItem();
        restore = new javax.swing.JMenuItem();
        closeDisplay = new javax.swing.JMenuItem();

        Connect2DB.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Connect2DB.setTitle("Connect to Database");
        Connect2DB.setIconImage(new ImageIcon("resources/icon.png").getImage());
        Connect2DB.setModal(true);

        jLabel1.setText("Database URL:");

        hostTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostTFActionPerformed(evt);
            }
        });

        jLabel2.setText("Username:");

        usernameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTFActionPerformed(evt);
            }
        });

        jLabel3.setText("Password:");

        passwordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTFActionPerformed(evt);
            }
        });

        connectBT.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        connectBT.setText("Save Preferences");
        connectBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBTActionPerformed(evt);
            }
        });

        counterSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel5.setText("Counter #:");

        cancelPrefsBT.setText("Cancel");
        cancelPrefsBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPrefsBTActionPerformed(evt);
            }
        });

        jLabel23.setText("SMS Notifications Interval:");

        intervalSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1)));

        updateInterval.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5000), Integer.valueOf(100), null, Integer.valueOf(100)));

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Upcoming List Database Refresh Interval (ms)");

        jLabel33.setText("SMS Red Oxygen Account:");

        jLabel34.setText("Account ID:");

        jLabel35.setText("Email:");

        jLabel36.setText("Password:");

        javax.swing.GroupLayout Connect2DBLayout = new javax.swing.GroupLayout(Connect2DB.getContentPane());
        Connect2DB.getContentPane().setLayout(Connect2DBLayout);
        Connect2DBLayout.setHorizontalGroup(
            Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Connect2DBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Connect2DBLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(counterSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(intervalSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Connect2DBLayout.createSequentialGroup()
                        .addGap(0, 46, Short.MAX_VALUE)
                        .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Connect2DBLayout.createSequentialGroup()
                                .addComponent(cancelPrefsBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(connectBT))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Connect2DBLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateInterval, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Connect2DBLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(33, 33, 33)
                        .addComponent(accountID))
                    .addGroup(Connect2DBLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(62, 62, 62)
                        .addComponent(email))
                    .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Connect2DBLayout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addGap(40, 40, 40)
                            .addComponent(smsPassword))
                        .addGroup(Connect2DBLayout.createSequentialGroup()
                            .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Connect2DBLayout.createSequentialGroup()
                                    .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(hostTF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(usernameTF)
                                        .addComponent(passwordTF)))
                                .addComponent(jLabel33))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
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
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(accountID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(smsPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(counterSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel23)
                    .addComponent(intervalSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(Connect2DBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectBT)
                    .addComponent(cancelPrefsBT))
                .addContainerGap())
        );

        Display.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Display.setTitle("Now Serving");
        Display.setBackground(new java.awt.Color(255, 255, 255));
        Display.setIconImage(new ImageIcon("resources/icon.png").getImage());
        Display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DisplayMouseClicked(evt);
            }
        });
        Display.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                DisplayComponentResized(evt);
            }
        });

        nowServingLBL.setBackground(new java.awt.Color(255, 255, 255));
        nowServingLBL.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nowServingLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nowServingLBL.setText("Counter");

        dNowServing.setBackground(new java.awt.Color(255, 255, 255));
        dNowServing.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        dNowServing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dNowServing.setText("None");

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon("C:\\Users\\PatrickJoshua\\OneDrive\\Capstone Project (Thesis)\\Barbie-Queue\\Thesis-Queuing-System\\QueueController\\resources\\banner.png")); // NOI18N

        javax.swing.GroupLayout DisplayLayout = new javax.swing.GroupLayout(Display.getContentPane());
        Display.getContentPane().setLayout(DisplayLayout);
        DisplayLayout.setHorizontalGroup(
            DisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nowServingLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dNowServing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DisplayLayout.setVerticalGroup(
            DisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayLayout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(nowServingLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dNowServing, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(130, 130, 130))
        );

        viewDatabase.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        viewDatabase.setTitle("View Database");
        viewDatabase.setIconImage(new ImageIcon("resources/icon.png").getImage());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("SQL Statement"));

        sqlTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqlTFActionPerformed(evt);
            }
        });

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

        addVIPDiag.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addVIPDiag.setTitle("Add a VIP");
        addVIPDiag.setIconImage(new ImageIcon("resources/icon.png").getImage());

        jLabel12.setText("Full Name:");

        jLabel13.setText("Mobile Number: ");

        jLabel14.setText("Username: ");

        jLabel15.setText("Password:");

        jLabel16.setText("Confirm Password:");

        addVIPOK.setText("OK");
        addVIPOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVIPOKActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        jLabel17.setText("Format: +639XXXXXXXXX");

        javax.swing.GroupLayout addVIPDiagLayout = new javax.swing.GroupLayout(addVIPDiag.getContentPane());
        addVIPDiag.getContentPane().setLayout(addVIPDiagLayout);
        addVIPDiagLayout.setHorizontalGroup(
            addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addVIPDiagLayout.createSequentialGroup()
                .addGroup(addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addVIPDiagLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(addVIPOK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addVIPDiagLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(27, 27, 27)
                        .addGroup(addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fn)
                                .addComponent(mn)
                                .addComponent(un)
                                .addComponent(pw)
                                .addComponent(cpw, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addVIPDiagLayout.setVerticalGroup(
            addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addVIPDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(mn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(un, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cpw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addVIPOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editVIPDiag.setIconImage(new ImageIcon("resources/icon.png").getImage());

        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel18.setText("Username: ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));

        jLabel19.setText("Full Name: ");

        fne.setEnabled(false);

        jLabel20.setText("Mobile Number:");

        mne.setEnabled(false);

        jLabel21.setText("Username:");

        une.setEnabled(false);

        jLabel22.setText("Password: ");

        pwe.setEnabled(false);

        editVIPBT.setText("Edit Record");
        editVIPBT.setEnabled(false);
        editVIPBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editVIPBTActionPerformed(evt);
            }
        });

        deleteVIPBT.setText("Delete Record");
        deleteVIPBT.setEnabled(false);
        deleteVIPBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVIPBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fne)
                            .addComponent(mne)
                            .addComponent(une)
                            .addComponent(pwe)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(editVIPBT, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteVIPBT, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(fne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(mne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(une, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(pwe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editVIPBT)
                    .addComponent(deleteVIPBT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editVIPDiagLayout = new javax.swing.GroupLayout(editVIPDiag.getContentPane());
        editVIPDiag.getContentPane().setLayout(editVIPDiagLayout);
        editVIPDiagLayout.setHorizontalGroup(
            editVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editVIPDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editVIPDiagLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        editVIPDiagLayout.setVerticalGroup(
            editVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editVIPDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editVIPDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editTransDiag.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editTransDiag.setTitle("Select Transaction");
        editTransDiag.setIconImage(new ImageIcon("resources/icon.png").getImage());

        comboTrans.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        editTransBT.setText("Edit Transaction");
        editTransBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTransBTActionPerformed(evt);
            }
        });

        deleteTransBT.setText("Delete Transaction");
        deleteTransBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTransBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editTransDiagLayout = new javax.swing.GroupLayout(editTransDiag.getContentPane());
        editTransDiag.getContentPane().setLayout(editTransDiagLayout);
        editTransDiagLayout.setHorizontalGroup(
            editTransDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTransDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editTransDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(comboTrans, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(editTransDiagLayout.createSequentialGroup()
                        .addComponent(editTransBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteTransBT)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editTransDiagLayout.setVerticalGroup(
            editTransDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTransDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(editTransDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTransBT)
                    .addComponent(deleteTransBT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logFrame.setTitle("System Log");
        logFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());

        log.setColumns(20);
        log.setRows(5);
        jScrollPane3.setViewportView(log);

        javax.swing.GroupLayout logFrameLayout = new javax.swing.GroupLayout(logFrame.getContentPane());
        logFrame.getContentPane().setLayout(logFrameLayout);
        logFrameLayout.setHorizontalGroup(
            logFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        logFrameLayout.setVerticalGroup(
            logFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        selectedDiag.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        selectedDiag.setTitle("View Queue Details");
        selectedDiag.setIconImage(new ImageIcon("resources/icon.png").getImage());

        jLabel24.setText("Name: ");

        jLabel25.setText("Mobile Number:");

        jLabel26.setText("Reference Number:");

        jLabel27.setText("Transactions:");

        jLabel28.setText("SMS Notifications:");

        selectedSMS.setText("Enabled");
        selectedSMS.setFocusable(false);
        selectedSMS.setRequestFocusEnabled(false);
        selectedSMS.setRolloverEnabled(false);

        selectedRef.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectedRef.setText("Ref");

        selectedTrans.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectedTrans.setText("Trans");

        selectedNum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectedNum.setText("Number");

        selectedName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectedName.setText("Name");

        javax.swing.GroupLayout selectedDiagLayout = new javax.swing.GroupLayout(selectedDiag.getContentPane());
        selectedDiag.getContentPane().setLayout(selectedDiagLayout);
        selectedDiagLayout.setHorizontalGroup(
            selectedDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectedDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectedDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(selectedDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectedName)
                    .addComponent(selectedNum)
                    .addComponent(selectedTrans)
                    .addComponent(selectedSMS)
                    .addComponent(selectedRef))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        selectedDiagLayout.setVerticalGroup(
            selectedDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectedDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectedDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(selectedName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectedDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(selectedNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectedDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(selectedRef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectedDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(selectedTrans))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectedDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(selectedSMS))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        changeAdminDiag.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        changeAdminDiag.setTitle("Change Administrator Password");

        jLabel30.setText("New Password:");

        pw1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pw1ActionPerformed(evt);
            }
        });

        jLabel31.setText("Confirm Password:");

        pw2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pw2ActionPerformed(evt);
            }
        });

        changePasswordBT.setText("Change Password");
        changePasswordBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout changeAdminDiagLayout = new javax.swing.GroupLayout(changeAdminDiag.getContentPane());
        changeAdminDiag.getContentPane().setLayout(changeAdminDiagLayout);
        changeAdminDiagLayout.setHorizontalGroup(
            changeAdminDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeAdminDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(changeAdminDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(pw1)
                    .addComponent(pw2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeAdminDiagLayout.createSequentialGroup()
                        .addGap(0, 81, Short.MAX_VALUE)
                        .addComponent(changePasswordBT)))
                .addContainerGap())
        );
        changeAdminDiagLayout.setVerticalGroup(
            changeAdminDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeAdminDiagLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changePasswordBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Offline");
        setIconImage(new ImageIcon("resources/icon.png").getImage());
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cNowServing.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cNowServing.setText("None");

        nextBT.setText("Next");
        nextBT.setEnabled(false);
        nextBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBTActionPerformed(evt);
            }
        });

        mobilenumLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mobilenumLBL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mobilenumLBL.setText("Mobile Number");

        refLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refLBL.setText("Reference Number");

        nameLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nameLBL.setText("Name");

        transLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        transLBL.setText("Transaction");

        nextLBL.setForeground(new java.awt.Color(153, 153, 153));
        nextLBL.setText("Next:");

        jLabel4.setText("You're Serving:");

        callAgainBT.setText("Call Again");
        callAgainBT.setEnabled(false);
        callAgainBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callAgainBTActionPerformed(evt);
            }
        });

        info.setForeground(new java.awt.Color(51, 51, 51));
        info.setText("Not Connected");

        jLabel6.setText("Name: ");

        jLabel7.setText("Mobile Number:");

        jLabel8.setText("Reference Number:");

        jLabel9.setText("Transaction: ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Upcoming"));

        guestList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Not", " ", "Con", "nec", "ted" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        guestList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guestListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guestListMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(guestList);

        vipList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Not", " ", "Con", "nec", "ted" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        vipList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vipListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vipListMousePressed(evt);
            }
        });
        scroll.setViewportView(vipList);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Guests");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("VIP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll)
                    .addComponent(jScrollPane2)))
        );

        previousBT.setText("Previous (Undo)");
        previousBT.setEnabled(false);
        previousBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousBTActionPerformed(evt);
            }
        });

        jmenu1.setText("Menu");

        connectToDatabaseAgain.setText("Connect to Database Server...");
        connectToDatabaseAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectToDatabaseAgainActionPerformed(evt);
            }
        });
        jmenu1.add(connectToDatabaseAgain);

        preferences.setText("Preferences...");
        preferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferencesActionPerformed(evt);
            }
        });
        jmenu1.add(preferences);

        changeAdminMenu.setText("Change Admin Password");
        changeAdminMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeAdminMenuActionPerformed(evt);
            }
        });
        jmenu1.add(changeAdminMenu);
        jmenu1.add(jSeparator2);

        logMenu.setText("System Log...");
        logMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logMenuActionPerformed(evt);
            }
        });
        jmenu1.add(logMenu);

        jMenuBar1.add(jmenu1);

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

        add.setText("Add");

        addVIP.setText("Add a VIP...");
        addVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVIPActionPerformed(evt);
            }
        });
        add.add(addVIP);

        addTrans.setText("Add Transaction...");
        addTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTransActionPerformed(evt);
            }
        });
        add.add(addTrans);

        jMenu2.add(add);

        jMenu1.setText("Edit/Delete");

        editDeleteVIP.setText("Edit/Delete VIP Record...");
        editDeleteVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDeleteVIPActionPerformed(evt);
            }
        });
        jMenu1.add(editDeleteVIP);

        editTrans.setText("Edit/Delete Transaction...");
        editTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTransActionPerformed(evt);
            }
        });
        jMenu1.add(editTrans);

        jMenu2.add(jMenu1);

        jMenu5.setText("Clear Database");

        cleanup.setText("Cleanup Queue");
        cleanup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanupActionPerformed(evt);
            }
        });
        jMenu5.add(cleanup);

        clearQueue.setText("Clear Queue");
        clearQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearQueueActionPerformed(evt);
            }
        });
        jMenu5.add(clearQueue);
        jMenu5.add(jSeparator1);

        clrHistory.setText("Clear Records History");
        clrHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrHistoryActionPerformed(evt);
            }
        });
        jMenu5.add(clrHistory);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Window");

        launchDisplay.setText("Launch Display");
        launchDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchDisplayActionPerformed(evt);
            }
        });
        jMenu3.add(launchDisplay);

        fullscreen.setText("Fullscreen Display");
        fullscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullscreenActionPerformed(evt);
            }
        });
        jMenu3.add(fullscreen);

        restore.setText("Restore Window Controls");
        restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreActionPerformed(evt);
            }
        });
        jMenu3.add(restore);

        closeDisplay.setText("Close Display");
        closeDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeDisplayActionPerformed(evt);
            }
        });
        jMenu3.add(closeDisplay);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nextBT)
                                .addGap(18, 18, 18)
                                .addComponent(callAgainBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(previousBT))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mobilenumLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refLBL))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(transLBL))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLBL))
                            .addComponent(nextLBL)
                            .addComponent(jLabel4)
                            .addComponent(cNowServing)))
                    .addComponent(info))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(14, 14, 14)
                        .addComponent(cNowServing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nameLBL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(mobilenumLBL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(refLBL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(transLBL))
                        .addGap(57, 57, 57)
                        .addComponent(nextLBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextBT)
                            .addComponent(callAgainBT)
                            .addComponent(previousBT)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTFActionPerformed
        connectBTActionPerformed(evt);
    }//GEN-LAST:event_usernameTFActionPerformed

    private void connectBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBTActionPerformed
        connectToDatabase(hostTF.getText(), usernameTF.getText(), passwordTF.getText(), counterSpinner.getValue().toString(), intervalSpinner.getValue().toString(), updateInterval.getValue().toString(), accountID.getText(), email.getText(), smsPassword.getText());
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
            con.createStatement().executeUpdate("delete from QUEUETBL where COUNTER=" + counter);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error deleting previously served number.\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void updateLabels(ResultSet rs) {
        try {
            if (rs.getBoolean("VIP")) //transfer data from db to GUI labels on controller
            {
                cNowServing.setText("V" + rs.getInt("NUM"));    //if VIP
            } else {
                cNowServing.setText("N" + rs.getInt("NUM"));    //non-vip guest
            }
            mobilenumLBL.setText(rs.getString("MOBILENUM"));
            refLBL.setText(rs.getInt("REF") + "");
            String name = rs.getString("NAME");
            if(name.isEmpty())
                nameLBL.setText("Guest");
            else
                nameLBL.setText(rs.getString("NAME"));
            transLBL.setText(rs.getString("TRANS"));
            rs.close();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update QUEUETBL set COUNTER=" + counter + " where MOBILENUM='" + mobilenumLBL.getText() + "'"); //set now serving field to true
            stmt.close();
            dNowServing.setText("  " + cNowServing.getText() + "  ");   //set now serving on display
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error retreiving data\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    void updateLabels(String [] label) {
        nameLBL.setText(label[0]);
        mobilenumLBL.setText(label[1]);
        refLBL.setText(label[2]);
        transLBL.setText(label[3]);
        cNowServing.setText(label[4]);
        dNowServing.setText(label[4]);
    }

    private void nextBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBTActionPerformed
        try {
            if(!undoed) {       //normal operation without undo
                deletePreviouslyServed();
                //if(previousRS != null)      //backup to previous rs
                //previousRS = currentRS;
                //previousPS = currentPS;
                //if(!previousRS.equals(currentRS))
                previous = new String[]{nameLBL.getText(),mobilenumLBL.getText(),refLBL.getText(),transLBL.getText(),cNowServing.getText()};
                previousBT.setEnabled(true);
                
                //For VIP
                currentPS = con.prepareStatement("select * from QUEUETBL where DATE=? and VIP=true and COUNTER IS NULL ORDER BY NUM");    //query to get VIP first
                currentPS.setDate(1, new java.sql.Date(new java.util.Date().getTime()));   //get current date
                currentRS = currentPS.executeQuery();   //execute SQL statement
                if (currentRS.next()) {    //if there is a VIP on queue
                    updateLabels(currentRS);   //transfer retrieved DB data to GUI
                    Thread blink = new BlinkySound();
                    blink.start();
                    Thread sendSMS = new SMS(con);
                    sendSMS.start();
                    callAgainBT.setEnabled(true);
                } else {    //for guests
                    currentPS = con.prepareStatement("select * from QUEUETBL where DATE=? and VIP=false and COUNTER IS NULL ORDER BY NUM");  //get non-vip guest
                    currentPS.setDate(1, new java.sql.Date(new java.util.Date().getTime()));   //get current date
                    currentRS = currentPS.executeQuery();
                    if (currentRS.next()) {    //if there is a non-vip guest on queue
                        updateLabels(currentRS);
                        Thread blink = new BlinkySound();
                        blink.start();
                        Thread sendSMS = new SMS(con);
                        sendSMS.start();
                        callAgainBT.setEnabled(true);
                    } else {  //if queue is empty
                        cNowServing.setText("None");//transfer data from db to GUI labels on controller
                        mobilenumLBL.setText("-");
                        refLBL.setText("-");
                        nameLBL.setText("-");
                        transLBL.setText("-");
                        dNowServing.setText("None");
                        callAgainBT.setEnabled(false);
                        //JOptionPane.showMessageDialog(this, "No one is on queue", "Empty Queue", JOptionPane.INFORMATION_MESSAGE);
                        Thread thread = new Information("No one is on queue", true);
                        thread.start();
                    }
                }
            } else {    //if previoused
                updateLabels(current);
                Thread blink = new BlinkySound();
                blink.start();
                callAgainBT.setEnabled(true);
                undoed = false;
                previousBT.setEnabled(true);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error retreiving data\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nextBTActionPerformed

    private void hostTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostTFActionPerformed
        connectBTActionPerformed(evt);
    }//GEN-LAST:event_hostTFActionPerformed

    private void viewDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDBActionPerformed
        currentTBL = "QUEUETBL";
        sqlTF.setText("select * from QUEUETBL order by VIP desc, NUM");
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
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Administrator password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(this, panel, "Restricted Access",
                                 JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                 null, options, options[0]);
        if(option == 0) // pressing OK button
        {
            if(pass.getText().equals(prefs.get("PASSWORD", ""))) {
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
            } else
                JOptionPane.showMessageDialog(this, "Invalid password entered", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_clearQueueActionPerformed

    private void sqlBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqlBTActionPerformed
        executeSQL("QUEUETBL");
    }//GEN-LAST:event_sqlBTActionPerformed

    private void viewRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRecordsActionPerformed
        currentTBL = "RECORDSHISTORY";
        sqlTF.setText("select * from RECORDSHISTORY");
        executeSQL("RECORDSHISTORY");
        viewDatabase.pack();
        viewDatabase.setLocationRelativeTo(null);
        viewDatabase.setVisible(true);
    }//GEN-LAST:event_viewRecordsActionPerformed

    private void viewVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewVIPActionPerformed
//        String password = JOptionPane.showInputDialog("Administrator Password: ");
//        if(password == prefs.get("PASSWORD", "admin")) {
//            currentTBL = "VIPCLIENTSTBL";
//            sqlTF.setText("select * from VIPCLIENTSTBL");
//            executeSQL("VIPCLIENTSTBL");
//            viewDatabase.pack();
//            viewDatabase.setLocationRelativeTo(null);
//            viewDatabase.setVisible(true);
//        } else if(password == null) {
//            //do nothing
//        } else
//            JOptionPane.showMessageDialog(this, "Invalid password entered", "Access Denied", JOptionPane.ERROR_MESSAGE);
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Administrator password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(this, panel, "Restricted Access",
                                 JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                 null, options, options[0]);
        if(option == 0) // pressing OK button
        {
            if(pass.getText().equals(prefs.get("PASSWORD", ""))) {
                currentTBL = "VIPCLIENTSTBL";
                sqlTF.setText("select * from VIPCLIENTSTBL");
                executeSQL("VIPCLIENTSTBL");
                viewDatabase.pack();
                viewDatabase.setLocationRelativeTo(null);
                viewDatabase.setVisible(true);
            } else
                JOptionPane.showMessageDialog(this, "Invalid password entered", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viewVIPActionPerformed

    private void launchDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchDisplayActionPerformed
        dNowServing.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        nowServingLBL.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        Display.setUndecorated(false);
        Display.pack();
        Display.setLocationRelativeTo(null);
        Display.setVisible(true);
    }//GEN-LAST:event_launchDisplayActionPerformed

    private void closeDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeDisplayActionPerformed
        Display.dispose();
        Display.setUndecorated(false);
    }//GEN-LAST:event_closeDisplayActionPerformed

    private void fullscreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullscreenActionPerformed
        Display.dispose();
        Display.setUndecorated(true);
        Display.setVisible(true);
    }//GEN-LAST:event_fullscreenActionPerformed

    private void restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreActionPerformed
        Display.dispose();
        Display.setUndecorated(false);
        Display.setVisible(true);
    }//GEN-LAST:event_restoreActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
    }//GEN-LAST:event_formWindowStateChanged

    private void DisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisplayMouseClicked
        Display.dispose();
        if (Display.isUndecorated()) {
            Display.setUndecorated(false);
            dNowServing.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
            nowServingLBL.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        } else {
            Display.setUndecorated(true);
        }
        Display.setVisible(true);
    }//GEN-LAST:event_DisplayMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void callAgainBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callAgainBTActionPerformed
        Thread blink = new BlinkySound();
        blink.start();
    }//GEN-LAST:event_callAgainBTActionPerformed

    private void connectToDatabaseAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectToDatabaseAgainActionPerformed
        Connect2DB.pack();
        Connect2DB.setLocationRelativeTo(null);
        Connect2DB.show();
    }//GEN-LAST:event_connectToDatabaseAgainActionPerformed

    private void addVIPOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVIPOKActionPerformed
        if(fn.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Full Name cannot be blank", "No Name Supplied" , JOptionPane.ERROR_MESSAGE);
        else if(mn.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Mobile Number cannot be blank", "No Mobile Number Supplied" , JOptionPane.ERROR_MESSAGE);
        else if(un.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Username cannot be blank", "No Username Supplied" , JOptionPane.ERROR_MESSAGE);
        else if(pw.getText().length()<6)
            JOptionPane.showMessageDialog(null,"Password length must be greater than or equal to 6", "Error",  JOptionPane.ERROR_MESSAGE);
        else if(!(pw.getText().equals(cpw.getText())))
            JOptionPane.showMessageDialog(null,"Passwords do not match", "Error",  JOptionPane.ERROR_MESSAGE);
        else if(!(mn.getText().substring(0, 3)).equals("+63") || (mn.getText().trim().length()!=13))
            JOptionPane.showMessageDialog(null, "Please use this 13 character Mobile Number format:\n+639XXXXXXXXX", "Invalid Mobile Number Format" , JOptionPane.ERROR_MESSAGE);
        else {
            try {
                Statement stmt = con.createStatement();
                if(stmt.executeUpdate("insert into vipclientstbl (username,password,mobilenumber,fullname) values ('" + un.getText() + "','" + pw.getText() + "','" + mn.getText() + "','" + fn.getText() + "')") == 1) {
                    JOptionPane.showMessageDialog(null, "Record has been added to the VIP List", "Success", JOptionPane.INFORMATION_MESSAGE);
                    addVIPDiag.dispose();
                }
                stmt.close();
            } catch (SQLException x) {
                JOptionPane.showMessageDialog(null, "Database Error", "Error occured while adding record.\nReason: " + x.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addVIPOKActionPerformed

    private void addVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVIPActionPerformed
        addVIPDiag.pack();
        addVIPDiag.setLocationRelativeTo(null);
        addVIPDiag.setVisible(true);
    }//GEN-LAST:event_addVIPActionPerformed

    private void editDeleteVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDeleteVIPActionPerformed
        try {    
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select * from VIPCLIENTSTBL");
            if(rs.last()) {
                String [] list = new String[rs.getRow()+1];   //create array
                rs.beforeFirst();   //go back to first
                list[0] = "Choose a username";
                for(int i=1; rs.next(); i++)    //transfer returned data to an array
                    list[i] = rs.getString("USERNAME");
                combo.setModel(new JComboBox(list).getModel());
                fne.setEnabled(false);
                mne.setEnabled(false);
                une.setEnabled(false);
                pwe.setEnabled(false);
                fne.setText("");
                mne.setText("");
                une.setText("");
                pwe.setText("");
                editVIPBT.setEnabled(false);
                deleteVIPBT.setEnabled(false);
                editVIPDiag.pack();
                editVIPDiag.setLocationRelativeTo(this);
                editVIPDiag.setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "Empty VIP List", "VIP Clients Table is empty", JOptionPane.ERROR_MESSAGE);
            rs.close();
            stmt.close();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Database Error", "Cannot retrieve VIP List from database.\nReason: " + x.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editDeleteVIPActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if(combo.getSelectedItem().toString().equalsIgnoreCase("Choose a username")) {
            fne.setEnabled(false);
            mne.setEnabled(false);
            une.setEnabled(false);
            pwe.setEnabled(false);
            editVIPBT.setEnabled(false);
            deleteVIPBT.setEnabled(false);
            fne.setText("");
            mne.setText("");
            une.setText("");
            pwe.setText("");
        }
        else {
            fne.setEnabled(true);
            mne.setEnabled(true);
            une.setEnabled(true);
            pwe.setEnabled(true);
            editVIPBT.setEnabled(true);
            deleteVIPBT.setEnabled(true);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from VIPCLIENTSTBL where USERNAME='" + combo.getSelectedItem().toString() + "'");
                rs.next();
                fne.setText(rs.getString("FULLNAME"));
                mne.setText(rs.getString("MOBILENUMBER"));
                une.setText(rs.getString("USERNAME"));
                pwe.setText(rs.getString("PASSWORD"));
                rs.close();
                stmt.close();
            } catch (SQLException x) {
                JOptionPane.showMessageDialog(null, "Cannot retrieve user details from database.\nReason: " + x.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_comboActionPerformed

    private void deleteVIPBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVIPBTActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Potential Data Loss Warning", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                Statement stmt = con.createStatement();
                if(stmt.executeUpdate("delete from VIPCLIENTSTBL where USERNAME='" + combo.getSelectedItem().toString() + "'")==1)
                    JOptionPane.showMessageDialog(null, "Record successfully deleted", "VIP Client Deleted", JOptionPane.INFORMATION_MESSAGE);
                editDeleteVIPActionPerformed(evt);
                stmt.close();
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Cannot delete the record.\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteVIPBTActionPerformed

    private void editVIPBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editVIPBTActionPerformed
        if(fne.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Full Name cannot be blank", "No Name Supplied" , JOptionPane.ERROR_MESSAGE);
        else if(mne.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Mobile Number cannot be blank", "No Mobile Number Supplied" , JOptionPane.ERROR_MESSAGE);
        else if(une.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Username cannot be blank", "No Username Supplied" , JOptionPane.ERROR_MESSAGE);
        else if(pwe.getText().length()<6)
            JOptionPane.showMessageDialog(null,"Password length must be greater than or equal to 6", "Error",  JOptionPane.ERROR_MESSAGE);
        else if(!(mne.getText().substring(0, 3)).equals("+63") || (mne.getText().trim().length()!=13))
            JOptionPane.showMessageDialog(null, "Please use this 13 character Mobile Number format:\n+639XXXXXXXXX", "Invalid Mobile Number Format" , JOptionPane.ERROR_MESSAGE);
        else {
            try {
                Statement stmt = con.createStatement();
                if(stmt.executeUpdate("update vipclientstbl set username='" + une.getText() + "',password='" + pwe.getText() + "',mobilenumber='" + mne.getText() + "',fullname='" + fne.getText() + "' where USERNAME='" + combo.getSelectedItem().toString() + "'") == 1) {
                    JOptionPane.showMessageDialog(null, "Record " + combo.getSelectedItem().toString() + " has been successfully updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                editDeleteVIPActionPerformed(evt);
                    addVIPDiag.dispose();
                }
                stmt.close();
            } catch (SQLException x) {
                JOptionPane.showMessageDialog(null,"Error occured while updating record.\nReason: " + x.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_editVIPBTActionPerformed

    private void addTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTransActionPerformed
        String trans = JOptionPane.showInputDialog("Type the transaction name: ");
        if(trans != null) {
            try {
                Statement stmt = con.createStatement();
                if(stmt.executeUpdate("insert into TRANSACTIONSTBL values ('" + trans + "')") == 1) {
                    Thread thread = new Information("New transaction added - " + trans, false);
                    thread.start();
                }
                stmt.close();
            } catch (SQLException x) {
                JOptionPane.showMessageDialog(null,"Error occured while adding transaction.\nReason: " + x.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addTransActionPerformed

    private void editTransBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTransBTActionPerformed
        String trans = JOptionPane.showInputDialog("Type the new transaction name: ");
        try {
            Statement stmt = con.createStatement();
            if(stmt.executeUpdate("update TRANSACTIONSTBL set TRANSACTIONTYPE='" + trans + "' where TRANSACTIONTYPE='" + comboTrans.getSelectedItem().toString() + "'") == 1) {
                Thread thread = new Information("Transaction has been edited - " + trans, false);
                thread.start();
                editTransActionPerformed(evt);
            }
            stmt.close();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null,"Error occured while adding transaction.\nReason: " + x.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editTransBTActionPerformed

    private void deleteTransBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTransBTActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this transaction?", "Potential Data Loss Warning", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                Statement stmt = con.createStatement();
                if(stmt.executeUpdate("delete from TRANSACTIONSTBL where TRANSACTIONTYPE='" + comboTrans.getSelectedItem().toString() + "'")==1) {
                    Thread thread = new Information("Transaction has been deleted", false);
                    thread.start();
                    editTransActionPerformed(evt);
                }
                stmt.close();
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Cannot delete the record.\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteTransBTActionPerformed

    private void editTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTransActionPerformed
        try {    
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select TRANSACTIONTYPE from TRANSACTIONSTBL");
            if(rs.last()) {
                String [] list = new String[rs.getRow()];   //create array
                rs.beforeFirst();   //go back to first
                for(int i=0; rs.next(); i++)    //transfer returned data to an array
                    list[i] = rs.getString(1);
                comboTrans.setModel(new JComboBox(list).getModel());
                editTransDiag.pack();
                editTransDiag.setLocationRelativeTo(this);
                editTransDiag.setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "Empty Transactions List", "Transactions Table is empty", JOptionPane.ERROR_MESSAGE);
            rs.close();
            stmt.close();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Database Error", "Cannot retrieve Transactions List from database.\nReason: " + x.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editTransActionPerformed

    private void clrHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrHistoryActionPerformed
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Administrator password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(this, panel, "Restricted Access",
                                 JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                 null, options, options[0]);
        if(option == 0) // pressing OK button
        {
            if(pass.getText().equals(prefs.get("PASSWORD", ""))) {
                int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the entire records history?\nThis process is irreversible.", "Clear Database Table Warning", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    try {
                        Statement stmt = con.createStatement();
                        JOptionPane.showMessageDialog(null, stmt.executeUpdate("delete from RECORDSHISTORY") + " Record(s) have been deleted", "Records History Table Deleted", JOptionPane.INFORMATION_MESSAGE);
                        stmt.close();
                    } catch (SQLException sqle) {
                        JOptionPane.showMessageDialog(null, "Cannot delete the records.\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else
                JOptionPane.showMessageDialog(this, "Invalid password entered", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_clrHistoryActionPerformed

    private void cancelPrefsBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPrefsBTActionPerformed
        Connect2DB.dispose();
    }//GEN-LAST:event_cancelPrefsBTActionPerformed

    private void preferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferencesActionPerformed
        hostTF.setText(prefs.get("DBHOST", "jdbc:derby://localhost:1527/QueueDB"));
        usernameTF.setText(prefs.get("DBUSERNAME", "dbadmin"));
        passwordTF.setText(prefs.get("DBPASSWORD", "dba"));
        counterSpinner.setValue(Integer.parseInt(prefs.get("COUNTER", "1")));
        updateInterval.setValue(Integer.parseInt(prefs.get("CONTROLLERINTERVAL", "5000")));
        accountID.setText(prefs.get("ACCOUNTID", ""));
        email.setText(prefs.get("EMAIL", ""));
        smsPassword.setText(prefs.get("SMSPASSWORD", ""));
        Connect2DB.pack();
        Connect2DB.setLocationRelativeTo(null);
        Connect2DB.setVisible(true);
    }//GEN-LAST:event_preferencesActionPerformed

    private void logMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logMenuActionPerformed
        logFrame.pack();
        logFrame.setLocationRelativeTo(this);
        logFrame.setVisible(true);
    }//GEN-LAST:event_logMenuActionPerformed

    private void sqlTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqlTFActionPerformed
        executeSQL("QUEUETBL");
    }//GEN-LAST:event_sqlTFActionPerformed

    private void guestListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guestListMouseClicked
        //vipList.clearSelection();
    }//GEN-LAST:event_guestListMouseClicked

    private void vipListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vipListMouseClicked
//        guestList.clearSelection();
    }//GEN-LAST:event_vipListMouseClicked

    private void vipListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vipListMousePressed
        guestList.clearSelection();
        displaySelected(vipList.getSelectedValue().toString());
    }//GEN-LAST:event_vipListMousePressed

    private void guestListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guestListMousePressed
        vipList.clearSelection();
        displaySelected(guestList.getSelectedValue().toString());
    }//GEN-LAST:event_guestListMousePressed

    private void previousBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousBTActionPerformed
        if(previous == null) {
            System.err.println("Previous Queue record data not found.");
        } else {
            current = new String[]{nameLBL.getText(),mobilenumLBL.getText(),refLBL.getText(),transLBL.getText(),cNowServing.getText()};
            updateLabels(previous);
            callAgainBT.setEnabled(true);
            undoed = true;
            previousBT.setEnabled(false);
            Thread blink = new BlinkySound();
            blink.start();
        }
    }//GEN-LAST:event_previousBTActionPerformed

    private void changePasswordBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordBTActionPerformed
        if(pw1.getText().equals(pw2.getText())) {
            prefs.put("PASSWORD", pw1.getText());
            changeAdminDiag.dispose();
            Thread t = new Information("Administrator password changed", false);
            t.start();
        } else
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Password mismatch", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_changePasswordBTActionPerformed

    private void changeAdminMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeAdminMenuActionPerformed
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Administrator password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(this, panel, "Restricted Access",
                                 JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                 null, options, options[0]);
        if(option == 0) // pressing OK button
        {
            if(pass.getText().equals(prefs.get("PASSWORD", ""))) {
                changeAdminDiag.pack();
                changeAdminDiag.setLocationRelativeTo(this);
                changeAdminDiag.setVisible(true);
            } else
                JOptionPane.showMessageDialog(this, "Invalid password entered", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_changeAdminMenuActionPerformed

    private void pw2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pw2ActionPerformed
        changePasswordBTActionPerformed(evt);
    }//GEN-LAST:event_pw2ActionPerformed

    private void pw1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pw1ActionPerformed
        changePasswordBTActionPerformed(evt);
    }//GEN-LAST:event_pw1ActionPerformed

    public void connectToDatabase(String host, String user, String pw, String counterNum, String interval, String update, String accountID, String email, String smsPassword) {
        try {
            counter = Integer.parseInt(counterNum);
            SMSINTERVAL = Integer.parseInt(interval);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(host, user, pw);
            //con = DriverManager.getConnection("jdbc:derby://localhost:1527/QueueDB", "dbadmin", "dba");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Failed connecting to the Database Server."
                    + "\nGo to preferences, and confirm that the ip address is correct"
                    + "\n or check if the Database Server is running."
                    + "\n\nError: " + sqle.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, cnfe.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            cnfe.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid Counter", JOptionPane.ERROR_MESSAGE);
        }
        if (con != null) {
            //save preferences
            prefs.put("DBHOST", host);
            prefs.put("DBUSERNAME", user);
            prefs.put("DBPASSWORD", pw);
            prefs.put("COUNTER", counterNum);
            prefs.put("SMSINTERVAL", interval);
            prefs.put("CONTROLLERINTERVAL", update);
            prefs.put("ACCOUNTID", accountID);
            prefs.put("EMAIL", email);
            prefs.put("SMSPASSWORD", smsPassword);
            
            //do necessary GUI actions
            Connect2DB.dispose();
            Display.pack();
            Display.setLocationRelativeTo(null);
            Display.setVisible(true);
            nextBT.setEnabled(true);
            connectToDatabaseAgain.setEnabled(false);
            connectToDatabaseAgain.setText("Connected to Database");
            Display.setTitle("Counter " + counter);
            nowServingLBL.setText("Counter " + counter);
            Thread thread = new Information("Connected to Database Server", false);
            thread.start();
            
            //retrieve now serving
            try {
                PreparedStatement ps = con.prepareStatement("select * from QUEUETBL where DATE=? and COUNTER=" + counter);
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    updateLabels(rs);
                    callAgainBT.setEnabled(true);
                }
                else {
                    cNowServing.setText("None");//transfer data from db to GUI labels on controller
                    mobilenumLBL.setText("-");
                    refLBL.setText("-");
                    nameLBL.setText("-");
                    transLBL.setText("-");
                    dNowServing.setText("None");
                    callAgainBT.setEnabled(false);
                }
                rs.close();
                ps.close();
            } catch (SQLException sqle) {
                    JOptionPane.showMessageDialog(null, "There was a problem retrieving the number currently being served.\n" + sqle.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }

            //start upcoming list generator thread
            upcominglistgeneratorThread.interrupt();
            upcominglistgeneratorThread = new UpcomingListGenerator(con,update);
            upcominglistgeneratorThread.start();
            
            this.setTitle("Counter " + counter);
        }
    }

    void executeSQL(String DBtable) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs;
            if (sqlTF.getText().startsWith("select")) {
                rs = stmt.executeQuery(sqlTF.getText());
            } else {
                JOptionPane.showMessageDialog(null, stmt.executeUpdate(sqlTF.getText()) + " row(s) affected", "SQL Result", JOptionPane.INFORMATION_MESSAGE);
                rs = stmt.executeQuery("select * from " + currentTBL);
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
    
    void displaySelected(String selected) {
        if(!selected.trim().isEmpty()) {
            try {
                Statement stmt = con.createStatement();
                ResultSet selectedrs;
                if(selected.contains("V"))
                    selectedrs = stmt.executeQuery("select * from QUEUETBL where VIP=true and NUM=" + selected.substring(1));
                else
                    selectedrs = stmt.executeQuery("select * from QUEUETBL where VIP=false and NUM=" + selected.substring(1));
                selectedrs.next();
                //update GUI
                selectedName.setText(selectedrs.getString("NAME"));
                selectedNum.setText(selectedrs.getString("MOBILENUM"));
                selectedRef.setText(selectedrs.getInt("REF") + "");
                selectedTrans.setText(selectedrs.getString("TRANS"));
                if(selectedrs.getBoolean("SMSNOTIFICATION")) {
                    selectedSMS.setText("Enabled");
                    selectedSMS.setSelected(true);
                } else {
                    selectedSMS.setText("Disabled");
                    selectedSMS.setSelected(false);
                }
                selectedDiag.setTitle(selected + " - Details");
                selectedDiag.pack();
                selectedDiag.setLocationRelativeTo(this);
                selectedDiag.setVisible(true);
                selectedrs.close();
                stmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" Display resizing code ">
    static void resizeDisplay() {
        Font labelFont = nowServingLBL.getFont();
        String labelText = nowServingLBL.getText();

        int stringWidth = nowServingLBL.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = nowServingLBL.getWidth();

        // Find out how much the font can grow in width.
        double widthRatio = (double) componentWidth / (double) stringWidth;

        int newFontSize = (int) (labelFont.getSize() * widthRatio);
        int componentHeight = nowServingLBL.getHeight();

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentHeight);

        // Set the label's font size to the newly determined size.
        nowServingLBL.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));

        //Number
        Font labelFont1 = dNowServing.getFont();
        String labelText1 = dNowServing.getText();

        int stringWidth1 = dNowServing.getFontMetrics(labelFont1).stringWidth(labelText1);
        int componentWidth1 = dNowServing.getWidth();

        // Find out how much the font can grow in width.
        double widthRatio1 = (double) componentWidth1 / (double) stringWidth1;

        int newFontSize1 = (int) (labelFont1.getSize() * widthRatio1);
        int componentHeight1 = dNowServing.getHeight();

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse1 = Math.min(newFontSize1, componentHeight1);

        // Set the label's font size to the newly determined size.
        dNowServing.setFont(new Font(labelFont1.getName(), Font.PLAIN, fontSizeToUse1));
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
            UIManager.put("Button.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("ToggleButton.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("RadioButton.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("CheckBox.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("ColorChooser.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("ComboBox.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("List.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("MenuBar.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("MenuItem.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("RadioButtonMenuItem.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("CheckBoxMenuItem.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("Menu.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("PopupMenu.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("OptionPane.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("Panel.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("ProgressBar.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("ScrollPane.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("Viewport.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("TabbedPane.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("Table.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("TableHeader.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("PasswordField.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("TextArea.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("TextPane.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("EditorPane.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("TitledBorder.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("ToolBar.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("ToolTip.font", new Font("Segoe UI", Font.PLAIN, 11));
            UIManager.put("Tree.font", new Font("Segoe UI", Font.PLAIN, 11));
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
    private javax.swing.JTextField accountID;
    private javax.swing.JMenu add;
    private javax.swing.JMenuItem addTrans;
    private javax.swing.JMenuItem addVIP;
    private javax.swing.JDialog addVIPDiag;
    private javax.swing.JButton addVIPOK;
    public static javax.swing.JLabel cNowServing;
    private javax.swing.JButton callAgainBT;
    private javax.swing.JButton cancelPrefsBT;
    private javax.swing.JDialog changeAdminDiag;
    private javax.swing.JMenuItem changeAdminMenu;
    private javax.swing.JButton changePasswordBT;
    private javax.swing.JMenuItem cleanup;
    private javax.swing.JMenuItem clearQueue;
    private javax.swing.JMenuItem closeDisplay;
    private javax.swing.JMenuItem clrHistory;
    private javax.swing.JComboBox combo;
    private javax.swing.JComboBox comboTrans;
    private javax.swing.JButton connectBT;
    private javax.swing.JMenuItem connectToDatabaseAgain;
    private javax.swing.JSpinner counterSpinner;
    private javax.swing.JPasswordField cpw;
    public static javax.swing.JLabel dNowServing;
    private javax.swing.JButton deleteTransBT;
    private javax.swing.JButton deleteVIPBT;
    private javax.swing.JMenuItem editDeleteVIP;
    private javax.swing.JMenuItem editTrans;
    private javax.swing.JButton editTransBT;
    private javax.swing.JDialog editTransDiag;
    private javax.swing.JButton editVIPBT;
    private javax.swing.JDialog editVIPDiag;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fn;
    private javax.swing.JTextField fne;
    private javax.swing.JMenuItem fullscreen;
    public static javax.swing.JList guestList;
    private javax.swing.JTextField hostTF;
    public static javax.swing.JLabel info;
    private javax.swing.JSpinner intervalSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu jmenu1;
    private javax.swing.JMenuItem launchDisplay;
    public static javax.swing.JTextArea log;
    private javax.swing.JFrame logFrame;
    private javax.swing.JMenuItem logMenu;
    private javax.swing.JTextField mn;
    private javax.swing.JTextField mne;
    private javax.swing.JLabel mobilenumLBL;
    private javax.swing.JLabel nameLBL;
    public static javax.swing.JButton nextBT;
    public static javax.swing.JLabel nextLBL;
    public static javax.swing.JLabel nowServingLBL;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JMenuItem preferences;
    private javax.swing.JButton previousBT;
    private javax.swing.JPasswordField pw;
    private javax.swing.JPasswordField pw1;
    private javax.swing.JPasswordField pw2;
    private javax.swing.JPasswordField pwe;
    private javax.swing.JLabel refLBL;
    private javax.swing.JMenuItem restore;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JDialog selectedDiag;
    private javax.swing.JLabel selectedName;
    private javax.swing.JLabel selectedNum;
    private javax.swing.JLabel selectedRef;
    private javax.swing.JCheckBox selectedSMS;
    private javax.swing.JLabel selectedTrans;
    private javax.swing.JPasswordField smsPassword;
    private javax.swing.JButton sqlBT;
    private javax.swing.JTextField sqlTF;
    public javax.swing.JTable table;
    private javax.swing.JLabel transLBL;
    private javax.swing.JTextField un;
    private javax.swing.JTextField une;
    private javax.swing.JSpinner updateInterval;
    private javax.swing.JTextField usernameTF;
    private javax.swing.JMenuItem viewDB;
    public static javax.swing.JFrame viewDatabase;
    private javax.swing.JMenuItem viewRecords;
    private javax.swing.JMenuItem viewVIP;
    public static javax.swing.JList vipList;
    // End of variables declaration//GEN-END:variables
}
