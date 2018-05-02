/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlibaocaokhoahoc.Model.Nguoidung;
import quanlibaocaokhoahoc.Controller.NguoidungJpaController;
import quanlibaocaokhoahoc.Controller.exceptions.NonexistentEntityException;

/**
 *
 * @author Hung Nguyen
 */
public class Form_ManageUser extends javax.swing.JFrame {

    /**
     * Creates new form Form_Manage
     */
    //private ArrayList<Nguoidung> list;
    //DefaultTableModel model;
    private int flag = 1;

    public Form_ManageUser() {
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

        jPanel1 = new javax.swing.JPanel();
        cb_role = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        txt_User = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Save = new javax.swing.JButton();
        btn_Edit = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_Close = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_Add = new javax.swing.JButton();
        btn_AttachIcon = new javax.swing.JButton();
        lb_Avatar = new javax.swing.JLabel();
        txt_Image = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_User = new javax.swing.JTable();

        setTitle("User Management");
        setBackground(java.awt.Color.lightGray);
        getContentPane().setLayout(null);

        jPanel1.setBackground(java.awt.Color.lightGray);
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        cb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User", " " }));
        cb_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_roleActionPerformed(evt);
            }
        });
        jPanel1.add(cb_role);
        cb_role.setBounds(100, 150, 100, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Role");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 150, 50, 20);

        txt_password.setMinimumSize(new java.awt.Dimension(4, 20));
        jPanel1.add(txt_password);
        txt_password.setBounds(100, 100, 180, 30);

        txt_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UserActionPerformed(evt);
            }
        });
        jPanel1.add(txt_User);
        txt_User.setBounds(100, 30, 180, 30);

        jLabel2.setBackground(java.awt.Color.lightGray);
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 20, 110, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 80, 60, 17);

        btn_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlibaocaokhoahoc/View/Save-icon green.png"))); // NOI18N
        btn_Save.setText("Save");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Save);
        btn_Save.setBounds(340, 20, 100, 30);

        btn_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlibaocaokhoahoc/View/edit-icon.png"))); // NOI18N
        btn_Edit.setText("Edit");
        btn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Edit);
        btn_Edit.setBounds(340, 80, 100, 30);

        btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlibaocaokhoahoc/View/Delete-icon.png"))); // NOI18N
        btn_Delete.setText("Delete");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Delete);
        btn_Delete.setBounds(340, 140, 100, 30);

        btn_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlibaocaokhoahoc/View/Button-Close-icon 16.png"))); // NOI18N
        btn_Close.setText("Close");
        btn_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CloseActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Close);
        btn_Close.setBounds(480, 180, 85, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(6, 330, 610, 220);

        jPanel2.setBackground(java.awt.Color.lightGray);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        btn_Add.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\users-add-icon.png")); // NOI18N
        btn_Add.setText("New user");
        btn_Add.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Add);
        btn_Add.setBounds(10, 20, 120, 40);

        btn_AttachIcon.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\Documents-icon.png")); // NOI18N
        btn_AttachIcon.setText("Attach");
        btn_AttachIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_AttachIcon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_AttachIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AttachIconActionPerformed(evt);
            }
        });
        jPanel2.add(btn_AttachIcon);
        btn_AttachIcon.setBounds(390, 280, 90, 25);

        lb_Avatar.setForeground(java.awt.Color.lightGray);
        lb_Avatar.setIcon(new javax.swing.ImageIcon("E:\\QuanLiBaoCao\\icon file\\ed sheeran.jpg")); // NOI18N
        lb_Avatar.setAlignmentY(0.0F);
        lb_Avatar.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        lb_Avatar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lb_Avatar.setMaximumSize(new java.awt.Dimension(230, 210));
        lb_Avatar.setMinimumSize(new java.awt.Dimension(230, 210));
        jPanel2.add(lb_Avatar);
        lb_Avatar.setBounds(390, 88, 200, 190);
        jPanel2.add(txt_Image);
        txt_Image.setBounds(510, 280, 90, 25);

        jPanel3.setBackground(java.awt.Color.lightGray);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("List Users"));
        jPanel3.setLayout(null);

        tbl_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_User.getTableHeader().setReorderingAllowed(false);
        tbl_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_UserMouseClicked(evt);
            }
        });
        tbl_User.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_UserPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_User);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 340, 200);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 70, 360, 230);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(6, 10, 610, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        // TODO add your handling code here:
        btn_Save.setEnabled(true);
        txt_User.setEditable(true);
        txt_password.setEditable(true);


    }//GEN-LAST:event_btn_AddActionPerformed

    private void txt_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UserActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_UserActionPerformed

    private void clearUser() {
        txt_User.setText("");
        txt_password.setText("");
        txt_Image.setText("");
        ImageIcon icon = new ImageIcon("E:/gauavatar.jpg");
        lb_Avatar.setIcon(icon);

    }

    @SuppressWarnings({"unchecked", "unchecked"})
    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed

        try {
            Nguoidung nguoidung = new Nguoidung();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLiBaoCaoKhoaHocPU");//dung de ket noi voi database ten lay o file persistence.xml

            NguoidungJpaController controller = new NguoidungJpaController(emf);// tao ra viec xac nhan transaction
            nguoidung.setUsername(txt_User.getText());// lay du lieu tu textbox
            nguoidung.setPassword(txt_password.getText());
            nguoidung.setQuyenHan(cb_role.getSelectedIndex());
            nguoidung.setAvatar(txt_Image.getText());

            if (txt_User.getText().equals("") || txt_password.getText().equals("") || txt_password.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please fill all before ");

            } else {

                controller.create(nguoidung);//store into database
                JOptionPane.showMessageDialog(rootPane, "Added successfully");
//                btn_Save.setEnabled(false);
                txt_User.setEditable(false);
                txt_password.setEditable(false);

                bindUserTable();
                clearUser();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btn_SaveActionPerformed

    private void cb_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_roleActionPerformed

    private void tbl_UserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_UserPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tbl_UserPropertyChange

    private void btn_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Form_Home fh = new Form_Home();
        fh.setVisible(true);
    }//GEN-LAST:event_btn_CloseActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
        if (selectedUserID != -1) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLiBaoCaoKhoaHocPU");
            NguoidungJpaController controller = new NguoidungJpaController(emf);
            try {
                controller.destroy(selectedUserID);
                JOptionPane.showMessageDialog(rootPane, "Deleted successfully!");

            } catch (NonexistentEntityException ex) {
                ex.printStackTrace();
                Logger.getLogger(Form_ManageUser.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            JOptionPane.showMessageDialog(null, "You must select a row first", "Missing a row selected", JOptionPane.WARNING_MESSAGE);
        }

        clearUser();
        bindUserTable();
        txt_User.setEditable(true);
        txt_password.setEditable(true);
        selectedUserID = -1;
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void tbl_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_UserMouseClicked
        // TODO add your handling code here:
        btn_Delete.setEnabled(true);
        btn_Edit.setEnabled(true);
        txt_User.setEditable(true);
        txt_password.setEditable(true);
        int row = tbl_User.getSelectedRow();
        selectedUserID = Integer.parseInt(tbl_User.getValueAt(row, 0).toString());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLiBaoCaoKhoaHocPU");
        NguoidungJpaController controller = new NguoidungJpaController(emf);
        Nguoidung nguoidung = controller.findNguoidung(selectedUserID);
        txt_User.setText(nguoidung.getUsername());
        txt_password.setText(nguoidung.getPassword());
        txt_Image.setText(nguoidung.getAvatar());
        if (nguoidung.getAvatar().equals("")) {
            ImageIcon icon = new ImageIcon("E:/gauavatar.jpg");
            lb_Avatar.setIcon(icon);
        } else {
            File file = new File(nguoidung.getAvatar().toString());
            ImageIcon icon = new ImageIcon(file.toString());
            lb_Avatar.setIcon(icon);
        }
    }//GEN-LAST:event_tbl_UserMouseClicked

    private void btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditActionPerformed
        // TODO add your handling code here:
        if (selectedUserID != -1) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLiBaoCaoKhoaHocPU");
            NguoidungJpaController controller = new NguoidungJpaController(emf);
            Nguoidung nguoidung = controller.findNguoidung(selectedUserID);

            nguoidung.setUsername(txt_User.getText());
            nguoidung.setPassword(txt_password.getText());
            nguoidung.setQuyenHan(cb_role.getSelectedIndex());
            nguoidung.setAvatar(txt_Image.getText());
            if (txt_User.getText().equals("") || txt_password.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Missing field sername or password!");
            } else {
                try {
                    controller.edit(nguoidung);
                    JOptionPane.showMessageDialog(rootPane, "Updated successfully!");

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Logger.getLogger(Form_ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must select a row first!", "Missing a row selected!", JOptionPane.WARNING_MESSAGE);
        }

        clearUser();
        bindUserTable();


    }//GEN-LAST:event_btn_EditActionPerformed

    private void btn_AttachIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AttachIconActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            txt_Image.setText(fileName);
            ImageIcon icon = new ImageIcon(fileName);
            lb_Avatar.setIcon(icon);
        }


    }//GEN-LAST:event_btn_AttachIconActionPerformed

    /**
     * 
     */
    public void createAndShow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(635, 615);
        txt_User.setEditable(false);
        txt_password.setEditable(false);
        this.setLocationRelativeTo(null);
        bindUserTable();
        btn_Save.setEnabled(false);


        txt_Image.setEditable(false);

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_ManageUser().setVisible(true);

            }
        });
    }

    private void bindUserTable() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLiBaoCaoKhoaHocPU");
        NguoidungJpaController controller = new NguoidungJpaController(emf);
        List<Nguoidung> nguoiDung = controller.findNguoidungEntities();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Username", "Password", "Role"});
        for (Nguoidung nguoidung : nguoiDung) {
            model.addRow(new Object[]{nguoidung.getId(), nguoidung.getUsername(), nguoidung.getPassword(), nguoidung.getQuyenHan()});
        }

        tbl_User.setModel(model);
        tbl_User.getColumnModel().getColumn(0).setMinWidth(0);
        tbl_User.getColumnModel().getColumn(0).setMaxWidth(0);
        tbl_User.getColumnModel().getColumn(3).setMaxWidth(50);
        tbl_User.getColumnModel().getColumn(3).setMinWidth(30);
        tbl_User.setEditingColumn(0);
        tbl_User.setEditingRow(0);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_AttachIcon;
    private javax.swing.JButton btn_Close;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Edit;
    private javax.swing.JButton btn_Save;
    private javax.swing.JComboBox<String> cb_role;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Avatar;
    private javax.swing.JTable tbl_User;
    private javax.swing.JTextField txt_Image;
    private javax.swing.JTextField txt_User;
    private javax.swing.JTextField txt_password;
    // End of variables declaration//GEN-END:variables

    private static class ActionListenerImpl implements ActionListener {

        public ActionListenerImpl() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    int selectedUserID = -1;
}
