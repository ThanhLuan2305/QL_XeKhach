/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import javax.swing.JOptionPane;
import Database.ConnectOracle;
import Database.GetConnect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import oracle.jdbc.OracleTypes;
import java.sql.Types;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class pnAllUser extends javax.swing.JPanel {

    /**
     * Creates new form pnAllUser
     */
        Connection con = GetConnect.getUserConnected();
     public void showDBAUsers(JTable table) {
        try  {
            // Assuming you have already created the function in the database
            CallableStatement cs = con.prepareCall("{ ? = call F_GetAllUserDBA() }");
            cs.registerOutParameter(1, OracleTypes.CURSOR); // Use the appropriate type for your database if not Oracle
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            // Prepare table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing data
            String[] columnNames = {"USERNAME", "CREATED", "EXPIRY_DATE", "ACCOUNT_STATUS", "LAST_LOGIN", "PROFILE"};
            model.setColumnIdentifiers(columnNames);

            // Populate model with data from ResultSet
            while (rs.next()) {
                Object[] row = new Object[6]; // Assuming 6 columns based on your SELECT statement
                row[0] = rs.getObject("USERNAME");
                row[1] = rs.getObject("CREATED");
                row[2] = rs.getObject("EXPIRY_DATE");
                row[3] = rs.getObject("ACCOUNT_STATUS");
                row[4] = rs.getTimestamp("LAST_LOGIN");
                row[5] = rs.getObject("PROFILE");
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error accessing Database.");
        }
    }
    public void searchDBAUsers(JTable table, String username) {
        try {
            // Assuming you have already created the function in the database
            CallableStatement cs = con.prepareCall("{ ? = call F_SearchUserDBA(?) }");
            cs.registerOutParameter(1, OracleTypes.CURSOR); // Use the appropriate type for your database if not Oracle
            cs.setString(2, username); 
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            // Prepare table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing data
            while(model.getRowCount() > 0)
                    {
                        model.removeRow(0);
                    }
            String[] columnNames = {"USERNAME", "CREATED", "EXPIRY_DATE", "ACCOUNT_STATUS", "LAST_LOGIN", "PROFILE"};
            model.setColumnIdentifiers(columnNames);

            // Populate model with data from ResultSet
            while (rs.next()) {
                Object[] row = new Object[6]; // Assuming 6 columns based on your SELECT statement
                row[0] = rs.getObject("USERNAME");
                row[1] = rs.getObject("CREATED");
                row[2] = rs.getObject("EXPIRY_DATE");
                row[3] = rs.getObject("ACCOUNT_STATUS");
                row[4] = rs.getTimestamp("LAST_LOGIN");
                row[5] = rs.getObject("PROFILE");
                model.addRow(row);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error accessing Database.");
        }
    }
    public pnAllUser() {
        initComponents();
        showDBAUsers(tblAllUser);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAllProfile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTenUser = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllUser = new javax.swing.JTable();

        btnAllProfile.setText("Tất cả Profile");
        btnAllProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllProfileActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên người dùng:");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblAllUser.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblAllUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addGap(15, 228, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        searchDBAUsers(tblAllUser, txtTenUser.getText().toString());
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnAllProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllProfile;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAllUser;
    private javax.swing.JTextField txtTenUser;
    // End of variables declaration//GEN-END:variables
}
