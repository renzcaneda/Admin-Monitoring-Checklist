/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaswinggui;

import General.ConnectionProvider;
import General.AttendanceList;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import javax.swing.*;




public class Attendance extends javax.swing.JFrame {
    /**/
     
      private String Name;
      private String Room;
      private String Time;
      private String Date;
      private String Status;
      private String UniqueCode;
      private String Section;
      private String Teaching;
      private String Units;
      private String Substitute;

      
     
      
    
    public Attendance() {
       
        initComponents();
        date();
        uni();
        showAttendance();
        //sample sir cupal

    }
    
     public void uni(){
         Random rn = new Random();
         unitxt.setText(Integer.toString(rn.nextInt(100000000)));
     }
     
     
    public void date(){
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dd=sdf.format(d);
        txtdate.setText(dd);
        
    }
    
    private void clear(){
        txtname.setText(null);
        txtroom.setText(null);
        txttime.setText(null);
        txtsection.setText(null);
        txtTeaching.setText(null);
        txtSub.setText(null);
        txtunits.setText(null);
        
       
        
    }
    
   //===================================FUNCTION===============================================//
    
   
    
    
    
    public void showAttendance(){
         try {
            // Create the SQL query with placeholders
            String getQuery = "SELECT * FROM attendance_background";


            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(getQuery);

            statement.executeQuery();
           ResultSet resultSet = statement.executeQuery();
    
    // Process the result set as needed
    if (resultSet.next()) {
        this.Name = resultSet.getString("Name");
        this.Room = resultSet.getString("Room");
        this.Time = resultSet.getString("Time");
        this.Date = resultSet.getString("Date");
        this.Status = resultSet.getString("Status");
        this.Section = resultSet.getString("Section");
        this.Teaching = resultSet.getString("Teaching");
        this.Units = resultSet.getString("Units");
        this.Substitute = resultSet.getString("Substitute");
   

        // Display the retrieved data
        System.out.println("Name: " + this.Name);
        System.out.println("Room: " + this.Room);
        System.out.println("Time: " + this.Time);
        System.out.println("Date: " + this.Date);
        System.out.println("Status: " + this.Status);
        System.out.println("Section: " + this.Section);
        System.out.println("Teaching: " + this.Teaching);
        System.out.println("Units: " + this.Units);
        System.out.println("Substitute: " + this.Substitute);
        


        // Create a table model to store data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable2.setModel(tableModel);

        // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            if (columnName.equals("Name") || columnName.equals("Room") ||
                    columnName.equals("Time") || columnName.equals("Date")
                    || columnName.equals("Status") || columnName.equals("UniqueCode") 
                    || columnName.equals("Section") || columnName.equals("Teaching")
                    || columnName.equals("Units") || columnName.equals("Substitute")) {
                tableModel.addColumn(columnName);
            }
        }

        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } else {
        System.out.println("No matching records found.");
        JOptionPane.showMessageDialog(null, "No record found!");
    }

    // Close resources
    resultSet.close();
    statement.close();
    connection.close();

