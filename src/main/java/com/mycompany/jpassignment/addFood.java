/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.jpassignment;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author zhong
 */
public class addFood extends javax.swing.JFrame {

    private String foodCode;

    /**
     * Creates new form addFood
     */
    public addFood() {
        initComponents();
    }
    
    //This method is used to generator food ID
    private String idGenerator(String category)
    {   
        try(BufferedReader br = new BufferedReader(new FileReader("Food.txt")))
        {   
            
            String information;
            int foodID = 0;
            
            //This code is used when there is nothing inside the Food.txt
            //Then, the food item will be set to 0 based on the category
            switch (category)
                {
                    case "Main Course":
                        foodCode = "MC0";
                        break;


                    case "Side Dish":
                        foodCode = "SD0";
                        break;


                    case "Dessert":
                        foodCode = "DS0";
                        break;


                    case "Beverages":
                        foodCode = "BV0";
                        break;
                    
                        //This is to ensure admin gives an input
                    case "<-- Select -->":
                        JOptionPane.showMessageDialog(this, "You must select 1 category!", "Error Message", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            
            while((information = br.readLine()) != null)
            {
                String[] data = information.split(";");
                //This code is used when there is something in the Food.txt
                switch (category)
                {   
                    //All these cases all doing the samething
                    //First, create food ID with 0 based on the category
                    //Then, check whether the food ID 0 is in the file or not
                    //If yes, then the ID 0 will plus 1, keep doing this until the ID is not exist in the file
                    case "Main Course":
                        while(data[0].equals("MC"+foodID))
                        {
                            foodID = foodID + 1;
                        }
                        foodCode = "MC"+foodID;
                        break;
                        
                        
                    case "Side Dish":
                        while(data[0].equals("SD"+foodID))
                        {
                            foodID += 1;
                        }
                        foodCode = "SD"+foodID;
                        break;
                        
                        
                    case "Dessert":
                        while(data[0].equals("DS"+foodID))
                        {
                            foodID += 1;
                        }
                        foodCode = "DS"+foodID;
                        break;
                        
                     
                    case "Beverages":
                        while(data[0].equals("BV"+foodID))
                        {
                            foodID += 1;
                        }
                        foodCode = "BV"+foodID;
                        break;       
                }    
            }
            br.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        return foodCode;
    }
    
    //This method is used to check whether the foodID and name is used before or not
    private Boolean itemValidation(String foodID, String name)
    {
        Boolean found = false;
        try(BufferedReader br = new BufferedReader(new FileReader("Food.txt")))
        {
            String information;
            while((information = br.readLine()) != null)
            {
                //Return true whent the foodID and name is already exist in the text file
                String[] data = information.split(";");
                if(data[0].equals(foodID) || data[1].equals(name))
                { 
                    found = true;
                    return found;
                }
            }
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        return found;
    }
    
    //This method is used to add item to the food menu
    private void addItem()
    {   
        try{
            //Create a file for storing all the data that got from the code below
            File f = new File("Food.txt");
            String name, price, category, description;
            name = nameTxt.getText();
            price = priceTxt.getText();
            category = categoryBox.getSelectedItem().toString();
            description = descTxt.getText();
            String itemID = codeTxt.getText();
            
            //Put all the data into a list
            String[] foodInfo = {itemID, name, price, category, description};
            List<String> list = Arrays.asList(foodInfo);
            
            if(itemValidation(itemID, name))
            {
                JOptionPane.showMessageDialog(this, "You cannot add the same item with the same FoodID!", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
            else
            //Check is there any empty data in the list
            if(list.contains(""))
            {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields!","Error Message", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                //Create a writer to write data into the file
                try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Food.txt", true)))) 
                {   
                    //Taking the elements from the list as data
                    //Write those data 1 by 1 into the file
                    for (String data : list)
                    {
                        writer.print(data+";");
                    }
                    writer.println("");
                    JOptionPane.showMessageDialog(this, "Food Added Successfully!", "Information",JOptionPane.INFORMATION_MESSAGE);
                    //After the data added, the combo box will change back to default
                    categoryBox.setSelectedItem("<-- Select -->");
                    writer.close();       
                }
                catch(IOException ioe)
                {
                    JOptionPane.showMessageDialog(this, "This is Error to write a file.","Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "This is Error to create a file.","Error Message",JOptionPane.ERROR_MESSAGE);
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

        addLab = new javax.swing.JLabel();
        codeLab = new javax.swing.JLabel();
        nameLab = new javax.swing.JLabel();
        priceLab = new javax.swing.JLabel();
        categoryLab = new javax.swing.JLabel();
        descLab = new javax.swing.JLabel();
        codeTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        priceTxt = new javax.swing.JTextField();
        descTxt = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        categoryBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addLab.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        addLab.setForeground(new java.awt.Color(255, 51, 51));
        addLab.setText("Add Food Item");

        codeLab.setText("Item Code:");

        nameLab.setText("Name:");

        priceLab.setText("Price:");

        categoryLab.setText("Category:");

        descLab.setText("Description:");

        codeTxt.setEnabled(false);

        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });

        priceTxt.setText("RM");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(255, 51, 51));
        clearBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(102, 255, 102));
        addBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        categoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-- Select -->", "Main Course", "Side Dish", "Dessert", "Beverages" }));
        categoryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descLab, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(categoryBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(categoryLab))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(codeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceLab, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(codeLab)))
                        .addComponent(addLab, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descTxt)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(addLab, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLab)
                    .addComponent(codeLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLab)
                    .addComponent(priceLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(descLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(clearBtn)
                    .addComponent(addBtn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        addItem();
    }//GEN-LAST:event_addBtnActionPerformed

    private void categoryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBoxActionPerformed
        // TODO add your handling code here:
        //To get the item from the combo box and pass it to the idGenerator method
        String category = categoryBox.getSelectedItem().toString();
        //To get the food ID and display on the screen
        String itemID = idGenerator(category);
        codeTxt.setText(itemID);
    }//GEN-LAST:event_categoryBoxActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        adminOption ao = new adminOption();
        ao.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        nameTxt.setText("");
        priceTxt.setText("RM");
        categoryBox.setSelectedItem("<-- Select -->");
        descTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

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
            java.util.logging.Logger.getLogger(addFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new addFood().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel addLab;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JLabel categoryLab;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel codeLab;
    private javax.swing.JTextField codeTxt;
    private javax.swing.JLabel descLab;
    private javax.swing.JTextField descTxt;
    private javax.swing.JLabel nameLab;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel priceLab;
    private javax.swing.JTextField priceTxt;
    // End of variables declaration//GEN-END:variables

}
