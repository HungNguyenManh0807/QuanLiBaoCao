/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.View;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import quanlibaocaokhoahoc.Controller.NguoidungJpaController;
import quanlibaocaokhoahoc.Model.Nguoidung;

/**
 *
 * @author Hung Nguyen
 */
public class Form_Login extends javax.swing.JFrame {

    /**
     * Creates new form Form_Login
     */
    private int checkPass = -1;

    public Form_Login() {

        initComponents();

        createAndShow();

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        checkBox_ShowPw = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(153, 153, 255));
        setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        setForeground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(null);

        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\man-icon.png")); // NOI18N
        jLabel2.setText("User*");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 80, 100, 54);

        txt_user.setBackground(new java.awt.Color(204, 204, 255));
        txt_user.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        txt_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_userActionPerformed(evt);
            }
        });
        getContentPane().add(txt_user);
        txt_user.setBounds(60, 140, 120, 25);

        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\password-icon.png")); // NOI18N
        jLabel3.setText("Password*");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 190, 120, 32);

        txt_pass.setBackground(new java.awt.Color(204, 204, 255));
        txt_pass.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
        });
        getContentPane().add(txt_pass);
        txt_pass.setBounds(60, 230, 120, 25);

        btn_login.setBackground(new java.awt.Color(255, 204, 255));
        btn_login.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\accept-icon (16.png")); // NOI18N
        btn_login.setText("Login");
        btn_login.setMargin(new java.awt.Insets(2, 12, 2, 12));
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        btn_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_loginKeyPressed(evt);
            }
        });
        getContentPane().add(btn_login);
        btn_login.setBounds(40, 290, 110, 25);

        btn_cancel.setBackground(new java.awt.Color(255, 204, 204));
        btn_cancel.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Knob-Cancel-icon.png")); // NOI18N
        btn_cancel.setText("Cancel");
        btn_cancel.setMargin(new java.awt.Insets(2, 12, 2, 12));
        btn_cancel.setName(""); // NOI18N
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
        });
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel);
        btn_cancel.setBounds(190, 290, 120, 25);

        checkBox_ShowPw.setBackground(new java.awt.Color(0, 51, 51));
        checkBox_ShowPw.setForeground(new java.awt.Color(255, 255, 204));
        checkBox_ShowPw.setText("Show Password");
        checkBox_ShowPw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox_ShowPwActionPerformed(evt);
            }
        });
        getContentPane().add(checkBox_ShowPw);
        checkBox_ShowPw.setBounds(190, 230, 130, 23);

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Login-icon.png")); // NOI18N
        jLabel1.setText("Login");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 10, 290, 70);

        jLabel4.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\elegant-blue-motion-background-animation-looped_7jtp8mml__F0000.png")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-10, -10, 470, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_userActionPerformed

    private void checkBox_ShowPwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_ShowPwActionPerformed
        // TODO add your handling code here:

        if (checkPass == -1) {
            txt_pass.setEchoChar((char) 0);// set password into visible

            checkPass = 1;

        } else {
            txt_pass.setEchoChar('*');// set password into encrypt

            checkPass = -1;
        }

    }//GEN-LAST:event_checkBox_ShowPwActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        btn_login.setEnabled(false);

        Nguoidung nguoidung = new Nguoidung();
        if (txt_user.getText().equals("") || txt_pass.getPassword().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Username and password must be filled!");
        } else if (checkLogIn() >= 1) {// ton tai nguoi dung trong cau truy van select database

            Form_Home fh = new Form_Home();
            fh.setVisible(true);
            this.setVisible(false);
            btn_login.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Username or password is wrong, please try again!");
        }


    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        txt_user.setText("");
        txt_pass.setText("");

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_loginMouseClicked

    private void btn_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_loginKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_loginKeyPressed

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            

            Nguoidung nguoidung = new Nguoidung();
            if (txt_user.getText().equals("") || txt_pass.getPassword().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Username and password must be filled!");
            } else if (checkLogIn() >= 1) {// ton tai nguoi dung trong cau truy van select database
                btn_login.setEnabled(false);
                Form_Home fh = new Form_Home();
                fh.setVisible(true);
                this.setVisible(false);
                btn_login.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Username or password is wrong, please try again!");
            }

        }
    }//GEN-LAST:event_txt_passKeyPressed
    public int checkLogIn() {

        Nguoidung nguoidung = new Nguoidung();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLiBaoCaoKhoaHocPU");

        EntityManager em = emf.createEntityManager();

        String username = txt_user.getText();
        char[] password = txt_pass.getPassword();

        Query query = em.createNamedQuery("Nguoidung.checkLogin");
        query.setParameter("us", new String(username));// ep kieu ve string cho dung format cua para
        query.setParameter("ps", new String(password));
        List<Nguoidung> list = query.getResultList();
        int numberOfUser = list.size();
        return numberOfUser;
    }

    /**
     * 
     *
     *
     */
    public void createAndShow() {

        this.setSize(460, 372);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Login().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_login;
    private javax.swing.JCheckBox checkBox_ShowPw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
