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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.util.Date; 

/**
 *
 * @author zhong
 */
public class cart extends javax.swing.JFrame {
    
    public static String username;
    private String orderID;
    /**
     * Creates new form cart
     * @param username
     */
    public cart(String username) {
        initComponents();
    }
    
    //This is used to get the username from the previous form
    void customer(String username)
    {
        nameLab.setText(username);
        username = nameLab.getText();
        displayUser(username);
        displayCart();
    }
    
    //This is used to display the user information
    private void displayUser(String username)
    {
        try(BufferedReader br = new BufferedReader(new FileReader("Customer.txt")))
        {
            String information;
            while((information = br.readLine()) != null)
            {
                String[] data = information.split(";");
                if(data[0].equals(username))
                {
                    contactLab.setText("Contact Number: "+data[3]);
                    emailLab.setText("Email: "+data[5]);
                    addressLab.setText("Address: "+data[6]);
                }
            }
            br.close();
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        customernameLab.setText("Customer Name: "+username);
    }
    
    //This method is used to display the cart of the user
    private void displayCart()
    {   
        cartTable.getColumnModel().getColumn(0).setPreferredWidth(2);
        cartTable.getColumnModel().getColumn(2).setPreferredWidth(3);
        cartTable.getColumnModel().getColumn(3).setPreferredWidth(7);
        try(BufferedReader br = new BufferedReader(new FileReader("Cart.txt")))
        {
            float total = 0;
            String information;
            //Inside the while loop
            //The data get from the text file line by line
            //Add a new row with those data 
            while((information = br.readLine()) != null)
            {
                String[] data = information.split(";");
                String each = data[3].substring(2);
                float price = Float.parseFloat(each) * Integer.parseInt(data [2]);
                DefaultTableModel model = (DefaultTableModel)cartTable.getModel();
                model.addRow(new Object[]{data[0],data[1],data[2],"RM"+String.format("%.02f", price)});
                total += price;
            }
            totalLab.setText(" Total: RM"+String.format("%.02f", total));
            br.close();
        }   
        //Receive a message when there is no item in the cart
        //Back to the menu page
        catch(IOException ioe)
        {   
            JOptionPane.showMessageDialog(this, "Sorry, you currently have no item added into your cart!\n", "Error Message", JOptionPane.ERROR_MESSAGE);
            username = nameLab.getText();
            menu m = new menu(username);
            m.setVisible(true);
            this.dispose();
            m.userID(username);
        }
    }
    
    //This method is used to create new and unique orderID
    private String orderIDgenerator()
    {
       try(BufferedReader br = new BufferedReader(new FileReader("Order.txt")))
       {
            //The default orderID is CO1, if there is no orderID inside the Order.txt
            String information;
            int i = 1;
            String orderID = "CO1";
            //If there are orderIDs
            //Then check line by line, and add 1 to i (current orderID)
            //Finally, got the latest ID and return that orderID
            while((information = br.readLine()) != null)
            { 
                String[] data = information.split(";");
                while(data[0].equals("CO"+i))
                {
                    i += 1;
                }
                
            }
            orderID = "CO"+i;
            return orderID;
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
       return orderID;
    }
    
    //This is used when user confirm payment
    private void orderConfirmed()
    {   
        File f = new File("Order.txt");
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Order.txt", true)))) 
        {   
            //All details will be written in the Order.txt
            String orderID = orderIDgenerator();
            String customer = nameLab.getText();
            String phone = contactLab.getText();
            String email = emailLab.getText();
            String address = addressLab.getText();
            String total = totalLab.getText().substring(8);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date();  
            String dateTime = formatter.format(date); 
            writer.print(orderID+";"+customer+";Pending;"+total+";"+dateTime+";");
            
            //Read the order details from the Cart.txt
            try(BufferedReader br = new BufferedReader(new FileReader("Cart.txt")))
            {
                //Then, write those order details behind the user detail in the Order.txt
                String information;
                while((information = br.readLine()) != null)
                {
                    String[] data = information.split(";");
                    writer.print(data[0]+";"+data[1]+";"+data[2]+";"+data[3]+";");   
                }
                writer.println("");
                br.close();
                writer.close();
                //Pass these information to receipt form and display it
                receipt r = new receipt(orderID, customer, phone, email, address, total,dateTime);
                r.setVisible(true);
                this.dispose();
            }   
            catch(IOException ioe)
            {
                JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
            }        
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
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

        cartLab = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        payBtn = new javax.swing.JButton();
        totalLab = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        customernameLab = new javax.swing.JLabel();
        contactLab = new javax.swing.JLabel();
        emailLab = new javax.swing.JLabel();
        addressLab = new javax.swing.JLabel();
        nameLab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cartLab.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        cartLab.setForeground(new java.awt.Color(102, 102, 255));
        cartLab.setText("Cart");

        cancelBtn.setBackground(new java.awt.Color(153, 153, 153));
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        payBtn.setBackground(new java.awt.Color(255, 51, 51));
        payBtn.setForeground(new java.awt.Color(255, 255, 255));
        payBtn.setText("Pay by Card");
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        totalLab.setBackground(new java.awt.Color(153, 153, 153));
        totalLab.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        totalLab.setForeground(new java.awt.Color(0, 0, 0));
        totalLab.setText(" Total：RM");
        totalLab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FoodID", "Name", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cartTable);

        customernameLab.setText("Customer Name:");

        contactLab.setText("Contact Number: ");

        emailLab.setText("Email: ");

        addressLab.setText("Address: ");

        nameLab.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLab, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailLab, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cartLab, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(56, 56, 56)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(customernameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(nameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(contactLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(addressLab, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartLab)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customernameLab)
                            .addComponent(nameLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactLab)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressLab, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalLab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(payBtn))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        String username = nameLab.getText();
        menu m = new menu(username);
        m.setVisible(true);
        this.dispose();
        m.userID(username);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog
                (this, "Are you sure you want to proceed to payment?", 
                "Confirm!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_OPTION)
        {
            orderConfirmed();
        }
    }//GEN-LAST:event_payBtnActionPerformed

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
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new cart(username).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLab;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel cartLab;
    private javax.swing.JTable cartTable;
    private javax.swing.JLabel contactLab;
    private javax.swing.JLabel customernameLab;
    private javax.swing.JLabel emailLab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLab;
    private javax.swing.JButton payBtn;
    private javax.swing.JLabel totalLab;
    // End of variables declaration//GEN-END:variables
}
