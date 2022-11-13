/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.jpassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhong
 */
public class customerOrder extends javax.swing.JFrame {

    /**
     * Creates new form customerOrder
     */
    DefaultListModel m = new DefaultListModel();
    
    public customerOrder() {
        initComponents();
        displayList();
    }
    
    //This method is used to display all the orderID into a List
    private void displayList()
    {
        try(BufferedReader br = new BufferedReader(new FileReader("Order.txt")))
        {   
            String information;
            while((information = br.readLine()) != null)
            {   
                String[] data = information.split(";");
                orderList.setModel(m);
                m.addElement(data[0]);
            }
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //This method is used to display customer information
    private void displayCustomer(String username)
    {
        //Read data from Customer.txt
        try(BufferedReader br = new BufferedReader(new FileReader("Customer.txt")))
        {   
            String information;
            while((information = br.readLine()) != null)
            {   
                String[] data = information.split(";");
                //Search for the username and display all his/her details
                if(data[0].equals(username))
                {
                    contactLab.setText("Contact Number: "+data[3]);
                    emailLab.setText("Email: "+data[5]);
                    addressLab.setText("Address: "+data[6]);
                    break;
                }
            }
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //This method is used to display all the order details of the customer
    private void displayOrder(String orderID)
    {   
        //Read from the Order.txt
        try(BufferedReader br = new BufferedReader(new FileReader("Order.txt")))
        {   
            String information;
            //Create ArrayList for storing the order details
            ArrayList<String> list = new ArrayList<>();
            //Create ArrayList for storing the foodIDs
            ArrayList<String> foodID = new ArrayList<>();
            //Create ArrayList for storing the food names
            ArrayList<String> name = new ArrayList<>();
            //Create ArrayList for storing the quantity of the foods ordered
            ArrayList<String> quantity = new ArrayList<>();
            //Create ArrayList for storing the price of each items
            ArrayList<String> each = new ArrayList<>();
            while((information = br.readLine()) != null)
            {   
                String[] data = information.split(";");
                if(data[0].equals(orderID))
                {   
                    //Add all the order details into a list (without user information)
                    //Add all the data start at index 5
                    for(int i=5; i<data.length;i++)
                    {
                        list.add(data[i]);
                    }
                    
                    //From the ArrayList for order details just now
                    //Get and add all the foodID into this list
                    //The foodID in the list is start at index 0 and skip 4 indexes
                    for(int f=0; f<list.size();f+=4)
                    {
                        foodID.add(list.get(f));
                    }
                    
                    //Get and add all the food name into this list
                    //The food name in the list is start at index 1 and skip 4 indexes
                    for(int f=1; f<list.size();f+=4)
                    {
                        name.add(list.get(f));
                    }
                    
                    //Get and add all the quantity into this list
                    //The quantity in the list is start at index 2 and skip 4 indexes
                    for(int f=2; f<list.size();f+=4)
                    {
                        quantity.add(list.get(f));
                    }
                    
                    //Get and add all the price of each item into this list
                    //The price in the list is start at index 3 and skip 4 indexes
                    for(int f=3; f<list.size();f+=4)
                    {
                        each.add(list.get(f));
                    }
                    //Take the elements from those ArrayList by the increasing index
                    //add those elements to the table row
                    for(int a=0;a<foodID.size();a++)
                    {
                        String eachPrice = each.get(a).substring(2);
                        float total = Float.parseFloat(eachPrice) * Integer.parseInt(quantity.get(a));
                        DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
                        model.addRow(new Object[]{foodID.get(a),name.get(a),quantity.get(a),each.get(a),"RM"+total});
                    }
                }
            }
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //This method is used to display all information about the Order
    private void displayAll()
    {
        String orderID = orderList.getSelectedValue();
        try(BufferedReader br = new BufferedReader(new FileReader("Order.txt")))
        {   
            String information;
            while((information = br.readLine()) != null)
            {   
                String[] data = information.split(";");
                if(data[0].equals(orderID))
                {
                    orderidLab.setText("Order ID: "+data[0]);
                    customernameLab.setText("Customer Name: "+data[1]);
                    totalLab.setText("Total: "+data[3]);
                    displayCustomer(data[1]);
                    if(data[2].equals("Completed"))
                    {
                        statusCombo.setSelectedItem("Completed");
                    }
                    else
                    {
                        statusCombo.setSelectedItem("Pending");
                    }
                    displayOrder(orderID);
                    break;
                }
            }
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //This method is used to reset the table
    //Which means remove all the items from the table 
    private void resetTable()
    {
        DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
    }
    
    //Thise method is used to change the status "Pending" to "Completed"
    //Update the Order.txt
    private void statusChanger()
    {
        String orderID = orderidLab.getText().substring(10);
        String status = statusCombo.getSelectedItem().toString();
        String fileName = "Order.txt";
        String tempFile = "temp.txt";   
        File oldFile = new File(fileName);
        File newFile = new File(tempFile);
        ArrayList<String> tempList = new ArrayList<>();
        
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile, true))))
        {
            try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
            {
                String information;
                while((information = br.readLine()) != null)
                {
                    String[] data = information.split(";");
                    if(data[0].equals(orderID))
                    {   
                        //If the data match with orderID
                        //Add all the data into a tempList
                        for(int d=0;d<data.length;d++)
                        {
                            tempList.add(data[d]);
                        }
                        //Remove element with index 2 in the tempList
                        //Which is the status
                        tempList.remove(2);
                        //After remove it, then add the updated status into the tempList
                        tempList.add(2,status);
                        
                        //Then write the tempList into the temp txt file
                        for(String newData : tempList)
                        {
                            pw.print(newData+";");
                        }
                        pw.println("");
                    }
                    else
                    {
                        pw.println(information);
                    }
                }
                br.close();
                pw.close();
                //Delete the old Order.txt
                oldFile.delete();
                //Create a new file
                File dump = new File(fileName);
                //Then, rename it to Order.txt for the replacement
                newFile.renameTo(dump);
            }
            catch (IOException ioe)
            {
                JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with writting a file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
        orderLab = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JList<>();
        orderidLab = new javax.swing.JLabel();
        customernameLab = new javax.swing.JLabel();
        contactLab = new javax.swing.JLabel();
        emailLab = new javax.swing.JLabel();
        addressLab = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        orderLab2 = new javax.swing.JLabel();
        statusCombo = new javax.swing.JComboBox<>();
        totalLab = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        goBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        orderLab.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        orderLab.setForeground(new java.awt.Color(255, 51, 51));
        orderLab.setText("All Customer Orders");

        jScrollPane2.setViewportView(orderList);

        orderidLab.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        orderidLab.setForeground(new java.awt.Color(0, 153, 255));
        orderidLab.setText("Order ID:");

        customernameLab.setText("Customer Name:");

        contactLab.setText("Contact Number:");

        emailLab.setText("Email: ");

        addressLab.setText("Address:");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Quantity", "Each", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(orderTable);

        orderLab2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        orderLab2.setForeground(new java.awt.Color(0, 153, 255));
        orderLab2.setText("Orders");

        statusCombo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        statusCombo.setForeground(new java.awt.Color(255, 51, 0));
        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Completed", " " }));

        totalLab.setBackground(new java.awt.Color(255, 255, 255));
        totalLab.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        totalLab.setForeground(new java.awt.Color(0, 0, 0));
        totalLab.setText(" Total: RM ");
        totalLab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        backBtn.setBackground(new java.awt.Color(153, 153, 153));
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        goBtn.setBackground(new java.awt.Color(102, 255, 51));
        goBtn.setForeground(new java.awt.Color(0, 0, 0));
        goBtn.setText("Go");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 51, 51));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(orderLab, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(goBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(orderidLab, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)
                            .addComponent(orderLab2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(customernameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(contactLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(addressLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailLab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLab, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(orderLab)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orderidLab)
                            .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contactLab)
                            .addComponent(customernameLab))
                        .addGap(8, 8, 8)
                        .addComponent(emailLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderLab2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goBtn)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLab, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        adminOption ao = new adminOption();
        ao.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
        // TODO add your handling code here:
        resetTable();
        displayAll();
    }//GEN-LAST:event_goBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        statusChanger();
    }//GEN-LAST:event_updateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(customerOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new customerOrder().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLab;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel contactLab;
    private javax.swing.JLabel customernameLab;
    private javax.swing.JLabel emailLab;
    private javax.swing.JButton goBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel orderLab;
    private javax.swing.JLabel orderLab2;
    private javax.swing.JList<String> orderList;
    private javax.swing.JTable orderTable;
    private javax.swing.JLabel orderidLab;
    private javax.swing.JComboBox<String> statusCombo;
    private javax.swing.JLabel totalLab;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
