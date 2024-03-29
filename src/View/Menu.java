/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Database.ConnectOracle;
import Database.GetConnect;
import Model.User;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JPanel;
import javax.swing.table.TableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Types;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    Connection con = GetConnect.getUserConnected();
    Statement stmt;
    ResultSet rs;
    private JPanel chillPn;
    private Object OracleTypes;

    public void getLastLogin() throws ClassNotFoundException, SQLException {
        try {
            String tk = Login.getDataUser.tenTk;
            CallableStatement cstmt = con.prepareCall("{call Get_Last_Login(?, ?)}");

            // Thiết lập đối số vào stored procedure
            cstmt.setString(1, tk.toUpperCase());
            cstmt.registerOutParameter(2, Types.TIMESTAMP);

            cstmt.execute();
            txtLastLogin.setText(cstmt.getTimestamp(2) + "");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }

    public void getDataTable() throws ClassNotFoundException, SQLException {
        try {
            String sql = "select diemxuatphat, diemden, thoigianxuatphat, thoigianden, giave from QUOC.CHUYENDI";
            stmt = con.createStatement();
            //pst = con.prepareStatement("select diemxuatphat, diemden, thoigianxuatphat, thoigianden, giave from chuyendi");
            try {
                rs = stmt.executeQuery(sql);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "Phiên bản hết hạn !");
                this.setVisible(false);
                Login lg = new Login();
                lg.setVisible(true);
            }
            DefaultTableModel model = (DefaultTableModel) tblChuyenDi.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("DiemXuatPhat"),
                    rs.getString("DiemDen"),
                    rs.getTimestamp("ThoiGianXuatPhat"),
                    rs.getTimestamp("ThoiGianDen"),
                    rs.getBigDecimal("GiaVe")
                });
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }

    }

    public Menu() throws SQLException, ClassNotFoundException {
        initComponents();
        parentPN.removeAll();
        parentPN.add(pnHome);
        parentPN.repaint();
        parentPN.revalidate();
        txtNameU.setText(Login.getDataUser.tenTk);
        getLastLogin();
    }

    public static boolean logoutUser(String username) {
        try {
            //dùng để đăng xuất
            String call = "{ call kill_user_sessions(?) }";
            try (Connection conn = ConnectOracle.getConnecOracle()) {
                try (CallableStatement cstmt = conn.prepareCall(call)) {
                    cstmt.setString(1, username.toUpperCase());
                    cstmt.execute();
                    JOptionPane.showMessageDialog(new JFrame(), "Đăng xuất thành công", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(new JFrame(), "Đăng xuất thất bại1", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Đăng xuất thất bại2", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        btnDX = new javax.swing.JButton();
        btnCD = new javax.swing.JButton();
        btnNhatKy = new javax.swing.JButton();
        btnGiaoDich = new javax.swing.JButton();
        btnQL = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pnAva = new javax.swing.JPanel();
        btnNhatKy1 = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        txtNameU = new javax.swing.JLabel();
        txtLastLogin = new javax.swing.JLabel();
        parentPN = new javax.swing.JPanel();
        pnChuyenDi = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChuyenDi = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        pnNhatKy = new javax.swing.JPanel();
        pnHome = new javax.swing.JPanel();
        btnTBS = new javax.swing.JButton();
        btnDTF = new javax.swing.JButton();
        lbUsername = new javax.swing.JLabel();
        pnCartHome = new javax.swing.JPanel();
        pnDTF = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDTF = new javax.swing.JTable();
        pnTBS = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTBS = new javax.swing.JTable();
        lbTableSpace = new javax.swing.JLabel();
        txtTbsName = new javax.swing.JTextField();
        lbFile = new javax.swing.JLabel();
        btnFolder = new javax.swing.JButton();
        txtFolder = new javax.swing.JTextField();
        btnAddTbs = new javax.swing.JButton();
        btnXemTbs = new javax.swing.JButton();
        lbSize = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        btnAddDTF = new javax.swing.JButton();
        cbbUserName = new javax.swing.JComboBox<>();
        btnAlTbs = new javax.swing.JButton();
        btnDropTbs = new javax.swing.JButton();
        btnDTFToTBS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        btnDX.setText("Đăng xuất");
        btnDX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDXActionPerformed(evt);
            }
        });

        btnCD.setText("Chuyến đi");
        btnCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCDActionPerformed(evt);
            }
        });

        btnNhatKy.setText("Thông tin xe");
        btnNhatKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhatKyActionPerformed(evt);
            }
        });

        btnGiaoDich.setText("Giao dịch");

        btnQL.setText("Quàn lý khách hàng");
        btnQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout pnAvaLayout = new javax.swing.GroupLayout(pnAva);
        pnAva.setLayout(pnAvaLayout);
        pnAvaLayout.setHorizontalGroup(
            pnAvaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
        pnAvaLayout.setVerticalGroup(
            pnAvaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        btnNhatKy1.setText("Nhật ký");
        btnNhatKy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhatKy1ActionPerformed(evt);
            }
        });

        btnHome.setText("Trang chủ");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        txtNameU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNameU.setForeground(new java.awt.Color(0, 51, 255));
        txtNameU.setText("Null");
        txtNameU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNameUMouseEntered(evt);
            }
        });

        txtLastLogin.setText("Null");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnDX, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txtNameU))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNhatKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGiaoDich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNhatKy1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(pnAva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pnAva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNameU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLastLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addGap(18, 18, 18)
                .addComponent(btnCD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhatKy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhatKy1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGiaoDich)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDX)
                .addContainerGap())
        );

        parentPN.setBackground(new java.awt.Color(255, 0, 51));
        parentPN.setLayout(new java.awt.CardLayout());

        pnChuyenDi.setBackground(new java.awt.Color(204, 204, 204));

        tblChuyenDi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Điểm Đi", "Điểm Đến", "Thời Gian Đi", "Thời Gian Đến", "Giá Vé"
            }
        ));
        jScrollPane2.setViewportView(tblChuyenDi);

        jButton1.setText("play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnChuyenDiLayout = new javax.swing.GroupLayout(pnChuyenDi);
        pnChuyenDi.setLayout(pnChuyenDiLayout);
        pnChuyenDiLayout.setHorizontalGroup(
            pnChuyenDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
            .addGroup(pnChuyenDiLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnChuyenDiLayout.setVerticalGroup(
            pnChuyenDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChuyenDiLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        parentPN.add(pnChuyenDi, "card3");

        pnNhatKy.setBackground(new java.awt.Color(51, 0, 255));

        javax.swing.GroupLayout pnNhatKyLayout = new javax.swing.GroupLayout(pnNhatKy);
        pnNhatKy.setLayout(pnNhatKyLayout);
        pnNhatKyLayout.setHorizontalGroup(
            pnNhatKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnNhatKyLayout.setVerticalGroup(
            pnNhatKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        parentPN.add(pnNhatKy, "card2");

        btnTBS.setText("Các Tablespace");
        btnTBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTBSActionPerformed(evt);
            }
        });

        btnDTF.setText("Các Datafile");
        btnDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDTFActionPerformed(evt);
            }
        });

        lbUsername.setText("Tên người dùng:  ");

        pnCartHome.setLayout(new java.awt.CardLayout());

        tblDTF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên Datafile", "ID Datafile", "Tên Tablespace"
            }
        ));
        jScrollPane1.setViewportView(tblDTF);

        javax.swing.GroupLayout pnDTFLayout = new javax.swing.GroupLayout(pnDTF);
        pnDTF.setLayout(pnDTFLayout);
        pnDTFLayout.setHorizontalGroup(
            pnDTFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        pnDTFLayout.setVerticalGroup(
            pnDTFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );

        pnCartHome.add(pnDTF, "card3");

        tblTBS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên Tablespace", "Têm Datafile"
            }
        ));
        tblTBS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTBSMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTBS);

        javax.swing.GroupLayout pnTBSLayout = new javax.swing.GroupLayout(pnTBS);
        pnTBS.setLayout(pnTBSLayout);
        pnTBSLayout.setHorizontalGroup(
            pnTBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        pnTBSLayout.setVerticalGroup(
            pnTBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );

        pnCartHome.add(pnTBS, "card2");

        lbTableSpace.setText("Tên Tablespace: ");

        lbFile.setText("Tên file");

        btnFolder.setText("Chọn đường dẫn");
        btnFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFolderActionPerformed(evt);
            }
        });

        btnAddTbs.setText("Thêm Tablespace");
        btnAddTbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTbsActionPerformed(evt);
            }
        });

        btnXemTbs.setText("Xem Tablespace");
        btnXemTbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTbsActionPerformed(evt);
            }
        });

        lbSize.setText("Size: ");

        btnAddDTF.setText("Thêm Datafile");
        btnAddDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDTFActionPerformed(evt);
            }
        });

        cbbUserName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên người dùng" }));
        cbbUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbUserNameActionPerformed(evt);
            }
        });

        btnAlTbs.setText("Xem tất cả");
        btnAlTbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlTbsActionPerformed(evt);
            }
        });

        btnDropTbs.setText("Xóa Tablespace");
        btnDropTbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDropTbsActionPerformed(evt);
            }
        });

        btnDTFToTBS.setText("Datafile từ TBS");
        btnDTFToTBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDTFToTBSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnHomeLayout = new javax.swing.GroupLayout(pnHome);
        pnHome.setLayout(pnHomeLayout);
        pnHomeLayout.setHorizontalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCartHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnHomeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnTBS, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlTbs, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDropTbs, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHomeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTableSpace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbUserName, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSize)
                    .addComponent(txtFolder)
                    .addComponent(txtTbsName))
                .addGap(56, 56, 56)
                .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDTFToTBS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddTbs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXemTbs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddDTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
        );
        pnHomeLayout.setVerticalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHomeLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsername)
                    .addComponent(btnXemTbs)
                    .addComponent(cbbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTableSpace)
                    .addComponent(txtTbsName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddTbs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFile)
                    .addComponent(txtFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSize)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDTF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDTFToTBS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(pnCartHome, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTBS)
                    .addComponent(btnDTF)
                    .addComponent(btnAlTbs)
                    .addComponent(btnDropTbs))
                .addGap(19, 19, 19))
        );

        parentPN.add(pnHome, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(parentPN, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDXActionPerformed
        // TODO add your handling code here:
        String tk = Login.getDataUser.tenTk;
        boolean check = logoutUser(tk);
        if (check == true) {
            this.setVisible(false);
            Login lg = new Login();
            lg.setVisible(true);
            System.exit(0);
        }
    }//GEN-LAST:event_btnDXActionPerformed

    private void btnNhatKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhatKyActionPerformed
        parentPN.removeAll();
        parentPN.add(pnNhatKy);
        parentPN.repaint();
        parentPN.revalidate();
    }//GEN-LAST:event_btnNhatKyActionPerformed

    private void btnCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCDActionPerformed
        parentPN.removeAll();
        parentPN.add(pnChuyenDi);
        parentPN.repaint();
        parentPN.revalidate();
        try {
            getDataTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCDActionPerformed

    private void btnNhatKy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhatKy1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhatKy1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosing

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        parentPN.removeAll();
        parentPN.add(pnHome);
        parentPN.repaint();
        parentPN.revalidate();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFolderActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            txtFolder.setText(path);
        }
    }//GEN-LAST:event_btnFolderActionPerformed

    private void loadDataTablespace() throws ClassNotFoundException {
        String username = (String) cbbUserName.getSelectedItem();
        try {
            String Call = "{call xem_tbs_dtf_user(?, ?)}";
            try (CallableStatement callableStatement = con.prepareCall(Call)) {
                callableStatement.setString(1, username);
                callableStatement.registerOutParameter(2, java.sql.Types.REF_CURSOR);
                callableStatement.execute();

                try (ResultSet rs = (ResultSet) callableStatement.getObject(2)) {
                    // Assuming your JTable variable name is jTable1
                    DefaultTableModel model = (DefaultTableModel) tblTBS.getModel();
                    while (model.getRowCount() > 0) {
                        model.removeRow(0);
                    }
                    Object[] row = new Object[2];
                    while (rs.next()) {
                        row[0] = rs.getString("tablespace_name");
                        row[1] = rs.getString("file_name");
                        model.addRow(row);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void btnTBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTBSActionPerformed
        // TODO add your handling code here:
        pnCartHome.removeAll();
        pnCartHome.add(pnTBS);
        pnCartHome.repaint();
        pnCartHome.revalidate();
        try {
            loadDataTablespace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTBSActionPerformed

    private void loadDataFile() throws ClassNotFoundException {
        String username = (String) cbbUserName.getSelectedItem();
        try {
            CallableStatement cstmt = con.prepareCall("{call hien_thi_datafiles_chi_tiet(?, ?)}");
            cstmt.setString(1, username);
            cstmt.registerOutParameter(2, java.sql.Types.REF_CURSOR);

            // Thực thi stored procedure
            cstmt.execute();

            // Nhận kết quả từ tham số đầu ra
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            DefaultTableModel model = (DefaultTableModel) tblDTF.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            // Thêm dữ liệu từ ResultSet vào DefaultTableModel
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("file_name"), rs.getInt("file_id"), rs.getString("tablespace_name")});
            }

            // Đóng tất cả các tài nguyên
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void btnDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDTFActionPerformed
        // TODO add your handling code here:
        pnCartHome.removeAll();
        pnCartHome.add(pnDTF);
        pnCartHome.repaint();
        pnCartHome.revalidate();
        try {
            loadDataFile();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDTFActionPerformed

    private void btnXemTbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTbsActionPerformed
        // TODO add your handling code here:
        try {
            String userName = (String) cbbUserName.getSelectedItem();
            con = ConnectOracle.getUserConnected();
            try (CallableStatement stmtEnable = con.prepareCall("{call dbms_output.enable(?) }")) {
                stmtEnable.setInt(1, 10000); // Set buffer size
                stmtEnable.execute();
            }
            try (CallableStatement stmtCall = con.prepareCall("{call xem_tablespaces_cua_user(?)}")) {
                stmtCall.setString(1, userName);
                stmtCall.execute();

                // Retrieve DBMS_OUTPUT
                try (OracleCallableStatement stmtOutput = (OracleCallableStatement) con.prepareCall("{call dbms_output.get_line(?,?)}")) {
                    stmtOutput.registerOutParameter(1, java.sql.Types.VARCHAR);
                    stmtOutput.registerOutParameter(2, java.sql.Types.INTEGER);
                    int status = 0;
                    while (status == 0) {
                        stmtOutput.execute();
                        String line = stmtOutput.getString(1);
                        status = stmtOutput.getInt(2);
                        if (line != null && status == 0) {
                            System.out.println(line);
                            JOptionPane.showMessageDialog(new JFrame(), line, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }//GEN-LAST:event_btnXemTbsActionPerformed

    private void addDatafileToTablespace() throws ClassNotFoundException {
        String tablespaceName = txtTbsName.getText();
        String datafilePath = txtFolder.getText();
        String size = txtSize.getText();

        try {
            String sql = "{CALL them_datafile_vao_tablespace(?, ?, ?)}";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, tablespaceName);
            stmt.setString(2, datafilePath);
            stmt.setString(3, size);
            stmt.execute();
            JOptionPane.showMessageDialog(this, "Thêm thành công data file.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    private void btnAddDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDTFActionPerformed
        try {
            // TODO add your handling code here:
            addDatafileToTablespace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddDTFActionPerformed

    private void createTablespace() throws ClassNotFoundException {
        String tablespaceName = txtTbsName.getText();
        String datafileNames = txtFolder.getText();
        String sizes = txtSize.getText();

        try {
            String sql = "{CALL tao_tablespace1(?, ?, ?)}";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, tablespaceName);
            stmt.setString(2, datafileNames);
            stmt.setString(3, sizes);
            stmt.execute();
            JOptionPane.showMessageDialog(this, "Tạo thành công Tablespace.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    private void btnAddTbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTbsActionPerformed
        try {
            // TODO add your handling code here:
            createTablespace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddTbsActionPerformed

    private void dropTablespace() throws ClassNotFoundException {
        String tablespaceName = txtTbsName.getText();
        try {
            String sql = "{CALL Drop_Tablespace(?)}";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, tablespaceName);
            stmt.execute();
            JOptionPane.showMessageDialog(this, "Xóa thành công Tablespace.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    private void btnDropTbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropTbsActionPerformed
        try {
            // TODO add your handling code here:
            String nametbs = txtTbsName.getText();
            if (nametbs.contains("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Hãy điền tên Tablespace!", "WARNING", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int dialogButton = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc muốn xóa?", "WARNING", JOptionPane.YES_NO_OPTION);
                if (dialogButton == JOptionPane.YES_OPTION) {
                    dropTablespace();
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDropTbsActionPerformed

    private void loadAllDataTablespace() throws ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) tblTBS.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        try {
            try (CallableStatement cstmt = con.prepareCall("{call sys.GetAllTablespaces(?)}")) {
                cstmt.registerOutParameter(1, java.sql.Types.REF_CURSOR);
                cstmt.execute();

                try (ResultSet rs = (ResultSet) cstmt.getObject(1)) {

                    Object[] row = new Object[2];
                    while (rs.next()) {
                        row[0] = rs.getString("tablespace_name");
                        model.addRow(row);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void btnAlTbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlTbsActionPerformed
        // TODO add your handling code here:
        pnCartHome.removeAll();
        pnCartHome.add(pnTBS);
        pnCartHome.repaint();
        pnCartHome.revalidate();
        try {
            loadAllDataTablespace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlTbsActionPerformed

    private void tblTBSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTBSMouseClicked
        // TODO add your handling code here:
        int index = tblTBS.getSelectedRow();
        TableModel model = tblTBS.getModel();
        String nameTBS = model.getValueAt(index, 0).toString();
        txtTbsName.setText(nameTBS);
    }//GEN-LAST:event_tblTBSMouseClicked

    private void loadDataFileToTBS() throws ClassNotFoundException {
        String tbsName = txtTbsName.getText();
        DefaultTableModel model = (DefaultTableModel) tblDTF.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        try {
            CallableStatement cstmt = con.prepareCall("{call GetDTF_To_TBS(?, ?)}");
            cstmt.setString(1, tbsName);
            cstmt.registerOutParameter(2, java.sql.Types.REF_CURSOR);

            // Thực thi stored procedure
            cstmt.execute();

            // Nhận kết quả từ tham số đầu ra
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            // Thêm dữ liệu từ ResultSet vào DefaultTableModel
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("file_name"), rs.getInt("file_id"), rs.getString("tablespace_name")});
            }

            // Đóng tất cả các tài nguyên
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void btnDTFToTBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDTFToTBSActionPerformed
        pnCartHome.removeAll();
        pnCartHome.add(pnDTF);
        pnCartHome.repaint();
        pnCartHome.revalidate();
        try {
            // TODO add your handling code here:
            loadDataFileToTBS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDTFToTBSActionPerformed

    private void txtNameUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameUMouseClicked
        // TODO add your handling code here:
        chillPn = new pnPrUser();
        parentPN.removeAll();
        parentPN.add(chillPn);
        parentPN.repaint();
        parentPN.revalidate();
    }//GEN-LAST:event_txtNameUMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // Kết nối đến cơ sở dữ liệu Oracle
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl1", "quoc", "123123");

            // Thực hiện truy vấn để lấy dữ liệu âm thanh từ cơ sở dữ liệu
            PreparedStatement statement = connection.prepareStatement("SELECT sound FROM audios WHERE id = 2");

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Lấy dữ liệu âm thanh từ trường LOB trong cơ sở dữ liệu
                byte[] audioBytes = resultSet.getBytes("sound");
                ByteArrayInputStream bis = new ByteArrayInputStream(audioBytes);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bis);

                // Tạo Clip và phát âm thanh
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }

            // Đóng các tài nguyên
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbUserNameActionPerformed

    String filename = null;
    byte[] person_image = null;
    private void btnQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLActionPerformed
        // TODO add your handling code here:
        chillPn = new pnAllUser();
        parentPN.removeAll();
        parentPN.add(chillPn);
        parentPN.repaint();
        parentPN.revalidate();
    }//GEN-LAST:event_btnQLActionPerformed

    private void txtNameUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameUMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameUMouseEntered

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDTF;
    private javax.swing.JButton btnAddTbs;
    private javax.swing.JButton btnAlTbs;
    private javax.swing.JButton btnCD;
    private javax.swing.JButton btnDTF;
    private javax.swing.JButton btnDTFToTBS;
    private javax.swing.JButton btnDX;
    private javax.swing.JButton btnDropTbs;
    private javax.swing.JButton btnFolder;
    private javax.swing.JButton btnGiaoDich;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnNhatKy;
    private javax.swing.JButton btnNhatKy1;
    private javax.swing.JButton btnQL;
    private javax.swing.JButton btnTBS;
    private javax.swing.JButton btnXemTbs;
    private javax.swing.JComboBox<String> cbbUserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFile;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbTableSpace;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JPanel parentPN;
    private javax.swing.JPanel pnAva;
    private javax.swing.JPanel pnCartHome;
    private javax.swing.JPanel pnChuyenDi;
    private javax.swing.JPanel pnDTF;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnNhatKy;
    private javax.swing.JPanel pnTBS;
    private javax.swing.JTable tblChuyenDi;
    private javax.swing.JTable tblDTF;
    private javax.swing.JTable tblTBS;
    private javax.swing.JTextField txtFolder;
    private javax.swing.JLabel txtLastLogin;
    private javax.swing.JLabel txtNameU;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtTbsName;
    // End of variables declaration//GEN-END:variables
}