            System.out.println("Retrieved Successfully!");

        } catch (ClassNotFoundException | SQLException e) {
          JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          e.printStackTrace();
        }
    }
    
    
    //===========================================================================================//

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Addbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtroom = new javax.swing.JTextField();
        txttime = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        searchTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cb1 = new javax.swing.JComboBox<>();
        cb2 = new javax.swing.JComboBox<>();
        cb3 = new javax.swing.JComboBox<>();
        clearbtn = new javax.swing.JButton();
        cb4 = new javax.swing.JComboBox<>();
        unitxt = new javax.swing.JTextField();
        txtunits = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cb5 = new javax.swing.JComboBox<>();
        txtsection = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTeaching = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cb6 = new javax.swing.JComboBox<>();
        cb7 = new javax.swing.JComboBox<>();
        txtSub = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb8 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "student_id", "student_name", "course", "age", "grade_level", "status", "section"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN");
        setBackground(new java.awt.Color(51, 51, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(102, 102, 255));
        setPreferredSize(new java.awt.Dimension(894, 610));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Addbtn.setBackground(new java.awt.Color(102, 102, 255));
        Addbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Addbtn.setText("Add");
        Addbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 140, -1));

        updatebtn.setBackground(new java.awt.Color(102, 102, 255));
        updatebtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        getContentPane().add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 120, -1));

        deletebtn.setBackground(new java.awt.Color(102, 102, 255));
        deletebtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        getContentPane().add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 140, -1));

        exitbtn.setBackground(new java.awt.Color(102, 102, 255));
        exitbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exitbtn.setText("Logout");
        exitbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        getContentPane().add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 130, -1));

        searchButton.setBackground(new java.awt.Color(102, 102, 255));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setText("SEARCH");
        searchButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 110, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("ATTENDANCE CHECKER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 430, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Room");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Time");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Date");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        txtname.setBackground(new java.awt.Color(153, 153, 255));
        txtname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 210, -1));

        txtroom.setBackground(new java.awt.Color(153, 153, 255));
        txtroom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroomActionPerformed(evt);
            }
        });
        getContentPane().add(txtroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 210, -1));

        txttime.setBackground(new java.awt.Color(153, 153, 255));
        txttime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txttime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimeActionPerformed(evt);
            }
        });
        getContentPane().add(txttime, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 210, -1));

        txtdate.setBackground(new java.awt.Color(153, 153, 255));
        txtdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });
        getContentPane().add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 210, -1));

        searchTF.setBackground(new java.awt.Color(153, 153, 255));
        searchTF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchTF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        getContentPane().add(searchTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 250, 50));

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UniqueCode", "Name", "Room", "Section", "Time", "Date", "Status", "Teaching", "Units", "Substitute"
            }
        ));
        jTable2.setToolTipText("");
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 810, 160));

        cb1.setBackground(new java.awt.Color(153, 153, 255));
        cb1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sir Cupal", "Sir Bhabs", "Sir Labajo", "Miss Yasay", " " }));
        cb1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        getContentPane().add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 150, 30));

        cb2.setBackground(new java.awt.Color(153, 153, 255));
        cb2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "101", "102", "103", "104", " " }));
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        getContentPane().add(cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 150, 30));

        cb3.setBackground(new java.awt.Color(153, 153, 255));
        cb3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:30 AM", "8:30 AM", "9:30 AM", "10:30 AM", "11:30 AM", "12:30 PM", " " }));
        cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb3ActionPerformed(evt);
            }
        });
        getContentPane().add(cb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 150, 30));

        clearbtn.setBackground(new java.awt.Color(102, 102, 255));
        clearbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearbtn.setText("Clear Text");
        clearbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        getContentPane().add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 130, 30));

        cb4.setBackground(new java.awt.Color(153, 153, 255));
        cb4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRESENT", "ABSENT", "LATE", "EARLY" }));
        cb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb4ActionPerformed(evt);
            }
        });
        getContentPane().add(cb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 150, 30));

        unitxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitxtActionPerformed(evt);
            }
        });
        getContentPane().add(unitxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 150, -1));

        txtunits.setBackground(new java.awt.Color(153, 153, 255));
        txtunits.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtunits, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 160, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Section");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        cb5.setBackground(new java.awt.Color(153, 153, 255));
        cb5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BRILLIANT", "AFFABLE", "FAITH" }));
        cb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb5ActionPerformed(evt);
            }
        });
        getContentPane().add(cb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 150, 30));

        txtsection.setBackground(new java.awt.Color(153, 153, 255));
        txtsection.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtsection, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 210, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Substitute");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        txtTeaching.setBackground(new java.awt.Color(153, 153, 255));
        txtTeaching.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtTeaching, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Units");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        cb6.setBackground(new java.awt.Color(153, 153, 255));
        cb6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Face To Face" }));
        cb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb6ActionPerformed(evt);
            }
        });
        getContentPane().add(cb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 150, 30));

        cb7.setBackground(new java.awt.Color(153, 153, 255));
        cb7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "6", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        cb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb7ActionPerformed(evt);
            }
        });
        getContentPane().add(cb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 150, 30));

        txtSub.setBackground(new java.awt.Color(153, 153, 255));
        txtSub.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 290, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Teaching");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        cb8.setBackground(new java.awt.Color(153, 153, 255));
        cb8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sir Rio" }));
        cb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb8ActionPerformed(evt);
            }
        });
        getContentPane().add(cb8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 150, 30));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 870, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroomActionPerformed

    private void txttimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimeActionPerformed
private JFrame frame;
    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
    Login log = new Login();
        log.setVisible(true);
        log.pack();
        log.setLocationRelativeTo(null);
       if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to Logout","MySQL connector",
               JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
       {
          
           this.dispose();
       }
        
        
    }//GEN-LAST:event_exitbtnActionPerformed

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
         
         try {
            
            // Create the SQL query with placeholders
            String insertQuery = "INSERT INTO attendance_background(UniqueCode,Name,Room,Time,Date,Status,Section,Teaching,Units,Substitute) VALUES (?,?,?,?,?,?,?,?,?,?)";


            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(insertQuery);

            statement.setString(1, unitxt.getText());
            statement.setString(2, txtname.getText());
            statement.setString(3, txtroom.getText());
            statement.setString(4, txttime.getText());
            statement.setString(5, txtdate.getText());
            statement.setString(6, (String) cb4.getSelectedItem());
            statement.setString(7, txtsection.getText());
            statement.setString(8, txtTeaching.getText());
            statement.setString(9, txtunits.getText());
            statement.setString(10, txtSub.getText());
            
            
            


            
            statement.executeUpdate();
            
            this.txtname.setText("");
            this.txtroom.setText("");
            this.txttime.setText("");

            
             DefaultTableModel tableModel = new DefaultTableModel();
             jTable2.setModel(tableModel);
             
             
            
             
             
             
            showAttendance();
            
            JOptionPane.showMessageDialog(this,"Record Added");
            clear();

        } catch (ClassNotFoundException | SQLException e) {
           JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
        }
     uni();
      


       
    }//GEN-LAST:event_AddbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
    // TODO add your handling code here:
