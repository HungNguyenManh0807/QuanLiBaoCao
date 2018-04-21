/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlibaocaokhoahoc.Model.Nguoidung;
import quanlibaocaokhoahoc.Controller.NguoidungJpaController;

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
        //list = new ArrayList<>();
        // model = (DefaultTableModel) jTable1.getModel();

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        QuanLiBaoCaoKhoaHocPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("QuanLiBaoCaoKhoaHocPU").createEntityManager();
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("QuanLiBaoCaoKhoaHocPU").createEntityManager();
        nguoidungQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT n FROM Nguoidung n");
        nguoidungList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : nguoidungQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_User = new javax.swing.JTable();
        btn_Add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_User = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        btn_Save = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        cb_role = new javax.swing.JComboBox<>();

        setTitle("User Management");
        setBackground(java.awt.Color.lightGray);
        getContentPane().setLayout(null);

        jLabel1.setText("Lists username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 20, 120, 60);

        tbl_User.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, nguoidungList, tbl_User);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${username}"));
        columnBinding.setColumnName("Username");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${password}"));
        columnBinding.setColumnName("Password");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quyenHan}"));
        columnBinding.setColumnName("Quyen Han");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tbl_User.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_UserPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_User);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 590, 140);

        btn_Add.setText("New user");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Add);
        btn_Add.setBounds(10, 0, 110, 60);

        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 240, 50, 14);

        jLabel3.setText("password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 280, 60, 14);

        txt_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UserActionPerformed(evt);
            }
        });
        getContentPane().add(txt_User);
        txt_User.setBounds(80, 240, 150, 30);

        txt_password.setMinimumSize(new java.awt.Dimension(4, 20));
        getContentPane().add(txt_password);
        txt_password.setBounds(80, 280, 150, 30);

        btn_Save.setText("Save");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Save);
        btn_Save.setBounds(30, 360, 80, 23);

        btn_Delete.setText("Delete");
        getContentPane().add(btn_Delete);
        btn_Delete.setBounds(170, 360, 80, 23);

        jLabel4.setText("Role");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 320, 50, 20);

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(510, 360, 73, 23);

        cb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User", " " }));
        cb_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_roleActionPerformed(evt);
            }
        });
        getContentPane().add(cb_role);
        cb_role.setBounds(80, 320, 100, 20);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        // TODO add your handling code here:

//        if (flag == 1) {
//            btn_Add.setEnabled(true);
//            flag = 2;
//           
//        } else {
//            btn_Add.setEnabled(false);
//        }
    }//GEN-LAST:event_btn_AddActionPerformed

    private void txt_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UserActionPerformed
        // TODO add your handling code here:
        txt_User.setEnabled(false);
    }//GEN-LAST:event_txt_UserActionPerformed

    @SuppressWarnings({"unchecked", "unchecked"})
    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed

        try {
            Nguoidung n1 = new Nguoidung();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLiBaoCaoKhoaHocPU");//dung de ket noi voi database ten lay o file persistence.xml

            NguoidungJpaController njc = new NguoidungJpaController(emf);// tao ra viec xac nhan transaction
            n1.setUsername(txt_User.getText());// lay du lieu tu textbox
            n1.setPassword(txt_password.getText());
            n1.setQuyenHan(cb_role.getSelectedIndex());
            if (txt_User.getText().equals("") || txt_password.getText().equals("") || txt_password.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please fill all before ");

            } else {

                njc.create(n1);//store into database
                JOptionPane.showMessageDialog(rootPane, "Added successfully");
                bindUserTable();

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Form_Home fh = new Form_Home();
        fh.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
    int i = 1;

//    public void showResult() {
//        Nguoidung n = list.get(list.size() - 1);// insert 
//        model.addRow(new Object[]{
//            i++, n.getUsername(), n.getPassword(), n.getQuyenHan()
//
//        });
//
//    }
    /**
     * @param args the command line arguments
     */
    public void createAndShow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(630, 450);
        this.setLocationRelativeTo(null);

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
        model.setColumnIdentifiers(new String[]{"Username", "Password", "Quyen han"});
        for (Nguoidung nguoidung : nguoiDung) {
            model.addRow(new Object[]{nguoidung.getUsername(), nguoidung.getPassword(), nguoidung.getQuyenHan()});
        }
        tbl_User.setModel(model);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager QuanLiBaoCaoKhoaHocPUEntityManager;
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Save;
    private javax.swing.JComboBox<String> cb_role;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<quanlibaocaokhoahoc.View.Nguoidung> nguoidungList;
    private javax.persistence.Query nguoidungQuery;
    private javax.swing.JTable tbl_User;
    private javax.swing.JTextField txt_User;
    private javax.swing.JTextField txt_password;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
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
