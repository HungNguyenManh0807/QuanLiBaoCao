/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hung Nguyen
 */
public class Form_Manager_Thesis extends javax.swing.JFrame {

    /**
     * Creates new form Form_Manage
     */
  

    public Form_Manager_Thesis() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btn_Add = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_User = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        btn_Save = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Field = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(java.awt.Color.lightGray);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Thesises", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Console", 0, 13))); // NOI18N
        jPanel1.setLayout(null);

        btn_Add.setText("Add Thesis");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Add);
        btn_Add.setBounds(570, 250, 110, 40);

        jLabel3.setText("Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 250, 60, 14);

        txt_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UserActionPerformed(evt);
            }
        });
        jPanel1.add(txt_User);
        txt_User.setBounds(20, 280, 310, 30);
        jPanel1.add(txt_password);
        txt_password.setBounds(370, 340, 170, 60);

        btn_Save.setText("Save");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Save);
        btn_Save.setBounds(570, 320, 110, 30);

        btn_Delete.setText("Delete");
        jPanel1.add(btn_Delete);
        btn_Delete.setBounds(570, 380, 110, 30);

        jLabel4.setText("Resume");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 320, 50, 20);

        jButton1.setText("print");
        jPanel1.add(jButton1);
        jButton1.setBounds(760, 40, 55, 23);

        jButton2.setText("Export to Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(590, 40, 110, 23);

        jButton3.setText("close");
        jPanel1.add(jButton3);
        jButton3.setBounds(700, 440, 80, 23);

        jLabel5.setText("Time");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(380, 240, 40, 50);

        jLabel6.setText("Url");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(370, 320, 30, 20);
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(370, 280, 170, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa hoc ki thuat", "Van Hoa", "Triet hoc" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(120, 420, 220, 20);

        jLabel2.setText("Type");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 470, 60, 14);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Luan an tien si", "Luan van thac si", "Do an tot nghiep" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(120, 460, 220, 20);

        jLabel7.setText("Field");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 430, 60, 14);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 340, 320, 60);

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
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 70, 810, 170);

        jTabbedPane1.addTab("Thesis", jPanel1);

        jPanel2.setLayout(null);

        jPanel4.setBackground(java.awt.Color.lightGray);
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Field", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Console", 0, 13))); // NOI18N
        jPanel4.setLayout(null);

        jButton4.setText("Insert");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(30, 20, 70, 23);

        jButton5.setText("Edit");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel4.add(jButton5);
        jButton5.setBounds(30, 70, 73, 23);

        jButton6.setText("Delete");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);
        jButton6.setBounds(30, 120, 70, 23);

        jLabel10.setText("Field Name");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(170, 14, 110, 20);
        jPanel4.add(jTextField1);
        jTextField1.setBounds(170, 30, 180, 80);

        jButton7.setText("Close");
        jPanel4.add(jButton7);
        jButton7.setBounds(240, 170, 100, 23);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(10, 10, 360, 200);

        tbl_Field.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_Field);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(392, 10, 430, 200);

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 33)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Mangement Thesis System");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(210, 320, 510, 130);

        jLabel9.setText("jLabel9");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(600, 50, 34, 14);

        jTabbedPane1.addTab("Field", jPanel2);

        jPanel5.setBackground(java.awt.Color.lightGray);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Console", 0, 13))); // NOI18N
        jPanel5.setLayout(null);

        jButton8.setText("Insert");
        jPanel5.add(jButton8);
        jButton8.setBounds(20, 30, 70, 23);

        jButton9.setText("Edit");
        jPanel5.add(jButton9);
        jButton9.setBounds(20, 80, 73, 23);

        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10);
        jButton10.setBounds(20, 130, 70, 23);

        jLabel11.setText("Type Name");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(170, 14, 110, 20);
        jPanel5.add(jTextField2);
        jTextField2.setBounds(170, 30, 180, 80);

        jButton11.setText("close");
        jPanel5.add(jButton11);
        jButton11.setBounds(280, 210, 57, 23);

        jButton12.setText("Close");
        jPanel5.add(jButton12);
        jButton12.setBounds(239, 160, 90, 23);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jLabel8.setBackground(new java.awt.Color(0, 51, 51));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 3, 33)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Mangement Thesis System");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Type", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 830, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int i = 1;

//    public void showResult() {
//        Nguoidung n = list.get(list.size() - 1);
//        model.addRow(new Object[]{
//            i++, n.getUsername(), n.getPassword(), n.getQuyenHan()
//
//        });
//
//    }


    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        //        if (flag == 2) {
            //            setEnabled(true);
            //            flag = 1;
            //        } else {
            //            setEnabled(false);
            //        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void txt_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UserActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        // TODO add your handling code here:
        //
        //        Nguoidung n = new Nguoidung();
        //
        //        if(txt_User.getText().equals("")||txt_password.getText().equals("")||txt_right.getText().equals("") ){
            //            JOptionPane.showMessageDialog(rootPane, "Please fill all before ");
            //
            //        }else{
            //             //n.getId(); when connection with dtb
            //        n.setUsername(txt_User.getText());
            //        n.setPassword(txt_password.getText());
            //        n.setQuyenHan(Integer.parseInt(txt_right.getText()));
            //         list.add(n);
            //        showResult();
            //        }

        //        if (flag == 1) {
            //            btn_Add.setEnabled(true);
            //            flag = 2;
            //
            //        } else {
            //            btn_Add.setEnabled(false);
            //        }
    }//GEN-LAST:event_btn_AddActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void createAndShow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setSize(840, 590);
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
            java.util.logging.Logger.getLogger(Form_Manager_Thesis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Manager_Thesis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Manager_Thesis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Manager_Thesis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Manager_Thesis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btn_Add;
    javax.swing.JButton btn_Delete;
    javax.swing.JButton btn_Save;
    javax.swing.JButton jButton1;
    javax.swing.JButton jButton10;
    javax.swing.JButton jButton11;
    javax.swing.JButton jButton12;
    javax.swing.JButton jButton2;
    javax.swing.JButton jButton3;
    javax.swing.JButton jButton4;
    javax.swing.JButton jButton5;
    javax.swing.JButton jButton6;
    javax.swing.JButton jButton7;
    javax.swing.JButton jButton8;
    javax.swing.JButton jButton9;
    javax.swing.JComboBox<String> jComboBox1;
    javax.swing.JComboBox<String> jComboBox3;
    com.toedter.calendar.JDateChooser jDateChooser1;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JPanel jPanel4;
    javax.swing.JPanel jPanel5;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JScrollPane jScrollPane4;
    javax.swing.JTabbedPane jTabbedPane1;
    javax.swing.JTable jTable2;
    javax.swing.JTable jTable3;
    javax.swing.JTextArea jTextArea1;
    javax.swing.JTextField jTextField1;
    javax.swing.JTextField jTextField2;
    javax.swing.JTable tbl_Field;
    javax.swing.JTextField txt_User;
    javax.swing.JTextField txt_password;
    // End of variables declaration//GEN-END:variables

    private static class ActionListenerImpl implements ActionListener {

        public ActionListenerImpl() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
