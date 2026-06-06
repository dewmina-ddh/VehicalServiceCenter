package vehicalservicecenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JobSet extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JobSet.class.getName());
    setJob setJ;
    ArrayList<String> serviceList;
    Dash dash;
    PreparedStatement pst;
    ResultSet rs;
    DBConnection db = new DBConnection();

    public JobSet(setJob setJob, Dash dsh) {
        initComponents();
        loadTechnicians();
        leadServiceBays();
        loadBays();
        this.setJ = setJob;
        this.serviceList = setJ.getServiceList();
        this.dash = dsh;

        txtJobID.setText(setJob.getJobId());
        txtPrices.setText(String.valueOf(setJob.getTotalAmount()));

        txtArea.setText("");

        try {
            for (String sId : serviceList) {
                String sqlName = "SELECT service_name FROM services WHERE service_id = ?";
                pst = db.con.prepareStatement(sqlName);
                pst.setString(1, sId);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String serviceName = rs.getString("service_name");
                    txtArea.append(serviceName + "\n");
                }
                rs.close();
                pst.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtJobID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbTech = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbBays = new javax.swing.JComboBox<>();
        btnSet = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPrices = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(501, 440));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setText("JOB Id");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setText("S E T   J O B");

        txtJobID.setEditable(false);
        txtJobID.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setText("Technician");

        cmbTech.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setText("Servise Bay");

        cmbBays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSet.setText("Set");
        btnSet.addActionListener(this::btnSetActionPerformed);

        jButton2.setText("Back");

        jButton3.setText("Cancle");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setText("Price");

        txtPrices.setEditable(false);
        txtPrices.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setText("Selected Services");

        txtArea.setEditable(false);
        txtArea.setBackground(new java.awt.Color(255, 255, 255));
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtArea.setForeground(new java.awt.Color(51, 153, 255));
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrices, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbBays, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbTech, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtJobID, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJobID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTech, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbBays, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrices, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
        if (cmbBays.getSelectedIndex() == 0 || cmbTech.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a valid Service Bay and Technician!");
        }

        String selectedBay = cmbBays.getSelectedItem().toString();
        String selectedTechRaw = cmbTech.getSelectedItem().toString();
        String selectedTech = selectedTechRaw.split(" - ")[0];

        String serviceType = setJ.getServiceType(); // Normal Service / Full Service / Custom
        String additionalServices = setJ.getAdditionalServices();

        try {
            db.con.setAutoCommit(false);
            pst = db.con.prepareStatement("INSERT INTO job_table (job_id, vehicle_no, service_type, additional_services, bay_id, tech_id, odometer_reading, start_time, total_amount, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'Ongoing')");
            pst.setString(1, setJ.getJobId());
            pst.setString(2, setJ.getVehicleNo());
            pst.setString(3, serviceType);
            pst.setString(4, additionalServices);
            pst.setString(5, selectedBay);
            pst.setString(6, selectedTech);
            pst.setString(7, setJ.getOdometerReading());

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
            String startTimeOnly = sdf.format(new java.util.Date());

            pst.setString(8, startTimeOnly);
            pst.setDouble(9, setJ.getTotalAmount());
            
            pst.executeUpdate();
            pst.close();

            String sqlJobService = "INSERT INTO job_services (job_id, service_id, price) VALUES (?, ?, ?)";
            PreparedStatement pstService = db.con.prepareStatement(sqlJobService);
            for (String sId : serviceList) {
                double servicePrice = 0.0;
                String sqlP = "SELECT price FROM services WHERE service_id = ?";
                PreparedStatement pstP = db.con.prepareStatement(sqlP);
                pstP.setString(1, sId);
                ResultSet rsP = pstP.executeQuery();
                if (rsP.next()) {
                    servicePrice = rsP.getDouble("price");
                }
                rsP.close();
                pstP.close();

                pstService.setString(1, setJ.getJobId());
                pstService.setString(2, sId);
                pstService.setDouble(3, servicePrice);
                pstService.executeUpdate();
            }

            int randomInv = (int) (Math.random() * 9000) + 1000;
            String invoiceNo = "INV-" + randomInv; //

            String sqlInvoice = "INSERT INTO invoice (inv_id, job_id, date, total_amount, discount, net_amount, payment_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstInv = db.con.prepareStatement(sqlInvoice);

            pstInv.setString(1, invoiceNo);
            pstInv.setString(2, setJ.getJobId());
            pstInv.setString(3, startTimeOnly);
            pstInv.setDouble(4, setJ.getTotalAmount());
            pstInv.setInt(5, 0);
            pstInv.setDouble(6, setJ.getTotalAmount());
            pstInv.setString(7, "Pending");

            pstInv.executeUpdate();
            pstInv.close();

            String sqlUpdateTech = "UPDATE technician SET status = 'Busy' WHERE tech_id = ?";
            pst = db.con.prepareStatement(sqlUpdateTech);
            pst.setString(1, selectedTech); //
            pst.executeUpdate();
            pst.close();

            db.con.commit();
            this.dash.loadInventoryTable();
            this.dash.loadOngoingJobsTable();
            this.dash.loadOverviewCounts();
            this.dash.loadTechnicianCards();
            
            String successMessage = "Job Activated Successfully! 👍\n\n"
                                  + "🚗 Vehicle No: " + setJ.getVehicleNo() + "\n"
                                  + "🆔 Job ID    : " + setJ.getJobId() + "\n"
                                  + "💳 Invoice No: " + invoiceNo;
            
            JOptionPane.showMessageDialog(this, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (SQLException ex) {
            System.getLogger(JobSet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                db.con.setAutoCommit(true);
            } catch (Exception e) {
            } //
        }
    }//GEN-LAST:event_btnSetActionPerformed

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
                new JobSet(null, null).setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSet;
    private javax.swing.JComboBox<String> cmbBays;
    private javax.swing.JComboBox<String> cmbTech;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtJobID;
    private javax.swing.JTextField txtPrices;
    // End of variables declaration//GEN-END:variables

    private void loadTechnicians() {
        try {
            String sql = "SELECT tech_id, name FROM technician WHERE status = 'Available'";
            pst = db.con.prepareStatement(sql);
            rs = pst.executeQuery();

            cmbTech.removeAllItems();
            cmbTech.addItem("- Select Technician -");
            while (rs.next()) {
                cmbTech.addItem(rs.getString("tech_id") + " - " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBays() {

    }

    private void leadServiceBays() {
        try {
            pst = db.con.prepareStatement("SELECT bay_id FROM bay_table WHERE status = 'Available'");
            rs = pst.executeQuery();

            cmbBays.removeAllItems();
            cmbBays.addItem("- Select Bay -");
            while (rs.next()) {
                cmbBays.addItem(rs.getString("bay_id"));
            }

        } catch (SQLException ex) {
            System.getLogger(JobSet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
