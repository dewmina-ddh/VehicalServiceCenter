package vehicalservicecenter;

import java.awt.CardLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        inventorybill = new javax.swing.JPanel();
        ServiceBill = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billShow = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cmbVehicles = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbDiscont = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtTotalA = new javax.swing.JTextField();
        txtPayAmount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNet = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtVNo = new javax.swing.JLabel();
        txtOwner = new javax.swing.JLabel();
        txtTech = new javax.swing.JLabel();
        btnClear1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        main.setMaximumSize(new java.awt.Dimension(800, 600));
        main.setMinimumSize(new java.awt.Dimension(800, 600));
        main.setPreferredSize(new java.awt.Dimension(800, 600));
        main.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(27, 42, 71));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 60));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 60));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(598, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        main.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        billPnael.setMaximumSize(new java.awt.Dimension(800, 540));
        billPnael.setMinimumSize(new java.awt.Dimension(800, 540));
        billPnael.setPreferredSize(new java.awt.Dimension(800, 540));
        billPnael.setLayout(new java.awt.CardLayout());

        inventorybill.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout inventorybillLayout = new javax.swing.GroupLayout(inventorybill);
        inventorybill.setLayout(inventorybillLayout);
        inventorybillLayout.setHorizontalGroup(
            inventorybillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        inventorybillLayout.setVerticalGroup(
            inventorybillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        billPnael.add(inventorybill, "card2");

        ServiceBill.setBackground(new java.awt.Color(255, 255, 255));
        ServiceBill.setMaximumSize(new java.awt.Dimension(920, 540));
        ServiceBill.setMinimumSize(new java.awt.Dimension(920, 540));
        ServiceBill.setPreferredSize(new java.awt.Dimension(920, 540));

        billShow.setColumns(20);
        billShow.setRows(5);
        billShow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        jScrollPane1.setViewportView(billShow);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ongoing Services");

        cmbVehicles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVehicles.addActionListener(this::cmbVehiclesActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel3.setText("Vehicle Number");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel4.setText("Owners Name");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel5.setText("Technician");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel6.setText("Total Amount");

        txtTotal.setForeground(new java.awt.Color(0, 153, 204));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("Discount");

        cmbDiscont.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "50", "100", "500", "1000" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("Total Amount");

        txtTotalA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTotalAMouseClicked(evt);
            }
        });

        txtPayAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPayAmountFocusGained(evt);
            }
        });
        txtPayAmount.addActionListener(this::txtPayAmountActionPerformed);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("Pay Amount");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("Net Amount");

        btnPrint.setText("Print Bill");
        btnPrint.addActionListener(this::btnPrintActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Bill Show");

        jButton1.setText("Calculate");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        txtVNo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        txtOwner.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        txtTech.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        btnClear1.setText("Clear");
        btnClear1.addActionListener(this::btnClear1ActionPerformed);

        javax.swing.GroupLayout ServiceBillLayout = new javax.swing.GroupLayout(ServiceBill);
        ServiceBill.setLayout(ServiceBillLayout);
        ServiceBillLayout.setHorizontalGroup(
            ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServiceBillLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ServiceBillLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(ServiceBillLayout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ServiceBillLayout.createSequentialGroup()
                                    .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtVNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTech, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ServiceBillLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbDiscont, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(ServiceBillLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNet))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ServiceBillLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPayAmount))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ServiceBillLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        ServiceBillLayout.setVerticalGroup(
            ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServiceBillLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(ServiceBillLayout.createSequentialGroup()
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTech, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ServiceBillLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addGap(18, 18, 18)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbDiscont, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ServiceBillLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ServiceBillLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPayAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ServiceBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ServiceBillLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 83, Short.MAX_VALUE))
        );

        billPnael.add(ServiceBill, "card3");

        main.add(billPnael, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVehiclesActionPerformed
        fetchAndGenerateServiceBill();
        txtPayAmount.requestFocus();
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
        txtTotalA.setText("");
        txtPayAmount.setText("");
        txtNet.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtTotalAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTotalAMouseClicked
        double amount = (Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter Amount!", JOptionPane.QUESTION_MESSAGE)));
        double totalP = Integer.parseInt(txtTotalA.getText());

        if (totalP > amount) {
            double net = totalP - amount;
            txtNet.setText(String.valueOf(net));
        }
    }//GEN-LAST:event_txtTotalAMouseClicked

    private void txtPayAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayAmountActionPerformed
        try {
            if (txtPayAmount.getText().trim().isEmpty()) {
                return;
            }

            double netTotal = Double.parseDouble(txtTotalA.getText());
            double paid = Double.parseDouble(txtPayAmount.getText().trim());

            double balance = paid - netTotal;
            txtNet.setText(String.format("%.2f", balance));

            double total = Double.parseDouble(txtTotal.getText());
            String discStr = cmbDiscont.getSelectedItem().toString();
            double discount = (discStr.matches("\\d+")) ? Double.parseDouble(discStr) : 0;

            generateReceipt(total, discount, netTotal, paid, balance);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid Paid Amount!");
        }
    }//GEN-LAST:event_txtPayAmountActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void txtPayAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPayAmountFocusGained
        if (txtTotalA.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please click Calculate button first!");
            cmbVehicles.requestFocus();
            return;
        }
        String[] options = {"Cash", "Card"};
        int choice = javax.swing.JOptionPane.showOptionDialog(this, "Select Payment Method:",
                "Payment Type", javax.swing.JOptionPane.DEFAULT_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0)
            paymentMethod = "Cash";
        else if (choice == 1)
            paymentMethod = "Card";
    }//GEN-LAST:event_txtPayAmountFocusGained

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
    private javax.swing.JButton btnClear1;
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
    private javax.swing.JLabel txtOwner;
    private javax.swing.JTextField txtPayAmount;
    private javax.swing.JLabel txtTech;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalA;
    private javax.swing.JLabel txtVNo;
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
            clearAllFields();
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
            rs.close();
            pst.close();

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
            rs.close();
            pst.close();

            txtTotal.setText(String.format("%.2f", totalAmount));

            txtTotalA.setText("");
            txtPayAmount.setText("");
            txtNet.setText("");
            billShow.setText("");

            this.billData = new BillStatement(cusName, totalAmount, serviceList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateReceipt(double total, double discount, double netTotal, double paid, double balance) {
        if (billData == null) {
            return;
        }
        StringBuilder bill = new StringBuilder();
        billShow.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

        java.text.SimpleDateFormat sdfDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat sdfTime = new java.text.SimpleDateFormat("hh:mm a");

        bill.append("          YOUR GARAGE NAME\n");
        bill.append("       No 123, Main Street, City\n");
        bill.append("          Tel: 071 234 5678\n");
        bill.append("--------------------------------------\n");
        bill.append("           SERVICE INVOICE\n");
        bill.append("Vehicle: ").append(cmbVehicles.getSelectedItem().toString()).append("\n");
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
            if (itemName.length() > 24) {
                itemName = itemName.substring(0, 22) + "..";
            }
            bill.append(String.format("%-25s %,10.2f\n", itemName, price));
        }

        bill.append("--------------------------------------\n");
        bill.append(String.format("%-25s %,10.2f\n", "TOTAL AMOUNT:", total));
        bill.append(String.format("%-25s %,10.2f\n", "DISCOUNT:", discount));
        bill.append(String.format("%-25s %,10.2f\n", "NET AMOUNT:", netTotal));
        bill.append("--------------------------------------\n");
        bill.append(String.format("%-25s %10s\n", "PAYMENT METHOD:", paymentMethod));
        bill.append(String.format("%-25s %,10.2f\n", "PAID AMOUNT:", paid));
        bill.append(String.format("%-25s %,10.2f\n", "BALANCE:", balance));
        bill.append("--------------------------------------\n");
        bill.append("\n         Thank You, Come Again!\n\n\n");

        billShow.setText(bill.toString());
    }

    private void calculateBalance() {
        try {
            if (txtTotal.getText().isEmpty()) {
                return;
            }

            double total = Double.parseDouble(txtTotal.getText());
            double discount = 0;

            String discStr = cmbDiscont.getSelectedItem().toString();
            if (discStr.matches("\\d+")) {
                discount = Double.parseDouble(discStr);
            }
            double netTotal = total - discount;
            txtTotalA.setText(String.format("%.2f", netTotal));

            txtPayAmount.requestFocus();

        } catch (Exception e) {
        }
    }

    private void printAndSaveInvoice() {
        try {
            if (billShow.getText().isEmpty() || currentJobId.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No bill to print!");
                return;
            }

            String updateInvSql = "UPDATE invoice SET total_amount = ?, discount = ?, net_amount = ?, "
                    + "payment_status = 'Paid', date = CURTIME() "
                    + "WHERE job_id = ?";

            pst = db.con.prepareStatement(updateInvSql);
            pst.setInt(1, (int) Double.parseDouble(txtTotal.getText()));

            String discStr = cmbDiscont.getSelectedItem().toString();
            int disc = (discStr.matches("\\d+")) ? Integer.parseInt(discStr) : 0;
            pst.setInt(2, disc);

            pst.setInt(3, (int) Double.parseDouble(txtTotalA.getText()));
            pst.setString(4, currentJobId);
            pst.executeUpdate();
            pst.close();

            String releaseTechSql = "UPDATE technician SET status = 'Available' WHERE tech_id = "
                    + "(SELECT tech_id FROM job_table WHERE job_id = ?)";
            pst = db.con.prepareStatement(releaseTechSql);
            pst.setString(1, currentJobId);
            pst.executeUpdate();
            pst.close();

            String releaseBaySql = "UPDATE bay SET status = 'Available' WHERE bay_id = "
                    + "(SELECT bay_id FROM job_table WHERE job_id = ?)";
            pst = db.con.prepareStatement(releaseBaySql);
            pst.setString(1, currentJobId);
            pst.executeUpdate();
            pst.close();

            String jobUpdate = "UPDATE job_table SET status = 'Completed' WHERE job_id = ?";
            pst = db.con.prepareStatement(jobUpdate);
            pst.setString(1, currentJobId);
            pst.executeUpdate();
            pst.close();

            boolean isPrinted = billShow.print();
            if (isPrinted) {
                javax.swing.JOptionPane.showMessageDialog(this, "Bill Paid! Technician and Bay Released Successfully!");
                btnClearActionPerformed(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void clearAllFields() {
        billShow.setText("");
        txtVNo.setText("");
        txtOwner.setText("");
        txtTech.setText("");
        txtTotal.setText("");
        txtTotalA.setText("");
        txtPayAmount.setText("");
        txtNet.setText("");
    }
}
