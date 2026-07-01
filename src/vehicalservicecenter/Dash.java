package vehicalservicecenter;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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

    Color setColor1 = new Color(25, 37, 61);
    Color setColor2 = new Color(27, 42, 71);

    JPopupMenu popupMenu = new javax.swing.JPopupMenu();
    DefaultListModel<String> listModel = new javax.swing.DefaultListModel<>();
    JList<String> suggestionList = new javax.swing.JList<>(listModel);

    public Dash(User user) {
        initComponents();
        loadBayStatus();
        customiseButtons(btnSave, btnUpdate, btnDetails);
        customiseTable(table);
        cards(card1, card2, card3, card4);
        loadImage();
        loadDigitalFont();
        loadLogo();
        setTime();
        loadTechnicianCards();
        loadOverviewCounts();
        loadOngoingJobsTable();
        loadInventoryTable();
        setupAutocomplete();
        loadAccessoriesInventory();
        registerGlobalShortcuts();
        loadBrand();
        loadUserTable();
        loadInvoiceTable(invoiceTable, "");

        styleAdminTables(jTable1); // User Table
        styleAdminTables(jTable4); // Technician Table
        styleAdminTables(jTable5); // Services Table
        styleAdminTables(jTable6);
        styleAdminTables(jTable7); // Service Report Table

        // Standardize ComboBox models to correct spelling and status categories
        combRole1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Available", "Busy"}));
        combRole2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Available", "Busy", "Maintenance"}));
        combRole3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Available", "Busy", "Maintenance"}));

        // Register action listeners for the Clear buttons and Report Print button
        UClear.addActionListener(this::UClearActionPerformed);
        UClear1.addActionListener(this::UClear1ActionPerformed);
        UClear2.addActionListener(this::UClear2ActionPerformed);
        UClear3.addActionListener(this::UClear3ActionPerformed);
        btnPrintPDF.addActionListener(this::btnPrintPDFActionPerformed);

        // Register PropertyChangeListeners for date choosers
        jDateChooser1.addPropertyChangeListener("date", evt -> loadServiceReportTable());
        jDateChooser2.addPropertyChangeListener("date", evt -> loadServiceReportTable());

        // Load administration tables
        loadTechnicianTable();
        loadServicesTable();
        loadBaysTable();
        initInventoryManageCRUD();
        loadSparePartsAdminTable();
        loadAccessoriesTable();
        loadServiceReportTable();

        // Pre-populate input fields with generated IDs
        clearUserFields();
        clearTechnicianFields();
        clearServiceFields();
        clearBayFields();

        this.user1 = user;

        CardPanel.add(pnlDash, "card1");
        CardPanel.add(pnlAppo, "card2");
        CardPanel.add(pnlInventory, "card3");
        CardPanel.add(pnlTech, "card4");
        CardPanel.add(pnlHistory, "card5");
        CardPanel.add(pnlAdmin, "card7");

        UIManager.put("TextComponent.arc", 15);
        lblTopic.setText("DASHBOARD");

        if (user.getRole().equalsIgnoreCase("admin")) {
            btnAdminC.setVisible(true);
            lblUser.setText(user1.getName());
            lblAdmin.setText("ADMIN");
        } else if (user.getRole().equalsIgnoreCase("user")) {
            btnAdminC.setVisible(false);
            lblUser.setText(user1.getName());
        }

        btnDash.setBackground(setColor1);
        btnAppo.setBackground(setColor2);
        btnInven.setBackground(setColor2);
        btnHistory.setBackground(setColor2);
        btnTech.setBackground(setColor2);

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
        logo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        buttons = new javax.swing.JPanel();
        btnDash = new javax.swing.JButton();
        btnAppo = new javax.swing.JButton();
        btnInven = new javax.swing.JButton();
        btnReg = new javax.swing.JButton();
        btnTech = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnAdminC = new javax.swing.JButton();
        logOut = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
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
        btnServiceBill = new javax.swing.JButton();
        lblAdmin = new javax.swing.JLabel();
        pnlAppo = new javax.swing.JPanel();
        appoAll = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnDetails = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
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
        pnlInventory = new javax.swing.JPanel();
        inventMain = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        head = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        conbTableSelect = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        acce = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        cmbName = new javax.swing.JComboBox<>();
        cmbBrand = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cmbDetails = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtQtuInvent = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAcc = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnBill = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        invenAddAcc = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        txtFinalPrice = new javax.swing.JTextField();
        spair = new javax.swing.JPanel();
        lblName1 = new javax.swing.JLabel();
        cmbName1 = new javax.swing.JComboBox<>();
        cmbBrand1 = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        cmbDetails1 = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtPrice1 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtQtuInvent1 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableSpair = new javax.swing.JTable();
        jTextField9 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        btnBillSpair = new javax.swing.JButton();
        btnBill4 = new javax.swing.JButton();
        btnBill5 = new javax.swing.JButton();
        invenAdd1 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        txtFinalPrice1 = new javax.swing.JTextField();
        right = new javax.swing.JPanel();
        Accessories = new javax.swing.JPanel();
        txtSearch2 = new javax.swing.JTextField();
        btnSearch2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        accesChart = new javax.swing.JButton();
        Spair = new javax.swing.JPanel();
        txtSearch3 = new javax.swing.JTextField();
        btnSearch3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        pnlHistory = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        txtSearch5 = new javax.swing.JTextField();
        pnlTech = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        techMain = new javax.swing.JPanel();
        pnlAdmin = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtUname = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtNIC = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        combRole = new javax.swing.JComboBox<>();
        btnUserAdd = new javax.swing.JButton();
        btnUserUpdate = new javax.swing.JButton();
        btnUserDel = new javax.swing.JButton();
        UClear = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        txtName1 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txtNIC1 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        combRole1 = new javax.swing.JComboBox<>();
        btnUserAdd1 = new javax.swing.JButton();
        btnUserUpdate1 = new javax.swing.JButton();
        btnUserDel1 = new javax.swing.JButton();
        UClear1 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        txtPhone1 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtSpeality = new javax.swing.JTextArea();
        jLabel65 = new javax.swing.JLabel();
        txtName2 = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        txtName3 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        combRole2 = new javax.swing.JComboBox<>();
        btnUserAdd2 = new javax.swing.JButton();
        btnUserUpdate2 = new javax.swing.JButton();
        btnUserDel2 = new javax.swing.JButton();
        UClear2 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtSpeality1 = new javax.swing.JTextArea();
        jLabel75 = new javax.swing.JLabel();
        txtName4 = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        txtName5 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        combRole3 = new javax.swing.JComboBox<>();
        btnUserAdd3 = new javax.swing.JButton();
        btnUserUpdate3 = new javax.swing.JButton();
        btnUserDel3 = new javax.swing.JButton();
        UClear3 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        txtName6 = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel79 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        btnPrintPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        sidebar.setBackground(new java.awt.Color(27, 42, 71));
        sidebar.setPreferredSize(new java.awt.Dimension(250, 720));
        sidebar.setLayout(new java.awt.BorderLayout());

        logo.setBackground(new java.awt.Color(27, 42, 71));
        logo.setPreferredSize(new java.awt.Dimension(250, 120));

        javax.swing.GroupLayout logoLayout = new javax.swing.GroupLayout(logo);
        logo.setLayout(logoLayout);
        logoLayout.setHorizontalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        logoLayout.setVerticalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidebar.add(logo, java.awt.BorderLayout.PAGE_START);

        buttons.setBackground(new java.awt.Color(27, 42, 71));
        buttons.setLayout(new java.awt.GridLayout(8, 1));

        btnDash.setBackground(new java.awt.Color(27, 42, 71));
        btnDash.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDash.setForeground(new java.awt.Color(255, 255, 255));
        btnDash.setText("DASHBOARD [F1]");
        btnDash.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        btnDash.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDash.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnDash.addActionListener(this::btnDashActionPerformed);
        buttons.add(btnDash);

        btnAppo.setBackground(new java.awt.Color(27, 42, 71));
        btnAppo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAppo.setForeground(new java.awt.Color(255, 255, 255));
        btnAppo.setText("APPOINTMENT");
        btnAppo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        btnAppo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAppo.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAppo.addActionListener(this::btnAppoActionPerformed);
        buttons.add(btnAppo);

        btnInven.setBackground(new java.awt.Color(27, 42, 71));
        btnInven.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnInven.setForeground(new java.awt.Color(255, 255, 255));
        btnInven.setText("INVENTORY");
        btnInven.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        btnInven.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInven.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnInven.addActionListener(this::btnInvenActionPerformed);
        buttons.add(btnInven);

        btnReg.setBackground(new java.awt.Color(27, 42, 71));
        btnReg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnReg.setForeground(new java.awt.Color(255, 255, 255));
        btnReg.setText("SET JOB CARD");
        btnReg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        btnReg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReg.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnReg.addActionListener(this::btnRegActionPerformed);
        buttons.add(btnReg);

        btnTech.setBackground(new java.awt.Color(27, 42, 71));
        btnTech.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnTech.setForeground(new java.awt.Color(255, 255, 255));
        btnTech.setText("TECHNICIANS");
        btnTech.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        btnTech.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTech.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnTech.addActionListener(this::btnTechActionPerformed);
        buttons.add(btnTech);

        btnHistory.setBackground(new java.awt.Color(27, 42, 71));
        btnHistory.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setText("SERVICE HISTORY");
        btnHistory.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistory.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnHistory.addActionListener(this::btnHistoryActionPerformed);
        buttons.add(btnHistory);

        btnAdminC.setBackground(new java.awt.Color(17, 24, 39));
        btnAdminC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdminC.setForeground(new java.awt.Color(255, 255, 255));
        btnAdminC.setText("ADMIN CREDENTIALS");
        btnAdminC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        btnAdminC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdminC.addActionListener(this::btnAdminCActionPerformed);
        buttons.add(btnAdminC);

        sidebar.add(buttons, java.awt.BorderLayout.CENTER);

        logOut.setBackground(new java.awt.Color(27, 42, 71));
        logOut.setPreferredSize(new java.awt.Dimension(250, 80));
        logOut.setLayout(new java.awt.GridLayout(1, 1));

        jButton2.setBackground(new java.awt.Color(27, 42, 71));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("LOG OUT");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(this::jButton2ActionPerformed);
        logOut.add(jButton2);

        sidebar.add(logOut, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(sidebar, java.awt.BorderLayout.LINE_START);

        main.setLayout(new java.awt.BorderLayout());

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setPreferredSize(new java.awt.Dimension(1030, 60));

        lblTopic.setBackground(new java.awt.Color(255, 255, 255));
        lblTopic.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTopic.setText("APPOINTMENT");

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUser.setForeground(new java.awt.Color(102, 0, 255));

        lblUser1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lblUser1.setText("USER :-");

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
                .addGap(461, 461, 461)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDateTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(lblUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUser1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDateTime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTopic, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        main.add(Header, java.awt.BorderLayout.PAGE_START);

        CardPanel.setBackground(new java.awt.Color(204, 204, 204));
        CardPanel.setLayout(new java.awt.CardLayout());

        pnlDash.setBackground(new java.awt.Color(210, 210, 210));
        pnlDash.setMinimumSize(new java.awt.Dimension(1030, 671));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
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
                .addContainerGap(30, Short.MAX_VALUE))
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
                .addContainerGap(42, Short.MAX_VALUE)
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
        card3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 3, true));
        card3.setPreferredSize(new java.awt.Dimension(30, 100));

        lblTech.setBackground(new java.awt.Color(255, 255, 255));
        lblTech.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblTech.setForeground(new java.awt.Color(0, 102, 204));
        lblTech.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 102, 204));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Technicians");

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
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
                .addContainerGap(61, Short.MAX_VALUE)
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
        bay1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));
        bay1.setPreferredSize(new java.awt.Dimension(20, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BAY - 01");

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setForeground(new java.awt.Color(0, 51, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("XXX-0000");

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setForeground(new java.awt.Color(0, 51, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText(".............");

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
        bay2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setForeground(new java.awt.Color(0, 51, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText(".............");

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 51, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("BAY - 02");

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setForeground(new java.awt.Color(0, 51, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("XXX-0000");

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
        bay3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        jLabel31.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 51, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("BAY - 03");

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setForeground(new java.awt.Color(0, 51, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("XXX-0000");

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setForeground(new java.awt.Color(0, 51, 102));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText(".............");

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
        bay4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 51, 102));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("BAY - 04");

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setForeground(new java.awt.Color(0, 51, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("XXX-0000");

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setForeground(new java.awt.Color(0, 51, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText(".............");

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
        bay5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        jLabel33.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 51, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("BAY - 05");

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setForeground(new java.awt.Color(0, 51, 102));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("XXX-0000");

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setForeground(new java.awt.Color(0, 51, 102));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText(".............");

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
        bay6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 51, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("BAY - 06");

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setForeground(new java.awt.Color(0, 51, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("XXX-0000");

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setForeground(new java.awt.Color(0, 51, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText(".............");

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
        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(73, 80, 87));
        jLabel17.setText("Todays' Overview");

        jLabel18.setBackground(new java.awt.Color(79, 115, 186));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(73, 80, 87));
        jLabel18.setText("Service Bay Status");

        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator5.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));

        jLabel19.setBackground(new java.awt.Color(79, 115, 186));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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

        btnServiceBill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnServiceBill.setForeground(new java.awt.Color(0, 102, 255));
        btnServiceBill.setText("Service Billing");
        btnServiceBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        btnServiceBill.addActionListener(this::btnServiceBillActionPerformed);

        lblAdmin.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(0, 153, 255));
        lblAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bays, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnServiceBill, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(lblAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(4, 4, 4)
                .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bays, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnServiceBill, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        pnlAppo.setBackground(new java.awt.Color(220, 220, 220));
        pnlAppo.setMinimumSize(new java.awt.Dimension(1030, 671));

        appoAll.setBackground(new java.awt.Color(255, 255, 255));
        appoAll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        appoAll.setPreferredSize(new java.awt.Dimension(1018, 659));

        jPanel10.setMinimumSize(new java.awt.Dimension(940, 530));
        jPanel10.setLayout(new java.awt.BorderLayout());

        btnDetails.setText("Details >");
        btnDetails.addActionListener(this::btnDetailsActionPerformed);

        btnUpdate.setText("Update");

        btnSave.setText("Save");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnSearch.setText("Serch");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

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

        txtCustName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustNameKeyReleased(evt);
            }
        });

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

        appoTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                appoTimeFocusLost(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel27.setText("Make");

        cmbMake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "Van", "SUV", "Lorry", "Bus" }));

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel28.setText("Fuel Type");

        cmbFuel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Petrol", "Desel" }));

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

        javax.swing.GroupLayout appoAllLayout = new javax.swing.GroupLayout(appoAll);
        appoAll.setLayout(appoAllLayout);
        appoAllLayout.setHorizontalGroup(
            appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appoAllLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(appoAllLayout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(regDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(appoAllLayout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(appoAllLayout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(276, 276, 276))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appoAllLayout.createSequentialGroup()
                                .addGap(568, 568, 568)
                                .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34))
        );
        appoAllLayout.setVerticalGroup(
            appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoAllLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(appoAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
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
                .addComponent(appoAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        CardPanel.add(pnlAppo, "card4");

        pnlInventory.setBackground(new java.awt.Color(220, 220, 220));
        pnlInventory.setMaximumSize(new java.awt.Dimension(1030, 671));
        pnlInventory.setMinimumSize(new java.awt.Dimension(1030, 671));
        pnlInventory.setPreferredSize(new java.awt.Dimension(1030, 671));

        inventMain.setBackground(new java.awt.Color(255, 255, 255));
        inventMain.setMaximumSize(new java.awt.Dimension(1018, 665));
        inventMain.setMinimumSize(new java.awt.Dimension(1018, 665));
        inventMain.setLayout(new java.awt.BorderLayout());

        left.setBackground(new java.awt.Color(255, 255, 255));
        left.setPreferredSize(new java.awt.Dimension(450, 655));
        left.setLayout(new java.awt.BorderLayout());

        head.setPreferredSize(new java.awt.Dimension(450, 60));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setText("I n v e n t o r y");

        conbTableSelect.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        conbTableSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accessories", "SpairParts" }));
        conbTableSelect.addActionListener(this::conbTableSelectActionPerformed);

        javax.swing.GroupLayout headLayout = new javax.swing.GroupLayout(head);
        head.setLayout(headLayout);
        headLayout.setHorizontalGroup(
            headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(conbTableSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headLayout.setVerticalGroup(
            headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conbTableSelect)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        left.add(head, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.CardLayout());

        acce.setBackground(new java.awt.Color(255, 255, 255));

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Catagory");

        cmbName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbName.addActionListener(this::cmbNameActionPerformed);

        cmbBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBrand.addActionListener(this::cmbBrandActionPerformed);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Item Brand");

        cmbDetails.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDetails.addActionListener(this::cmbDetailsActionPerformed);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Details");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Price");

        txtPrice.setEditable(false);
        txtPrice.setBackground(new java.awt.Color(255, 255, 255));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(51, 102, 255));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Quantity");

        txtQtuInvent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQtuInvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQtuInventMouseClicked(evt);
            }
        });
        txtQtuInvent.addActionListener(this::txtQtuInventActionPerformed);
        txtQtuInvent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtuInventKeyReleased(evt);
            }
        });

        tableAcc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tableAcc);
        if (tableAcc.getColumnModel().getColumnCount() > 0) {
            tableAcc.getColumnModel().getColumn(0).setResizable(false);
            tableAcc.getColumnModel().getColumn(0).setPreferredWidth(120);
            tableAcc.getColumnModel().getColumn(1).setResizable(false);
            tableAcc.getColumnModel().getColumn(1).setPreferredWidth(40);
            tableAcc.getColumnModel().getColumn(2).setResizable(false);
            tableAcc.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField8.addActionListener(this::jTextField8ActionPerformed);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("total");

        btnBill.setForeground(new java.awt.Color(255, 51, 51));
        btnBill.setText("Bill");
        btnBill.addActionListener(this::btnBillActionPerformed);

        btnCancle.setText("Cancle");
        btnCancle.addActionListener(this::btnCancleActionPerformed);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(this::btnRemoveActionPerformed);

        invenAddAcc.setText("Add");
        invenAddAcc.addActionListener(this::invenAddAccActionPerformed);

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("Last Price");

        txtFinalPrice.setEditable(false);
        txtFinalPrice.setBackground(new java.awt.Color(255, 255, 255));
        txtFinalPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFinalPrice.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout acceLayout = new javax.swing.GroupLayout(acce);
        acce.setLayout(acceLayout);
        acceLayout.setHorizontalGroup(
            acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acceLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(acceLayout.createSequentialGroup()
                        .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbBrand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDetails, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(acceLayout.createSequentialGroup()
                        .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(acceLayout.createSequentialGroup()
                                .addComponent(txtFinalPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(invenAddAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, acceLayout.createSequentialGroup()
                                .addComponent(txtPrice)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtuInvent, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
            .addGroup(acceLayout.createSequentialGroup()
                .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(acceLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(acceLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(acceLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBill, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(acceLayout.createSequentialGroup()
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        acceLayout.setVerticalGroup(
            acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, acceLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQtuInvent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFinalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(invenAddAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(acceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel6.add(acce, "card3");

        spair.setBackground(new java.awt.Color(255, 255, 255));

        lblName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName1.setText("Part Name");

        cmbName1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbName1.addActionListener(this::cmbName1ActionPerformed);

        cmbBrand1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBrand1.addActionListener(this::cmbBrand1ActionPerformed);

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setText("Item Brand");

        cmbDetails1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDetails1.addActionListener(this::cmbDetails1ActionPerformed);

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setText("Details");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setText("Price");

        txtPrice1.setEditable(false);
        txtPrice1.setBackground(new java.awt.Color(255, 255, 255));
        txtPrice1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice1.setForeground(new java.awt.Color(51, 102, 255));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setText("Quantity");

        txtQtuInvent1.setEditable(false);
        txtQtuInvent1.setBackground(new java.awt.Color(255, 255, 255));
        txtQtuInvent1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQtuInvent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQtuInvent1MouseClicked(evt);
            }
        });
        txtQtuInvent1.addActionListener(this::txtQtuInvent1ActionPerformed);
        txtQtuInvent1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtuInvent1KeyReleased(evt);
            }
        });

        tableSpair.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tableSpair);
        if (tableSpair.getColumnModel().getColumnCount() > 0) {
            tableSpair.getColumnModel().getColumn(0).setResizable(false);
            tableSpair.getColumnModel().getColumn(0).setPreferredWidth(120);
            tableSpair.getColumnModel().getColumn(1).setResizable(false);
            tableSpair.getColumnModel().getColumn(1).setPreferredWidth(40);
            tableSpair.getColumnModel().getColumn(2).setResizable(false);
            tableSpair.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jTextField9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField9.addActionListener(this::jTextField9ActionPerformed);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setText("total");

        btnBillSpair.setForeground(new java.awt.Color(255, 51, 51));
        btnBillSpair.setText("Bill");
        btnBillSpair.addActionListener(this::btnBillSpairActionPerformed);

        btnBill4.setText("Cancle");
        btnBill4.addActionListener(this::btnBill4ActionPerformed);

        btnBill5.setText("Remove");
        btnBill5.addActionListener(this::btnBill5ActionPerformed);

        invenAdd1.setText("Add");
        invenAdd1.addActionListener(this::invenAdd1ActionPerformed);

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setText("Last Price");

        txtFinalPrice1.setEditable(false);
        txtFinalPrice1.setBackground(new java.awt.Color(255, 255, 255));
        txtFinalPrice1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFinalPrice1.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout spairLayout = new javax.swing.GroupLayout(spair);
        spair.setLayout(spairLayout);
        spairLayout.setHorizontalGroup(
            spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spairLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spairLayout.createSequentialGroup()
                        .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbBrand1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDetails1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbName1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(spairLayout.createSequentialGroup()
                        .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(spairLayout.createSequentialGroup()
                                .addComponent(txtFinalPrice1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(invenAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spairLayout.createSequentialGroup()
                                .addComponent(txtPrice1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtuInvent1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
            .addGroup(spairLayout.createSequentialGroup()
                .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spairLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(spairLayout.createSequentialGroup()
                                .addComponent(btnBill5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBill4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBillSpair, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(spairLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spairLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        spairLayout.setVerticalGroup(
            spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spairLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbName1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbBrand1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQtuInvent1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrice1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFinalPrice1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(invenAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(spairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBill5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBill4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBillSpair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel6.add(spair, "card2");

        left.add(jPanel6, java.awt.BorderLayout.CENTER);

        inventMain.add(left, java.awt.BorderLayout.LINE_START);

        right.setBackground(new java.awt.Color(222, 238, 255));
        right.setMaximumSize(new java.awt.Dimension(568, 655));
        right.setMinimumSize(new java.awt.Dimension(568, 655));
        right.setOpaque(false);
        right.setLayout(new java.awt.CardLayout());

        txtSearch2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch2.addActionListener(this::txtSearch2ActionPerformed);
        txtSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearch2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch2KeyReleased(evt);
            }
        });

        btnSearch2.setText("Search");
        btnSearch2.addActionListener(this::btnSearch2ActionPerformed);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Brand", "Details", "Qty", "Unit Price"
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
            table1.getColumnModel().getColumn(0).setPreferredWidth(40);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(2).setResizable(false);
            table1.getColumnModel().getColumn(2).setPreferredWidth(40);
            table1.getColumnModel().getColumn(3).setResizable(false);
            table1.getColumnModel().getColumn(3).setPreferredWidth(30);
            table1.getColumnModel().getColumn(4).setResizable(false);
            table1.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel51.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel51.setText("Accessories - Table");

        accesChart.setForeground(new java.awt.Color(102, 102, 255));
        accesChart.setText("Charts");
        accesChart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        accesChart.addActionListener(this::accesChartActionPerformed);

        javax.swing.GroupLayout AccessoriesLayout = new javax.swing.GroupLayout(Accessories);
        Accessories.setLayout(AccessoriesLayout);
        AccessoriesLayout.setHorizontalGroup(
            AccessoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccessoriesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(AccessoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addGroup(AccessoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(AccessoriesLayout.createSequentialGroup()
                            .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accesChart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        AccessoriesLayout.setVerticalGroup(
            AccessoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccessoriesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(AccessoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AccessoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(accesChart, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel51)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        right.add(Accessories, "card3");

        Spair.setBackground(new java.awt.Color(255, 255, 255));

        txtSearch3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch3.addActionListener(this::txtSearch3ActionPerformed);
        txtSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearch3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch3KeyReleased(evt);
            }
        });

        btnSearch3.setText("Search");
        btnSearch3.addActionListener(this::btnSearch3ActionPerformed);

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Brand", "Details", "Qty", "Unit Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(table3);
        if (table3.getColumnModel().getColumnCount() > 0) {
            table3.getColumnModel().getColumn(0).setResizable(false);
            table3.getColumnModel().getColumn(0).setPreferredWidth(40);
            table3.getColumnModel().getColumn(1).setResizable(false);
            table3.getColumnModel().getColumn(2).setResizable(false);
            table3.getColumnModel().getColumn(2).setPreferredWidth(40);
            table3.getColumnModel().getColumn(3).setResizable(false);
            table3.getColumnModel().getColumn(3).setPreferredWidth(30);
            table3.getColumnModel().getColumn(4).setResizable(false);
            table3.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel52.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel52.setText("SpairParts - Table");

        javax.swing.GroupLayout SpairLayout = new javax.swing.GroupLayout(Spair);
        Spair.setLayout(SpairLayout);
        SpairLayout.setHorizontalGroup(
            SpairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpairLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(SpairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addGroup(SpairLayout.createSequentialGroup()
                        .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        SpairLayout.setVerticalGroup(
            SpairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SpairLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(SpairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        right.add(Spair, "card2");

        inventMain.add(right, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlInventoryLayout = new javax.swing.GroupLayout(pnlInventory);
        pnlInventory.setLayout(pnlInventoryLayout);
        pnlInventoryLayout.setHorizontalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlInventoryLayout.setVerticalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventMain, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        CardPanel.add(pnlInventory, "card6");

        pnlHistory.setBackground(new java.awt.Color(220, 220, 220));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice", "JobID", "Discount", "Total", "Pay Amount", "Method", "Balance", "Customer", "Bill Type", "User"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(invoiceTable);
        if (invoiceTable.getColumnModel().getColumnCount() > 0) {
            invoiceTable.getColumnModel().getColumn(0).setResizable(false);
            invoiceTable.getColumnModel().getColumn(1).setResizable(false);
            invoiceTable.getColumnModel().getColumn(2).setResizable(false);
            invoiceTable.getColumnModel().getColumn(3).setResizable(false);
            invoiceTable.getColumnModel().getColumn(4).setResizable(false);
            invoiceTable.getColumnModel().getColumn(5).setResizable(false);
            invoiceTable.getColumnModel().getColumn(6).setResizable(false);
            invoiceTable.getColumnModel().getColumn(7).setResizable(false);
            invoiceTable.getColumnModel().getColumn(8).setResizable(false);
            invoiceTable.getColumnModel().getColumn(9).setResizable(false);
        }

        txtSearch5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch5KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305))
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

        pnlTech.setBackground(new java.awt.Color(220, 220, 220));

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
                .addContainerGap(28, Short.MAX_VALUE))
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

        pnlAdmin.setBackground(new java.awt.Color(220, 220, 220));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(0, 51, 102));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(240, 240, 240));
        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel12.setPreferredSize(new java.awt.Dimension(300, 612));

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel21.setText("Name");

        jLabel59.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel59.setText("User Name");

        jLabel60.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel60.setText("Email");

        jLabel61.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel61.setText("NIC");

        jLabel62.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel62.setText("Role");

        combRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));

        btnUserAdd.setText("Add User");
        btnUserAdd.addActionListener(this::btnUserAddActionPerformed);

        btnUserUpdate.setText("Update User");
        btnUserUpdate.addActionListener(this::btnUserUpdateActionPerformed);

        btnUserDel.setText("Delete User");
        btnUserDel.addActionListener(this::btnUserDelActionPerformed);

        UClear.setText("Clear");

        jLabel63.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel63.setText("Phone");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUserAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUserUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(btnUserDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNIC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserDel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(jPanel12, java.awt.BorderLayout.LINE_START);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "User Name", "Email", "NIC", "Phone", "Role"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel13, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("USER MANAGE", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(240, 240, 240));
        jPanel15.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel15.setPreferredSize(new java.awt.Dimension(300, 612));

        jLabel64.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel64.setText("Name");

        jLabel67.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel67.setText("NIC");

        jLabel68.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel68.setText("Status");

        combRole1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Awailable", "busy" }));

        btnUserAdd1.setText("Add Technician");
        btnUserAdd1.addActionListener(this::btnUserAdd1ActionPerformed);

        btnUserUpdate1.setText("Update Technician");
        btnUserUpdate1.addActionListener(this::btnUserUpdate1ActionPerformed);

        btnUserDel1.setText("Delete Technician");
        btnUserDel1.addActionListener(this::btnUserDel1ActionPerformed);

        UClear1.setText("Clear");

        jLabel69.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel69.setText("Phone");

        jLabel70.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel70.setText("Spesiality");

        txtSpeality.setColumns(20);
        txtSpeality.setRows(5);
        jScrollPane9.setViewportView(txtSpeality);

        jLabel65.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel65.setText("ID");

        txtName2.setEditable(false);
        txtName2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUserAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUserUpdate1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(btnUserDel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UClear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combRole1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNIC1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPhone1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9)
                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNIC1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUserAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserDel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.add(jPanel15, java.awt.BorderLayout.LINE_START);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "User Name", "Email", "NIC", "Phone", "Role"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jTable4);

        jPanel14.add(jScrollPane12, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("TECHNICIAN MANAGE", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel19.setBackground(new java.awt.Color(240, 240, 240));
        jPanel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel19.setPreferredSize(new java.awt.Dimension(300, 612));

        jLabel66.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel66.setText("Service Name");

        jLabel71.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel71.setText("Price");

        jLabel72.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel72.setText("Status");

        combRole2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Awailable", "busy", "Maintains" }));

        btnUserAdd2.setText("Add Services");
        btnUserAdd2.addActionListener(this::btnUserAdd2ActionPerformed);

        btnUserUpdate2.setText("Update Services");
        btnUserUpdate2.addActionListener(this::btnUserUpdate2ActionPerformed);

        btnUserDel2.setText("Delete Services");
        btnUserDel2.addActionListener(this::btnUserDel2ActionPerformed);

        UClear2.setText("Clear");

        txtSpeality1.setColumns(20);
        txtSpeality1.setRows(5);
        jScrollPane11.setViewportView(txtSpeality1);

        jLabel75.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel75.setText("Service ID");

        txtName4.setEditable(false);
        txtName4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtName3)
            .addComponent(txtName4)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
            .addComponent(btnUserAdd2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUserUpdate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUserDel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(UClear2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(combRole2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combRole2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(btnUserAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserDel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel18.add(jPanel19, java.awt.BorderLayout.LINE_START);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "User Name", "Email", "NIC", "Phone", "Role"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jTable5);

        jPanel18.add(jScrollPane13, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("SERVICES MANAGE", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setMinimumSize(new java.awt.Dimension(503, 612));
        jPanel16.setPreferredSize(new java.awt.Dimension(503, 612));

        jLabel76.setText("SpairParts");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(564, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(256, Short.MAX_VALUE)))
        );

        jPanel9.add(jPanel16, java.awt.BorderLayout.LINE_START);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel77.setText("Accessories");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane8))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(371, Short.MAX_VALUE))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel20, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("INVENTORY MANAGE", jPanel9);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jPanel22.setBackground(new java.awt.Color(240, 240, 240));
        jPanel22.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel22.setPreferredSize(new java.awt.Dimension(300, 612));

        jLabel78.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel78.setText("Bay Name");

        jLabel80.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel80.setText("Status");

        combRole3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Awailable", "busy", "Maintains" }));

        btnUserAdd3.setText("Add Services");
        btnUserAdd3.addActionListener(this::btnUserAdd3ActionPerformed);

        btnUserUpdate3.setText("Update Services");
        btnUserUpdate3.addActionListener(this::btnUserUpdate3ActionPerformed);

        btnUserDel3.setText("Delete Services");
        btnUserDel3.addActionListener(this::btnUserDel3ActionPerformed);

        UClear3.setText("Clear");

        jLabel81.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel81.setText("Bay ID");

        txtName6.setEditable(false);
        txtName6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtName5)
            .addComponent(txtName6)
            .addComponent(btnUserAdd3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUserUpdate3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
            .addComponent(btnUserDel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(UClear3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(combRole3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combRole3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224)
                .addComponent(btnUserAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserUpdate3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserDel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UClear3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel21.add(jPanel22, java.awt.BorderLayout.LINE_START);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "User Name", "Email", "NIC", "Phone", "Role"
            }
        ));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(jTable6);

        jPanel21.add(jScrollPane14, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("BAYS MANAGE", jPanel11);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Job ID", "Customer Name", "Total Amount", "Paid", "Balance", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(jTable7);
        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(0).setResizable(false);
            jTable7.getColumnModel().getColumn(1).setResizable(false);
            jTable7.getColumnModel().getColumn(2).setResizable(false);
            jTable7.getColumnModel().getColumn(3).setResizable(false);
            jTable7.getColumnModel().getColumn(4).setResizable(false);
            jTable7.getColumnModel().getColumn(5).setResizable(false);
            jTable7.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel79.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel79.setText("FROM");

        jLabel82.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel82.setText("To");

        btnPrintPDF.setText("Print PDF");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel79, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrintPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("SERVICE REPORTS", jPanel17);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlAdminLayout = new javax.swing.GroupLayout(pnlAdmin);
        pnlAdmin.setLayout(pnlAdminLayout);
        pnlAdminLayout.setHorizontalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAdminLayout.setVerticalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        CardPanel.add(pnlAdmin, "card7");

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
        customizeSearchBar(txtSearch);

        btnDash.setBackground(setColor2);
        btnAppo.setBackground(setColor1);
        btnInven.setBackground(setColor2);
        btnHistory.setBackground(setColor2);
        btnTech.setBackground(setColor2);
        btnAdminC.setBackground(new java.awt.Color(17, 24, 39));
    }//GEN-LAST:event_btnAppoActionPerformed

    private void btnTechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTechActionPerformed
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.show(CardPanel, "card4");
        lblTopic.setText("TECHNICIANS");

        btnDash.setBackground(setColor2);
        btnAppo.setBackground(setColor2);
        btnInven.setBackground(setColor2);
        btnHistory.setBackground(setColor2);
        btnTech.setBackground(setColor1);
        btnAdminC.setBackground(new java.awt.Color(17, 24, 39));
    }//GEN-LAST:event_btnTechActionPerformed

    private void txtSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch2ActionPerformed

    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillActionPerformed
        String billType = "accBill";
        try {
            DefaultTableModel model = (DefaultTableModel) tableAcc.getModel();

            if (model.getRowCount() == 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Please add items to the list first!");
                return;
            }

            // Start DB Transaction
            db.con.setAutoCommit(false);

            ArrayList<Object[]> serviceList = new ArrayList<>();
            double totalAmount = 0.0;

            for (int i = 0; i < model.getRowCount(); i++) {
                String itemName = model.getValueAt(i, 0).toString(); // Item Name: brand + " - " + details
                int qtyToDeduct = Integer.parseInt(model.getValueAt(i, 1).toString()); // Qty
                double price = Double.parseDouble(model.getValueAt(i, 2).toString()); // Price

                // Parse brand and details
                String[] nameParts = itemName.split(" - ", 2);
                if (nameParts.length < 2) {
                    throw new Exception("Invalid item name format in table: " + itemName);
                }
                String brand = nameParts[0].trim();
                String details = nameParts[1].trim();

                // 1. Verify current stock in DB first to avoid race conditions
                int currentQty = 0;
                String selectSql = "SELECT qty FROM inventory WHERE brand = ? AND details = ? FOR UPDATE";
                pst = db.con.prepareStatement(selectSql);
                pst.setString(1, brand);
                pst.setString(2, details);
                rs = pst.executeQuery();
                if (rs.next()) {
                    currentQty = rs.getInt("qty");
                } else {
                    throw new Exception("Item not found in inventory: " + itemName);
                }
                rs.close();
                pst.close();

                if (currentQty < qtyToDeduct) {
                    throw new Exception("Insufficient stock for " + itemName + ". Available: " + currentQty + ", Requested: " + qtyToDeduct);
                }

                // 2. Perform UPDATE subtraction
                String updateSql = "UPDATE inventory SET qty = qty - ? WHERE brand = ? AND details = ?";
                pst = db.con.prepareStatement(updateSql);
                pst.setInt(1, qtyToDeduct);
                pst.setString(2, brand);
                pst.setString(3, details);
                
                int updatedRows = pst.executeUpdate();
                pst.close();

                if (updatedRows == 0) {
                    throw new Exception("Failed to update inventory for " + itemName);
                }

                serviceList.add(new Object[]{itemName, String.valueOf(qtyToDeduct), price});
                totalAmount += price;
            }

            // Commit Transaction
            db.con.commit();
            db.con.setAutoCommit(true);

            // Open Bill Frame
            BillStatement myBillData = new BillStatement("General Customer", totalAmount, serviceList);
            BillFrame bill = new BillFrame(billType, myBillData, this);
            bill.setVisible(true);

            // Clear UI elements and Table
            model.setRowCount(0);
            jTextField8.setText("");
            loadInventoryTable();

        } catch (Exception e) {
            try {
                db.con.rollback();
                db.con.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Transaction failed and rolled back: " + e.getMessage(), "Billing Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBillActionPerformed

    private void btnDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashActionPerformed
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.show(CardPanel, "card1");
        lblTopic.setText("DASHBOARD");

        btnDash.setBackground(setColor1);
        btnAppo.setBackground(setColor2);
        btnInven.setBackground(setColor2);
        btnHistory.setBackground(setColor2);
        btnTech.setBackground(setColor2);
        btnAdminC.setBackground(new java.awt.Color(17, 24, 39));
    }//GEN-LAST:event_btnDashActionPerformed

    private void btnInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvenActionPerformed
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.show(CardPanel, "card3");
        lblTopic.setText("INVENTORY");
        customiseTable(table1);
        customiseTable(tableAcc);
        customizeSearchBar(txtSearch2);

        btnDash.setBackground(setColor2);
        btnAppo.setBackground(setColor2);
        btnInven.setBackground(setColor1);
        btnHistory.setBackground(setColor2);
        btnTech.setBackground(setColor2);
        btnAdminC.setBackground(new java.awt.Color(17, 24, 39));
    }//GEN-LAST:event_btnInvenActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.show(CardPanel, "card5");
        lblTopic.setText("JobCARD");
        customiseTable(invoiceTable);
        customizeSearchBar(txtSearch5);

        btnDash.setBackground(setColor2);
        btnAppo.setBackground(setColor2);
        btnInven.setBackground(setColor2);
        btnHistory.setBackground(setColor1);
        btnTech.setBackground(setColor2);
        btnAdminC.setBackground(new java.awt.Color(17, 24, 39));
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        Register reg = new Register(this);
        reg.setVisible(true);

        btnDash.setBackground(setColor2);
        btnAppo.setBackground(setColor2);
        btnInven.setBackground(setColor2);
        btnHistory.setBackground(setColor2);
        btnTech.setBackground(setColor2);
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
        AppointmentDetails appoi = new AppointmentDetails(this);
        appoi.setVisible(true);
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancleActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void txtSearch2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch2KeyPressed

    }//GEN-LAST:event_txtSearch2KeyPressed

    private void txtSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch2KeyReleased
        String searchKey = txtSearch2.getText();

        try {
            String sql = "SELECT catagory, brand, details, qty, unit_price FROM inventory WHERE catagory LIKE ? OR brand LIKE ? OR details LIKE ?";

            pst = db.con.prepareStatement(sql);

            pst.setString(1, "%" + searchKey + "%");
            pst.setString(2, "%" + searchKey + "%");
            pst.setString(3, "%" + searchKey + "%");

            rs = pst.executeQuery();

            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("catagory"),
                    rs.getString("brand"),
                    rs.getString("details"),
                    rs.getString("qty"),
                    rs.getString("unit_price")
                };
                model.addRow(row);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearch2KeyReleased

    private void cmbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNameActionPerformed
        if (cmbName.getSelectedIndex() > 0) {
            String selectedType = cmbName.getSelectedItem().toString();

            try {
                pst = db.con.prepareStatement("SELECT DISTINCT brand FROM inventory WHERE catagory=? ");
                pst.setString(1, selectedType);
                rs = pst.executeQuery();

                cmbBrand.removeAllItems();
                cmbBrand.addItem("- Select Item -");
                while (rs.next()) {

                    cmbBrand.addItem(rs.getString("brand"));
                }
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                System.getLogger(Dash.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } else {
            cmbBrand.removeAllItems();
            cmbBrand.addItem("- Select Brand -");
        }
    }//GEN-LAST:event_cmbNameActionPerformed

    private void cmbBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBrandActionPerformed
        if (cmbBrand.getSelectedItem() != null && cmbBrand.getSelectedIndex() > 0) {

            String selectedType = cmbName.getSelectedItem().toString();
            String selectedBrand = cmbBrand.getSelectedItem().toString();

            try {
                String sql = "SELECT details FROM inventory WHERE catagory = ? AND brand = ?";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, selectedType);
                pst.setString(2, selectedBrand);
                rs = pst.executeQuery();

                cmbDetails.removeAllItems();
                cmbDetails.addItem("- Select Item -");

                while (rs.next()) {
                    cmbDetails.addItem(rs.getString("details"));
                }

                rs.close();
                pst.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (cmbDetails != null) {
                cmbDetails.removeAllItems();
                cmbDetails.addItem("- Select Item -");
            }
        }
    }//GEN-LAST:event_cmbBrandActionPerformed

    private void cmbDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDetailsActionPerformed
        if (cmbDetails.getSelectedItem() != null && cmbDetails.getSelectedIndex() > 0) {

            String selectedType = cmbName.getSelectedItem().toString();
            String selectedBrand = cmbBrand.getSelectedItem().toString();
            String selectedDetails = cmbDetails.getSelectedItem().toString();

            try {
                String sql = "SELECT unit_price FROM inventory WHERE catagory = ? AND brand = ? AND details = ?";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, selectedType);
                pst.setString(2, selectedBrand);
                pst.setString(3, selectedDetails);

                rs = pst.executeQuery();

                if (rs.next()) {
                    txtPrice.setText(rs.getString("unit_price"));
                }

                rs.close();
                pst.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (txtPrice != null) {
                txtPrice.setText("");
            }
        }
    }//GEN-LAST:event_cmbDetailsActionPerformed

    private void invenAddAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invenAddAccActionPerformed
        try {
            if (cmbName.getSelectedIndex() <= 0 || cmbDetails.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this, "Please select an option", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (txtQtuInvent.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Quantity!", "Qty Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String category = cmbName.getSelectedItem().toString();
            String brand = cmbBrand.getSelectedItem().toString();
            String details = cmbDetails.getSelectedItem().toString();
            String itemName = brand + " - " + details;
            int qtyToAdd = Integer.parseInt(txtQtuInvent.getText().trim());

            if (qtyToAdd <= 0) {
                JOptionPane.showMessageDialog(this, "Please Enter quantity > 0!", "Qty Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 1. Fetch current database stock
            int dbQty = 0;
            String stockSql = "SELECT qty FROM inventory WHERE catagory = ? AND brand = ? AND details = ?";
            pst = db.con.prepareStatement(stockSql);
            pst.setString(1, category);
            pst.setString(2, brand);
            pst.setString(3, details);
            rs = pst.executeQuery();
            if (rs.next()) {
                dbQty = rs.getInt("qty");
            }
            rs.close();
            pst.close();

            // 2. Sum up quantity already in tableAcc
            DefaultTableModel model = (DefaultTableModel) tableAcc.getModel();
            int alreadyAddedQty = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).toString().equals(itemName)) {
                    alreadyAddedQty += Integer.parseInt(model.getValueAt(i, 1).toString());
                }
            }

            // 3. Validation
            if (alreadyAddedQty + qtyToAdd > dbQty) {
                JOptionPane.showMessageDialog(this, 
                    "Requested quantity (" + qtyToAdd + ") + already added (" + alreadyAddedQty + ") exceeds available stock (" + dbQty + ")!", 
                    "Stock Validation Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            double finalPrice = Double.parseDouble(txtFinalPrice.getText().trim());

            model.addRow(new Object[]{itemName, qtyToAdd, finalPrice});

            double grandTotal = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                grandTotal += Double.parseDouble(model.getValueAt(i, 2).toString());
            }
            jTextField8.setText(String.format("%.2f", grandTotal));

            cmbName.setSelectedIndex(0);

            if (cmbBrand.getItemCount() > 0) {
                cmbBrand.setSelectedIndex(0);
            }
            if (cmbDetails.getItemCount() > 0) {
                cmbDetails.setSelectedIndex(0);
            }

            txtPrice.setText("");
            txtQtuInvent.setText("");
            txtFinalPrice.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please Enter a Number!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_invenAddAccActionPerformed

    private void txtQtuInventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtuInventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtuInventActionPerformed

    private void txtQtuInventKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtuInventKeyReleased

    }//GEN-LAST:event_txtQtuInventKeyReleased

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void txtSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3ActionPerformed

    private void txtSearch3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3KeyPressed

    private void txtSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch3KeyReleased
        String searchKey = txtSearch3.getText().trim();

        try {
            String sql = "SELECT part_name, brand, details, qty, unit_price FROM spare_parts WHERE part_name LIKE ? OR brand LIKE ? OR details LIKE ?";

            pst = db.con.prepareStatement(sql);

            pst.setString(1, "%" + searchKey + "%");
            pst.setString(2, "%" + searchKey + "%");
            pst.setString(3, "%" + searchKey + "%");

            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table3.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("part_name"),
                    rs.getString("brand"),
                    rs.getString("details"),
                    rs.getString("qty"),
                    rs.getString("unit_price")
                };
                model.addRow(row);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearch3KeyReleased

    private void btnSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch3ActionPerformed

    private void conbTableSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conbTableSelectActionPerformed
        String selected = conbTableSelect.getSelectedItem().toString();

        if (selected.equals("Accessories")) {
            Accessories.setVisible(true);
            acce.setVisible(true);
            spair.setVisible(false);
            Spair.setVisible(false);
        } else if (selected.equals("SpairParts")) {
            Accessories.setVisible(false);
            acce.setVisible(false);
            spair.setVisible(true);
            Spair.setVisible(true);
            loadSparePartsItemNames();
        }
    }//GEN-LAST:event_conbTableSelectActionPerformed

    private void txtCustNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustNameKeyReleased
        String search = txtCustName.getText().trim();
        if (search.length() >= 2) {
            try {
                String sql = "SELECT name, phone FROM customer WHERE name LIKE ?";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, search + "%");
                rs = pst.executeQuery();

                listModel.clear();

                while (rs.next()) {
                    listModel.addElement(rs.getString("name") + " - 0" + rs.getInt("phone"));
                }

                if (listModel.getSize() > 0) {
                    popupMenu.show(txtCustName, 0, txtCustName.getHeight());
                    txtCustName.requestFocus();
                } else {
                    popupMenu.setVisible(false);
                }

                rs.close();
                pst.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            popupMenu.setVisible(false);
        }

    }//GEN-LAST:event_txtCustNameKeyReleased

    private void appoTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_appoTimeFocusLost
        String timeStr = appoTime.getText().trim();

        if (!timeStr.isEmpty()) {
            try {
                if (timeStr.length() == 1 || timeStr.length() == 2) {
                    int hour = Integer.parseInt(timeStr);
                    if (hour >= 0 && hour <= 23) {
                        appoTime.setText(String.format("%02d:00", hour));
                    } else {
                        throw new NumberFormatException();
                    }
                } else if (timeStr.length() == 4 && !timeStr.contains(":")) {
                    int hour = Integer.parseInt(timeStr.substring(0, 2));
                    int min = Integer.parseInt(timeStr.substring(2, 4));
                    if (hour >= 0 && hour <= 23 && min >= 0 && min <= 59) {
                        appoTime.setText(String.format("%02d:%02d", hour, min));
                    } else {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Please Enter Correct Time! (උදා: 10:30 හෝ 14:00).", "Wront Typeි", javax.swing.JOptionPane.WARNING_MESSAGE);
                appoTime.setText("");
                appoTime.requestFocus();
            }
        }
    }//GEN-LAST:event_appoTimeFocusLost

    private void txtQtuInventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQtuInventMouseClicked
        String currentQty = txtQtuInvent.getText().trim();
        if (currentQty.isEmpty()) {
            currentQty = "1";
        }

        String input = JOptionPane.showInputDialog(this, "Please Enter Quantity :", currentQty);

        if (input != null && !input.trim().isEmpty()) {
            try {
                int qty = Integer.parseInt(input.trim());

                if (qty > 0) {
                    txtQtuInvent.setText(String.valueOf(qty));

                    String priceStr = txtPrice.getText().trim();
                    if (!priceStr.isEmpty()) {
                        double price = Double.parseDouble(priceStr);
                        double lastPrice = qty * price;
                        txtFinalPrice.setText(String.format("%.2f", lastPrice));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please Enter number > 0!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtQtuInventMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int k = JOptionPane.showConfirmDialog(this, "Are you sure?", "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (k == JOptionPane.YES_OPTION) {
            this.dispose();
            LoginForm log = new LoginForm();
            log.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnServiceBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiceBillActionPerformed
        String uName = user1.getName();
        ArrayList<Object[]> emptyList = new ArrayList<>();
        BillStatement myBillData = new BillStatement("General Customer", 0.0, emptyList);
        String billType = "ServiceBill";
        BillFrame bill = new BillFrame(billType, myBillData, this);
        bill.setVisible(true);

    }//GEN-LAST:event_btnServiceBillActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void cmbName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbName1ActionPerformed
        if (cmbName1.getSelectedItem() != null && cmbName1.getSelectedIndex() > 0) {
            String selectedName = cmbName1.getSelectedItem().toString();

            try {
                pst = db.con.prepareStatement("SELECT DISTINCT brand FROM spare_parts WHERE part_name = ?");
                pst.setString(1, selectedName);
                rs = pst.executeQuery();

                cmbBrand1.removeAllItems();
                cmbBrand1.addItem("- Select Brand -");
                while (rs.next()) {
                    cmbBrand1.addItem(rs.getString("brand"));
                }
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } else {
            cmbBrand1.removeAllItems();
            cmbBrand1.addItem("- Select Brand -");
        }
    }//GEN-LAST:event_cmbName1ActionPerformed

    private void cmbBrand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBrand1ActionPerformed
        if (cmbBrand1.getSelectedItem() != null && cmbBrand1.getSelectedIndex() > 0) {
            String selectedName = cmbName1.getSelectedItem().toString();
            String selectedBrand = cmbBrand1.getSelectedItem().toString();

            try {
                pst = db.con.prepareStatement("SELECT DISTINCT details FROM spare_parts WHERE part_name = ? AND brand = ?");
                pst.setString(1, selectedName);
                pst.setString(2, selectedBrand);
                rs = pst.executeQuery();

                cmbDetails1.removeAllItems();
                cmbDetails1.addItem("- Select Details -");
                while (rs.next()) {
                    cmbDetails1.addItem(rs.getString("details"));
                }
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } else {
            cmbDetails1.removeAllItems();
            cmbDetails1.addItem("- Select Details -");
        }
    }//GEN-LAST:event_cmbBrand1ActionPerformed

    private void cmbDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDetails1ActionPerformed
        if (cmbDetails1.getSelectedItem() != null && cmbDetails1.getSelectedIndex() > 0) {
            String selectedName = cmbName1.getSelectedItem().toString();
            String selectedBrand = cmbBrand1.getSelectedItem().toString();
            String selectedDetails = cmbDetails1.getSelectedItem().toString();

            try {
                pst = db.con.prepareStatement("SELECT unit_price FROM spare_parts WHERE part_name = ? AND brand = ? AND details = ?");
                pst.setString(1, selectedName);
                pst.setString(2, selectedBrand);
                pst.setString(3, selectedDetails);
                rs = pst.executeQuery();

                if (rs.next()) {
                    txtPrice1.setText(rs.getString("unit_price"));
                }
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } else {
            txtPrice1.setText("");
        }
    }//GEN-LAST:event_cmbDetails1ActionPerformed

    private void txtQtuInvent1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQtuInvent1MouseClicked
        String currentQty = txtQtuInvent1.getText().trim();
        if (currentQty.isEmpty()) {
            currentQty = "1";
        }

        String input = JOptionPane.showInputDialog(this, "Please Enter Quantity :", currentQty);

        if (input != null && !input.trim().isEmpty()) {
            try {
                int qty = Integer.parseInt(input.trim());

                if (qty > 0) {
                    txtQtuInvent1.setText(String.valueOf(qty));

                    String priceStr = txtPrice1.getText().trim();
                    if (!priceStr.isEmpty()) {
                        double price = Double.parseDouble(priceStr);
                        double lastPrice = qty * price;
                        txtFinalPrice1.setText(String.format("%.2f", lastPrice));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please Enter number > 0!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtQtuInvent1MouseClicked

    private void txtQtuInvent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtuInvent1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtuInvent1ActionPerformed

    private void txtQtuInvent1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtuInvent1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtuInvent1KeyReleased

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void btnBillSpairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillSpairActionPerformed
        String billType = "spairBill";
        try {
            DefaultTableModel model = (DefaultTableModel) tableSpair.getModel();

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Please Select Items!", "Empty Table", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Start DB Transaction
            db.con.setAutoCommit(false);

            ArrayList<Object[]> tableData = new ArrayList<>();
            double total = 0.0;

            for (int i = 0; i < model.getRowCount(); i++) {
                String itemName = model.getValueAt(i, 0).toString(); // Item Name: name + " - " + brand + " - " + details
                int qtyToDeduct = Integer.parseInt(model.getValueAt(i, 1).toString()); // Qty
                double price = Double.parseDouble(model.getValueAt(i, 2).toString()); // Price

                // Parse name, brand, details
                String[] nameParts = itemName.split(" - ", 3);
                if (nameParts.length < 3) {
                    throw new Exception("Invalid item name format in table: " + itemName);
                }
                String partName = nameParts[0].trim();
                String brand = nameParts[1].trim();
                String details = nameParts[2].trim();

                // 1. Verify current stock in DB first to avoid race conditions
                int currentQty = 0;
                String selectSql = "SELECT qty FROM spare_parts WHERE part_name = ? AND brand = ? AND details = ? FOR UPDATE";
                pst = db.con.prepareStatement(selectSql);
                pst.setString(1, partName);
                pst.setString(2, brand);
                pst.setString(3, details);
                rs = pst.executeQuery();
                if (rs.next()) {
                    currentQty = rs.getInt("qty");
                } else {
                    throw new Exception("Spare part not found: " + itemName);
                }
                rs.close();
                pst.close();

                if (currentQty < qtyToDeduct) {
                    throw new Exception("Insufficient stock for " + itemName + ". Available: " + currentQty + ", Requested: " + qtyToDeduct);
                }

                // 2. Perform UPDATE subtraction
                String updateSql = "UPDATE spare_parts SET qty = qty - ? WHERE part_name = ? AND brand = ? AND details = ?";
                pst = db.con.prepareStatement(updateSql);
                pst.setInt(1, qtyToDeduct);
                pst.setString(2, partName);
                pst.setString(3, brand);
                pst.setString(4, details);
                
                int updatedRows = pst.executeUpdate();
                pst.close();

                if (updatedRows == 0) {
                    throw new Exception("Failed to update spare parts stock for " + itemName);
                }

                tableData.add(new Object[]{itemName, String.valueOf(qtyToDeduct), price});
                total += price;
            }

            // Commit Transaction
            db.con.commit();
            db.con.setAutoCommit(true);

            String cusName = txtCustName.getText().trim();
            if (cusName.isEmpty()) {
                cusName = "General Customer";
            }

            // Open Bill Frame
            BillStatement myBillData = new BillStatement(cusName, total, tableData);
            BillFrame billWindow = new BillFrame(billType, myBillData, this);
            billWindow.setVisible(true);

            // Clear UI elements and Table
            model.setRowCount(0);
            jTextField9.setText("");
            loadSparePartsAdminTable();

        } catch (Exception e) {
            try {
                db.con.rollback();
                db.con.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Transaction failed and rolled back: " + e.getMessage(), "Billing Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBillSpairActionPerformed

    private void btnBill4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBill4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBill4ActionPerformed

    private void btnBill5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBill5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBill5ActionPerformed

    private void invenAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invenAdd1ActionPerformed
        try {
            if (cmbName1.getSelectedIndex() <= 0 || cmbDetails1.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this, "Please select an option", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (txtQtuInvent1.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Quantity!", "Qty Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String partName = cmbName1.getSelectedItem().toString();
            String brand = cmbBrand1.getSelectedItem().toString();
            String details = cmbDetails1.getSelectedItem().toString();
            String itemName = partName + " - " + brand + " - " + details;
            int qtyToAdd = Integer.parseInt(txtQtuInvent1.getText().trim());

            if (qtyToAdd <= 0) {
                JOptionPane.showMessageDialog(this, "Please Enter quantity > 0!", "Qty Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 1. Fetch current database stock
            int dbQty = 0;
            String stockSql = "SELECT qty FROM spare_parts WHERE part_name = ? AND brand = ? AND details = ?";
            pst = db.con.prepareStatement(stockSql);
            pst.setString(1, partName);
            pst.setString(2, brand);
            pst.setString(3, details);
            rs = pst.executeQuery();
            if (rs.next()) {
                dbQty = rs.getInt("qty");
            }
            rs.close();
            pst.close();

            // 2. Sum up quantity already in tableSpair
            DefaultTableModel model = (DefaultTableModel) tableSpair.getModel();
            int alreadyAddedQty = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).toString().equals(itemName)) {
                    alreadyAddedQty += Integer.parseInt(model.getValueAt(i, 1).toString());
                }
            }

            // 3. Validation
            if (alreadyAddedQty + qtyToAdd > dbQty) {
                JOptionPane.showMessageDialog(this, 
                    "Requested quantity (" + qtyToAdd + ") + already added (" + alreadyAddedQty + ") exceeds available stock (" + dbQty + ")!", 
                    "Stock Validation Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            double finalPrice = Double.parseDouble(txtFinalPrice1.getText().trim());

            model.addRow(new Object[]{itemName, qtyToAdd, finalPrice});

            double grandTotal = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                grandTotal += Double.parseDouble(model.getValueAt(i, 2).toString());
            }
            jTextField9.setText(String.format("%.2f", grandTotal));

            cmbName1.setSelectedIndex(0);

            if (cmbBrand1.getItemCount() > 0) {
                cmbBrand1.setSelectedIndex(0);
            }
            if (cmbDetails1.getItemCount() > 0) {
                cmbDetails1.setSelectedIndex(0);
            }

            txtPrice1.setText("");
            txtQtuInvent1.setText("");
            txtFinalPrice1.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please Enter a Number!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_invenAdd1ActionPerformed

    private void accesChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accesChartActionPerformed
        String name = "accesChart";
        Charts chart = new Charts(name);
        chart.setVisible(true);
    }//GEN-LAST:event_accesChartActionPerformed

    private void txtSearch5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch5KeyReleased
        loadInvoiceTable(invoiceTable, txtSearch5.getText().trim());
    }//GEN-LAST:event_txtSearch5KeyReleased

    private void btnAdminCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminCActionPerformed

        javax.swing.JPasswordField pf = new javax.swing.JPasswordField();
        pf.addAncestorListener(new javax.swing.event.AncestorListener() {
            @Override
            public void ancestorAdded(javax.swing.event.AncestorEvent event) {
                pf.requestFocusInWindow();
            }
            @Override
            public void ancestorRemoved(javax.swing.event.AncestorEvent event) {}
            @Override
            public void ancestorMoved(javax.swing.event.AncestorEvent event) {}
        });

        int option = JOptionPane.showConfirmDialog(
                this,
                new Object[]{"Enter Your Password to Access Admin Panel:", pf},
                "Admin Verification",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        String confirmPass = null;
        if (option == JOptionPane.OK_OPTION) {
            confirmPass = new String(pf.getPassword());
        }

        if (confirmPass != null && !confirmPass.trim().isEmpty()) {
            PreparedStatement pstCheck = null;
            ResultSet rsCheck = null;

            try {
                String sql = "SELECT password FROM user WHERE uName = ?";
                pstCheck = db.con.prepareStatement(sql);
                pstCheck.setString(1, user1.getUserName());
                rsCheck = pstCheck.executeQuery();

                if (rsCheck.next()) {
                    String dbPassword = rsCheck.getString("password");

                    if (dbPassword.equals(confirmPass.trim())) {

                        CardLayout cl = (CardLayout) CardPanel.getLayout();
                        cl.show(CardPanel, "card7");

                        lblTopic.setText("ADMIN PANEL");

                        btnAdminC.setBackground(setColor1);
                        btnDash.setBackground(setColor2);
                        btnAppo.setBackground(setColor2);
                        btnInven.setBackground(setColor2);
                        btnHistory.setBackground(setColor2);
                        btnTech.setBackground(setColor2);

                        loadUserTable();
                        loadTechnicianTable();
                        loadServicesTable();
                        loadBaysTable();
                        loadSparePartsAdminTable();
                        loadAccessoriesTable();

                        clearUserFields();
                        clearTechnicianFields();
                        clearServiceFields();
                        clearBayFields();

                    } else {
                        JOptionPane.showMessageDialog(this, "Incorrect Password! Access Denied.", "Security Alert", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Admin profile not found in database!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database Verification Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (rsCheck != null) {
                        rsCheck.close();
                    }
                    if (pstCheck != null) {
                        pstCheck.close();
                    }
                } catch (Exception e) {
                }
            }
        }

    }//GEN-LAST:event_btnAdminCActionPerformed

    private void btnUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserUpdateActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user from the table to update!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = jTable1.getValueAt(selectedRow, 0).toString();
        String name = txtName.getText().trim();
        String uname = txtUname.getText().trim();
        String email = txtEmail.getText().trim();
        String nic = txtNIC.getText().trim();
        String phone = txtPhone.getText().trim();
        String role = combRole.getSelectedItem().toString();

        try {
            String sql = "UPDATE user SET name=?, uName=?, email=?, nic=?, phone=?, role=? WHERE id=?";
            pst = db.con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, uname);
            pst.setString(3, email);
            pst.setString(4, nic);
            pst.setString(5, phone);
            pst.setString(6, role);
            pst.setString(7, id);

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "User Updated Successfully!");
                loadUserTable();
                clearUserFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Update Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUserUpdateActionPerformed

    private void btnUserAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAddActionPerformed
        String name = txtName.getText().trim();
        String uname = txtUname.getText().trim();
        String email = txtEmail.getText().trim();
        String nic = txtNIC.getText().trim();
        String phone = txtPhone.getText().trim();
        String role = combRole.getSelectedItem().toString();

        if (name.isEmpty() || uname.isEmpty() || email.isEmpty() || nic.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(emailRegex)) {
            JOptionPane.showMessageDialog(this, "Invalid Email Address format!\n(e.g., example@mail.com)", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            return;
        }

        String oldNICRegex = "^[0-9]{9}[vVxX]$";
        String newNICRegex = "^[0-9]{12}$";
        if (!nic.matches(oldNICRegex) && !nic.matches(newNICRegex)) {
            JOptionPane.showMessageDialog(this, "Invalid Sri Lankan NIC number!\nMust be 9 digits with V/X or exactly 12 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtNIC.requestFocus();
            return;
        }

        String phoneRegex = "^0[0-9]{9}$";
        if (!phone.matches(phoneRegex)) {
            JOptionPane.showMessageDialog(this, "Invalid Phone Number!\nMust start with 0 and contain exactly 10 digits.\n(e.g., 0771234567)", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtPhone.requestFocus();
            return;
        }

        try {
            String sql = "INSERT INTO user (name, uName, email, nic, phone, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst = db.con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, uname);
            pst.setString(3, email);
            pst.setString(4, nic);
            pst.setString(5, phone);
            pst.setString(6, nic);
            pst.setString(7, role);

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "User Registered Successfully!\nDefault Password is user's NIC: " + nic, "Success", JOptionPane.INFORMATION_MESSAGE);
                loadUserTable();
                clearUserFields();
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(this, "User Name or Email already exists!", "Database Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Save Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUserAddActionPerformed

    private void btnUserDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDelActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user from the table to delete!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = jTable1.getValueAt(selectedRow, 0).toString();
        String uname = jTable1.getValueAt(selectedRow, 2).toString();

        if (uname.equalsIgnoreCase(user1.getUserName())) {
            JOptionPane.showMessageDialog(this, "You cannot delete your own logged-in account!", "Access Denied", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM user WHERE id=?";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, id);

                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "User Deleted Successfully!");
                    loadUserTable();
                    clearUserFields();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Delete Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (pst != null) {
                        pst.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnUserDelActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            txtName.setText(jTable1.getValueAt(selectedRow, 1).toString());
            txtUname.setText(jTable1.getValueAt(selectedRow, 2).toString());
            txtEmail.setText(jTable1.getValueAt(selectedRow, 3).toString());
            txtNIC.setText(jTable1.getValueAt(selectedRow, 4).toString());
            txtPhone.setText(jTable1.getValueAt(selectedRow, 5).toString());

            String role = jTable1.getValueAt(selectedRow, 6).toString();
            combRole.setSelectedItem(role);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUserAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAdd1ActionPerformed
        String id = txtName2.getText().trim();
        String name = txtName1.getText().trim();
        String nic = txtNIC1.getText().trim();
        String phone = txtPhone1.getText().trim();
        String specialty = txtSpeality.getText().trim();
        String status = combRole1.getSelectedItem().toString();

        if (name.isEmpty() || nic.isEmpty() || phone.isEmpty() || specialty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String oldNICRegex = "^[0-9]{9}[vVxX]$";
        String newNICRegex = "^[0-9]{12}$";
        if (!nic.matches(oldNICRegex) && !nic.matches(newNICRegex)) {
            JOptionPane.showMessageDialog(this, "Invalid Sri Lankan NIC number!\nMust be 9 digits with V/X or exactly 12 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtNIC1.requestFocus();
            return;
        }

        String phoneRegex = "^0[0-9]{9}$";
        if (!phone.matches(phoneRegex)) {
            JOptionPane.showMessageDialog(this, "Invalid Phone Number!\nMust start with 0 and contain exactly 10 digits.\n(e.g., 0771234567)", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtPhone1.requestFocus();
            return;
        }

        // Check if technician ID already exists in DB
        try {
            String checkSql = "SELECT COUNT(*) FROM technician WHERE tech_id = ?";
            PreparedStatement checkPst = db.con.prepareStatement(checkSql);
            checkPst.setString(1, id);
            ResultSet checkRs = checkPst.executeQuery();
            if (checkRs.next() && checkRs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Technician ID " + id + " already exists!\nPlease click Clear to generate a new ID, or Update to modify the existing record.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                checkRs.close();
                checkPst.close();
                return;
            }
            checkRs.close();
            checkPst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database check failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO technician (tech_id, name, nic, phone, specialty, status) VALUES (?, ?, ?, ?, ?, ?)";
            pst = db.con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, nic);
            pst.setInt(4, Integer.parseInt(phone));
            pst.setString(5, specialty);
            pst.setString(6, status);

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Technician Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTechnicianTable();
                loadTechnicianCards(); // Refresh cards in the UI dashboard
                clearTechnicianFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Save Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUserAdd1ActionPerformed

    private void btnUserUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserUpdate1ActionPerformed
        int selectedRow = jTable4.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a technician from the table to update!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = txtName2.getText().trim();
        String name = txtName1.getText().trim();
        String nic = txtNIC1.getText().trim();
        String phone = txtPhone1.getText().trim();
        String specialty = txtSpeality.getText().trim();
        String status = combRole1.getSelectedItem().toString();

        if (name.isEmpty() || nic.isEmpty() || phone.isEmpty() || specialty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String oldNICRegex = "^[0-9]{9}[vVxX]$";
        String newNICRegex = "^[0-9]{12}$";
        if (!nic.matches(oldNICRegex) && !nic.matches(newNICRegex)) {
            JOptionPane.showMessageDialog(this, "Invalid Sri Lankan NIC number!\nMust be 9 digits with V/X or exactly 12 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtNIC1.requestFocus();
            return;
        }

        String phoneRegex = "^0[0-9]{9}$";
        if (!phone.matches(phoneRegex)) {
            JOptionPane.showMessageDialog(this, "Invalid Phone Number!\nMust start with 0 and contain exactly 10 digits.\n(e.g., 0771234567)", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtPhone1.requestFocus();
            return;
        }

        try {
            String sql = "UPDATE technician SET name=?, nic=?, phone=?, specialty=?, status=? WHERE tech_id=?";
            pst = db.con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, nic);
            pst.setInt(3, Integer.parseInt(phone));
            pst.setString(4, specialty);
            pst.setString(5, status);
            pst.setString(6, id);

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Technician Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTechnicianTable();
                loadTechnicianCards(); // Refresh cards in UI dashboard
                clearTechnicianFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Update Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUserUpdate1ActionPerformed

    private void btnUserDel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDel1ActionPerformed
        int selectedRow = jTable4.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a technician from the table to delete!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = jTable4.getValueAt(selectedRow, 0).toString();
        String name = jTable4.getValueAt(selectedRow, 1).toString();

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete technician: " + name + " (" + id + ")?\n"
                + "WARNING: This will cascade-delete all ongoing and completed jobs assigned to this technician!",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM technician WHERE tech_id=?";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, id);

                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Technician Deleted Successfully!", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                    loadTechnicianTable();
                    loadTechnicianCards(); // Refresh cards in UI dashboard
                    clearTechnicianFields();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Delete Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (pst != null) {
                        pst.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnUserDel1ActionPerformed

    private void btnUserAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAdd2ActionPerformed
        String id = txtName4.getText().trim();
        String name = txtName3.getText().trim();
        String priceStr = txtSpeality1.getText().trim();
        String status = combRole2.getSelectedItem().toString();

        if (name.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double priceVal;
        try {
            priceVal = Double.parseDouble(priceStr);
            if (priceVal <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be a positive number!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Price format! Must be a valid positive number.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int price = (int) Math.round(priceVal);

        // Check if service ID already exists in DB
        try {
            String checkSql = "SELECT COUNT(*) FROM services WHERE service_id = ?";
            PreparedStatement checkPst = db.con.prepareStatement(checkSql);
            checkPst.setString(1, id);
            ResultSet checkRs = checkPst.executeQuery();
            if (checkRs.next() && checkRs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Service ID " + id + " already exists!\nPlease click Clear to generate a new ID, or Update to modify the existing record.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                checkRs.close();
                checkPst.close();
                return;
            }
            checkRs.close();
            checkPst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database check failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO services (service_id, service_name, price, status) VALUES (?, ?, ?, ?)";
            pst = db.con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setInt(3, price);
            pst.setString(4, status);

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Service Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadServicesTable();
                clearServiceFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Save Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUserAdd2ActionPerformed

    private void btnUserUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserUpdate2ActionPerformed
        int selectedRow = jTable5.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a service from the table to update!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = txtName4.getText().trim();
        String name = txtName3.getText().trim();
        String priceStr = txtSpeality1.getText().trim();
        String status = combRole2.getSelectedItem().toString();

        if (name.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double priceVal;
        try {
            priceVal = Double.parseDouble(priceStr);
            if (priceVal <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be a positive number!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Price format! Must be a valid positive number.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int price = (int) Math.round(priceVal);

        try {
            String sql = "UPDATE services SET service_name=?, price=?, status=? WHERE service_id=?";
            pst = db.con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, price);
            pst.setString(3, status);
            pst.setString(4, id);

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Service Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadServicesTable();
                clearServiceFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Update Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUserUpdate2ActionPerformed

    private void btnUserDel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDel2ActionPerformed
        int selectedRow = jTable5.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a service from the table to delete!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = jTable5.getValueAt(selectedRow, 0).toString();
        String name = jTable5.getValueAt(selectedRow, 1).toString();

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete service: " + name + " (" + id + ")?\n"
                + "WARNING: This will cascade-delete all job services associated with this service!",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM services WHERE service_id=?";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, id);

                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Service Deleted Successfully!", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                    loadServicesTable();
                    clearServiceFields();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Delete Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (pst != null) {
                        pst.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnUserDel2ActionPerformed

    private void btnUserAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAdd3ActionPerformed
        String id = txtName6.getText().trim();
        String name = txtName5.getText().trim();
        String status = combRole3.getSelectedItem().toString();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill Bay Name!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check if bay ID already exists
        try {
            String checkSql = "SELECT COUNT(*) FROM bay_table WHERE bay_id = ?";
            PreparedStatement checkPst = db.con.prepareStatement(checkSql);
            checkPst.setString(1, id);
            ResultSet checkRs = checkPst.executeQuery();
            if (checkRs.next() && checkRs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Bay ID " + id + " already exists!\nPlease click Clear to generate a new ID, or Update to modify the existing record.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                checkRs.close();
                checkPst.close();
                return;
            }
            checkRs.close();
            checkPst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database check failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO bay_table (bay_id, bay_name, status) VALUES (?, ?, ?)";
            pst = db.con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, status);

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Bay Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadBaysTable();
                loadBayStatus(); // Refresh dashboard panels
                clearBayFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Save Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUserAdd3ActionPerformed

    private void btnUserUpdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserUpdate3ActionPerformed
        int selectedRow = jTable6.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a bay from the table to update!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = txtName6.getText().trim();
        String name = txtName5.getText().trim();
        String status = combRole3.getSelectedItem().toString();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill Bay Name!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE bay_table SET bay_name=?, status=? WHERE bay_id=?";
            pst = db.con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, status);
            pst.setString(3, id);

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Bay Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadBaysTable();
                loadBayStatus(); // Refresh dashboard panels
                clearBayFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Update Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUserUpdate3ActionPerformed

    private void btnUserDel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDel3ActionPerformed
        int selectedRow = jTable6.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a bay from the table to delete!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = jTable6.getValueAt(selectedRow, 0).toString();
        String name = jTable6.getValueAt(selectedRow, 1).toString();

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete bay: " + name + " (" + id + ")?\n"
                + "WARNING: This will cascade-delete all ongoing and completed jobs assigned to this service bay!",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM bay_table WHERE bay_id=?";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, id);

                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Bay Deleted Successfully!", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                    loadBaysTable();
                    loadBayStatus(); // Refresh dashboard panels
                    clearBayFields();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Delete Failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (pst != null) {
                        pst.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnUserDel3ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        int selectedRow = jTable4.getSelectedRow();
        if (selectedRow != -1) {
            txtName2.setText(jTable4.getValueAt(selectedRow, 0).toString());
            txtName1.setText(jTable4.getValueAt(selectedRow, 1).toString());
            txtNIC1.setText(jTable4.getValueAt(selectedRow, 2).toString());
            txtPhone1.setText(jTable4.getValueAt(selectedRow, 3).toString());
            txtSpeality.setText(jTable4.getValueAt(selectedRow, 4).toString());
            combRole1.setSelectedItem(jTable4.getValueAt(selectedRow, 5).toString());
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        int selectedRow = jTable5.getSelectedRow();
        if (selectedRow != -1) {
            txtName4.setText(jTable5.getValueAt(selectedRow, 0).toString());
            txtName3.setText(jTable5.getValueAt(selectedRow, 1).toString());
            txtSpeality1.setText(jTable5.getValueAt(selectedRow, 2).toString());
            combRole2.setSelectedItem(jTable5.getValueAt(selectedRow, 3).toString());
        }
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        int selectedRow = jTable6.getSelectedRow();
        if (selectedRow != -1) {
            txtName6.setText(jTable6.getValueAt(selectedRow, 0).toString());
            txtName5.setText(jTable6.getValueAt(selectedRow, 1).toString());
            combRole3.setSelectedItem(jTable6.getValueAt(selectedRow, 2).toString());
        }
    }//GEN-LAST:event_jTable6MouseClicked

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
    private javax.swing.JPanel Accessories;
    private javax.swing.JPanel CardPanel;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Spair;
    private javax.swing.JButton UClear;
    private javax.swing.JButton UClear1;
    private javax.swing.JButton UClear2;
    private javax.swing.JButton UClear3;
    private com.toedter.calendar.JYearChooser YearChooser;
    private javax.swing.JPanel acce;
    private javax.swing.JButton accesChart;
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
    private javax.swing.JButton btnAdminC;
    private javax.swing.JButton btnAppo;
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnBill4;
    private javax.swing.JButton btnBill5;
    private javax.swing.JButton btnBillSpair;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnDash;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnInven;
    private javax.swing.JButton btnPrintPDF;
    private javax.swing.JButton btnReg;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSearch3;
    private javax.swing.JButton btnServiceBill;
    private javax.swing.JButton btnTech;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUserAdd;
    private javax.swing.JButton btnUserAdd1;
    private javax.swing.JButton btnUserAdd2;
    private javax.swing.JButton btnUserAdd3;
    private javax.swing.JButton btnUserDel;
    private javax.swing.JButton btnUserDel1;
    private javax.swing.JButton btnUserDel2;
    private javax.swing.JButton btnUserDel3;
    private javax.swing.JButton btnUserUpdate;
    private javax.swing.JButton btnUserUpdate1;
    private javax.swing.JButton btnUserUpdate2;
    private javax.swing.JButton btnUserUpdate3;
    private javax.swing.JPanel buttons;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private javax.swing.JPanel cards;
    private javax.swing.JComboBox<String> cmbBrand;
    private javax.swing.JComboBox<String> cmbBrand1;
    private javax.swing.JComboBox<String> cmbDetails;
    private javax.swing.JComboBox<String> cmbDetails1;
    private javax.swing.JComboBox<String> cmbFuel;
    private javax.swing.JComboBox<String> cmbMake;
    private javax.swing.JComboBox<String> cmbName;
    private javax.swing.JComboBox<String> cmbName1;
    private javax.swing.JComboBox<String> combRole;
    private javax.swing.JComboBox<String> combRole1;
    private javax.swing.JComboBox<String> combRole2;
    private javax.swing.JComboBox<String> combRole3;
    private javax.swing.JComboBox<String> conbTableSelect;
    private javax.swing.JPanel head;
    private javax.swing.JPanel image;
    private javax.swing.JButton invenAdd1;
    private javax.swing.JButton invenAddAcc;
    private javax.swing.JPanel inventMain;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAppoNo;
    private javax.swing.JLabel lblAppoNo1;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblDateTime1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblTech;
    private javax.swing.JLabel lblTopic;
    private javax.swing.JLabel lblTotSer;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JPanel left;
    private javax.swing.JPanel logOut;
    private javax.swing.JPanel logo;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pnlAdmin;
    private javax.swing.JPanel pnlAppo;
    private javax.swing.JPanel pnlDash;
    private javax.swing.JPanel pnlHistory;
    private javax.swing.JPanel pnlInventory;
    private javax.swing.JPanel pnlTech;
    private javax.swing.JPanel regDetails;
    private javax.swing.JPanel right;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel spair;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table3;
    private javax.swing.JTable tableAcc;
    private javax.swing.JTable tableSpair;
    private javax.swing.JPanel techMain;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFinalPrice;
    private javax.swing.JTextField txtFinalPrice1;
    private javax.swing.JTextField txtLisen;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtNIC1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtName3;
    private javax.swing.JTextField txtName4;
    private javax.swing.JTextField txtName5;
    private javax.swing.JTextField txtName6;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhone1;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPrice1;
    private javax.swing.JTextField txtQtuInvent;
    private javax.swing.JTextField txtQtuInvent1;
    private javax.swing.JTextField txtReading;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch3;
    private javax.swing.JTextField txtSearch5;
    private javax.swing.JTextArea txtSpeality;
    private javax.swing.JTextArea txtSpeality1;
    private javax.swing.JTextField txtTown;
    private javax.swing.JTextField txtUname;
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
        table.getTableHeader().setBackground(new Color(4, 102, 200));
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

    private void customizeSearchBar(JTextField txtSerch) {
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
        appoDate.setDate(null);
        appoTime.setText("");
        txtLisen.setText(txtSearch.getText());
        appo.setText("");
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

    public void loadBayStatus() {
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
        try {
            pst = db.con.prepareStatement("SELECT catagory, brand, details, qty, unit_price FROM inventory");
            rs = pst.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                dtm.addRow(new Object[]{
                    rs.getString("catagory"),
                    rs.getString("brand"),
                    rs.getString("details"),
                    rs.getString("qty"),
                    rs.getString("unit_price")
                });
            }
            rs.close();
            pst.close();

            // Register LowStockRenderer on table1 (index 3 is Qty)
            LowStockRenderer renderer = new LowStockRenderer(3);
            table1.setDefaultRenderer(Object.class, renderer);
            table1.setDefaultRenderer(String.class, renderer);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void loadAccessoriesInventory() {
        try {
            pst = db.con.prepareStatement("SELECT DISTINCT catagory FROM inventory");
            rs = pst.executeQuery();
            cmbName.removeAllItems();
            cmbName.addItem("- Select Item -");

            while (rs.next()) {
                cmbName.addItem(rs.getString("catagory"));
            }
            rs.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading accessories inventory: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registerGlobalShortcuts() {
        java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(java.awt.event.KeyEvent e) {
                if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
                    switch (e.getKeyCode()) {
                        case java.awt.event.KeyEvent.VK_F1:
                            btnDash.doClick();
                            return true;
                        case java.awt.event.KeyEvent.VK_F2:
                            btnAppo.doClick();
                            return true;
                        case java.awt.event.KeyEvent.VK_F3:
                            btnInven.doClick();
                            return true;
                        case java.awt.event.KeyEvent.VK_F4:
                            btnReg.doClick();
                            return true;
                        case java.awt.event.KeyEvent.VK_F5:
                            btnTech.doClick();
                            return true;
                        case java.awt.event.KeyEvent.VK_F6:
                            btnHistory.doClick();
                            return true;
                    }
                }
                return false;
            }
        });
    }

    private void loadBrand() {

    }

    private void setupAutocomplete() {
        popupMenu = new JPopupMenu();
        popupMenu.setBorder(BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 1));

        listModel = new DefaultListModel<>();
        suggestionList = new JList<>(listModel);

        suggestionList.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                list.setFixedCellHeight(35);

                label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

                if (value != null) {
                    String[] parts = value.toString().split(" - ");
                    if (parts.length == 2) {
                        label.setText("<html><b style='font-size:11px; color:#333333;'>" + parts[0] + "</b> <span style='font-size:10px; color:#888888;'>&nbsp;&nbsp;📞 " + parts[1] + "</span></html>");
                    }
                }
                if (isSelected) {
                    label.setBackground(new java.awt.Color(235, 245, 255));
                    label.setForeground(new java.awt.Color(0, 102, 204));
                } else {
                    label.setBackground(java.awt.Color.WHITE);
                }

                return label;
            }
        });

        JScrollPane scrollPane = new javax.swing.JScrollPane(suggestionList);
        scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        scrollPane.setPreferredSize(new java.awt.Dimension(371, 100));
        popupMenu.add(scrollPane);

        suggestionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    String selectedValue = suggestionList.getSelectedValue();
                    if (selectedValue != null) {
                        try {
                            String[] parts = selectedValue.split(" - ");
                            String nameOnly = parts[0];
                            String phoneOnly = parts[1];

                            txtCustName.setText(nameOnly);
                            popupMenu.setVisible(false);

                            int dbPhone = Integer.parseInt(phoneOnly);
                            String sql = "SELECT cus_id, nic, phone, city, town FROM customer WHERE name = ? AND phone = ?";
                            PreparedStatement pstLocal = db.con.prepareStatement(sql);
                            pstLocal.setString(1, nameOnly);
                            pstLocal.setInt(2, dbPhone);

                            ResultSet rsLocal = pstLocal.executeQuery();
                            String customerId = "";
                            if (rsLocal.next()) {
                                customerId = rsLocal.getString("cus_id");
                                txtNic.setText(rsLocal.getString("nic"));
                                txtNumber.setText("0" + rsLocal.getInt("phone"));
                                txtCity.setText(rsLocal.getString("city"));
                                txtTown.setText(rsLocal.getString("town"));
                            }
                            rsLocal.close();
                            pstLocal.close();

                            if (!customerId.isEmpty()) {
                                String sqlVehList = "SELECT vehical_no FROM vehical_table WHERE cus_id = ?";
                                PreparedStatement pstVehList = db.con.prepareStatement(sqlVehList);
                                pstVehList.setString(1, customerId);
                                ResultSet rsVehList = pstVehList.executeQuery();

                                ArrayList<String> vList = new ArrayList<>();
                                vList.add("Add New Vehical");
                                while (rsVehList.next()) {
                                    vList.add(rsVehList.getString("vehical_no"));
                                }
                                rsVehList.close();
                                pstVehList.close();

                                String selectedVehNo = "";

                                if (vList.size() > 0) {
                                    String[] vehArray = vList.toArray(new String[0]);
                                    selectedVehNo = (String) JOptionPane.showInputDialog(
                                            null,
                                            "Select Number Plate in the Vehicle:",
                                            "Select Number Plate",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            vehArray,
                                            vehArray[0]
                                    );
                                }
                                if (selectedVehNo != null && !selectedVehNo.isEmpty()) {

                                    if (selectedVehNo.equals("Add New Vehicle")) {
                                        txtLisen.setText("");
                                        cmbMake.setSelectedIndex(0);
                                        txtBrand.setText("");
                                        txtModel.setText("");
                                        cmbFuel.setSelectedIndex(0);
                                        txtReading.setText("");
                                        txtColor.setText("");
                                        YearChooser.setYear(2026);
                                        txtLisen.requestFocus();

                                    } else {
                                        String sqlGetVeh = "SELECT * FROM vehical_table WHERE vehical_no = ?";
                                        PreparedStatement pstGetVeh = db.con.prepareStatement(sqlGetVeh);
                                        pstGetVeh.setString(1, selectedVehNo);
                                        ResultSet rsGetVeh = pstGetVeh.executeQuery();

                                        if (rsGetVeh.next()) {
                                            txtLisen.setText(rsGetVeh.getString("vehical_no"));
                                            cmbMake.setSelectedItem(rsGetVeh.getString("make"));
                                            txtBrand.setText(rsGetVeh.getString("brand"));
                                            txtModel.setText(rsGetVeh.getString("model"));
                                            cmbFuel.setSelectedItem(rsGetVeh.getString("fuel"));
                                            txtReading.setText(rsGetVeh.getString("reading"));
                                            txtColor.setText(rsGetVeh.getString("color"));

                                            try {
                                                String yearStr = rsGetVeh.getString("make_year");
                                                if (yearStr != null && !yearStr.trim().isEmpty()) {
                                                    YearChooser.setYear(Integer.parseInt(yearStr.trim()));
                                                }
                                            } catch (Exception e) {
                                                YearChooser.setYear(2026);
                                            }
                                        }
                                        rsGetVeh.close();
                                        pstGetVeh.close();
                                    }
                                }
                            }
                        } catch (SQLException ex) {
                            System.getLogger(Dash.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        }

                    }
                }
            }
        });
    }

    private void loadLogo() {
        java.net.URL imgURL = getClass().getResource("/Images/pLogo.png");
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage();

            Image scaledImg = img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
            lblLogo.setIcon(new ImageIcon(scaledImg));
        }
    }

    private void loadInvoiceTable(JTable invoiceTable, String searchQuery) {
        int c;
        try {
            String sql;
            // Check if the search query is empty
            if (searchQuery == null || searchQuery.trim().isEmpty()) {
                sql = "SELECT inv_id, job_id, discount, total_amount, pay_amount, payment_method, balance, cust_name, bill_type, recoded_user "
                        + "FROM invoice ORDER BY recorded_at DESC";
                pst = db.con.prepareStatement(sql);
            } else {
                sql = "SELECT inv_id, job_id, discount, total_amount, pay_amount, payment_method, balance, cust_name, bill_type, recoded_user "
                        + "FROM invoice WHERE inv_id LIKE ? OR cust_name LIKE ? ORDER BY recorded_at DESC";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, "%" + searchQuery + "%");
                pst.setString(2, "%" + searchQuery + "%");
            }

            rs = pst.executeQuery();

            ResultSetMetaData rd = rs.getMetaData();
            c = rd.getColumnCount();

            DefaultTableModel dtm = (DefaultTableModel) invoiceTable.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v3 = new Vector();
                v3.add(rs.getString("inv_id"));
                v3.add(rs.getString("job_id"));
                v3.add(rs.getString("discount"));
                v3.add(rs.getString("total_amount"));
                v3.add(rs.getString("pay_amount"));
                v3.add(rs.getString("payment_method"));
                v3.add(rs.getString("balance"));
                v3.add(rs.getString("cust_name"));
                v3.add(rs.getString("bill_type"));
                v3.add(rs.getString("recoded_user"));

                dtm.addRow(v3);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading invoice data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void loadUserTable() {
        try {
            String sql = "SELECT id, name, uName, email, nic, phone, role FROM user";
            pst = db.con.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("uName"));
                v.add(rs.getString("email"));
                v.add(rs.getString("nic"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("role"));

                dtm.addRow(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading users: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void clearUserFields() {
        txtName.setText("");
        txtUname.setText("");
        txtEmail.setText("");
        txtNIC.setText("");
        txtPhone.setText("");
        combRole.setSelectedIndex(0);
        jTable1.clearSelection();
    }

    private void UClearActionPerformed(java.awt.event.ActionEvent evt) {
        clearUserFields();
    }

    private void UClear1ActionPerformed(java.awt.event.ActionEvent evt) {
        clearTechnicianFields();
    }

    private void UClear2ActionPerformed(java.awt.event.ActionEvent evt) {
        clearServiceFields();
    }

    private void UClear3ActionPerformed(java.awt.event.ActionEvent evt) {
        clearBayFields();
    }

    private void loadTechnicianTable() {
        try {
            String sql = "SELECT tech_id, name, nic, phone, specialty, status FROM technician";
            pst = db.con.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel dtm = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"ID", "Name", "NIC", "Phone", "Specialty", "Status"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable4.setModel(dtm);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("tech_id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("nic"));

                // Pad phone with leading zero if it has 9 digits
                String phoneStr = rs.getString("phone");
                if (phoneStr != null && phoneStr.length() == 9) {
                    phoneStr = "0" + phoneStr;
                }
                v.add(phoneStr);

                v.add(rs.getString("specialty"));
                v.add(rs.getString("status"));

                dtm.addRow(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading technicians: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String generateTechnicianID() {
        String techId = "";
        boolean exists = true;
        java.util.Random rand = new java.util.Random();
        while (exists) {
            techId = "TECH-" + String.format("%04d", rand.nextInt(10000));
            try {
                String sql = "SELECT COUNT(*) FROM technician WHERE tech_id=?";
                PreparedStatement pstCheck = db.con.prepareStatement(sql);
                pstCheck.setString(1, techId);
                ResultSet rsCheck = pstCheck.executeQuery();
                if (rsCheck.next() && rsCheck.getInt(1) == 0) {
                    exists = false;
                }
                rsCheck.close();
                pstCheck.close();
            } catch (SQLException e) {
                exists = false; // fallback if connection fails
            }
        }
        return techId;
    }

    private void clearTechnicianFields() {
        txtName2.setText(generateTechnicianID());
        txtName1.setText("");
        txtNIC1.setText("");
        txtPhone1.setText("");
        txtSpeality.setText("");
        combRole1.setSelectedIndex(0);
        jTable4.clearSelection();
    }

    private void loadServicesTable() {
        try {
            String sql = "SELECT service_id, service_name, price, status FROM services";
            pst = db.con.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel dtm = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"Service ID", "Service Name", "Price", "Status"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable5.setModel(dtm);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("service_id"));
                v.add(rs.getString("service_name"));
                v.add(rs.getString("price"));
                v.add(rs.getString("status"));

                dtm.addRow(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading services: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String generateServiceID() {
        String serId = "";
        boolean exists = true;
        java.util.Random rand = new java.util.Random();
        while (exists) {
            serId = "SER-" + String.format("%04d", rand.nextInt(10000));
            try {
                String sql = "SELECT COUNT(*) FROM services WHERE service_id=?";
                PreparedStatement pstCheck = db.con.prepareStatement(sql);
                pstCheck.setString(1, serId);
                ResultSet rsCheck = pstCheck.executeQuery();
                if (rsCheck.next() && rsCheck.getInt(1) == 0) {
                    exists = false;
                }
                rsCheck.close();
                pstCheck.close();
            } catch (SQLException e) {
                exists = false; // fallback if connection fails
            }
        }
        return serId;
    }

    private void clearServiceFields() {
        txtName4.setText(generateServiceID());
        txtName3.setText("");
        txtSpeality1.setText("");
        combRole2.setSelectedIndex(0);
        jTable5.clearSelection();
    }

    private void loadBaysTable() {
        try {
            String sql = "SELECT bay_id, bay_name, status FROM bay_table";
            pst = db.con.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel dtm = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"Bay ID", "Bay Name", "Status"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable6.setModel(dtm);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("bay_id"));
                v.add(rs.getString("bay_name"));
                v.add(rs.getString("status"));

                dtm.addRow(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading bays: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String generateBayID() {
        String nextBayId = "BAY-01";
        try {
            String sql = "SELECT bay_id FROM bay_table ORDER BY bay_id DESC LIMIT 1";
            PreparedStatement pstCheck = db.con.prepareStatement(sql);
            ResultSet rsCheck = pstCheck.executeQuery();
            if (rsCheck.next()) {
                String lastId = rsCheck.getString("bay_id");
                if (lastId.startsWith("BAY-")) {
                    try {
                        int num = Integer.parseInt(lastId.substring(4));
                        nextBayId = "BAY-" + String.format("%02d", num + 1);
                    } catch (NumberFormatException e) {
                        nextBayId = "BAY-" + String.format("%02d", new java.util.Random().nextInt(99) + 1);
                    }
                }
            }
            rsCheck.close();
            pstCheck.close();
        } catch (SQLException e) {
            // fallback
        }
        return nextBayId;
    }

    private void clearBayFields() {
        txtName6.setText(generateBayID());
        txtName5.setText("");
        combRole3.setSelectedIndex(0);
        jTable6.clearSelection();
    }

    private void styleAdminTables(JTable table) {
        if (table != null) {
            // 1. Table Header එක Royal Blue (#0466c8)
            table.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
            table.getTableHeader().setBackground(Color.decode("#000000")); // 🌟 Header Background
            table.getTableHeader().setForeground(Color.WHITE);
            table.getTableHeader().setPreferredSize(new Dimension(0, 35)); // Header
            table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());

            // 2. Table Rows & Selection Styling
            table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            table.setRowHeight(38);
            table.setSelectionBackground(new Color(230, 242, 255)); 
            table.setSelectionForeground(Color.decode("#0466c8"));

            // Grid Lines
            table.setShowGrid(false);
            table.setIntercellSpacing(new Dimension(0, 0));

            // 3.(Center Alignment for Rows)
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            table.setDefaultRenderer(Object.class, centerRenderer);
            table.setDefaultRenderer(String.class, centerRenderer);
            table.setDefaultRenderer(Integer.class, centerRenderer);
            table.setDefaultRenderer(Double.class, centerRenderer);

            // 4. Scroll Pane 
            if (table.getParent() != null && table.getParent().getParent() instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) table.getParent().getParent();
                scrollPane.setBorder(BorderFactory.createEmptyBorder());
                scrollPane.getViewport().setBackground(Color.WHITE);
            }
        }
    }

    public void loadServiceReportTable() {
        java.util.Date fromDate = jDateChooser1.getDate();
        java.util.Date toDate = jDateChooser2.getDate();

        try {
            String sql;
            if (fromDate == null || toDate == null) {
                sql = "SELECT inv_id, job_id, cust_name, total_amount, pay_amount, balance, DATE(recorded_at) as date_only FROM invoice ORDER BY recorded_at ASC";
                pst = db.con.prepareStatement(sql);
            } else {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String fromStr = sdf.format(fromDate);
                String toStr = sdf.format(toDate);
                sql = "SELECT inv_id, job_id, cust_name, total_amount, pay_amount, balance, DATE(recorded_at) as date_only FROM invoice WHERE DATE(recorded_at) BETWEEN ? AND ? ORDER BY recorded_at ASC";
                pst = db.con.prepareStatement(sql);
                pst.setString(1, fromStr);
                pst.setString(2, toStr);
            }
            rs = pst.executeQuery();

            DefaultTableModel dtm = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Invoice ID", "Job ID", "Customer Name", "Total Amount", "Paid", "Balance", "Date" }
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable7.setModel(dtm);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("inv_id"));
                v.add(rs.getString("job_id"));
                v.add(rs.getString("cust_name"));
                v.add(rs.getString("total_amount"));
                v.add(rs.getString("pay_amount"));
                v.add(rs.getString("balance"));
                v.add(rs.getString("date_only"));

                dtm.addRow(v);
            }

            styleAdminTables(jTable7);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading service reports: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void btnPrintPDFActionPerformed(java.awt.event.ActionEvent evt) {
        int rowCount = jTable7.getRowCount();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(this, "The Service Report table is empty! Please select dates with data first.", "Print Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        java.util.Date fromDate = jDateChooser1.getDate();
        java.util.Date toDate = jDateChooser2.getDate();

        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        String filename;
        String subtitleText;

        if (fromDate == null || toDate == null) {
            filename = desktopPath + "Service_Report_All.pdf";
            subtitleText = "All Service Revenue Report";
        } else {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String fromStr = sdf.format(fromDate);
            String toStr = sdf.format(toDate);
            filename = desktopPath + "Service_Report_" + fromStr + "_to_" + toStr + ".pdf";
            subtitleText = "Service Revenue Report (" + fromStr + " to " + toStr + ")";
        }

        com.itextpdf.text.Document document = new com.itextpdf.text.Document(com.itextpdf.text.PageSize.A4, 36, 36, 54, 54);

        try {
            com.itextpdf.text.pdf.PdfWriter.getInstance(document, new java.io.FileOutputStream(filename));
            document.open();

            // Set up Fonts
            com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 20, com.itextpdf.text.Font.BOLD, new com.itextpdf.text.BaseColor(4, 102, 200));
            com.itextpdf.text.Font subtitleFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.NORMAL, new com.itextpdf.text.BaseColor(100, 100, 100));
            com.itextpdf.text.Font headerCellFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 10, com.itextpdf.text.Font.BOLD, com.itextpdf.text.BaseColor.WHITE);
            com.itextpdf.text.Font bodyCellFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 9, com.itextpdf.text.Font.NORMAL);
            com.itextpdf.text.Font totalFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.BOLD, new com.itextpdf.text.BaseColor(4, 102, 200));

            // Title
            com.itextpdf.text.Paragraph title = new com.itextpdf.text.Paragraph("SALFORD CAR SERVICE & REPAIR", titleFont);
            title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(title);

            // Subtitle
            com.itextpdf.text.Paragraph subtitle = new com.itextpdf.text.Paragraph(subtitleText, subtitleFont);
            subtitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            subtitle.setSpacingAfter(20);
            document.add(subtitle);

            // Create PdfPTable with 7 columns
            com.itextpdf.text.pdf.PdfPTable pdfTable = new com.itextpdf.text.pdf.PdfPTable(7);
            pdfTable.setWidthPercentage(100);
            pdfTable.setSpacingBefore(10);
            pdfTable.setSpacingAfter(10);
            float[] columnWidths = {1.2f, 1.2f, 2.0f, 1.3f, 1.2f, 1.2f, 1.5f};
            pdfTable.setWidths(columnWidths);

            // Headers
            String[] headers = {"Invoice ID", "Job ID", "Customer Name", "Total Amount", "Paid", "Balance", "Date"};
            com.itextpdf.text.BaseColor headerBgColor = new com.itextpdf.text.BaseColor(4, 102, 200); // #0466c8

            for (String headerText : headers) {
                com.itextpdf.text.pdf.PdfPCell cell = new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Phrase(headerText, headerCellFont));
                cell.setBackgroundColor(headerBgColor);
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
                cell.setPadding(8);
                pdfTable.addCell(cell);
            }

            // Populate PDF Table Rows & Calculate Grand Total
            double grandTotalRevenue = 0;
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 7; j++) {
                    Object valObj = jTable7.getValueAt(i, j);
                    String val = (valObj != null) ? valObj.toString() : "";
                    
                    com.itextpdf.text.pdf.PdfPCell cell = new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Phrase(val, bodyCellFont));
                    cell.setPadding(6);
                    cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
                    pdfTable.addCell(cell);
                }

                // Sum total_amount (column index 3)
                try {
                    Object totalObj = jTable7.getValueAt(i, 3);
                    if (totalObj != null) {
                        grandTotalRevenue += Double.parseDouble(totalObj.toString());
                    }
                } catch (NumberFormatException e) {
                    // Skip or log
                }
            }

            document.add(pdfTable);

            // Add spacing
            com.itextpdf.text.Paragraph spacing = new com.itextpdf.text.Paragraph(" ");
            spacing.setSpacingAfter(10);
            document.add(spacing);

            // Grand Total Revenue paragraph
            com.itextpdf.text.Paragraph totalRev = new com.itextpdf.text.Paragraph("Grand Total Revenue: LKR " + String.format("%,.2f", grandTotalRevenue), totalFont);
            totalRev.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
            document.add(totalRev);

            JOptionPane.showMessageDialog(this, "Service Report PDF Printed Successfully!\nSaved to: " + filename, "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error generating PDF: " + e.getMessage(), "PDF Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (document != null && document.isOpen()) {
                document.close();
            }
        }
    }

    // Helper Methods and Classes for Inventory & Spare Parts

    /**
     * Custom renderer to highlight low-stock items (quantity <= 5) in bold bright RED.
     */
    public static class LowStockRenderer extends DefaultTableCellRenderer {
        private final int qtyColIndex;

        public LowStockRenderer(int qtyColIndex) {
            this.qtyColIndex = qtyColIndex;
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            
            java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            try {
                Object qtyObj = table.getValueAt(row, qtyColIndex);
                if (qtyObj != null) {
                    int qty = Integer.parseInt(qtyObj.toString());
                    if (qty <= 5) {
                        c.setForeground(Color.RED);
                        c.setFont(new Font(table.getFont().getName(), Font.BOLD, table.getFont().getSize()));
                    } else {
                        c.setFont(new Font(table.getFont().getName(), Font.PLAIN, table.getFont().getSize()));
                        if (isSelected) {
                            c.setForeground(table.getSelectionForeground());
                        } else {
                            c.setForeground(table.getForeground());
                        }
                    }
                }
            } catch (Exception e) {
                // Ignore rendering exceptions
            }
            return c;
        }
    }

    /**
     * Populates BOTH the admin spare parts grid (jTable3) and checkout spare parts grid (table3).
     */
    public void loadSparePartsAdminTable() {
        try {
            pst = db.con.prepareStatement("SELECT part_id, part_name, brand, details, qty, unit_price FROM spare_parts");
            rs = pst.executeQuery();

            // Populate Admin Grid (jTable3)
            DefaultTableModel adminModel = new DefaultTableModel(
                new Object[][] {},
                new String[] {"Part ID", "Name", "Brand", "Details", "Qty", "Unit Price"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable3.setModel(adminModel);

            // Populate Checkout Grid (table3)
            DefaultTableModel checkoutModel = new DefaultTableModel(
                new Object[][] {},
                new String[] {"Item Name", "Brand", "Details", "Qty", "Unit Price"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table3.setModel(checkoutModel);

            while (rs.next()) {
                String partId = rs.getString("part_id");
                String partName = rs.getString("part_name");
                String brand = rs.getString("brand");
                String details = rs.getString("details");
                int qty = rs.getInt("qty");
                double unitPrice = rs.getDouble("unit_price");

                adminModel.addRow(new Object[]{partId, partName, brand, details, qty, unitPrice});
                checkoutModel.addRow(new Object[]{partName, brand, details, qty, unitPrice});
            }

            rs.close();
            pst.close();

            styleAdminTables(jTable3);
            
            // Set LowStockRenderer after styling to avoid overwrite
            LowStockRenderer adminRenderer = new LowStockRenderer(4);
            jTable3.setDefaultRenderer(Object.class, adminRenderer);
            jTable3.setDefaultRenderer(String.class, adminRenderer);

            LowStockRenderer checkoutRenderer = new LowStockRenderer(3);
            table3.setDefaultRenderer(Object.class, checkoutRenderer);
            table3.setDefaultRenderer(String.class, checkoutRenderer);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * Loads distinct spare part names to populate the initial combo box in Checkout.
     */
    public void loadSparePartsItemNames() {
        try {
            pst = db.con.prepareStatement("SELECT DISTINCT part_name FROM spare_parts");
            rs = pst.executeQuery();

            cmbName1.removeAllItems();
            cmbName1.addItem("- Select Name -");
            while (rs.next()) {
                cmbName1.addItem(rs.getString("part_name"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void addGB(JPanel p, java.awt.Component c, int x, int y, int width, int height, double weightx, double weighty) {
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);
        p.add(c, gbc);
    }

    private void initInventoryManageCRUD() {
        // --- 1. SPARE PARTS CRUD FORM PANEL ---
        JPanel spFormPanel = new JPanel(new java.awt.GridBagLayout());
        spFormPanel.setBackground(Color.WHITE);
        spFormPanel.setBorder(BorderFactory.createTitledBorder("Manage Spare Part"));

        addGB(spFormPanel, new JLabel("Part ID:"), 0, 0, 1, 1, 0.0, 0.0);
        txtSpId = new JTextField();
        txtSpId.setEditable(false);
        txtSpId.setBackground(new Color(240, 240, 240));
        addGB(spFormPanel, txtSpId, 1, 0, 1, 1, 1.0, 0.0);

        addGB(spFormPanel, new JLabel("Name:"), 2, 0, 1, 1, 0.0, 0.0);
        txtSpName = new JTextField();
        addGB(spFormPanel, txtSpName, 3, 0, 1, 1, 1.0, 0.0);

        addGB(spFormPanel, new JLabel("Brand:"), 4, 0, 1, 1, 0.0, 0.0);
        txtSpBrand = new JTextField();
        addGB(spFormPanel, txtSpBrand, 5, 0, 1, 1, 1.0, 0.0);

        addGB(spFormPanel, new JLabel("Details:"), 0, 1, 1, 1, 0.0, 0.0);
        txtSpDetails = new JTextField();
        addGB(spFormPanel, txtSpDetails, 1, 1, 1, 1, 1.0, 0.0);

        addGB(spFormPanel, new JLabel("Qty:"), 2, 1, 1, 1, 0.0, 0.0);
        txtSpQty = new JTextField();
        addGB(spFormPanel, txtSpQty, 3, 1, 1, 1, 1.0, 0.0);

        addGB(spFormPanel, new JLabel("Price:"), 4, 1, 1, 1, 0.0, 0.0);
        txtSpPrice = new JTextField();
        addGB(spFormPanel, txtSpPrice, 5, 1, 1, 1, 1.0, 0.0);

        JPanel spBtnPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));
        spBtnPanel.setBackground(Color.WHITE);
        btnSpAdd = new JButton("Add");
        btnSpUpdate = new JButton("Update");
        btnSpDelete = new JButton("Delete");
        btnSpClear = new JButton("Clear");
        spBtnPanel.add(btnSpAdd);
        spBtnPanel.add(btnSpUpdate);
        spBtnPanel.add(btnSpDelete);
        spBtnPanel.add(btnSpClear);
        
        customiseButtons(btnSpAdd, btnSpUpdate, btnSpDelete);
        btnSpClear.setBackground(new Color(108, 117, 125));
        btnSpClear.setForeground(Color.WHITE);
        btnSpClear.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addGB(spFormPanel, spBtnPanel, 0, 2, 6, 1, 1.0, 0.0);

        // Re-layout jPanel16
        jPanel16.removeAll();
        jPanel16.setLayout(new java.awt.BorderLayout(10, 10));
        jPanel16.setBackground(Color.WHITE);
        jPanel16.add(jLabel76, java.awt.BorderLayout.NORTH);
        jPanel16.add(jScrollPane10, java.awt.BorderLayout.CENTER);
        jPanel16.add(spFormPanel, java.awt.BorderLayout.SOUTH);

        // --- 2. ACCESSORIES CRUD FORM PANEL ---
        JPanel accFormPanel = new JPanel(new java.awt.GridBagLayout());
        accFormPanel.setBackground(Color.WHITE);
        accFormPanel.setBorder(BorderFactory.createTitledBorder("Manage Accessory"));

        addGB(accFormPanel, new JLabel("Item ID:"), 0, 0, 1, 1, 0.0, 0.0);
        txtAccId = new JTextField();
        txtAccId.setEditable(false);
        txtAccId.setBackground(new Color(240, 240, 240));
        addGB(accFormPanel, txtAccId, 1, 0, 1, 1, 1.0, 0.0);

        addGB(accFormPanel, new JLabel("Category:"), 2, 0, 1, 1, 0.0, 0.0);
        txtAccCategory = new JTextField();
        addGB(accFormPanel, txtAccCategory, 3, 0, 1, 1, 1.0, 0.0);

        addGB(accFormPanel, new JLabel("Brand:"), 4, 0, 1, 1, 0.0, 0.0);
        txtAccBrand = new JTextField();
        addGB(accFormPanel, txtAccBrand, 5, 0, 1, 1, 1.0, 0.0);

        addGB(accFormPanel, new JLabel("Details:"), 0, 1, 1, 1, 0.0, 0.0);
        txtAccDetails = new JTextField();
        addGB(accFormPanel, txtAccDetails, 1, 1, 1, 1, 1.0, 0.0);

        addGB(accFormPanel, new JLabel("Qty:"), 2, 1, 1, 1, 0.0, 0.0);
        txtAccQty = new JTextField();
        addGB(accFormPanel, txtAccQty, 3, 1, 1, 1, 1.0, 0.0);

        addGB(accFormPanel, new JLabel("Price:"), 4, 1, 1, 1, 0.0, 0.0);
        txtAccPrice = new JTextField();
        addGB(accFormPanel, txtAccPrice, 5, 1, 1, 1, 1.0, 0.0);

        JPanel accBtnPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));
        accBtnPanel.setBackground(Color.WHITE);
        btnAccAdd = new JButton("Add");
        btnAccUpdate = new JButton("Update");
        btnAccDelete = new JButton("Delete");
        btnAccClear = new JButton("Clear");
        accBtnPanel.add(btnAccAdd);
        accBtnPanel.add(btnAccUpdate);
        accBtnPanel.add(btnAccDelete);
        accBtnPanel.add(btnAccClear);
        
        customiseButtons(btnAccAdd, btnAccUpdate, btnAccDelete);
        btnAccClear.setBackground(new Color(108, 117, 125));
        btnAccClear.setForeground(Color.WHITE);
        btnAccClear.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addGB(accFormPanel, accBtnPanel, 0, 2, 6, 1, 1.0, 0.0);

        // Re-layout jPanel20
        jPanel20.removeAll();
        jPanel20.setLayout(new java.awt.BorderLayout(10, 10));
        jPanel20.setBackground(Color.WHITE);
        jPanel20.add(jLabel77, java.awt.BorderLayout.NORTH);
        jPanel20.add(jScrollPane8, java.awt.BorderLayout.CENTER);
        jPanel20.add(accFormPanel, java.awt.BorderLayout.SOUTH);

        // --- 3. REGISTER ACTION LISTENERS & MOUSE CLICKS ---
        btnSpAdd.addActionListener(this::btnSpAddActionPerformed);
        btnSpUpdate.addActionListener(this::btnSpUpdateActionPerformed);
        btnSpDelete.addActionListener(this::btnSpDeleteActionPerformed);
        btnSpClear.addActionListener(evt -> clearSpFields());

        btnAccAdd.addActionListener(this::btnAccAddActionPerformed);
        btnAccUpdate.addActionListener(this::btnAccUpdateActionPerformed);
        btnAccDelete.addActionListener(this::btnAccDeleteActionPerformed);
        btnAccClear.addActionListener(evt -> clearAccFields());

        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTable3.getSelectedRow();
                if (selectedRow != -1) {
                    txtSpId.setText(jTable3.getValueAt(selectedRow, 0).toString());
                    txtSpName.setText(jTable3.getValueAt(selectedRow, 1).toString());
                    txtSpBrand.setText(jTable3.getValueAt(selectedRow, 2).toString());
                    txtSpDetails.setText(jTable3.getValueAt(selectedRow, 3).toString());
                    txtSpQty.setText(jTable3.getValueAt(selectedRow, 4).toString());
                    txtSpPrice.setText(jTable3.getValueAt(selectedRow, 5).toString());
                    try {
                        clickedSpQty = Integer.parseInt(jTable3.getValueAt(selectedRow, 4).toString());
                    } catch (NumberFormatException e) {
                        clickedSpQty = -1;
                    }
                }
            }
        });

        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTable2.getSelectedRow();
                if (selectedRow != -1) {
                    txtAccId.setText(jTable2.getValueAt(selectedRow, 0).toString());
                    txtAccCategory.setText(jTable2.getValueAt(selectedRow, 1).toString());
                    txtAccBrand.setText(jTable2.getValueAt(selectedRow, 2).toString());
                    txtAccDetails.setText(jTable2.getValueAt(selectedRow, 3).toString());
                    txtAccQty.setText(jTable2.getValueAt(selectedRow, 4).toString());
                    txtAccPrice.setText(jTable2.getValueAt(selectedRow, 5).toString());
                    try {
                        clickedAccQty = Integer.parseInt(jTable2.getValueAt(selectedRow, 4).toString());
                    } catch (NumberFormatException e) {
                        clickedAccQty = -1;
                    }
                }
            }
        });

        jPanel9.revalidate();
        jPanel9.repaint();
    }

    private String generateSparePartID() {
        java.util.Random rand = new java.util.Random();
        while (true) {
            String id = "SP-" + (1000 + rand.nextInt(9000));
            try {
                pst = db.con.prepareStatement("SELECT part_id FROM spare_parts WHERE part_id = ?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                boolean exists = rs.next();
                rs.close();
                pst.close();
                if (!exists) {
                    return id;
                }
            } catch (SQLException e) {
                return id;
            }
        }
    }

    // generateAccessoryID removed since inventory table item_id uses auto_increment

    public void loadSparePartsTable() {
        try {
            pst = db.con.prepareStatement("SELECT part_id, part_name, brand, details, qty, unit_price FROM spare_parts");
            rs = pst.executeQuery();

            DefaultTableModel adminModel = new DefaultTableModel(
                new Object[][] {},
                new String[] {"Part ID", "Name", "Brand", "Details", "Qty", "Unit Price"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable3.setModel(adminModel);

            // Populate Checkout Grid (table3)
            DefaultTableModel checkoutModel = new DefaultTableModel(
                new Object[][] {},
                new String[] {"Item Name", "Brand", "Details", "Qty", "Unit Price"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table3.setModel(checkoutModel);

            while (rs.next()) {
                String partId = rs.getString("part_id");
                String partName = rs.getString("part_name");
                String brand = rs.getString("brand");
                String details = rs.getString("details");
                int qty = rs.getInt("qty");
                double unitPrice = rs.getDouble("unit_price");

                adminModel.addRow(new Object[]{partId, partName, brand, details, qty, unitPrice});
                checkoutModel.addRow(new Object[]{partName, brand, details, qty, unitPrice});
            }

            rs.close();
            pst.close();

            styleAdminTables(jTable3);
            
            // Set LowStockRenderer
            LowStockRenderer adminRenderer = new LowStockRenderer(4);
            jTable3.setDefaultRenderer(Object.class, adminRenderer);
            jTable3.setDefaultRenderer(String.class, adminRenderer);

            LowStockRenderer checkoutRenderer = new LowStockRenderer(3);
            table3.setDefaultRenderer(Object.class, checkoutRenderer);
            table3.setDefaultRenderer(String.class, checkoutRenderer);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void loadAccessoriesTable() {
        try {
            pst = db.con.prepareStatement("SELECT item_id, catagory, brand, details, qty, unit_price FROM inventory");
            rs = pst.executeQuery();

            DefaultTableModel adminModel = new DefaultTableModel(
                new Object[][] {},
                new String[] {"Item ID", "Category", "Brand", "Details", "Qty", "Unit Price"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable2.setModel(adminModel);

            while (rs.next()) {
                String itemId = rs.getString("item_id");
                String category = rs.getString("catagory");
                String brand = rs.getString("brand");
                String details = rs.getString("details");
                int qty = rs.getInt("qty");
                double unitPrice = rs.getDouble("unit_price");

                adminModel.addRow(new Object[]{itemId, category, brand, details, qty, unitPrice});
            }

            rs.close();
            pst.close();

            styleAdminTables(jTable2);
            
            // Set LowStockRenderer on jTable2 (Qty index is 4)
            LowStockRenderer adminRenderer = new LowStockRenderer(4);
            jTable2.setDefaultRenderer(Object.class, adminRenderer);
            jTable2.setDefaultRenderer(String.class, adminRenderer);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void btnSpAddActionPerformed(java.awt.event.ActionEvent evt) {
        String name = txtSpName.getText().trim();
        String brand = txtSpBrand.getText().trim();
        String details = txtSpDetails.getText().trim();
        String qtyStr = txtSpQty.getText().trim();
        String priceStr = txtSpPrice.getText().trim();

        if (name.isEmpty() || brand.isEmpty() || details.isEmpty() || qtyStr.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int qty = Integer.parseInt(qtyStr);
            double price = Double.parseDouble(priceStr);
            
            if (qty < 0 || price < 0) {
                JOptionPane.showMessageDialog(this, "Quantity and Price must be positive numbers!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String id = generateSparePartID();

            pst = db.con.prepareStatement("INSERT INTO spare_parts(part_id, part_name, brand, details, qty, unit_price) VALUES(?,?,?,?,?,?)");
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, brand);
            pst.setString(4, details);
            pst.setInt(5, qty);
            pst.setDouble(6, price);

            pst.executeUpdate();
            pst.close();

            JOptionPane.showMessageDialog(this, "Spare Part added successfully! ID: " + id, "Success", JOptionPane.INFORMATION_MESSAGE);
            loadSparePartsTable();
            clearSpFields();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be an integer and Price must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnSpUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        String id = txtSpId.getText().trim();
        String name = txtSpName.getText().trim();
        String brand = txtSpBrand.getText().trim();
        String details = txtSpDetails.getText().trim();
        String qtyStr = txtSpQty.getText().trim();
        String priceStr = txtSpPrice.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a spare part from the table to update!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (name.isEmpty() || brand.isEmpty() || details.isEmpty() || qtyStr.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int qty = Integer.parseInt(qtyStr);
            double price = Double.parseDouble(priceStr);

            if (qty < 0 || price < 0) {
                JOptionPane.showMessageDialog(this, "Quantity and Price must be positive numbers!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int qtyToAdd = (qty == clickedSpQty) ? 0 : qty;

            pst = db.con.prepareStatement("UPDATE spare_parts SET part_name = ?, brand = ?, details = ?, qty = qty + ?, unit_price = ? WHERE part_id = ?");
            pst.setString(1, name);
            pst.setString(2, brand);
            pst.setString(3, details);
            pst.setInt(4, qtyToAdd);
            pst.setDouble(5, price);
            pst.setString(6, id);

            int updated = pst.executeUpdate();
            pst.close();

            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Spare Part updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadSparePartsTable();
                clearSpFields();
            } else {
                JOptionPane.showMessageDialog(this, "Spare Part record not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be an integer and Price must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnSpDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        String id = txtSpId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a spare part from the table to delete!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete spare part " + id + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                pst = db.con.prepareStatement("DELETE FROM spare_parts WHERE part_id = ?");
                pst.setString(1, id);
                pst.executeUpdate();
                pst.close();

                JOptionPane.showMessageDialog(this, "Spare Part deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadSparePartsTable();
                clearSpFields();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void clearSpFields() {
        txtSpId.setText("");
        txtSpName.setText("");
        txtSpBrand.setText("");
        txtSpDetails.setText("");
        txtSpQty.setText("");
        txtSpPrice.setText("");
        clickedSpQty = -1;
        jTable3.clearSelection();
    }

    private void btnAccAddActionPerformed(java.awt.event.ActionEvent evt) {
        String category = txtAccCategory.getText().trim();
        String brand = txtAccBrand.getText().trim();
        String details = txtAccDetails.getText().trim();
        String qtyStr = txtAccQty.getText().trim();
        String priceStr = txtAccPrice.getText().trim();

        if (category.isEmpty() || brand.isEmpty() || details.isEmpty() || qtyStr.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int qty = Integer.parseInt(qtyStr);
            double price = Double.parseDouble(priceStr);

            if (qty < 0 || price < 0) {
                JOptionPane.showMessageDialog(this, "Quantity and Price must be positive numbers!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pst = db.con.prepareStatement("INSERT INTO inventory(catagory, brand, details, qty, unit_price) VALUES(?,?,?,?,?)");
            pst.setString(1, category);
            pst.setString(2, brand);
            pst.setString(3, details);
            pst.setInt(4, qty);
            pst.setDouble(5, price);

            pst.executeUpdate();
            pst.close();

            JOptionPane.showMessageDialog(this, "Accessory added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadAccessoriesTable();
            loadInventoryTable(); // Refresh checkout accessories table
            clearAccFields();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be an integer and Price must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnAccUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        String id = txtAccId.getText().trim();
        String category = txtAccCategory.getText().trim();
        String brand = txtAccBrand.getText().trim();
        String details = txtAccDetails.getText().trim();
        String qtyStr = txtAccQty.getText().trim();
        String priceStr = txtAccPrice.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an accessory from the table to update!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (category.isEmpty() || brand.isEmpty() || details.isEmpty() || qtyStr.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int itemId = Integer.parseInt(id);
            int qty = Integer.parseInt(qtyStr);
            double price = Double.parseDouble(priceStr);

            if (qty < 0 || price < 0) {
                JOptionPane.showMessageDialog(this, "Quantity and Price must be positive numbers!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int qtyToAdd = (qty == clickedAccQty) ? 0 : qty;

            pst = db.con.prepareStatement("UPDATE inventory SET catagory = ?, brand = ?, details = ?, qty = qty + ?, unit_price = ? WHERE item_id = ?");
            pst.setString(1, category);
            pst.setString(2, brand);
            pst.setString(3, details);
            pst.setInt(4, qtyToAdd);
            pst.setDouble(5, price);
            pst.setInt(6, itemId);

            int updated = pst.executeUpdate();
            pst.close();

            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Accessory updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadAccessoriesTable();
                loadInventoryTable(); // Refresh checkout accessories table
                clearAccFields();
            } else {
                JOptionPane.showMessageDialog(this, "Accessory record not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be an integer and Price must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnAccDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        String id = txtAccId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an accessory from the table to delete!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete accessory " + id + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int itemId = Integer.parseInt(id);
                pst = db.con.prepareStatement("DELETE FROM inventory WHERE item_id = ?");
                pst.setInt(1, itemId);
                pst.executeUpdate();
                pst.close();

                JOptionPane.showMessageDialog(this, "Accessory deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadAccessoriesTable();
                loadInventoryTable(); // Refresh checkout accessories table
                clearAccFields();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void clearAccFields() {
        txtAccId.setText("");
        txtAccCategory.setText("");
        txtAccBrand.setText("");
        txtAccDetails.setText("");
        txtAccQty.setText("");
        txtAccPrice.setText("");
        clickedAccQty = -1;
        jTable2.clearSelection();
    }

    // Programmatic fields for Inventory Management CRUD
    private javax.swing.JTextField txtSpId;
    private javax.swing.JTextField txtSpName;
    private javax.swing.JTextField txtSpBrand;
    private javax.swing.JTextField txtSpDetails;
    private javax.swing.JTextField txtSpQty;
    private javax.swing.JTextField txtSpPrice;
    private javax.swing.JButton btnSpAdd;
    private javax.swing.JButton btnSpUpdate;
    private javax.swing.JButton btnSpDelete;
    private javax.swing.JButton btnSpClear;

    private javax.swing.JTextField txtAccId;
    private javax.swing.JTextField txtAccCategory;
    private javax.swing.JTextField txtAccBrand;
    private javax.swing.JTextField txtAccDetails;
    private javax.swing.JTextField txtAccQty;
    private javax.swing.JTextField txtAccPrice;
    private javax.swing.JButton btnAccAdd;
    private javax.swing.JButton btnAccUpdate;
    private javax.swing.JButton btnAccDelete;
    private javax.swing.JButton btnAccClear;

    // Track clicked quantities for additive inventory updates
    private int clickedSpQty = -1;
    private int clickedAccQty = -1;
}
