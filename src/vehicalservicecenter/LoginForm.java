package vehicalservicecenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginForm.class.getName());
    User user1;
    DBConnection db = new DBConnection();
    PreparedStatement pst;
    ResultSet rs;

    public LoginForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtUname = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 450));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 450));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUname.setToolTipText("User Name");
        txtUname.setBorder(null);
        txtUname.addActionListener(this::txtUnameActionPerformed);
        jPanel1.add(txtUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 186, 220, 20));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btns/login.png"))); // NOI18N
        btnLogin.setBorder(null);
        btnLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btns/login D.png"))); // NOI18N
        btnLogin.addActionListener(this::btnLoginActionPerformed);
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 110, 40));

        txtPass.setBorder(null);
        txtPass.addActionListener(this::txtPassActionPerformed);
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 220, 20));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btns/Cancle.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btns/Cancle D.png"))); // NOI18N
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, 110, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/login.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String userId = txtUname.getText();
        String pass = txtPass.getText();

        User isUser = checkUser(userId, pass);

        if (isUser != null) {
            System.out.println("User Role is: " + isUser.getRole());

            if (isUser.getRole().equalsIgnoreCase("admin")) {
                
                Admin ad = new Admin(isUser);
                ad.setVisible(true);
                this.dispose();
            } else if (isUser.getRole().equals("user")) {
                Dash dsh = new Dash(isUser);
                dsh.setVisible(true);
                this.dispose();
            }
//            JOptionPane.showMessageDialog(null, "Logging ");
        } else {
            JOptionPane.showMessageDialog(null, "Logging Failed ");
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed

    }//GEN-LAST:event_txtPassActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnameActionPerformed

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
                new LoginForm().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables

    private User checkUser(String user, String pass) {
        try {
            pst = db.con.prepareStatement("SELECT * FROM user WHERE (uName=? or nic=? or email=?) and password =?");
            pst.setString(1, user);
            pst.setString(2, user);
            pst.setString(3, user);
            pst.setString(4, pass);

            rs = pst.executeQuery();

            if (rs.next()) {
                return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8));
            }

        } catch (SQLException ex) {
            System.getLogger(LoginForm.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

}
