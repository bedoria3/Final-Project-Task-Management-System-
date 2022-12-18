
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Educator_announcements extends javax.swing.JFrame {

    /**
     * Creates new form Announcements
     */
    public Educator_announcements() {
        initComponents();
        showlist();
    }

    private void showlist() {
        try {
            String query = "SELECT * FROM `announcements` LEFT JOIN `educators_info` ON announcements.educatorID = educators_info.educator_id ORDER BY announcements.datePosted DESC";
            int s;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_system", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                com.mysql.jdbc.ResultSetMetaData rsd = (com.mysql.jdbc.ResultSetMetaData) rs.getMetaData();
                s = rsd.getColumnCount();

                DefaultTableModel model = (DefaultTableModel) announcement_table.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    Vector v2 = new Vector();

                    for (int i = 1; i < +s; i++) {
                        v2.add(rs.getString("announcement"));
                        v2.add(rs.getString("datePosted"));
                        v2.add(rs.getString("educatorID") + " " + rs.getString("first_name")+ " " + rs.getString("last_name"));
                        v2.add(rs.getString("announcement_id"));
                    }
                    model.addRow(v2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TaskForAll.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaskForAll.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        announcement_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        description_textarea = new javax.swing.JTextArea();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        names = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        scholars = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        educatorid_lbl = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(93, 78, 98));
        jLabel13.setText("Announcements");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(270, 80, 250, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(93, 78, 98));
        jLabel12.setText("__________________________________________________");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(260, 70, 760, 60);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(93, 78, 98));
        jLabel14.setText("Passerelles Numeriques Philippines Task Management System");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(430, 20, 540, 30);

        jButton2.setText("BACK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(970, 10, 63, 27);

        jPanel1.setOpaque(false);

        announcement_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Announcement", "Date Posted", "Educator", "Announcement ID"
            }
        ));
        announcement_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                announcement_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(announcement_table);

        description_textarea.setColumns(20);
        description_textarea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        description_textarea.setLineWrap(true);
        description_textarea.setRows(5);
        description_textarea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(51, 0, 102))); // NOI18N
        jScrollPane2.setViewportView(description_textarea);

        update.setBackground(new java.awt.Color(117, 98, 122));
        update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(117, 98, 122));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(117, 98, 122));
        add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD ANNOUNCEMENT");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(add)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(270, 150, 730, 450);

        jPanel2.setBackground(new java.awt.Color(233, 195, 244));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(93, 78, 98));
        jLabel4.setText("Educator");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(93, 78, 98));
        jLabel5.setText("tms");

        names.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        names.setForeground(new java.awt.Color(93, 78, 98));

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        scholars.setBackground(new java.awt.Color(255, 204, 204));
        scholars.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        scholars.setForeground(new java.awt.Color(117, 98, 122));
        scholars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scholars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Vector (2).png"))); // NOI18N
        scholars.setText("Educators");
        scholars.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scholars.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scholarsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scholars, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scholars, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        dashboard.setBackground(new java.awt.Color(255, 204, 204));
        dashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dashboard.setForeground(new java.awt.Color(117, 98, 122));
        dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Vector (1).png"))); // NOI18N
        dashboard.setText("  Dashboard");
        dashboard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel8.setBackground(new java.awt.Color(255, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(117, 98, 122));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Vector.png"))); // NOI18N
        jLabel8.setText("Scholars");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jButton3.setBackground(new java.awt.Color(117, 98, 122));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(names, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(educatorid_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(names, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(educatorid_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(231, 231, 231)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(349, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 220, 630);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/image 1.png"))); // NOI18N
        getContentPane().add(back);
        back.setBounds(0, 0, 1060, 630);

        setSize(new java.awt.Dimension(1069, 669));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        Educator_Dashboard ED = new Educator_Dashboard();
        ED.setVisible(true);
        Educator_Dashboard.educatorid_lbl.setText(educatorid_lbl.getText());
        Educator_Dashboard.names.setText(names.getText());
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void scholarsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scholarsMouseClicked
        Educator_ViewEducators scholar = new Educator_ViewEducators();
        scholar.setVisible(true);
        Educator_ViewEducators.educatorid_lbl.setText(educatorid_lbl.getText());
        Educator_ViewEducators.names.setText(names.getText());
        this.dispose();
    }//GEN-LAST:event_scholarsMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        //        Educator_Dashboard ED = new Educator_Dashboard();
        //        ED.setVisible(true);
        //        this.dispose();
    }//GEN-LAST:event_dashboardMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        Educator_ViewScholars ATG = new Educator_ViewScholars();
        ATG.setVisible(true);
        Educator_ViewScholars.educatorid_lbl.setText(educatorid_lbl.getText());
        Educator_ViewScholars.names.setText(names.getText());
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int logout = JOptionPane.showConfirmDialog(null, "Are you sure want to log out?");
        if (logout == 0) {
            this.dispose();
            Landing_page tms = new Landing_page();
            tms.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void announcement_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_announcement_tableMouseClicked
        
        
        DefaultTableModel model1 = (DefaultTableModel) announcement_table.getModel();
        int selectIndex = announcement_table.getSelectedRow();

        description_textarea.setText(model1.getValueAt(selectIndex, 0).toString());
    }//GEN-LAST:event_announcement_tableMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) announcement_table.getModel();
        int selectIndex = announcement_table.getSelectedRow();

        int id = Integer.parseInt(model1.getValueAt(selectIndex, 3).toString());
        String description = description_textarea.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/task_system", "root", "");
            PreparedStatement pst = (PreparedStatement) con1.prepareStatement("Update announcements set announcement=? where announcement_id=?");

            pst.setString(1, description);
            pst.setInt(2, id);

            pst.executeUpdate();

            showlist();
            JOptionPane.showMessageDialog(null, "Announcement Updated");
            description_textarea.setText("");


        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TaskForAll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) announcement_table.getModel();
        int selectIndex = announcement_table.getSelectedRow();

        int id = Integer.parseInt(model1.getValueAt(selectIndex, 3).toString());

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to remove the Record", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/task_system", "root", "");
                PreparedStatement pst = (PreparedStatement) con1.prepareStatement("Delete from announcements where announcement_id =?");

                pst.setInt(1, id);
                pst.executeUpdate();
                showlist();
                description_textarea.setText("");

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(TaskForAll.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String description = description_textarea.getText();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/task_system", "root", "");
            java.sql.PreparedStatement pst = con1.prepareStatement("insert into announcements(educatorID,announcement)values (?,?)");

            pst.setInt(1, Integer.parseInt(educatorid_lbl.getText()));
            pst.setString(2, description);

            pst.executeUpdate();
            showlist();
            JOptionPane.showMessageDialog(null, "Announcement Added!");

            description_textarea.setText("");


        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Educator_ViewScholars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Educator_announcements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Educator_announcements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Educator_announcements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Educator_announcements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Educator_announcements().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTable announcement_table;
    private javax.swing.JLabel back;
    private javax.swing.JLabel dashboard;
    private javax.swing.JButton delete;
    private javax.swing.JTextArea description_textarea;
    public static javax.swing.JLabel educatorid_lbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel names;
    private javax.swing.JLabel scholars;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
