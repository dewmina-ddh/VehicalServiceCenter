package vehicalservicecenter;

import java.awt.CardLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BillFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BillFrame.class.getName());
    DBConnection db = new DBConnection();
    PreparedStatement pst;
    ResultSet rs;

    String type;
    BillStatement billData;
    String paymentMethod = "Cash";
    String currentJobId = "";
    public BillFrame(String billType, BillStatement myBillData) {
        initComponents();
        loadOngoinService();

        this.type = billType;

        CardLayout cl = (java.awt.CardLayout) billPnael.getLayout();

        if ("ServiceBill".equals(type)) {
            cl.show(billPnael, "card3");
        } else if ("accBill".equals(type)) {
            cl.show(billPnael, "card2");
        }
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        billPnael = new javax.swing.JPanel();
        ServiceBill = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billShow = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cmbVehicles = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtVNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOwner = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTech = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbDiscont = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        txtPayAmount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNet = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        inventorybill = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        main.setMaximumSize(new java.awt.Dimension(1000, 600));
        main.setMinimumSize(new java.awt.Dimension(1000, 600));
        main.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(27, 42, 71));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 60));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(798, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        main.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        billPnael.setLayout(new java.awt.CardLayout());

        ServiceBill.setBackground(new java.awt.Color(255, 255, 255));

        billShow.setColumns(20);
        billShow.setRows(5);
        billShow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        jScrollPane1.setViewportView(billShow);

        jLabel2.setText("Ongoing Services");

        cmbVehicles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVehicles.addActionListener(this::cmbVehiclesActionPerformed);

        jLabel3.setText("Vehicle Number");

        jLabel4.setText("Owners Name");

        jLabel5.setText("Technician");

        jLabel6.setText("Total Amount");

        jLabel7.setText("Discount");

        cmbDiscont.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "50", "100", "500", "1000" }));

        jLabel8.setText("Total Amount");

        jLabel9.setText("Pay Amount");

        jLabel10.setText("Net Amount");

        btnPrint.setText("Print Bill");
        btnPrint.addActionListener(this::btnPrintActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Bill Show");

        jButton1.setText("Calculate");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout ServiceBillLayout = new javax.swing.GroupLayout(ServiceBill);
        ServiceBill.setLayout(ServiceBillLayout);
        ServiceBillLayout.setHorizontalGroup(
            ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServiceBillLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVNo)
                            .addComponent(txtOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTech))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbDiscont, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal1))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPayAmount))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNet)))
                .addGap(18, 18, 18)
                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        ServiceBillLayout.setVerticalGroup(
            ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServiceBillLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVNo, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ServiceBillLayout.createSequentialGroup()
                                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTech, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDiscont, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPayAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServiceBillLayout.createSequentialGroup()
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        billPnael.add(ServiceBill, "card3");

        inventorybill.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout inventorybillLayout = new javax.swing.GroupLayout(inventorybill);
        inventorybill.setLayout(inventorybillLayout);
        inventorybillLayout.setHorizontalGroup(
            inventorybillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        inventorybillLayout.setVerticalGroup(
            inventorybillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        billPnael.add(inventorybill, "card2");

        main.add(billPnael, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVehiclesActionPerformed
        fetchAndGenerateServiceBill();
    }//GEN-LAST:event_cmbVehiclesActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        printAndSaveInvoice();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        calculateBalance();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        cmbVehicles.setSelectedIndex(0);
        cmbDiscont.setSelectedIndex(0);
        billShow.setText("");
        txtVNo.setText("");
        txtOwner.setText("");
        txtTech.setText("");
        txtTotal.setText("");
        txtTotal1.setText("");
        txtPayAmount.setText("");
        txtNet.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new BillFrame(null, null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ServiceBill;
    private javax.swing.JPanel billPnael;
    private javax.swing.JTextArea billShow;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox<String> cmbDiscont;
    private javax.swing.JComboBox<String> cmbVehicles;
    private javax.swing.JPanel inventorybill;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel main;
    private javax.swing.JTextField txtNet;
    private javax.swing.JTextField txtOwner;
    private javax.swing.JTextField txtPayAmount;
    private javax.swing.JTextField txtTech;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    private javax.swing.JTextField txtVNo;
    // End of variables declaration//GEN-END:variables

    private void loadOngoinService() {
        try {
            String sql = "SELECT vehicle_no FROM job_table WHERE status = 'Ongoing'";
            pst = db.con.prepareStatement(sql);
            rs = pst.executeQuery();

            cmbVehicles.removeAllItems();
            cmbVehicles.addItem("- Select Vehicle -");

            while (rs.next()) {
                cmbVehicles.addItem(rs.getString("vehicle_no"));
            }
            rs.close();
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchAndGenerateServiceBill() {
        if (cmbVehicles.getSelectedIndex() <= 0) {
            billShow.setText("");
            txtVNo.setText(""); txtOwner.setText(""); txtTech.setText("");
            txtTotal.setText(""); txtTotal1.setText(""); txtPayAmount.setText(""); txtNet.setText("");
            return;
        }

        String vehicleNo = cmbVehicles.getSelectedItem().toString();
        String cusName = "General Customer";
        String techName = "Unknown";
        double totalAmount = 0.0;
        java.util.ArrayList<Object[]> serviceList = new java.util.ArrayList<>();

        try {
            String infoSql = "SELECT c.name AS cus_name, t.name AS tech_name, jt.job_id FROM job_table jt "
                    + "INNER JOIN vehical_table vt ON jt.vehicle_no = vt.vehical_no "
                    + "INNER JOIN customer c ON vt.cus_id = c.cus_id "
                    + "INNER JOIN technician t ON jt.tech_id = t.tech_id "
                    + "WHERE jt.vehicle_no = ? AND jt.status = 'Ongoing'";
            pst = db.con.prepareStatement(infoSql);
            pst.setString(1, vehicleNo);
            rs = pst.executeQuery();

            if (rs.next()) {
                cusName = rs.getString("cus_name");
                techName = rs.getString("tech_name");
                currentJobId = rs.getString("job_id");
            }
            rs.close(); pst.close();

            txtVNo.setText(vehicleNo);
            txtOwner.setText(cusName);
            txtTech.setText(techName);

            String serviceSql = "SELECT s.service_name, js.price FROM job_table jt "
                    + "INNER JOIN job_services js ON jt.job_id = js.job_id "
                    + "INNER JOIN services s ON js.service_id = s.service_id "
                    + "WHERE jt.vehicle_no = ? AND jt.status = 'Ongoing'";

            pst = db.con.prepareStatement(serviceSql);
            pst.setString(1, vehicleNo);
            rs = pst.executeQuery();

            while (rs.next()) {
                String sName = rs.getString("service_name");
                double sPrice = rs.getDouble("price");
                serviceList.add(new Object[]{sName, "1", sPrice});
                totalAmount += sPrice;
            }
            rs.close(); pst.close();

            txtTotal.setText(String.format("%.2f", totalAmount));
            txtTotal1.setText(String.format("%.2f", totalAmount));

            this.billData = new BillStatement(cusName, totalAmount, serviceList);

            String[] options = {"Cash", "Card"};
            int choice = javax.swing.JOptionPane.showOptionDialog(this, "Select Payment Method:",
                    "Payment Type", javax.swing.JOptionPane.DEFAULT_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (choice == 0) paymentMethod = "Cash";
            else if (choice == 1) paymentMethod = "Card";

            generateReceipt(totalAmount, 0.0, totalAmount, 0.0, 0.0, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateReceipt(double total, double discount, double netTotal, double paid, double balance, boolean par3) {
        if (billData == null) return;
        
        StringBuilder bill = new StringBuilder();
        billShow.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

        java.text.SimpleDateFormat sdfDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat sdfTime = new java.text.SimpleDateFormat("hh:mm a");

        bill.append("          YOUR GARAGE NAME\n");
        bill.append("       No 123, Main Street, City\n");
        bill.append("          Tel: 071 234 5678\n");
        bill.append("--------------------------------------\n");
        bill.append("           SERVICE INVOICE\n");
        if (cmbVehicles != null && cmbVehicles.getSelectedIndex() > 0) {
            bill.append("Vehicle: ").append(cmbVehicles.getSelectedItem().toString()).append("\n");
        }
        bill.append("--------------------------------------\n");
        bill.append("Date : ").append(sdfDate.format(new java.util.Date())).append("   Time: ").append(sdfTime.format(new java.util.Date())).append("\n");
        bill.append("Cust : ").append(billData.getCustomerName()).append("\n");
        bill.append("Tech : ").append(txtTech.getText()).append("\n");
        bill.append("--------------------------------------\n");
        bill.append(String.format("%-25s %10s\n", "SERVICE DESCRIPTION", "AMOUNT"));
        bill.append("--------------------------------------\n");

        for (Object[] row : billData.getItemsList()) {
            String itemName = row[0].toString();
            double price = Double.parseDouble(row[2].toString());
            if (itemName.length() > 24) itemName = itemName.substring(0, 22) + "..";
            bill.append(String.format("%-25s %,10.2f\n", itemName, price));
        }

        bill.append("--------------------------------------\n");
        bill.append(String.format("%-25s %,10.2f\n", "TOTAL AMOUNT:", total));
        bill.append(String.format("%-25s %,10.2f\n", "DISCOUNT:", discount));
        bill.append(String.format("%-25s %,10.2f\n", "NET AMOUNT:", netTotal));
        bill.append("--------------------------------------\n");

        if (isCalculated) {
            bill.append(String.format("%-25s %10s\n", "PAYMENT METHOD:", paymentMethod));
            bill.append(String.format("%-25s %,10.2f\n", "PAID AMOUNT:", paid));
            bill.append(String.format("%-25s %,10.2f\n", "BALANCE:", balance));
            bill.append("--------------------------------------\n");
        }
        
        bill.append("\n         Thank You, Come Again!\n\n\n");
        billShow.setText(bill.toString());
    }

    private void calculateBalance() {
        try {
            if (txtTotal.getText().isEmpty()) return;

            double total = Double.parseDouble(txtTotal.getText());
            double discount = 0;

            String discStr = cmbDiscont.getSelectedItem().toString();
            if (!discStr.equals("Select") && !discStr.isEmpty() && discStr.matches("\\d+")) {
                discount = Double.parseDouble(discStr);
            }

            double netTotal = total - discount;
            txtTotal1.setText(String.format("%.2f", netTotal));

            String payStr = txtPayAmount.getText().trim();
            double paid = 0;
            double balance = 0;
            
            if (!payStr.isEmpty()) {
                paid = Double.parseDouble(payStr);
                balance = paid - netTotal;
                txtNet.setText(String.format("%.2f", balance));
            } else {
                txtNet.setText("0.00");
            }

            generateReceipt(total, discount, netTotal, paid, balance, true);

        } catch (Exception e) {
        }
    }

    private void printAndSaveInvoice() {
        try {
            if (billShow.getText().isEmpty() || currentJobId.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No bill to print!");
                return;
            }

            int randomNumber = (int) (Math.random() * 9000) + 1000;
            String invId = "INV-" + randomNumber;

            String invSql = "INSERT INTO invoice (inv_id, job_id, date, total_amount, discount, net_amount, payment_method, payment_status) "
                    + "VALUES (?, ?, CURTIME(), ?, ?, ?, ?, 'Paid')";
            pst = db.con.prepareStatement(invSql);
            pst.setString(1, invId);
            pst.setString(2, currentJobId);
            pst.setInt(3, (int) Double.parseDouble(txtTotal.getText()));

            String discStr = cmbDiscont.getSelectedItem().toString();
            int disc = (discStr.matches("\\d+")) ? Integer.parseInt(discStr) : 0;

            pst.setInt(4, disc);
            pst.setInt(5, (int) Double.parseDouble(txtTotal1.getText()));
            pst.setString(6, paymentMethod);
            pst.executeUpdate();
            pst.close();

            String jobUpdate = "UPDATE job_table SET status = 'Completed' WHERE job_id = ?";
            pst = db.con.prepareStatement(jobUpdate);
            pst.setString(1, currentJobId);
            pst.executeUpdate();
            pst.close();

            boolean isPrinted = billShow.print();
            if (isPrinted) {
                javax.swing.JOptionPane.showMessageDialog(this, "Bill Printed & Saved Successfully!");
                this.dispose();
            }

        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving invoice: " + e.getMessage());
        }
    }
}
