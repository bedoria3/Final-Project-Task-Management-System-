
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Student.Admin
 */
public final class SpecificTask extends javax.swing.JFrame {

    public SpecificTask() {
        initComponents();
        setLocationRelativeTo(null);

        Connect();
        showlist();
        updateCombo();
        scholarCombo();

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
        String sql = "SELECT * FROM `scholars_info` ORDER BY scholar_id ASC";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            scholar_combo.addItem("All");
            while (rs.next()) {
                scholar_combo.addItem(rs.getInt("scholar_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void scholarCombo() {
        String sql = "SELECT * FROM `scholars_info` ORDER BY scholar_id ASC";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            assigned_combo.addItem("All");
            while (rs.next()) {
                assigned_combo.addItem(rs.getInt("scholar_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void filtered(String query) {
        DefaultTableModel dm = (DefaultTableModel) taskforall_table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        taskforall_table.setRowSorter(tr);

        if (query.equals("All")) {
            taskforall_table.setRowSorter(tr);
        } else {
            tr.setRowFilter(RowFilter.regexFilter(query));
        }

    }

    private void showlist() {
        try {
            String query = "SELECT * FROM `tasks` LEFT JOIN `scholars_info` ON tasks.scholar_id = scholars_info.scholar_id WHERE tasks.scholar_id IS NOT NULL ORDER BY tasks.duedate ASC";
            int s;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_system", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                com.mysql.jdbc.ResultSetMetaData rsd = (com.mysql.jdbc.ResultSetMetaData) rs.getMetaData();
                s = rsd.getColumnCount();

                DefaultTableModel model = (DefaultTableModel) taskforall_table.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    Vector v2 = new Vector();

                    for (int i = 1; i < +s; i++) {
                        v2.add(rs.getInt("tasks.scholar_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
                        v2.add(rs.getInt("taskID"));
                        v2.add(rs.getString("title"));
                        v2.add(rs.getString("description"));
                        v2.add(rs.getString("status"));
                        v2.add(rs.getString("dueDate"));
                        v2.add(rs.getString("completed"));
                    }
                    model.addRow(v2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SpecificTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpecificTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskforall_table = new javax.swing.JTable();
        task_title = new javax.swing.JTextField();
        scholar_combo = new javax.swing.JComboBox<>();
        task_status = new javax.swing.JComboBox<>();
        title_lbl2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        task_description = new javax.swing.JTextArea();
        update = new javax.swing.JButton();
        task_duedate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        filter_completed = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        filter_status = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        assigned_combo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(93, 78, 98));
        jLabel14.setText("Passerelles Numeriques Philippines Task Management System");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 540, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(93, 78, 98));
        jLabel13.setText("Specific Task Given");
        jLabel13.setAlignmentX(0.5F);
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(93, 78, 98)));
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 1010, 30));

        taskforall_table.setAutoCreateRowSorter(true);
        taskforall_table.setBackground(new java.awt.Color(204, 255, 255));
        taskforall_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taskforall_table.setForeground(new java.awt.Color(93, 78, 98));
        taskforall_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Scholar", "Task ID", "Title", "Description", "Status", "Due Date", "Completed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        taskforall_table.setRowHeight(20);
        taskforall_table.setRowMargin(2);
        taskforall_table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        taskforall_table.setSelectionForeground(new java.awt.Color(93, 78, 98));
        taskforall_table.setShowGrid(true);
        taskforall_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taskforall_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taskforall_table);
        if (taskforall_table.getColumnModel().getColumnCount() > 0) {
            taskforall_table.getColumnModel().getColumn(1).setResizable(false);
            taskforall_table.getColumnModel().getColumn(2).setResizable(false);
            taskforall_table.getColumnModel().getColumn(3).setResizable(false);
            taskforall_table.getColumnModel().getColumn(4).setResizable(false);
            taskforall_table.getColumnModel().getColumn(5).setResizable(false);
            taskforall_table.getColumnModel().getColumn(6).setResizable(false);
        }
        taskforall_table.getAccessibleContext().setAccessibleName("");

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 610, 380));
        jPanel6.add(task_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 420, 40));

        scholar_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                scholar_comboItemStateChanged(evt);
            }
        });
        scholar_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scholar_comboActionPerformed(evt);
            }
        });
        jPanel6.add(scholar_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 220, 40));

        task_status.setBackground(new java.awt.Color(255, 204, 255));
        task_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Major Task", "Minor Task" }));
        jPanel6.add(task_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 420, 40));

        title_lbl2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title_lbl2.setForeground(new java.awt.Color(117, 98, 122));
        title_lbl2.setText("Task Status");
        jPanel6.add(title_lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        task_description.setColumns(20);
        task_description.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        task_description.setLineWrap(true);
        task_description.setRows(5);
        task_description.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(51, 0, 102))); // NOI18N
        jScrollPane2.setViewportView(task_description);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 420, 220));

        update.setBackground(new java.awt.Color(117, 98, 122));
        update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel6.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 570, 160, 40));
        jPanel6.add(task_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 190, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(117, 98, 122));
        jLabel1.setText("Due Date");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, -1, -1));

        delete.setBackground(new java.awt.Color(117, 98, 122));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel6.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 570, 170, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(117, 98, 122));
        jLabel3.setText("Filter By Scholar:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(117, 98, 122));
        jLabel7.setText("Filter Completed:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        filter_completed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "Not Yet" }));
        filter_completed.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filter_completedItemStateChanged(evt);
            }
        });
        filter_completed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_completedActionPerformed(evt);
            }
        });
        jPanel6.add(filter_completed, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 170, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(117, 98, 122));
        jLabel9.setText("Filter Status:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        filter_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Major Task", "Minor Task" }));
        filter_status.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filter_statusItemStateChanged(evt);
            }
        });
        filter_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_statusActionPerformed(evt);
            }
        });
        jPanel6.add(filter_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 180, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(117, 98, 122));
        jLabel2.setText("Assigned To:");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, -1, -1));

        jPanel6.add(assigned_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, 190, 40));

        jButton2.setText("BACK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 100, 40));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 0, 1110, 640));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(231, 231, 231)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(387, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) taskforall_table.getModel();
        int selectIndex = taskforall_table.getSelectedRow();

        int id = Integer.parseInt(model1.getValueAt(selectIndex, 1).toString());
        String title = task_title.getText();
        String description = task_description.getText();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        String taskdue = dateformat.format(task_duedate.getDate());
        String taskstatus = task_status.getSelectedItem().toString();
        String scholar_id = assigned_combo.getSelectedItem().toString().substring(0, 1);

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/task_system", "root", "");
            PreparedStatement pst = con1.prepareStatement("Update tasks set title=?,status=?,description=?,dueDate=?,scholar_id=? where taskID=?");

            pst.setString(1, title);
            pst.setString(2, taskstatus);
            pst.setString(3, description);
            pst.setString(4, taskdue);
            pst.setString(5, scholar_id);
            pst.setInt(6, id);

            pst.executeUpdate();

            showlist();
            JOptionPane.showMessageDialog(null, "Task Updated");
            task_title.setText("");
            task_description.setText("");
            task_status.setSelectedIndex(-1);
            task_duedate.setDate(null);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SpecificTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_updateActionPerformed

    private void taskforall_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskforall_tableMouseClicked

        DefaultTableModel model1 = (DefaultTableModel) taskforall_table.getModel();
        int selectIndex = taskforall_table.getSelectedRow();

        assigned_combo.setSelectedItem(model1.getValueAt(selectIndex, 0).toString());
        task_title.setText(model1.getValueAt(selectIndex, 2).toString());
        task_description.setText(model1.getValueAt(selectIndex, 3).toString());

        String status = model1.getValueAt(selectIndex, 4).toString();

        if (status.equals("Major Task")) {
            task_status.setSelectedItem("Major Task");
        } else {
            task_status.setSelectedItem("Minor Task");
        }

        try {
            int srow = taskforall_table.getSelectedRow();

            Date date = new SimpleDateFormat("dd-MM-yyyy").parse((String) model1.getValueAt(srow, 5));
            task_duedate.setDate(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_taskforall_tableMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) taskforall_table.getModel();
        int selectIndex = taskforall_table.getSelectedRow();

        int id = Integer.parseInt(model1.getValueAt(selectIndex, 1).toString());

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to remove the Record", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/task_system", "root", "");
                PreparedStatement pst = con1.prepareStatement("Delete from tasks where taskID =?");

                pst.setInt(1, id);
                pst.executeUpdate();
                showlist();

                task_title.setText("");
                task_description.setText("");
                task_status.setSelectedIndex(-1);
                task_duedate.setDate(null);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SpecificTask.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_deleteActionPerformed

    private void filter_completedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_completedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filter_completedActionPerformed

    private void filter_completedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filter_completedItemStateChanged
        String complete = filter_completed.getSelectedItem().toString();
        filtered(complete);
    }//GEN-LAST:event_filter_completedItemStateChanged

    private void filter_statusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filter_statusItemStateChanged
        String stat = filter_status.getSelectedItem().toString();
        filtered(stat);
    }//GEN-LAST:event_filter_statusItemStateChanged

    private void scholar_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scholar_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scholar_comboActionPerformed

    private void scholar_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_scholar_comboItemStateChanged

        String query1 = scholar_combo.getSelectedItem().toString();
        filtered(query1);
    }//GEN-LAST:event_scholar_comboItemStateChanged

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

    private void filter_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filter_statusActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        AllTAskGiven ED = new AllTAskGiven();
        ED.setVisible(true);
        AllTAskGiven.educatorid_lbl.setText(educatorid_lbl.getText());
        AllTAskGiven.names.setText(names.getText());

        dispose();
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(SpecificTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpecificTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpecificTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpecificTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpecificTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> assigned_combo;
    private javax.swing.JLabel dashboard;
    private javax.swing.JButton delete;
    public static javax.swing.JLabel educatorid_lbl;
    private javax.swing.JComboBox<String> filter_completed;
    private javax.swing.JComboBox<String> filter_status;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel names;
    private javax.swing.JComboBox<String> scholar_combo;
    private javax.swing.JLabel scholars;
    private javax.swing.JTextArea task_description;
    private com.toedter.calendar.JDateChooser task_duedate;
    private javax.swing.JComboBox<String> task_status;
    private javax.swing.JTextField task_title;
    private javax.swing.JTable taskforall_table;
    private javax.swing.JLabel title_lbl2;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
