package vehicalservicecenter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Register.class.getName());
    User user1;
    Customer cus;

    PreparedStatement pst;
    ResultSet rs;
    DBConnection db = new DBConnection();

    public Register() {
        initComponents();
        loadImage();
        styleFormButtons();
        normalCheck();

    }

    private double getServicePrice(String serviceId) {
        double price = 0.0;
        try {
            String sql = "SELECT price FROM services WHERE service_id = ?";
            PreparedStatement pstTmp = db.con.prepareStatement(sql);
            pstTmp.setString(1, serviceId);
            ResultSet rsTmp = pstTmp.executeQuery();
            if (rsTmp.next()) {
                price = rsTmp.getDouble("price");
            }
            rsTmp.close();
            pstTmp.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblImage2 = new javax.swing.JLabel();
        details = new javax.swing.JPanel();
        regDetails = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCustName = new javax.swing.JTextField();
        txtNic = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTown = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        YearChooser = new com.toedter.calendar.JYearChooser();
        jLabel13 = new javax.swing.JLabel();
        txtLisen = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cmbMake = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cmbFuel = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txtReading = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        chkNormalService = new javax.swing.JCheckBox();
        chkBodtWash = new javax.swing.JCheckBox();
        chkEngineOil = new javax.swing.JCheckBox();
        chkOilFilter = new javax.swing.JCheckBox();
        chkFluidLevel = new javax.swing.JCheckBox();
        chkAirFilter = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        chkAlignment = new javax.swing.JCheckBox();
        chkLubrication = new javax.swing.JCheckBox();
        chkBrakeServ = new javax.swing.JCheckBox();
        chkFullService = new javax.swing.JCheckBox();
        chkTuneUp = new javax.swing.JCheckBox();
        chkUnderCarriage = new javax.swing.JCheckBox();
        chkAcSystem = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        chkBrakePad = new javax.swing.JCheckBox();
        chkBattery = new javax.swing.JCheckBox();
        chkSparkPlug = new javax.swing.JCheckBox();
        chkWiper = new javax.swing.JCheckBox();
        chkHeadlight = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        imLable3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setPreferredSize(new java.awt.Dimension(350, 865));

        lblImage2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        details.setBackground(new java.awt.Color(204, 204, 204));
        details.setPreferredSize(new java.awt.Dimension(850, 865));

        regDetails.setBackground(new java.awt.Color(255, 255, 255));
        regDetails.setPreferredSize(new java.awt.Dimension(615, 920));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Owner’s Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("NIC");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("Phone Number");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("City");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("Town");

        txtTown.addActionListener(this::txtTownActionPerformed);

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("Vehicle Brand");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("Vehicle Model");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("Vehicle Color");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setText("Build Year");

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setText("License Plate  number");

        jLabel27.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel27.setText("Make");

        cmbMake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel28.setText("Fuel Type");

        cmbFuel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel29.setText("Odometer Reading");

        chkNormalService.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        chkNormalService.setText("Normal Service ");

        chkBodtWash.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkBodtWash.setText("Body Wash & Vacuum");

        chkEngineOil.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkEngineOil.setText("Engine Oil Change");

        chkOilFilter.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkOilFilter.setText("Oil Filter Replacement");

        chkFluidLevel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkFluidLevel.setText("Fluid Level Check");

        chkAirFilter.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkAirFilter.setText("Air Filter Cleaning");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkNormalService)
                    .addComponent(chkEngineOil)
                    .addComponent(chkBodtWash)
                    .addComponent(chkOilFilter)
                    .addComponent(chkFluidLevel)
                    .addComponent(chkAirFilter))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(chkNormalService, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkBodtWash, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkEngineOil, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkOilFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkFluidLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAirFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        chkAlignment.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkAlignment.setText("Wheel Alignment & Balancing");

        chkLubrication.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkLubrication.setText("Full Lubrication Service");

        chkBrakeServ.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkBrakeServ.setText("Brake System Servicing");

        chkFullService.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        chkFullService.setText("Full Service ");
        chkFullService.addActionListener(this::chkFullServiceActionPerformed);

        chkTuneUp.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkTuneUp.setText("Engine Tune-up & Scanning");
        chkTuneUp.addActionListener(this::chkTuneUpActionPerformed);

        chkUnderCarriage.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkUnderCarriage.setText("Under-carriage Degreasing & Washing");

        chkAcSystem.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkAcSystem.setText("AC System Inspection & Top-up");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkFullService)
                    .addComponent(chkLubrication)
                    .addComponent(chkAlignment)
                    .addComponent(chkTuneUp)
                    .addComponent(chkBrakeServ)
                    .addComponent(chkUnderCarriage)
                    .addComponent(chkAcSystem))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkFullService, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkLubrication, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAlignment, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkTuneUp, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkBrakeServ, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkUnderCarriage, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAcSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel3.setText("J O B   F o r m");

        jLabel33.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel33.setText("Additional");

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));

        chkBrakePad.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkBrakePad.setText("Brake Pad Replacement");

        chkBattery.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkBattery.setText("Battery Charging & Replacement");
        chkBattery.addActionListener(this::chkBatteryActionPerformed);

        chkSparkPlug.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkSparkPlug.setText("Spark Plug Replacement");

        chkWiper.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkWiper.setText("Wiper Blade Replacement");

        chkHeadlight.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        chkHeadlight.setText("Headlight/Tail-light Bulb Replacement");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSparkPlug)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBrakePad)
                            .addComponent(chkBattery))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkWiper)
                            .addComponent(chkHeadlight))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBrakePad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkWiper, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBattery, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkHeadlight, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkSparkPlug, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel34.setText("Services");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnSave.setText("Add/Set Job");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        btnDelete.setText("Delete");

        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));

        btnSearch.setBackground(new java.awt.Color(255, 204, 51));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btns/search30.png"))); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.setMaximumSize(new java.awt.Dimension(40, 40));
        btnSearch.setMinimumSize(new java.awt.Dimension(40, 40));
        btnSearch.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        imLable3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout regDetailsLayout = new javax.swing.GroupLayout(regDetails);
        regDetails.setLayout(regDetailsLayout);
        regDetailsLayout.setHorizontalGroup(
            regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regDetailsLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, regDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel33)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator4)
                            .addGap(25, 25, 25))
                        .addGroup(regDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator3))
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(regDetailsLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(regDetailsLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTown))
                                    .addGroup(regDetailsLayout.createSequentialGroup()
                                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(regDetailsLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
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
                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(regDetailsLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
            .addGroup(regDetailsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(regDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(regDetailsLayout.createSequentialGroup()
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(regDetailsLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imLable3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        regDetailsLayout.setVerticalGroup(
            regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regDetailsLayout.createSequentialGroup()
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(regDetailsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLisen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbMake, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbFuel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regDetailsLayout.createSequentialGroup()
                        .addComponent(imLable3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(regDetailsLayout.createSequentialGroup()
                            .addGroup(regDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel33)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(regDetailsLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regDetailsLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout detailsLayout = new javax.swing.GroupLayout(details);
        details.setLayout(detailsLayout);
        detailsLayout.setHorizontalGroup(
            detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        detailsLayout.setVerticalGroup(
            detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(details, java.awt.BorderLayout.LINE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTownActionPerformed

    private void chkTuneUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTuneUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTuneUpActionPerformed

    private void chkFullServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFullServiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkFullServiceActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String vehicleNo = txtLisen.getText().trim();

            if (vehicleNo.isEmpty() || txtCustName.getText().trim().isEmpty() || txtNumber.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Vehicle No, Owner's Name and Phone Number!");
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

                String sqlVehInsert = "INSERT INTO vehical_table (vehical_no, make, brand, model, fuel, reading, color, make_year, cus_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                pst = db.con.prepareStatement(sqlVehInsert);
                pst.setString(1, vehicleNo);
                pst.setString(2, cmbMake.getSelectedItem().toString());
                pst.setString(3, txtBrand.getText().trim());
                pst.setString(4, txtModel.getText().trim());
                pst.setString(5, cmbFuel.getSelectedItem().toString());
                pst.setString(6, readingValue);
                pst.setString(7, txtColor.getText().trim());
                pst.setInt(8, YearChooser.getYear());
                pst.setString(9, currentCusId2);
                pst.executeUpdate();
                pst.close();
            }

            db.con.commit();

            java.util.ArrayList<String> selectedServices = new java.util.ArrayList<>();

            // === (A) Normal Service කාණ්ඩය ===
            if (chkNormalService.isSelected()) {
                selectedServices.add("SRV001");
                normalCheck();
            }
            if (chkBodtWash.isSelected()) {
                selectedServices.add("SRV002"); // Body Wash & Vacuum
            }
            if (chkEngineOil.isSelected()) {
                selectedServices.add("SRV003"); // Engine Oil Change
            }
            if (chkOilFilter.isSelected()) {
                selectedServices.add("SRV004"); // Oil Filter Replacement
            }
            if (chkFluidLevel.isSelected()) {
                selectedServices.add("SRV005"); // Fluid Level Check
            }
            if (chkAirFilter.isSelected()) {
                selectedServices.add("SRV006"); // Air Filter Cleaning
            }

            // === (B) Full Service කාණ්ඩය ===
            if (chkFullService.isSelected()) {
                selectedServices.add("SRV010");
            }
            if (chkLubrication.isSelected()) {
                selectedServices.add("SRV012"); // Full Lubrication Service
            }
            if (chkAlignment.isSelected()) {
                selectedServices.add("SRV013"); // Wheel Alignment & Balancing
            }
            if (chkTuneUp.isSelected()) {
                selectedServices.add("SRV014"); // Engine Tune-up & Scanning
            }
            if (chkBrakeServ.isSelected()) {
                selectedServices.add("SRV015"); // Brake System Servicing
            }
            if (chkUnderCarriage.isSelected()) {
                selectedServices.add("SRV016"); // Under-carriage Degreasing
            }
            if (chkAcSystem.isSelected()) {
                selectedServices.add("SRV017"); // AC System Inspection
            }

            // === (C) Additional Services ===
            if (chkBrakePad.isSelected()) {
                selectedServices.add("SRV020"); // Brake Pad Replacement
            }
            if (chkBattery.isSelected()) {
                selectedServices.add("SRV021"); // Battery Charging & Replacement
            }
            if (chkSparkPlug.isSelected()) {
                selectedServices.add("SRV022"); // Spark Plug Replacement
            }
            if (chkWiper.isSelected()) {
                selectedServices.add("SRV023"); // Wiper Blade Replacement
            }
            if (chkHeadlight.isSelected()) {
                selectedServices.add("SRV024"); // Headlight/Tail-light
            }

            if (selectedServices.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select at least one service from checkboxes!");
                return;
            }

            double totalAmount = 0.0;

            int randomJob = (int) (Math.random() * 9000) + 1000;
            String jobID = "JOB-" + randomJob;

            if (chkFullService.isSelected()) {
                totalAmount += getServicePrice("SRV010");

                if (chkBrakePad.isSelected()) {
                    totalAmount += getServicePrice("SRV020");
                }
                if (chkBattery.isSelected()) {
                    totalAmount += getServicePrice("SRV021");
                }
                if (chkSparkPlug.isSelected()) {
                    totalAmount += getServicePrice("SRV022");
                }
                if (chkWiper.isSelected()) {
                    totalAmount += getServicePrice("SRV023");
                }
                if (chkHeadlight.isSelected()) {
                    totalAmount += getServicePrice("SRV024");
                }
            } else if (chkNormalService.isSelected()) {
                totalAmount += getServicePrice("SRV001"); // Normal package price

                if (chkLubrication.isSelected()) {
                    totalAmount += getServicePrice("SRV012");
                }
                if (chkAlignment.isSelected()) {
                    totalAmount += getServicePrice("SRV013");
                }
                if (chkTuneUp.isSelected()) {
                    totalAmount += getServicePrice("SRV014");
                }
                if (chkBrakeServ.isSelected()) {
                    totalAmount += getServicePrice("SRV015");
                }
                if (chkUnderCarriage.isSelected()) {
                    totalAmount += getServicePrice("SRV016");
                }
                if (chkAcSystem.isSelected()) {
                    totalAmount += getServicePrice("SRV017");
                }

                // Additional services
                if (chkBrakePad.isSelected()) {
                    totalAmount += getServicePrice("SRV020");
                }
                if (chkBattery.isSelected()) {
                    totalAmount += getServicePrice("SRV021");
                }
                if (chkSparkPlug.isSelected()) {
                    totalAmount += getServicePrice("SRV022");
                }
                if (chkWiper.isSelected()) {
                    totalAmount += getServicePrice("SRV023");
                }
                if (chkHeadlight.isSelected()) {
                    totalAmount += getServicePrice("SRV024");
                }
            } else {
                for (String sId : selectedServices) {
                    totalAmount += getServicePrice(sId);
                }
            }

            String sType = "";
            if (chkFullService.isSelected()) {
                sType = "Full Service"; // Full Service 
            } else if (chkNormalService.isSelected()) {
                sType = "Normal Service"; // Normal Service
            } else {
                sType = "Custom Services"; // 
            }

            java.util.ArrayList<String> addList = new java.util.ArrayList<>();
            if (chkBrakePad.isSelected()) {
                addList.add("Brake Pad Replacement");
            }
            if (chkBattery.isSelected()) {
                addList.add("Battery Charging & Replacement");
            }
            if (chkSparkPlug.isSelected()) {
                addList.add("Spark Plug Replacement");
            }
            if (chkWiper.isSelected()) {
                addList.add("Wiper Blade Replacement");
            }
            if (chkHeadlight.isSelected()) {
                addList.add("Headlight/Tail-light Bulb Replacement");
            }

            String addServicesString = String.join(", ", addList);

            setJob setJob = new setJob(jobID, vehicleNo, readingValue, totalAmount, selectedServices, sType, addServicesString);
            JobSet setJobFrame = new JobSet(setJob);
            setJobFrame.setVisible(true);
            
            JOptionPane.showMessageDialog(this, "Job Created Successfully! Job ID: " + jobID);
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

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void chkBatteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBatteryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBatteryActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clean();
    }//GEN-LAST:event_btnClearActionPerformed

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
                new Register().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser YearChooser;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chkAcSystem;
    private javax.swing.JCheckBox chkAirFilter;
    private javax.swing.JCheckBox chkAlignment;
    private javax.swing.JCheckBox chkBattery;
    private javax.swing.JCheckBox chkBodtWash;
    private javax.swing.JCheckBox chkBrakePad;
    private javax.swing.JCheckBox chkBrakeServ;
    private javax.swing.JCheckBox chkEngineOil;
    private javax.swing.JCheckBox chkFluidLevel;
    private javax.swing.JCheckBox chkFullService;
    private javax.swing.JCheckBox chkHeadlight;
    private javax.swing.JCheckBox chkLubrication;
    private javax.swing.JCheckBox chkNormalService;
    private javax.swing.JCheckBox chkOilFilter;
    private javax.swing.JCheckBox chkSparkPlug;
    private javax.swing.JCheckBox chkTuneUp;
    private javax.swing.JCheckBox chkUnderCarriage;
    private javax.swing.JCheckBox chkWiper;
    private javax.swing.JComboBox<String> cmbFuel;
    private javax.swing.JComboBox<String> cmbMake;
    private javax.swing.JPanel details;
    private javax.swing.JLabel imLable3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblImage2;
    private javax.swing.JPanel regDetails;
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
    private javax.swing.JTextField txtTown;
    // End of variables declaration//GEN-END:variables

    private void loadImage() {
        java.net.URL imgURL = getClass().getResource("/Images/car5.jpg");
        java.net.URL imgURL2 = getClass().getResource("/Images/car6.png");

        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage();

            Image scaledImg = img.getScaledInstance(500, lblImage2.getHeight(), Image.SCALE_SMOOTH);
            lblImage2.setIcon(new ImageIcon(scaledImg));
        }

        if (imgURL2 != null) {
            ImageIcon icon2 = new ImageIcon(imgURL2);
            Image img2 = icon2.getImage();

            Image scaledImg2 = img2.getScaledInstance(300, imLable3.getHeight(), Image.SCALE_SMOOTH);
            imLable3.setIcon(new ImageIcon(scaledImg2));
        }
    }

    private Vehical checkVehical(String vehicleNo) {

        try {
            pst = db.con.prepareStatement("SELECT * FROM vehical_table WHERE vehical_no = ?");
            pst.setString(1, vehicleNo);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new Vehical(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9));
            }

        } catch (SQLException ex) {
            System.getLogger(Register.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
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

        chkNormalService.setSelected(false);
        chkBodtWash.setSelected(false);     // Body Wash & Vacuum
        chkEngineOil.setSelected(false);    // Engine Oil Change
        chkOilFilter.setSelected(false);    // Oil Filter Replacement
        chkAirFilter.setSelected(false);    // Air Filter Cleaning
        chkFluidLevel.setSelected(false);

        chkFullService.setSelected(false);
        chkLubrication.setSelected(false);  // Full Lubrication Service
        chkAlignment.setSelected(false);    // Wheel Alignment & Balancing
        chkTuneUp.setSelected(false);       // Engine Tune-up & Scanning
        chkBrakeServ.setSelected(false);    // Brake System Servicing
        chkUnderCarriage.setSelected(false); // Under-carriage Degreasing
        chkAcSystem.setSelected(false);

        chkBrakePad.setSelected(false);     // Brake Pad Replacement
        chkBattery.setSelected(false);      // Battery Charging
        chkSparkPlug.setSelected(false);    // Spark Plug Replacement
        chkWiper.setSelected(false);        // Wiper Blade Replacement
        chkHeadlight.setSelected(false);

        txtLisen.setText(txtSearch.getText());

        txtSearch.setText("");
        txtSearch.requestFocus();
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

    private void styleFormButtons() {
        // Save Button - Blue
        btnSave.setBackground(new Color(4, 102, 200));
        btnSave.setForeground(Color.WHITE);
//        btnSave.putClientProperty("JButton.buttonType", "roundRect");
        btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Update Button - Green (Success)
        btnUpdate.setBackground(new Color(42, 157, 143));
        btnUpdate.setForeground(Color.WHITE);
//        btnUpdate.putClientProperty("JButton.buttonType", "roundRect");
        btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Delete Button - Red (Danger)
        btnDelete.setBackground(new Color(230, 57, 70));
        btnDelete.setForeground(Color.WHITE);
//        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnClear.setBackground(new Color(244, 162, 97)); // Grey
        btnClear.setForeground(Color.WHITE);
//        btnClear.putClientProperty("JButton.buttonType", "roundRect");
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void normalCheck() {
        chkNormalService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean isSelected = chkNormalService.isSelected();
                chkBodtWash.setSelected(isSelected);
                chkEngineOil.setSelected(isSelected);
                chkOilFilter.setSelected(isSelected);
                chkFluidLevel.setSelected(isSelected);
                chkAirFilter.setSelected(isSelected);
            }
        });

        chkFullService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean isSelected = chkFullService.isSelected();
                chkLubrication.setSelected(isSelected);
                chkAlignment.setSelected(isSelected);
                chkTuneUp.setSelected(isSelected);
                chkBrakeServ.setSelected(isSelected);
                chkUnderCarriage.setSelected(isSelected);
                chkAcSystem.setSelected(isSelected);

                chkBodtWash.setSelected(isSelected);   // Body Wash
                chkEngineOil.setSelected(isSelected);  // Engine Oil
                chkOilFilter.setSelected(isSelected);  // Oil Filter
                chkFluidLevel.setSelected(isSelected); // Fluid Level
                chkAirFilter.setSelected(isSelected);
            }
        });
    }

}