// TODO add your handling code here:
try {
    int selectedRow = jTable2.getSelectedRow();

    if (selectedRow != -1) {
        // Create the SQL query for update
        String updateQuery = "UPDATE attendance_background SET Name='"+ txtname.getText()+"', Room='"+ txtroom.getText()+"', Time='"+ txttime.getText()+"', "
        + "Date='"+txtdate.getText()+"', Status='"+cb4.getSelectedItem()+"', Section='"+txtsection.getText()+"', Teaching='"+txtTeaching.getText()+"', "
        + "Units='"+txtunits.getText()+"', Substitute='"+txtSub.getText()+"' WHERE UniqueCode='"+unitxt.getText()+"'";


        // Create a connection
        ConnectionProvider dbc = new ConnectionProvider();
        String jdbcDriver = dbc.getJdbcDriver();
        String dbConnectionURL = dbc.getDbConnectionURL();
        String dbUsername = dbc.getDbUsername();
        String dbPassword = dbc.getDbPassword();
        Class.forName(jdbcDriver);
        Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

        // Create the PreparedStatement
        Statement statement = connection.createStatement();

        // Set parameters using data from the selected row
     
        // Execute the UPDATE query
        int rowsAffected = statement.executeUpdate(updateQuery);

        if (rowsAffected > 0) {
            // Clear the input fields
            this.txtname.setText("");
            this.txtroom.setText("");
            this.txttime.setText("");

            JOptionPane.showMessageDialog(this, "Record has been successfully updated");
        } else {
            JOptionPane.showMessageDialog(this, "No record found with the given UniqueCode.");
        }

        // Refresh the table with updated data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable2.setModel(tableModel);
        showAttendance();

        JOptionPane.showMessageDialog(this, "Successfully Update");

        clear();
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to update.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
uni();

    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
       int deleteItem;
DefaultTableModel RecordTable = (DefaultTableModel) jTable2.getModel();
int selectedRow = jTable2.getSelectedRow();

// ...
// Inside the try block
try {
    if (selectedRow != -1) {
        unitxt.setText(RecordTable.getValueAt(selectedRow, 0).toString());
        deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item ", "Warning", JOptionPane.YES_NO_OPTION);

        if (deleteItem == JOptionPane.YES_OPTION) {
            // Create the SQL query with placeholders
            String deleteQuery = "DELETE FROM attendance_background WHERE UniqueCode = ?";

            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(deleteQuery);

            // Bind the parameter
            statement.setString(1, unitxt.getText().trim());
 // Corrected index to 1

            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                // Remove the selected row from the table
                RecordTable.removeRow(selectedRow);

                // Clear the input fields
                this.txtname.setText("");
                this.txtroom.setText("");
                this.txtsection.setText("");
                this.txttime.setText("");
                this.txtdate.setText("");
                this.cb4.setSelectedItem("");
                this.txtTeaching.setText("");
                this.txtunits.setText("");
                this.txtSub.setText("");

                JOptionPane.showMessageDialog(this, "Record has been successfully deleted");
            } else {
                JOptionPane.showMessageDialog(this, "No record found with the given Unique Code.");
            }

            // Close resources
            statement.close();
            connection.close();

            // Refresh the table with updated data
            showAttendance();
            date();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
// ...



    }//GEN-LAST:event_deletebtnActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        

        
         try {
    // Create the SQL query with placeholders
    String searchQuery = "SELECT * FROM attendance_background WHERE Name LIKE ? OR Room LIKE ? OR Time LIKE ? OR Date LIKE ? OR Status LIKE ? OR Section LIKE ? OR Teaching LIKE ? OR Units LIKE ? OR Substitute LIKE ? OR UniqueCode LIKE? ";
    
    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);
    
    // Create the PreparedStatement
    PreparedStatement statement = connection.prepareStatement(searchQuery);
    
    // Set search parameters
    String searchKeyword = "%" + searchTF.getText() + "%";
    for (int i = 1; i <= 10; i++) {
        statement.setString(i, searchKeyword);
    }
    
    // Execute the query
    ResultSet resultSet = statement.executeQuery();
    
    // Process the result set as needed
    if (resultSet.next()) {
        this.UniqueCode=resultSet.getString("UniqueCode");
        this.Name = resultSet.getString("Name");
        this.Room = resultSet.getString("Room");
        this.Time = resultSet.getString("Time");
        this.Date = resultSet.getString("Date");
        this.Status=resultSet.getString("Status");
        this.Section = resultSet.getString("Section");
        this.Teaching = resultSet.getString("Teaching");
        this.Units = resultSet.getString("Units");
        this.Substitute = resultSet.getString("Substitute");
        
     
 

        // Display the retrieved data
        System.out.println("UniqueCode: " + this.unitxt);
        System.out.println("Name: " + this.Name);
        System.out.println("Room: " + this.Room);
        System.out.println("Time: " + this.Time);
        System.out.println("Date: " + this.Date);
        System.out.println("Status: " + this.cb4);
         System.out.println("Section: " + this.Section);
        System.out.println("Teaching: " + this.Teaching);
        System.out.println("Units: " + this.Units);
        System.out.println("Substitute: " + this.Substitute);
        
    

        // Create a table model to store data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable2.setModel(tableModel);

        // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            if (columnName.equals("Name") || columnName.equals("Room") ||
                    columnName.equals("Time") || columnName.equals("Date")
                    || columnName.equals("Status") || columnName.equals("UniqueCode")
                    || columnName.equals("Section") || columnName.equals("Teaching")
                    || columnName.equals("Units") || columnName.equals("Substitute")) {
                tableModel.addColumn(columnName);
            }
        }

        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } else {
        System.out.println("No matching records found.");
        JOptionPane.showMessageDialog(null, "No record found!");
    }

    // Close resources
    resultSet.close();
    statement.close();
    connection.close();
} catch (ClassNotFoundException | SQLException e) {
   JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
    }//GEN-LAST:event_searchButtonActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
       String selected1=cb1.getSelectedItem().toString();
        txtname.setText(selected1);
    }//GEN-LAST:event_cb1ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        String selected2=cb2.getSelectedItem().toString();
        txtroom.setText(selected2);
    }//GEN-LAST:event_cb2ActionPerformed

    private void cb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb3ActionPerformed
        // TODO add your handling code here:
        String selected3=cb3.getSelectedItem().toString();
        txttime.setText(selected3);
    }//GEN-LAST:event_cb3ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel) jTable2.getModel();
    int SelectedRows = jTable2.getSelectedRow();
    unitxt.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
    txtname.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
    txtroom.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
    txtsection.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
    txttime.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
    txtdate.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
  cb4.setSelectedItem(RecordTable.getValueAt(SelectedRows,6).toString());
  txtTeaching.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
  txtunits.setText(RecordTable.getValueAt(SelectedRows, 8).toString());
  txtSub.setText(RecordTable.getValueAt(SelectedRows, 9).toString());
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void unitxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitxtActionPerformed
        // TODO add your handling code here:
        uni();
        
    }//GEN-LAST:event_unitxtActionPerformed

    private void cb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb4ActionPerformed

    private void cb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb5ActionPerformed
        // TODO add your handling code here:
        String selected5=cb5.getSelectedItem().toString();
        txtsection.setText(selected5);
    }//GEN-LAST:event_cb5ActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateActionPerformed

    private void cb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb6ActionPerformed
        // TODO add your handling code here:
        String selected6=cb6.getSelectedItem().toString();
        txtTeaching.setText(selected6);
    }//GEN-LAST:event_cb6ActionPerformed

    private void cb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb7ActionPerformed
        // TODO add your handling code here:
        String selected7=cb7.getSelectedItem().toString();
        txtunits.setText(selected7);
    }//GEN-LAST:event_cb7ActionPerformed

    private void cb8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb8ActionPerformed
        // TODO add your handling code here:
        String selected8=cb8.getSelectedItem().toString();
        txtSub.setText(selected8);
    }//GEN-LAST:event_cb8ActionPerformed

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
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
         
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JComboBox<String> cb3;
    private javax.swing.JComboBox<String> cb4;
    private javax.swing.JComboBox<String> cb5;
    private javax.swing.JComboBox<String> cb6;
    private javax.swing.JComboBox<String> cb7;
    private javax.swing.JComboBox<String> cb8;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTextField txtSub;
    private javax.swing.JTextField txtTeaching;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtroom;
    private javax.swing.JTextField txtsection;
    private javax.swing.JTextField txttime;
    private javax.swing.JTextField txtunits;
    private javax.swing.JTextField unitxt;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
