package phase3;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package GUI1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author Yang-mac
 */
public class POI_Report extends javax.swing.JFrame {

    /**
     * Creates new form POI_Report
     */
    public POI_Report() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("POI Report");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        
        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POI location", "City", "State", "Mold Min", "Mold Avg", "Mold Max", "AQ Min", "AQ Avg", "AQ Max", "# of data points", "Flagged?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            
            boolean[] canEdit = new boolean[] {
            		false, false,false,false,false,false,false,false,false,false,false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTable2HierarchyChanged(evt);
            }
        });

        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(346, 346, 346)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
        );

        pack();
        
        DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
		while(model.getRowCount()>0){
		      model.setRowCount(0);
		} 

        try {
		  Connection conn = null;
		  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabase",  "root", "123");
		  System.out.println(conn.toString());
		  Statement stmt = conn.createStatement();
//		  String sql = "SELECT POIlocation, City, State, min(DataValue),avg(DataValue),max(Datavalue) FROM DATAPOINT, POI WHERE DataType = 'Mold' AND POIlocation = Location GROUP BY POIlocation;";
          String sql1 = "create view m1 as Select distinct POILOCATION, Min(DataValue) as mmin, Max(DataValue) as mmax, AVG(DataValue) as mavg from DATAPOINT Where DataType = \"mold\" Group by POILOCATION;";
          String sql2 = "create view a1 as Select POILOCATION, Min(DataValue) as amin, Max(DataValue) as amax, AVG(DataValue) as aavg from DATAPOINT Where DataType = \"Air quality\" Group by POILOCATION;";
          String sql3 = "create view mfinal as select distinct p.poilocation, m1.mmin, m1.mmax, m1.mavg from m1 right join (select poilocation from datapoint) as p on p.poilocation = m1.poilocation;";
          String sql4 = "create view afinal as select distinct p.poilocation, a1.amin, a1.amax, a1.aavg from a1 right join (select poilocation from datapoint) as p on p.poilocation = a1.poilocation;";
          String sql5 = "create view co as select distinct poilocation, city,state, count(*) as counts, flagged from datapoint,poi where poilocation = location group by poilocation;";
          String sql6 = "create view stats as select mfinal.poilocation,mfinal.mmin,mfinal.mmax,mfinal.mavg,afinal.amin,afinal.amax,afinal.aavg from afinal join mfinal on mfinal.poilocation = afinal.poilocation;";
          System.out.println("query: " + sql2 );
          stmt.executeUpdate(sql1);
          stmt.executeUpdate(sql2);
          stmt.executeUpdate(sql3);
          stmt.executeUpdate(sql4);
          stmt.executeUpdate(sql5);
          stmt.executeUpdate(sql6);
          String sql7 = "select stats.poilocation, co.city, co.state, stats.mmin,stats.mavg,stats.mmax,stats.amin,stats.aavg,stats.amax, co.counts,co.flagged from stats join co on stats.poilocation = co.poilocation;";
          System.out.println("query: " + sql7 );
          ResultSet rs = stmt.executeQuery(sql7);
		  ResultSetMetaData meta = rs.getMetaData();
		  int numberOfColumns = meta.getColumnCount();
        jScrollPane2.repaint();        
        while (rs.next()){
		  System.out.println("abc");
		  Object [] rowData = new Object[numberOfColumns];
		 for (int i=0; i<rowData.length; ++i){
		      rowData[i]=rs.getObject(i+1);
		  }
		  model.addRow(rowData);
		  System.out.println(rowData);
        }  
        model.fireTableDataChanged();
        jTable2.setModel(model);

        String sql8 = "drop view m1";
        String sql9 = "drop view a1";
        String sql10 = "drop view mfinal";
        String sql11 = "drop view afinal";
        String sql12 = "drop view co";
        String sql13 = "drop view stats";
            stmt.executeUpdate(sql8);
            stmt.executeUpdate(sql9);
            stmt.executeUpdate(sql10);
            stmt.executeUpdate(sql11);
            stmt.executeUpdate(sql12);
            stmt.executeUpdate(sql13);
        conn.close();
        } catch (Exception ex) {
		  JOptionPane.showMessageDialog(this,"Error in connectivity" );
        } 
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	this.dispose();
    	try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              if ("Nimbus".equals(info.getName())) {
                  javax.swing.UIManager.setLookAndFeel(info.getClassName());
                  break;
              }
          }
      } catch (ClassNotFoundException ex) {
          java.util.logging.Logger.getLogger(OfficialFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(OfficialFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(OfficialFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(OfficialFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              new OfficialFunctionality().setVisible(true);
          }
      });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTable2HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2HierarchyChanged

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
            java.util.logging.Logger.getLogger(POI_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POI_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POI_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POI_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POI_Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
