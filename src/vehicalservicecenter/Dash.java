package vehicalservicecenter;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Dash extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dash.class.getName());
    User user1;
    DBConnection db = new DBConnection();
    PreparedStatement pst;
    ResultSet rs;
    Customer cust;

    public Dash(User user) {
        initComponents();
        loadBayStatus();
        customiseButtons(btnSave, btnUpdate, btnDetails);
        customiseTable(table);
        cards(card1, card2, card3, card4);
        loadImage();
        loadDigitalFont();
        setTime();
        loadTechnicianCards();
        loadOverviewCounts();
        loadOngoingJobsTable();
        loadInventoryTable();

        this.user1 = user;

        CardPanel.add(pnlDash, "card1");
        CardPanel.add(pnlAppo, "card2");
        CardPanel.add(pnlInventory, "card3");
        CardPanel.add(pnlTech, "card4");
        CardPanel.add(pnlHistory, "card5");

        UIManager.put("TextComponent.arc", 15);

        lblUser.setText(user1.getName());
        lblTopic.setText("DASHBOARD");
    }

    private void setTime() {
        new javax.swing.Timer(1000, e -> {
            // Digital font and 24-hour format (HH:mm:ss)
            String time = new java.text.SimpleDateFormat("HH:mm:ss a").format(new java.util.Date());
            String date = new java.text.SimpleDateFormat("EEE,MMM dd yyyy").format(new java.util.Date());
            lblDateTime.setText(date);
            lblDateTime1.setText(time);
            lblDateTime.setForeground(new java.awt.Color(4, 102, 200));
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        btnDash = new javax.swing.JButton();
        btnAppo = new javax.swing.JButton();
        btnInven = new javax.swing.JButton();
        btnReg = new javax.swing.JButton();
        btnTech = new javax.swing.JButton();
        btnJob = new javax.swing.JButton();
        main = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        lblTopic = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblUser1 = new javax.swing.JLabel();
        lblDateTime = new javax.swing.JLabel();
        lblDateTime1 = new javax.swing.JLabel();
        CardPanel = new javax.swing.JPanel();
        pnlDash = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cards = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblAppoNo = new javax.swing.JLabel();
        card2 = new javax.swing.JPanel();
        lblAppoNo1 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        card3 = new javax.swing.JPanel();
        lblTech = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        card4 = new javax.swing.JPanel();
        lblTotSer = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        bays = new javax.swing.JPanel();
        bay1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        bay2 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        bay3 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        bay4 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        bay5 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        bay6 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        pnlAppo = new javax.swing.JPanel();
        appoAll = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        image = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        regDetails = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustName = new javax.swing.JTextField();
        txtNic = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTown = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        appoDate = new com.toedter.calendar.JDateChooser();
        YearChooser = new com.toedter.calendar.JYearChooser();
        jLabel13 = new javax.swing.JLabel();
        txtLisen = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        appoTime = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cmbMake = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cmbFuel = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txtReading = new javax.swing.JTextField();
        appo = new javax.swing.JLabel();
        btnDetails = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        pnlInventory = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnBill = new javax.swing.JButton();
        btnBill1 = new javax.swing.JButton();
        btnBill2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        txtSearch2 = new javax.swing.JTextField();
        btnSearch2 = new javax.swing.JButton();
        pnlHistory = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table5 = new javax.swing.JTable();
        txtSearch5 = new javax.swing.JTextField();
        btnSearch5 = new javax.swing.JButton();
        pnlTech = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        techMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebar.setBackground(new java.awt.Color(27, 42, 71));
        sidebar.setBorder(javax.swing.BorderFactory.createEmptyBorder(100, 10, 1, 10));
        sidebar.setPreferredSize(new java.awt.Dimension(250, 720));
        sidebar.setLayout(new java.awt.GridLayout(9, 0, 10, 0));

        btnDash.setBackground(new java.awt.Color(27, 42, 71));
        btnDash.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDash.setForeground(new java.awt.Color(255, 255, 255));
        btnDash.setText("DASHBOARD");
        btnDash.setBorder(null);
        btnDash.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDash.addActionListener(this::btnDashActionPerformed);
        sidebar.add(btnDash);

        btnAppo.setBackground(new java.awt.Color(27, 42, 71));
        btnAppo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAppo.setForeground(new java.awt.Color(255, 255, 255));
        btnAppo.setText("APPOINTMENT");
        btnAppo.setBorder(null);
        btnAppo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAppo.addActionListener(this::btnAppoActionPerformed);
        sidebar.add(btnAppo);

        btnInven.setBackground(new java.awt.Color(27, 42, 71));
        btnInven.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnInven.setForeground(new java.awt.Color(255, 255, 255));
        btnInven.setText("INVENTORY");
        btnInven.setBorder(null);
        btnInven.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInven.addActionListener(this::btnInvenActionPerformed);
        sidebar.add(btnInven);

        btnReg.setBackground(new java.awt.Color(27, 42, 71));
        btnReg.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnReg.setForeground(new java.awt.Color(255, 255, 255));
        btnReg.setText("SET JOB CARD");
        btnReg.setBorder(null);
        btnReg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReg.addActionListener(this::btnRegActionPerformed);
        sidebar.add(btnReg);

        btnTech.setBackground(new java.awt.Color(27, 42, 71));
        btnTech.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTech.setForeground(new java.awt.Color(255, 255, 255));
        btnTech.setText("TECHNICIANS");
        btnTech.setBorder(null);
        btnTech.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTech.addActionListener(this::btnTechActionPerformed);
        sidebar.add(btnTech);

        btnJob.setBackground(new java.awt.Color(27, 42, 71));
        btnJob.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnJob.setForeground(new java.awt.Color(255, 255, 255));
        btnJob.setText("SERVICE HISTORY");
        btnJob.setBorder(null);
        btnJob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJob.addActionListener(this::btnJobActionPerformed);
        sidebar.add(btnJob);

        getContentPane().add(sidebar, java.awt.BorderLayout.LINE_START);

        main.setLayout(new java.awt.BorderLayout());

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setPreferredSize(new java.awt.Dimension(1030, 60));

        lblTopic.setBackground(new java.awt.Color(255, 255, 255));
        lblTopic.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTopic.setText("APPOINTMENT");

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        lblUser1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblUser1.setText("User :-");

        lblDateTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDateTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblDateTime1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDateTime1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(431, 431, 431)
                .addComponent(lblUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDateTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(lblUser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(lblDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDateTime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(lblTopic, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        main.add(Header, java.awt.BorderLayout.PAGE_START);

        CardPanel.setBackground(new java.awt.Color(204, 204, 204));
        CardPanel.setLayout(new java.awt.CardLayout());

        pnlDash.setBackground(new java.awt.Color(204, 204, 204));
        pnlDash.setMinimumSize(new java.awt.Dimension(1030, 671));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel16.setText("WELCOME  BACK,");

        cards.setBackground(new java.awt.Color(255, 255, 255));
        cards.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cards.setMinimumSize(new java.awt.Dimension(960, 120));
        cards.setLayout(new java.awt.GridLayout(1, 4, 20, 0));

        card1.setBackground(new java.awt.Color(255, 255, 255));
        card1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 51), 3, true));
        card1.setPreferredSize(new java.awt.Dimension(30, 100));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 51));
        jLabel10.setText("ToDays' Appointment ");

        lblAppoNo.setBackground(new java.awt.Color(255, 255, 255));
        lblAppoNo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblAppoNo.setForeground(new java.awt.Color(255, 204, 51));
        lblAppoNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAppoNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAppoNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        cards.add(card1);

        card2.setBackground(new java.awt.Color(255, 255, 255));
        card2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 3, true));
        card2.setPreferredSize(new java.awt.Dimension(30, 100));

        lblAppoNo1.setBackground(new java.awt.Color(255, 255, 255));
        lblAppoNo1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblAppoNo1.setForeground(new java.awt.Color(204, 0, 0));
        lblAppoNo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(204, 0, 0));
        jLabel47.setText("Total Appointments");

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAppoNo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAppoNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        cards.add(card2);

        card3.setBackground(new java.awt.Color(255, 255, 255));
        card3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 3, true));
        card3.setPreferredSize(new java.awt.Dimension(30, 100));

        lblTech.setBackground(new java.awt.Color(255, 255, 255));
        lblTech.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblTech.setForeground(new java.awt.Color(0, 51, 204));
        lblTech.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 51, 204));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Technicians");

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTech, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTech, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        cards.add(card3);

        card4.setBackground(new java.awt.Color(255, 255, 255));
        card4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 3, true));

        lblTotSer.setBackground(new java.awt.Color(255, 255, 255));
        lblTotSer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblTotSer.setForeground(new java.awt.Color(0, 153, 51));
        lblTotSer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 153, 51));
        jLabel49.setText("Total Services");

        javax.swing.GroupLayout card4Layout = new javax.swing.GroupLayout(card4);
        card4.setLayout(card4Layout);
        card4Layout.setHorizontalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card4Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(lblTotSer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        card4Layout.setVerticalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotSer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        cards.add(card4);

        bays.setBackground(new java.awt.Color(255, 255, 255));
        bays.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bays.setPreferredSize(new java.awt.Dimension(960, 120));
        bays.setLayout(new java.awt.GridLayout(1, 6, 10, 0));

        bay1.setBackground(new java.awt.Color(255, 255, 255));
        bay1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));
        bay1.setPreferredSize(new java.awt.Dimension(20, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BAY - 01");

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setForeground(new java.awt.Color(0, 102, 153));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("222");

        javax.swing.GroupLayout bay1Layout = new javax.swing.GroupLayout(bay1);
        bay1.setLayout(bay1Layout);
        bay1Layout.setHorizontalGroup(
            bay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(bay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        bay1Layout.setVerticalGroup(
            bay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bays.add(bay1);

        bay2.setBackground(new java.awt.Color(255, 255, 255));
        bay2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setForeground(new java.awt.Color(0, 102, 153));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("222");

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 51, 204));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("BAY - 02");

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout bay2Layout = new javax.swing.GroupLayout(bay2);
        bay2.setLayout(bay2Layout);
        bay2Layout.setHorizontalGroup(
            bay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bay2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(bay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        bay2Layout.setVerticalGroup(
            bay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bays.add(bay2);

        bay3.setBackground(new java.awt.Color(255, 255, 255));
        bay3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));

        jLabel31.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 51, 204));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("BAY - 03");

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setForeground(new java.awt.Color(0, 102, 153));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("222");

        javax.swing.GroupLayout bay3Layout = new javax.swing.GroupLayout(bay3);
        bay3.setLayout(bay3Layout);
        bay3Layout.setHorizontalGroup(
            bay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(bay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        bay3Layout.setVerticalGroup(
            bay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel43)
                .addContainerGap())
        );

        bays.add(bay3);

        bay4.setBackground(new java.awt.Color(255, 255, 255));
        bay4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));

        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 51, 204));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("BAY - 04");

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setForeground(new java.awt.Color(0, 102, 153));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("222");

        javax.swing.GroupLayout bay4Layout = new javax.swing.GroupLayout(bay4);
        bay4.setLayout(bay4Layout);
        bay4Layout.setHorizontalGroup(
            bay4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(bay4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        bay4Layout.setVerticalGroup(
            bay4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addContainerGap())
        );

        bays.add(bay4);

        bay5.setBackground(new java.awt.Color(255, 255, 255));
        bay5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));

        jLabel33.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 51, 204));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("BAY - 05");

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setForeground(new java.awt.Color(0, 102, 153));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("222");

        javax.swing.GroupLayout bay5Layout = new javax.swing.GroupLayout(bay5);
        bay5.setLayout(bay5Layout);
        bay5Layout.setHorizontalGroup(
            bay5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(bay5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        bay5Layout.setVerticalGroup(
            bay5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addContainerGap())
        );

        bays.add(bay5);

        bay6.setBackground(new java.awt.Color(255, 255, 255));
        bay6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));

        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 51, 204));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("BAY - 06");

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setForeground(new java.awt.Color(0, 102, 153));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("222");

        javax.swing.GroupLayout bay6Layout = new javax.swing.GroupLayout(bay6);
        bay6.setLayout(bay6Layout);
        bay6Layout.setHorizontalGroup(
            bay6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(bay6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        bay6Layout.setVerticalGroup(
            bay6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bay6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addContainerGap())
        );

        bays.add(bay6);

        jLabel17.setBackground(new java.awt.Color(79, 115, 186));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(73, 80, 87));
        jLabel17.setText("Todays' Overview");

        jLabel18.setBackground(new java.awt.Color(79, 115, 186));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(73, 80, 87));
        jLabel18.setText("Service Bay Status");

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));

        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));

        jSeparator6.setForeground(new java.awt.Color(102, 102, 102));

        jLabel19.setBackground(new java.awt.Color(79, 115, 186));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(73, 80, 87));
        jLabel19.setText("Ongoing Servises");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job ID", "Vehical Number", "Bay ID", "Technician", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bays, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(4, 4, 4)
                .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bays, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDashLayout = new javax.swing.GroupLayout(pnlDash);
        pnlDash.setLayout(pnlDashLayout);
        pnlDashLayout.setHorizontalGroup(
            pnlDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDashLayout.setVerticalGroup(
            pnlDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        CardPanel.add(pnlDash, "card5");

        pnlAppo.setBackground(new java.awt.Color(204, 204, 204));
        pnlAppo.setMinimumSize(new java.awt.Dimension(1030, 671));

        appoAll.setBackground(new java.awt.Color(255, 255, 255));
        appoAll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        appoAll.setPreferredSize(new java.awt.Dimension(1018, 659));

        jPanel10.setMinimumSize(new java.awt.Dimension(940, 530));
        jPanel10.setLayout(new java.awt.BorderLayout());

        image.setPreferredSize(new java.awt.Dimension(320, 530));

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout imageLayout = new javax.swing.GroupLayout(image);
        image.setLayout(imageLayout);
        imageLayout.setHorizontalGroup(
            imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageLayout.createSequentialGroup()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                .addGap(314, 314, 314))
        );
        imageLayout.setVerticalGroup(
            imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageLayout.createSequentialGroup()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.add(image, java.awt.BorderLayout.LINE_START);

        regDetails.setBackground(new java.awt.Color(255, 255, 255));
        regDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel2.setText("A p p o i n t m e n t   F o r m");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Owner’s Name");

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("NIC");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Phone Number");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("City");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("Town");

        txtTown.addActionListener(this::txtTownActionPerformed);

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("Vehicle Brand");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("Vehicle Model");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("Vehicle Color");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setText("Build Year");

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setText("Appointment Date");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setText("License Plate  number");

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel15.setText("Time");

        jLabel27.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel27.setText("Make");

        cmbMake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel28.setText("Fuel Type");

        cmbFuel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel29.setText("Odometer Reading");

        appo.setBackground(new java.awt.Color(255, 255, 255));
        appo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        appo.setForeground(new java.awt.Color(0, 102, 255));
        appo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout regDetailsLayout = new javax.swing.GroupLayout(regDetails);
        regDetails.setLayout(regDetailsLayout);
        regDetailsLayout.setHorizontalGroup(
            regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regDetailsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(regDetailsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addGroup(regDetailsLayout.createSequentialGroup()
                                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(regDetailsLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(regDetailsLayout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(YearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(regDetailsLayout.createSequentialGroup()
                                                    .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(regDetailsLayout.createSequentialGroup()
                                                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jLabel29)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtReading, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(regDetailsLayout.createSequentialGroup()
                                                            .addComponent(txtBrand)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(cmbFuel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, regDetailsLayout.createSequentialGroup()
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtLisen, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(28, 28, 28)
                                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cmbMake, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(regDetailsLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(regDetailsLayout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTown))
                                            .addGroup(regDetailsLayout.createSequentialGroup()
                                                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtNic)
                                                        .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(regDetailsLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(appoDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(appoTime, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(regDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        regDetailsLayout.setVerticalGroup(
            regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(appo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMake, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLisen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFuel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReading, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(YearChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(regDetailsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(appoDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(regDetailsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appoTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17))
        );

        jPanel10.add(regDetails, java.awt.BorderLayout.CENTER);

        btnDetails.setText("Details >");
        btnDetails.addActionListener(this::btnDetailsActionPerformed);

        btnUpdate.setText("Update");

        btnSave.setText("Save");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnSearch.setText("Serch");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        javax.swing.GroupLayout appoAllLayout = new javax.swing.GroupLayout(appoAll);
        appoAll.setLayout(appoAllLayout);
        appoAllLayout.setHorizontalGroup(
            appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appoAllLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(appoAllLayout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(310, 310, 310))
                    .addGroup(appoAllLayout.createSequentialGroup()
                        .addGroup(appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))))
        );
        appoAllLayout.setVerticalGroup(
            appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoAllLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAppoLayout = new javax.swing.GroupLayout(pnlAppo);
        pnlAppo.setLayout(pnlAppoLayout);
        pnlAppoLayout.setHorizontalGroup(
            pnlAppoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAppoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appoAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAppoLayout.setVerticalGroup(
            pnlAppoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAppoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appoAll, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addContainerGap())
        );

        CardPanel.add(pnlAppo, "card4");

        pnlInventory.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(450, 648));

        jLabel20.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel20.setText("I n v e n t o r y");

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel21.setText("Item Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel22.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel22.setText("Item Brand");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel23.setText("Details");

        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel24.setText("Price");

        jTextField10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel25.setText("Quantity");

        jTextField12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Qty", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setResizable(false);
            table2.getColumnModel().getColumn(0).setPreferredWidth(120);
            table2.getColumnModel().getColumn(1).setResizable(false);
            table2.getColumnModel().getColumn(1).setPreferredWidth(40);
            table2.getColumnModel().getColumn(2).setResizable(false);
        }

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("total");

        btnBill.setForeground(new java.awt.Color(255, 51, 51));
        btnBill.setText("Bill");
        btnBill.addActionListener(this::btnBillActionPerformed);

        btnBill1.setText("Cancle");
        btnBill1.addActionListener(this::btnBill1ActionPerformed);

        btnBill2.setText("Remove");
        btnBill2.addActionListener(this::btnBill2ActionPerformed);

        jButton1.setText("Add");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBill, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField10)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jTextField12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(btnBill2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBill2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(btnBill, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.LINE_START);

        jPanel8.setBackground(new java.awt.Color(222, 238, 255));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Brand", "Qty", "Unit Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setResizable(false);
            table1.getColumnModel().getColumn(0).setPreferredWidth(20);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(2).setResizable(false);
            table1.getColumnModel().getColumn(2).setPreferredWidth(40);
            table1.getColumnModel().getColumn(3).setResizable(false);
            table1.getColumnModel().getColumn(3).setPreferredWidth(30);
            table1.getColumnModel().getColumn(4).setResizable(false);
            table1.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        txtSearch2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch2.addActionListener(this::txtSearch2ActionPerformed);

        btnSearch2.setText("Search");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(txtSearch2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlInventoryLayout = new javax.swing.GroupLayout(pnlInventory);
        pnlInventory.setLayout(pnlInventoryLayout);
        pnlInventoryLayout.setHorizontalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlInventoryLayout.setVerticalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        CardPanel.add(pnlInventory, "card6");

        pnlHistory.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        table5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table5);

        btnSearch5.setText("Search");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch5)
                    .addComponent(btnSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout pnlHistoryLayout = new javax.swing.GroupLayout(pnlHistory);
        pnlHistory.setLayout(pnlHistoryLayout);
        pnlHistoryLayout.setHorizontalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHistoryLayout.setVerticalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        CardPanel.add(pnlHistory, "card3");

        pnlTech.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        techMain.setBackground(new java.awt.Color(255, 255, 255));
        techMain.setLayout(new java.awt.GridLayout(3, 4, 20, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(techMain, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(techMain, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTechLayout = new javax.swing.GroupLayout(pnlTech);
        pnlTech.setLayout(pnlTechLayout);
        pnlTechLayout.setHorizontalGroup(
            pnlTechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTechLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTechLayout.setVerticalGroup(
            pnlTechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTechLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        CardPanel.add(pnlTech, "card2");

        main.add(CardPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTownActionPerformed

    private void btnAppoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppoActionPerformed
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.show(CardPanel, "card2");
        lblTopic.setText("APPOINTMENT");
        customizeSearchBar(txtSearch, btnSearch);
    }//GEN-LAST:event_btnAppoActionPerformed

    private void btnTechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTechActionPerformed
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.show(CardPanel, "card4");
        lblTopic.setText("TECHNICIANS");

    }//GEN-LAST:event_btnTechActionPerformed

    private void txtSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch2ActionPerformed

    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBillActionPerformed

    private void btnDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashActionPerformed
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.show(CardPanel, "card1");
        lblTopic.setText("DASHBOARD");

    }//GEN-LAST:event_btnDashActionPerformed

    private void btnInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvenActionPerformed
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.show(CardPanel, "card3");
        lblTopic.setText("INVENTORY");
        customiseTable(table1);
        customiseTable(table2);
        customizeSearchBar(txtSearch2, btnSearch2);
    }//GEN-LAST:event_btnInvenActionPerformed

    private void btnJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJobActionPerformed
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.show(CardPanel, "card5");
        lblTopic.setText("JobCARD");
        customiseTable(table5);
        customizeSearchBar(txtSearch5, btnSearch5);
    }//GEN-LAST:event_btnJobActionPerformed

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        Register reg = new Register(this);
        reg.setVisible(true);

    }//GEN-LAST:event_btnRegActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String vehicleNo = txtLisen.getText().trim();

            if (vehicleNo.isEmpty() || txtCustName.getText().trim().isEmpty() || txtNumber.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Vehicle No, Owner's Name and Phone Number!");
                return;
            }

            if (appoDate.getDate() == null || appoTime.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select an Appointment Date and Time!");
                return;
            }

            String readingValue = txtReading.getText().trim();
            if (readingValue.isEmpty()) {
                readingValue = "0";
            }

            db.con.setAutoCommit(false);

            Vehical exVehical = checkVehical(vehicleNo);
            String currentCusId = "";

            if (exVehical != null) {
                currentCusId = exVehical.getCusId();
                System.out.println("Existing vehicle found. Linking to Customer ID: " + currentCusId);
            } else {
                String currentCusId2 = "CUS-" + (System.currentTimeMillis() % 100000);

                String sql = "INSERT INTO customer (cus_id, name, nic, phone, city, town) VALUES (?, ?, ?, ?, ?, ?)";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, currentCusId2);
                pst.setString(2, txtCustName.getText().trim());
                pst.setString(3, txtNic.getText().trim());
                pst.setInt(4, Integer.parseInt(txtNumber.getText().trim()));
                pst.setString(5, txtCity.getText().trim());
                pst.setString(6, txtTown.getText().trim());
                pst.executeUpdate();
                pst.close();

                String sqlVehInsert = "INSERT INTO vehical_table (vehical_no, make, brand, model, fuel,reading, color, make_year, cus_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                pst = db.con.prepareStatement(sqlVehInsert);
                pst.setString(1, vehicleNo);
                pst.setString(2, cmbMake.getSelectedItem().toString());
                pst.setString(3, txtBrand.getText().trim());
                pst.setString(4, txtModel.getText().trim());
                pst.setString(5, cmbFuel.getSelectedItem().toString());
                pst.setString(6, txtReading.getText());
                pst.setString(7, txtColor.getText().trim());
                pst.setInt(8, YearChooser.getYear());
                pst.setString(9, currentCusId2); // Foreign Key
                pst.executeUpdate();
                pst.close();
            }

            java.util.Date selectDate = appoDate.getDate();
            java.sql.Date AppoDate = new java.sql.Date(selectDate.getTime());
            String AppoTime = appoTime.getText().trim();

            //make random number
            int randomNumber = (int) (Math.random() * 9000) + 1000;
            String appoID = "APP-" + randomNumber;
            appo.setText("Appointment ID: " + appoID + ")");

            String sqlAppo = "INSERT INTO appointment (appo_id, vehical_no, date, time, status ,uName) VALUES (?, ?, ?, ?, 'Pending',?)";
            pst = db.con.prepareStatement(sqlAppo);
            pst.setString(1, appoID); // Random ID
            pst.setString(2, vehicleNo);
            pst.setDate(3, AppoDate);
            pst.setString(4, AppoTime);
            pst.setString(5, user1.getName());

            pst.executeUpdate();
            pst.close();

            db.con.commit();
            clean();

        } catch (SQLException ex) {
            try {
                db.con.rollback();
                JOptionPane.showMessageDialog(this, "Save Error: " + ex.getMessage());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                db.con.setAutoCommit(true);
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String vehicleNo = txtSearch.getText().trim();

        if (vehicleNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a License Plate number to search!");
        }

        Vehical vehical = checkVehical(vehicleNo);

        if (vehical != null) {
            desableEditable();
            try {
                txtLisen.setText(vehical.getVno());
                txtBrand.setText(vehical.getBrand());
                txtModel.setText(vehical.getModel());
                txtColor.setText(vehical.getColor());

                cmbMake.setSelectedItem(vehical.getMake());
                cmbFuel.setSelectedItem(vehical.getFuel());
                txtReading.setText(vehical.getReading());
                try {
                    String yearStr = vehical.getYear();

                    if (yearStr != null && !yearStr.trim().isEmpty()) {
                        if (yearStr.contains("-")) {
                            yearStr = yearStr.substring(0, 4);
                        }
                        YearChooser.setYear(Integer.parseInt(yearStr.trim()));
                    } else {
                        YearChooser.setYear(2026);
                    }
                } catch (Exception e) {
                    YearChooser.setYear(2026);
                }

                String customerId = vehical.getCusId();

                pst = db.con.prepareStatement("SELECT * FROM customer WHERE cus_id = ?");
                pst.setString(1, customerId);
                rs = pst.executeQuery();

                if (rs.next()) {
                    txtCustName.setText(rs.getString("name"));
                    txtNic.setText(rs.getString("nic"));
                    txtNumber.setText(String.valueOf(rs.getInt("phone")));
                    txtCity.setText(rs.getString("city"));
                    txtTown.setText(rs.getString("town"));
                }

                txtSearch.setText("");

                JOptionPane.showMessageDialog(this, "Welcome Back! Vehicle & Owner details loaded.");
            } catch (SQLException ex) {
                System.getLogger(Dash.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } else {
            txtLisen.setText(vehicleNo);
            clean();
            JOptionPane.showMessageDialog(this, "Not Found ");

        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        AppointmentDetails appoi = new AppointmentDetails();
        appoi.setVisible(true);
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnBill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBill1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBill1ActionPerformed

    private void btnBill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBill2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBill2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            com.formdev.flatlaf.FlatLightLaf.setup();
//            com.formdev.flatlaf.FlatDarkLaf.setup();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dash(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanel;
    private javax.swing.JPanel Header;
    private com.toedter.calendar.JYearChooser YearChooser;
    private javax.swing.JLabel appo;
    private javax.swing.JPanel appoAll;
    private com.toedter.calendar.JDateChooser appoDate;
    private javax.swing.JTextField appoTime;
    private javax.swing.JPanel bay1;
    private javax.swing.JPanel bay2;
    private javax.swing.JPanel bay3;
    private javax.swing.JPanel bay4;
    private javax.swing.JPanel bay5;
    private javax.swing.JPanel bay6;
    private javax.swing.JPanel bays;
    private javax.swing.JButton btnAppo;
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnBill1;
    private javax.swing.JButton btnBill2;
    private javax.swing.JButton btnDash;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnInven;
    private javax.swing.JButton btnJob;
    private javax.swing.JButton btnReg;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSearch5;
    private javax.swing.JButton btnTech;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private javax.swing.JPanel cards;
    private javax.swing.JComboBox<String> cmbFuel;
    private javax.swing.JComboBox<String> cmbMake;
    private javax.swing.JPanel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblAppoNo;
    private javax.swing.JLabel lblAppoNo1;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblDateTime1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTech;
    private javax.swing.JLabel lblTopic;
    private javax.swing.JLabel lblTotSer;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pnlAppo;
    private javax.swing.JPanel pnlDash;
    private javax.swing.JPanel pnlHistory;
    private javax.swing.JPanel pnlInventory;
    private javax.swing.JPanel pnlTech;
    private javax.swing.JPanel regDetails;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table5;
    private javax.swing.JPanel techMain;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtLisen;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtReading;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch5;
    private javax.swing.JTextField txtTown;
    // End of variables declaration//GEN-END:variables

    private void customiseButtons(JButton btnSave, JButton btnUpdate, JButton btnDelete) {
        // Save Button - Blue
        btnSave.setBackground(new Color(4, 102, 200));
        btnSave.setForeground(Color.WHITE);
//        btnSave.putClientProperty("JButton.buttonType", "roundRect");
        btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Update Button - Green (Success)
        btnUpdate.setBackground(new Color(40, 167, 69));
        btnUpdate.setForeground(Color.WHITE);
//        btnUpdate.putClientProperty("JButton.buttonType", "roundRect");
        btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Delete Button - Red (Danger)
        btnDelete.setBackground(new Color(220, 53, 69));
        btnDelete.setForeground(Color.WHITE);
//        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnDetails.setBackground(new Color(108, 117, 125)); // Grey
        btnDetails.setForeground(Color.WHITE);
//        btnClear.putClientProperty("JButton.buttonType", "roundRect");
        btnDetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void customiseTable(JTable table) {
        // 1. Header
        table.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        table.getTableHeader().setBackground(new Color(43, 76, 126));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setPreferredSize(new Dimension(0, 30));
        table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());

        // 2. Table
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(40);
        table.setSelectionBackground(new Color(240, 245, 255));
        table.setSelectionForeground(new Color(0, 102, 204));

        // 3. Grid Lines
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setGridColor(new Color(230, 230, 230));

        // 4. Matte Border
        table.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));

        // 5. Scroll Pane
        JScrollPane scrollPane = (JScrollPane) table.getParent().getParent();
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);

        // 6. Body
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void customizeSearchBar(JTextField txtSerch, JButton btnSearch) {
        txtSerch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSerch.putClientProperty("JTextField.placeholderText", "Search ");
        txtSerch.putClientProperty("JTextField.showClearButton", true);
        txtSerch.putClientProperty("Component.arc", 15);

        btnSearch.setPreferredSize(new Dimension(100, 35));
        btnSearch.setBackground(new Color(33, 37, 41));
        btnSearch.setForeground(Color.WHITE);
    }

    private void cards(JPanel card1, JPanel card2, JPanel card3, JPanel card4) {
        card1.putClientProperty("JComponent.roundRect", true);
        card2.putClientProperty("JComponent.roundRect", true);
        card3.putClientProperty("JComponent.roundRect", true);
        card4.putClientProperty("JComponent.roundRect", true);

    }

    private void loadImage() {
        java.net.URL imgURL = getClass().getResource("/Images/car.jpg");

        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage();

            Image scaledImg = img.getScaledInstance(320, 545, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(scaledImg));
        }
    }

    private void loadDigitalFont() {
        try {
            InputStream is = getClass().getResourceAsStream("/file/Inter_18pt-SemiBold.ttf");
            Font digitalFont = Font.createFont(Font.TRUETYPE_FONT, is);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(digitalFont);

            lblDateTime.setFont(digitalFont.deriveFont(Font.PLAIN, 20f));
            lblDateTime1.setFont(digitalFont.deriveFont(Font.PLAIN, 15f));

        } catch (Exception e) {
            e.printStackTrace();
            lblDateTime.setFont(new Font("Consolas", Font.BOLD, 24));
        }
    }

    private Vehical checkVehical(String vehicleNo) {
        try {
            pst = db.con.prepareStatement("SELECT * FROM vehical_table INNER JOIN customer ON vehical_table.cus_id = customer.cus_id WHERE vehical_no = ?");
            pst.setString(1, vehicleNo);
            rs = pst.executeQuery();

            if (rs.next()) {
                return new Vehical(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9));
            } else {
                clean();
            }

        } catch (SQLException ex) {
            System.getLogger(Dash.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    private void clean() {
        txtCustName.setText("");
        txtNic.setText("");
        txtNumber.setText("");
        txtCity.setText("");
        txtTown.setText("");
        txtBrand.setText("");
        txtModel.setText("");
        txtColor.setText("");
        txtReading.setText("");
        cmbMake.setSelectedIndex(0);
        cmbFuel.setSelectedIndex(0);
        YearChooser.setYear(2026);
        txtSearch.setText("");

        txtLisen.setText(txtSearch.getText());
    }

    private void desableEditable() {
        txtCustName.setEditable(false);
        txtNic.setEditable(false);
        txtNumber.setEditable(false);
        txtCity.setEditable(false);
        txtTown.setEditable(false);
        txtBrand.setEditable(false);
        txtModel.setEditable(false);
        txtColor.setEditable(false);
        txtReading.setEditable(false);
        cmbMake.setEditable(false);
        cmbFuel.setEditable(false);
        YearChooser.setEnabled(false);
    }

    private void loadBayStatus() {
        try {
            Color freeColor = Color.WHITE;
            Color busyColor = Color.decode("#a2d2ff");

            java.util.HashMap<String, javax.swing.JPanel> bayPanels = new java.util.HashMap<>();
            bayPanels.put("BAY-01", bay1);
            bayPanels.put("BAY-02", bay2);
            bayPanels.put("BAY-03", bay3);
            bayPanels.put("BAY-04", bay4);
            bayPanels.put("BAY-05", bay5);
            bayPanels.put("BAY-06", bay6);

            bay1.setBackground(freeColor);
            bay2.setBackground(freeColor);
            bay3.setBackground(freeColor);
            bay4.setBackground(freeColor);
            bay5.setBackground(freeColor);
            bay6.setBackground(freeColor);

            jLabel41.setText("Available");
            jLabel35.setText("");
            jLabel42.setText("Available");
            jLabel36.setText("");
            jLabel43.setText("Available");
            jLabel37.setText("");
            jLabel44.setText("Available");
            jLabel38.setText("");
            jLabel45.setText("Available");
            jLabel39.setText("");
            jLabel46.setText("Available");
            jLabel40.setText("");

            pst = db.con.prepareStatement("SELECT bay_id, vehicle_no FROM job_table WHERE status = 'Ongoing'");
            rs = pst.executeQuery();

            while (rs.next()) {
                String bayId = rs.getString("bay_id");
                String vehical = rs.getString("vehicle_no");

                if (bayId != null && bayPanels.containsKey(bayId)) {
                    javax.swing.JPanel busyPanel = bayPanels.get(bayId);
                    busyPanel.setBackground(busyColor);

                    if (bayId.equals("BAY-01")) {
                        jLabel35.setText(vehical);
                        jLabel41.setText("Busy");
                    } else if (bayId.equals("BAY-02")) {
                        jLabel36.setText(vehical);
                        jLabel42.setText("Busy");
                    } else if (bayId.equals("BAY-03")) {
                        jLabel37.setText(vehical);
                        jLabel43.setText("Busy");
                    } else if (bayId.equals("BAY-04")) {
                        jLabel38.setText(vehical);
                        jLabel44.setText("Busy");
                    } else if (bayId.equals("BAY-05")) {
                        jLabel39.setText(vehical);
                        jLabel45.setText("Busy");
                    } else if (bayId.equals("BAY-06")) {
                        jLabel40.setText(vehical);
                        jLabel46.setText("Busy");
                    }
                }
            }

        } catch (SQLException ex) {
            System.getLogger(Dash.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void loadTechnicianCards() {
        techMain.removeAll();

        techMain.setLayout(new java.awt.GridLayout(0, 4, 20, 20));

        PreparedStatement pstTech = null;
        ResultSet rsTech = null;

        try {
            String sql = "SELECT * FROM technician";
            pstTech = db.con.prepareStatement(sql);
            rsTech = pstTech.executeQuery();

            while (rsTech.next()) {
                String id = rsTech.getString("tech_id");
                String name = rsTech.getString("name");
                String phone = rsTech.getString("phone");
                String spec = rsTech.getString("specialty");
                String status = rsTech.getString("status");

                javax.swing.JPanel card = new javax.swing.JPanel();
                card.setLayout(new javax.swing.BoxLayout(card, javax.swing.BoxLayout.Y_AXIS));
                card.setBackground(Color.WHITE);
                card.setPreferredSize(new java.awt.Dimension(200, 140));

                card.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(new Color(220, 224, 230), 1, true),
                        javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12)
                ));

                javax.swing.JLabel lblId = new javax.swing.JLabel(id);
                lblId.setFont(new Font("Segoe UI", Font.BOLD, 13));
                lblId.setForeground(new Color(0, 51, 153));
                lblId.setAlignmentX(javax.swing.JPanel.CENTER_ALIGNMENT);

                javax.swing.JLabel lblName = new javax.swing.JLabel(name);
                lblName.setFont(new Font("Segoe UI", Font.BOLD, 14));
                lblName.setAlignmentX(javax.swing.JPanel.CENTER_ALIGNMENT);

                javax.swing.JLabel lblPhone = new javax.swing.JLabel("📞 " + phone);
                lblPhone.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                lblPhone.setForeground(Color.GRAY);
                lblPhone.setAlignmentX(javax.swing.JPanel.CENTER_ALIGNMENT);

                javax.swing.JLabel lblSpec = new javax.swing.JLabel(spec);
                lblSpec.setFont(new Font("Segoe UI", Font.PLAIN, 11));
                lblSpec.setForeground(Color.DARK_GRAY);
                lblSpec.setAlignmentX(javax.swing.JPanel.CENTER_ALIGNMENT);

                javax.swing.JLabel lblStatus = new javax.swing.JLabel("  " + status + "  ");
                lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 11));
                lblStatus.setAlignmentX(javax.swing.JPanel.CENTER_ALIGNMENT);
                lblStatus.setOpaque(true);

                if (status.equalsIgnoreCase("Available")) {
                    lblStatus.setBackground(new Color(232, 245, 233));
                    lblStatus.setForeground(new Color(46, 125, 50));
                } else {
                    lblStatus.setBackground(new Color(255, 235, 235));
                    lblStatus.setForeground(new Color(211, 47, 47));
                }

                card.add(lblId);
                card.add(javax.swing.Box.createVerticalStrut(4));
                card.add(lblName);
                card.add(javax.swing.Box.createVerticalStrut(4));
                card.add(lblPhone);
                card.add(javax.swing.Box.createVerticalStrut(4));
                card.add(lblSpec);
                card.add(javax.swing.Box.createVerticalStrut(8));
                card.add(lblStatus);

                techMain.add(card);
            }

            techMain.revalidate();
            techMain.repaint();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rsTech != null) {
                    rsTech.close();
                }
                if (pstTech != null) {
                    pstTech.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public void loadOverviewCounts() {
        PreparedStatement pstCount;
        ResultSet rsCount;

        try {
            pst = db.con.prepareStatement("SELECT COUNT(*) AS today_count FROM appointment WHERE date = CURDATE()");
            rs = pst.executeQuery();

            if (rs.next()) {
                lblAppoNo.setText(String.valueOf(rs.getInt("today_count")));
            }
            pst.close();
            rs.close();

            String sqlTotalAppo = "SELECT COUNT(*) AS total_count FROM appointment";
            pstCount = db.con.prepareStatement(sqlTotalAppo);
            rsCount = pstCount.executeQuery();
            if (rsCount.next()) {
                lblAppoNo1.setText(String.valueOf(rsCount.getInt("total_count")));
            }
            rsCount.close();
            pstCount.close();

            String sqlTechCount = "SELECT COUNT(*) AS tech_count FROM technician";
            pstCount = db.con.prepareStatement(sqlTechCount);
            rsCount = pstCount.executeQuery();
            if (rsCount.next()) {
                lblTech.setText(String.valueOf(rsCount.getInt("tech_count")));
            }
            rsCount.close();
            pstCount.close();

            String sqlServicesCount = "SELECT COUNT(*) AS service_count FROM job_table";
            pstCount = db.con.prepareStatement(sqlServicesCount);
            rsCount = pstCount.executeQuery();
            if (rsCount.next()) {
                lblTotSer.setText(String.valueOf(rsCount.getInt("service_count")));
            }

        } catch (SQLException ex) {
            System.getLogger(Dash.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void loadOngoingJobsTable() {
        int c;
        try {
            pst = db.con.prepareStatement("SELECT job_id, vehicle_no, bay_id, tech_id,status FROM job_table WHERE status = 'Ongoing'");
            rs = pst.executeQuery();

            ResultSetMetaData rd = rs.getMetaData();
            c = rd.getColumnCount();

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v3 = new Vector();
                for (int a = 1; a <= c; a++) {
                    v3.add(rs.getString("job_id"));
                    v3.add(rs.getString("vehicle_no"));
                    v3.add(rs.getString("bay_id"));
                    v3.add(rs.getString("tech_id"));
                    v3.add(rs.getString("status"));
                }
                dtm.addRow(v3);
            }

        } catch (SQLException ex) {
            System.getLogger(Dash.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void loadInventoryTable() {
        int c;
        try {
            pst = db.con.prepareStatement("SELECT item_id, item_name, brand, qty, unit_price FROM inventory");
            rs = pst.executeQuery();

            ResultSetMetaData rd = rs.getMetaData();
            c = rd.getColumnCount();

            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v4 = new Vector();
                for (int a = 1; a <= c; a++) {
                    v4.add(rs.getString("item_id"));
                    v4.add(rs.getString("item_name"));
                    v4.add(rs.getString("brand"));
                    v4.add(rs.getString("qty"));
                    v4.add(rs.getString("unit_price"));
                }
                dtm.addRow(v4);
            }

        } catch (SQLException ex) {
            System.getLogger(Dash.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}
