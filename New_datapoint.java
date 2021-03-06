/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;


/**
 *
 * @author Zichen Wang
 */
public class New_datapoint extends javax.swing.JFrame {

    /**
     * Creates new form New_datapoint
     */
	
	private ArrayList<String> poi = new ArrayList<String>();
	private ArrayList<String> dataType = new ArrayList<String>();

	
    public New_datapoint() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        SimpleDateFormat dateForm = new SimpleDateFormat("hh:mm");
        jFormattedTextField1 = new javax.swing.JFormattedTextField(dateForm);
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Add a new data point");

        jLabel2.setText("POI location name:");

        jLabel3.setText("time and date of data reading:");

        jLabel4.setText("Data type:");

        jLabel5.setText("Data value:");
        
        try {
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabase",  "root", "123");
            System.out.println(conn.toString());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM POI;"; // populates the city and state dropdowns
            System.out.println("query: " + sql );
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	String name = rs.getString("Location");
            	poi.add(name);
            }
            sql = "SELECT * FROM DATATYPE;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	String temp = rs.getString("Type");
            	dataType.add(temp);
            }
            conn.close();
            } catch (Exception ex) {
            // JOptionPane.showMessageDialog(this,"Error in connectivity" );
        }

        // populates the poi dropdown
        String[] poiName = new String[poi.size()];
        for (int i = 0; i<poi.size(); i++) {
        	poiName[i] = poi.get(i);
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(poiName));
        
        // populates the data type dropdown
        String[] type = new String[dataType.size()];
        for (int i = 0; i<dataType.size(); i++) {
        	type[i] = dataType.get(i);
        }
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(type));

        
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        dateChooserCombo1.setCalendarPreferredSize(new java.awt.Dimension(500, 500));
        try {
            dateChooserCombo1.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2017, 3, 17),
                new java.util.GregorianCalendar(2017, 3, 17))));
        } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        	e1.printStackTrace();
        }

    jButton3.setText("add a new location");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(58, 58, 58)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel2)
                .addComponent(jLabel4)
                .addComponent(jLabel5)
                .addComponent(jLabel3))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jButton1)
                    .addGap(111, 111, 111)
                    .addComponent(jButton2)
                    .addGap(127, 127, 127))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(135, 135, 135))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addGap(29, 29, 29)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton3))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2))
            .addContainerGap(33, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Performs the buttion actions
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	this.dispose();
    	try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              if ("Nimbus".equals(info.getName())) {
                  javax.swing.UIManager.setLookAndFeel(info.getClassName());
                  break;
              }
          }
      } catch (ClassNotFoundException ex) {
          java.util.logging.Logger.getLogger(ScientistFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(ScientistFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(ScientistFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(ScientistFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              new ScientistFunctionality().setVisible(true);
          }
      });
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	String poi = jComboBox1.getSelectedItem().toString();
    	String type = jComboBox2.getSelectedItem().toString();
    	String value = jTextField1.getText();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm");
    	String date = dateChooserCombo1.getText();
    	String minutes = jFormattedTextField1.getText();
        String datemin = date + " " + minutes;
        try {
			java.util.Date st = sdf.parse(datemin);
			java.sql.Timestamp sqldate = new java.sql.Timestamp(st.getTime());
			 try {
		            Connection conn = null;
		            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabase",  "root", "123");
		            System.out.println(conn.toString());
		            Statement stmt = conn.createStatement();
		            String sql = "INSERT INTO DATAPOINT (POIlocation, DateTime, DataValue, Datatype) VALUES('"+poi+"','"+ sqldate +"','"+value+"','"+type+"');";
		            System.out.println("query: " + sql );
		            stmt.executeUpdate(sql);
		            conn.close();
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(this,"Error in connectivity" );
		        }
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        
    	this.dispose();
    	try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              if ("Nimbus".equals(info.getName())) {
                  javax.swing.UIManager.setLookAndFeel(info.getClassName());
                  break;
              }
          }
      } catch (ClassNotFoundException ex) {
          java.util.logging.Logger.getLogger(ScientistFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(ScientistFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(ScientistFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(ScientistFunctionality.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              new ScientistFunctionality().setVisible(true);
          }
      });
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	this.setVisible(false);
    	try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              if ("Nimbus".equals(info.getName())) {
                  javax.swing.UIManager.setLookAndFeel(info.getClassName());
                  break;
              }
          }
      } catch (ClassNotFoundException ex) {
          java.util.logging.Logger.getLogger(New_location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(New_location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(New_location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(New_location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              new New_location().setVisible(true);
          }
      });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
