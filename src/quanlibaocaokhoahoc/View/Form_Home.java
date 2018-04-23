/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Hung Nguyen
 */
public class Form_Home extends javax.swing.JFrame {

    /**
     * Creates new form Form_Home
     */
    public Form_Home() {
        initComponents();
        creatAndShow();
        showDate();
        showTime();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        btn_LinkToManagement_User = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_LinkToMaagenment_Scientist = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        WhiteLine = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateLab = new javax.swing.JLabel();
        timeLab = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        btn_LinkToManagement_User.setBackground(new java.awt.Color(51, 51, 255));
        btn_LinkToManagement_User.setForeground(new java.awt.Color(255, 255, 255));
        btn_LinkToManagement_User.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\man-icon.png")); // NOI18N
        btn_LinkToManagement_User.setText("Manage User");
        btn_LinkToManagement_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LinkToManagement_UserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_LinkToManagement_User);
        btn_LinkToManagement_User.setBounds(20, 110, 210, 90);

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Button-help-icon (1).png")); // NOI18N
        jButton2.setText("Help");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        getContentPane().add(jButton2);
        jButton2.setBounds(360, 310, 90, 20);

        btn_LinkToMaagenment_Scientist.setBackground(new java.awt.Color(51, 51, 255));
        btn_LinkToMaagenment_Scientist.setForeground(new java.awt.Color(255, 255, 255));
        btn_LinkToMaagenment_Scientist.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Professor-icon.png")); // NOI18N
        btn_LinkToMaagenment_Scientist.setText("Manage Scientist");
        btn_LinkToMaagenment_Scientist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LinkToMaagenment_ScientistActionPerformed(evt);
            }
        });
        getContentPane().add(btn_LinkToMaagenment_Scientist);
        btn_LinkToMaagenment_Scientist.setBounds(20, 210, 160, 90);

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Play-Books-icon.png")); // NOI18N
        jButton4.setText("Manage Thesis");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(240, 110, 160, 90);

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Other-Power-Log-Off-Metro-icon.png")); // NOI18N
        jButton5.setText("Log out");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        getContentPane().add(jButton5);
        jButton5.setBounds(430, 210, 130, 30);

        jButton6.setBackground(new java.awt.Color(51, 51, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\setup32.png")); // NOI18N
        jButton6.setText("Set up");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(410, 110, 150, 90);

        jButton7.setBackground(new java.awt.Color(51, 51, 255));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\SEO-icon.png")); // NOI18N
        jButton7.setText("Check Duplication");
        getContentPane().add(jButton7);
        jButton7.setBounds(190, 210, 210, 90);

        jButton8.setBackground(new java.awt.Color(51, 51, 255));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Actions-help-about-icon (1).png")); // NOI18N
        jButton8.setText("About");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jButton8);
        jButton8.setBounds(460, 310, 100, 20);

        btn_exit.setBackground(new java.awt.Color(51, 51, 255));
        btn_exit.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_exit.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Shut-Down-icon.png")); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_exit);
        btn_exit.setBounds(430, 250, 130, 50);

        WhiteLine.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\White--------.png")); // NOI18N
        getContentPane().add(WhiteLine);
        WhiteLine.setBounds(0, 90, 580, 10);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 50, 0, 0);

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Login as :");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 300, 50, 30);

        jLabel4.setBackground(new java.awt.Color(153, 153, 255));
        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Actions-system-search-icon.png")); // NOI18N
        jLabel4.setText("Thesis Managenent System");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 10, 360, 50);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\blue-abstract-background.jpg")); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -10, 580, 120);

        dateLab.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        dateLab.setForeground(new java.awt.Color(0, 51, 153));
        dateLab.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        dateLab.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        dateLab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(dateLab);
        dateLab.setBounds(150, 310, 90, 20);

        timeLab.setBackground(new java.awt.Color(102, 102, 255));
        timeLab.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        timeLab.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        timeLab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(timeLab);
        timeLab.setBounds(230, 310, 90, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Admin");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(80, 300, 60, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\White--------.png")); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-10, 310, 590, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\light-blue-wallpaper-full-hd-For-Desktop-Wallpaper.jpg")); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 110, 580, 200);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-10, 80, 590, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_LinkToManagement_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LinkToManagement_UserActionPerformed
        this.setVisible(false);
        Form_ManageUser fmu = new Form_ManageUser();
        fmu.setVisible(true);
    }//GEN-LAST:event_btn_LinkToManagement_UserActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
       int p =  JOptionPane.showConfirmDialog(null, "Are you sure to exit","Exit",JOptionPane.YES_OPTION);
        if(p==0){
        System.exit(0);
        }else{
        this.setVisible(true);
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_LinkToMaagenment_ScientistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LinkToMaagenment_ScientistActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Form_Manager_Scientist fms = new Form_Manager_Scientist();
        fms.setVisible(true);
        
    }//GEN-LAST:event_btn_LinkToMaagenment_ScientistActionPerformed

    /**
     * @param args the command line arguments
     */
    public void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-YYYY");
        dateLab.setText(s.format(d));
    }

    public void showTime() {
        new javax.swing.Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date d = new  Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss: a");
                timeLab.setText(s.format(d));
            }
        }).start();
    }

    public void creatAndShow() {
        
        this.setSize(585, 375);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

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
            java.util.logging.Logger.getLogger(Form_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel WhiteLine;
    private javax.swing.JButton btn_LinkToMaagenment_Scientist;
    private javax.swing.JButton btn_LinkToManagement_User;
    private javax.swing.JButton btn_exit;
    private javax.swing.JLabel dateLab;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel timeLab;
    // End of variables declaration//GEN-END:variables
}
