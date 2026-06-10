package vehicalservicecenter;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class LoginForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginForm.class.getName());
    User user1;
    DBConnection db = new DBConnection();
    PreparedStatement pst;
    ResultSet rs;

    public LoginForm() {
        initComponents();
        loadImage();

        txtUname.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtUname = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 450));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 450));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(450, 456));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(27, 42, 71));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("WEOLCOME BACK !");

        txtUname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUname.setToolTipText("User Name");
        txtUname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        txtUname.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUname.setPreferredSize(new java.awt.Dimension(200, 40));
        txtUname.addActionListener(this::txtUnameActionPerformed);
        txtUname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnameKeyTyped(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(0, 29, 61));
        btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LogIn");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        txtPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        txtPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPass.setPreferredSize(new java.awt.Dimension(200, 40));
        txtPass.addActionListener(this::txtPassActionPerformed);
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 29, 61));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancle");
        jButton2.setBorder(null);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User Name / Email / Nic");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("L O G I N");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

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

    private void txtUnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnameKeyTyped

    }//GEN-LAST:event_txtUnameKeyTyped

    private void txtUnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnameKeyReleased

    }//GEN-LAST:event_txtUnameKeyReleased

    private void txtUnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPass.requestFocus();
        }
    }//GEN-LAST:event_txtUnameKeyPressed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtPassKeyPressed

    public static void main(String args[]) {

        UIManager.put("TextComponent.arc", 15);
        UIManager.put("Component.arc", 15);
        UIManager.put("Button.arc", 15);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblImage;
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

    private void loadImage() {
        java.net.URL imgURL = getClass().getResource("/Images/carImage.png");

        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage();

            Image scaledImg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(scaledImg));
        }
    }

}
