
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;    
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public final class PostTask extends javax.swing.JFrame {

    public static PostTask Instance;
    public JLabel welcomelbl;

    public PostTask() {
        initComponents();

        Connect();
        updateCombo();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/task_system", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateCombo() {
        String sql = "select * from `scholars_info`";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            assigned_combo.addItem("All");

            while (rs.next()) {
                assigned_combo.addItem(rs.getString("scholar_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        title_lbl = new javax.swing.JLabel();
        title_field = new javax.swing.JTextField();
        status_combo = new javax.swing.JComboBox<>();
        duedate_field = new com.toedter.calendar.JDateChooser();
        title_lbl1 = new javax.swing.JLabel();
        title_lbl2 = new javax.swing.JLabel();
        assigned_combo = new javax.swing.JComboBox<>();
        title_lbl3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description_textarea = new javax.swing.JTextArea();
        addTask_btn = new javax.swing.JButton();
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
        jButton1 = new javax.swing.JButton();
        educatorid_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton2.setText("BACK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(923, 10, 110, 40);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(93, 78, 98));
        jLabel14.setText("Passerelles Numeriques Philippines Task Management System");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(430, 20, 540, 30);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(93, 78, 98));
        jLabel13.setText("Tasks to Scholars");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(270, 80, 250, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(93, 78, 98));
        jLabel12.setText("__________________________________________________");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(260, 70, 760, 60);

        jPanel1.setBackground(new java.awt.Color(182, 182, 240));

        title_lbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title_lbl.setForeground(new java.awt.Color(117, 98, 122));
        title_lbl.setText("Title:");

        title_field.setBackground(new java.awt.Color(182, 182, 240));
        title_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        title_field.setForeground(new java.awt.Color(93, 78, 98));
        title_field.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(93, 78, 98)));
        title_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title_fieldActionPerformed(evt);
            }
        });

        status_combo.setBackground(new java.awt.Color(255, 204, 255));
        status_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Major Task", "Minor Task" }));
        status_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_comboActionPerformed(evt);
            }
        });

        title_lbl1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        title_lbl1.setForeground(new java.awt.Color(117, 98, 122));
        title_lbl1.setText("Task Due Date");

        title_lbl2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        title_lbl2.setForeground(new java.awt.Color(117, 98, 122));
        title_lbl2.setText("Task Status");

        title_lbl3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        title_lbl3.setForeground(new java.awt.Color(117, 98, 122));
        title_lbl3.setText("Assigned to");

        description_textarea.setColumns(20);
        description_textarea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        description_textarea.setRows(5);
        description_textarea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(51, 0, 102))); // NOI18N
        jScrollPane1.setViewportView(description_textarea);

        addTask_btn.setText("ADD TASK");
        addTask_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTask_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(title_field, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title_lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assigned_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title_lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title_lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(duedate_field, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addTask_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(332, 332, 332))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_lbl)
                    .addComponent(title_field, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title_lbl3)
                    .addComponent(title_lbl1)
                    .addComponent(title_lbl2))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(assigned_combo, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(status_combo)
                    .addComponent(duedate_field, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addTask_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(220, 0, 840, 630);

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

        jButton1.setBackground(new java.awt.Color(117, 98, 122));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(231, 231, 231)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(349, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 220, 630);

        setSize(new java.awt.Dimension(1069, 669));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        Educator_Dashboard ED = new Educator_Dashboard();
        ED.setVisible(true);
        Educator_Dashboard.educatorid_lbl.setText(educatorid_lbl.getText());
        Educator_Dashboard.names.setText(names.getText());
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void title_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_title_fieldActionPerformed

    private void addTask_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTask_btnActionPerformed

        String title = title_field.getText();
        String status = status_combo.getSelectedItem().toString();
        String assigned = assigned_combo.getSelectedItem().toString();
        String description = description_textarea.getText();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        String duedate = dateformat.format(duedate_field.getDate());
        String completed = "Not Yet";
        String educator_id = educatorid_lbl.getText();

        if (title.equals("") || status.equals("") || assigned.equals("") || description.equals("") || duedate.equals("")) {

            JOptionPane.showMessageDialog(null, "Please fill up all information needed!", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                pst = con.prepareStatement("SELECT * FROM `educators_info` WHERE educator_id='" + educator_id + "'");
                rs = pst.executeQuery();
                if (rs.next() == true) {

                    if (assigned.equals("All")) {

                        pst = con.prepareStatement("INSERT INTO tasks(educatorID, title, status, completed, description, dueDate)VALUES(?,?,?,?,?,?)");
                        pst.setString(1, educator_id);
                        pst.setString(2, title);
                        pst.setString(3, status);
                        pst.setString(4, completed);
                        pst.setString(5, description);
                        pst.setString(6, duedate);

                        int k = pst.executeUpdate();
                        if (k == 1) {
                            title_field.setText("");
                            status_combo.setSelectedIndex(0);
                            title_field.setText("");
                            title_field.setText("");
                            description_textarea.setText("");
                            duedate_field.setCalendar(null);
                            JOptionPane.showMessageDialog(this, "Task added successfully!");
                        }

                    } else {
                        pst = con.prepareStatement("INSERT INTO tasks(educatorID, title, status, completed, description, dueDate, scholar_id)VALUES(?,?,?,?,?,?,?)");
                        pst.setString(1, educator_id);
                        pst.setString(2, title);
                        pst.setString(3, status);
                        pst.setString(4, completed);
                        pst.setString(5, description);
                        pst.setString(6, duedate);
                        pst.setString(7, assigned.substring(0, 1));
                        int k = pst.executeUpdate();
                        if (k == 1) {
                            title_field.setText("");
                            status_combo.setSelectedIndex(0);
                            title_field.setText("");
                            title_field.setText("");
                            description_textarea.setText("");
                            duedate_field.setCalendar(null);
                            JOptionPane.showMessageDialog(this, "Task added successfully!");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Account does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(PostTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_addTask_btnActionPerformed

    private void status_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_status_comboActionPerformed

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
        Educator_Dashboard ED = new Educator_Dashboard();
        ED.setVisible(true);
        Educator_Dashboard.educatorid_lbl.setText(educatorid_lbl.getText());
        Educator_Dashboard.names.setText(names.getText());
        this.dispose();
    }//GEN-LAST:event_dashboardMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        Educator_ViewScholars ATG = new Educator_ViewScholars();
        ATG.setVisible(true);
        Educator_ViewScholars.educatorid_lbl.setText(educatorid_lbl.getText());
        Educator_ViewScholars.names.setText(names.getText());

        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int logout = JOptionPane.showConfirmDialog(null, "Are you sure want to log out?");
        if (logout == 0) {
            this.dispose();
            Landing_page tms = new Landing_page();
            tms.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PostTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTask_btn;
    private javax.swing.JComboBox<String> assigned_combo;
    private javax.swing.JLabel dashboard;
    private javax.swing.JTextArea description_textarea;
    private com.toedter.calendar.JDateChooser duedate_field;
    public static javax.swing.JLabel educatorid_lbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    public static javax.swing.JLabel names;
    private javax.swing.JLabel scholars;
    private javax.swing.JComboBox<String> status_combo;
    private javax.swing.JTextField title_field;
    private javax.swing.JLabel title_lbl;
    private javax.swing.JLabel title_lbl1;
    private javax.swing.JLabel title_lbl2;
    private javax.swing.JLabel title_lbl3;
    // End of variables declaration//GEN-END:variables
}
