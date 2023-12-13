/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import javax.swing.JOptionPane;

import event.EventLogin;
import event.PublicEvent;
import model.Model_Login;

/**
 *
 * @author Admin
 */
public class P_Login extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    public P_Login() {
        initComponents();
        CustomButtonLogin();
        init();
    }
    private void CustomButtonLogin(){
        cmdLogin.setBackground(new java.awt.Color(104, 88, 219));
        cmdLogin.setForeground(new java.awt.Color(255, 255, 255));
        cmdLogin.setText("Đăng Nhập");
        cmdLogin.setColorClick(new java.awt.Color(152, 196, 239));
        cmdLogin.setColorOver(new java.awt.Color(219, 74, 131));
        cmdLogin.setFillBorder(30);
        cmdLogin.setFocusable(false);
    }
    private void init(){

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureBox1 = new swing.PictureBox();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        txtUserName = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        cmdRegister = new javax.swing.JButton();
        cmdLogin = new swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/login.png"))); // NOI18N

        txtUserName.setBorder(null);
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        
        txtPass.setBorder(null);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(txtUserName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtPass, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(txtPass)
                .addGap(44, 44, 44))
        );

        pictureBox1.add(jLayeredPane1);
        jLayeredPane1.setBounds(660, 220, 330, 140);

        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRegisterActionPerformed(evt);
            }
        });
        pictureBox1.add(cmdRegister);
        cmdRegister.setBounds(820, 390, 73, 23);

        cmdLogin.setForeground(new java.awt.Color(44, 44, 44));
        cmdLogin.setText("Đăng Nhập");
        cmdLogin.setFont(new java.awt.Font("iCiel Mijas", 0, 18)); // NOI18N
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });
        pictureBox1.add(cmdLogin);
        cmdLogin.setBounds(730, 340, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
    	  String userName = txtUserName.getText();
    	    String password = String.valueOf(txtPass.getPassword());

    	    if (userName.isEmpty() || password.isEmpty()) {
    	    	// Hiển thị thông báo khi người dùng ko nhập userNaem or password
    	        JOptionPane.showMessageDialog(this, "Vui lòng nhập cả tên người dùng và mật khẩu!", "Thông tin thiếu sót", JOptionPane.WARNING_MESSAGE);
    	    } else {
    	    	// Tiến hành đăng nhập
    	        PublicEvent.getInstance().getEventLogin().Login(new Model_Login(userName, password));
    	    }
//      PublicEvent.getInstance().getEventLogin().Login(new Model_Login(txtUserName.getText(), String.valueOf(txtPass.getPassword())));
      
    }//GEN-LAST:event_cmdLoginActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void cmdRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRegisterActionPerformed
       PublicEvent.getInstance().getEventLogin().goRegister();
        
        
        
    }//GEN-LAST:event_cmdRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button cmdLogin;
    private javax.swing.JButton cmdRegister;
    private javax.swing.JLayeredPane jLayeredPane1;
    private swing.PictureBox pictureBox1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
