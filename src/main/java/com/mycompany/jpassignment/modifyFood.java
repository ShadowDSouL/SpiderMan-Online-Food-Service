/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.jpassignment;

import java.io.*;
import javax.swing.*;

/**
 *
 * @author zhong
 */
public class modifyFood extends javax.swing.JFrame {

    /**
     * Creates new form modifyFood
     */
    public modifyFood() {
        initComponents();
    }
    
    //This is used to search the item based on the category
    //The item displayed is related to the category
    private void searchItem(String category)
    {
        try(BufferedReader br = new BufferedReader(new FileReader("Food.txt")))
        {   
            //It will reset the code every time when user change the category
            codeBox.removeAllItems();
            String information;
            while((information = br.readLine()) != null)
            {   
                String[] data = information.split(";");
                if(data[3].equals(category))
                {
                    codeBox.addItem(data[0]);
                }
            }
        }
        catch(NullPointerException npe)
        {
            JOptionPane.showMessageDialog(this, "The list of food name has been refreshed!\nPlease select more 1 time for the category.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //This is used to display the item information
    private void displayItem(String foodID)
    {
        try(BufferedReader br = new BufferedReader(new FileReader("Food.txt")))
        {  
            String information;
            while((information = br.readLine()) != null)
            {
                String[] data = information.split(";");
                if(data[0].equals(foodID))
                {
                    nameTxt.setText(data[1]);
                    priceTxt.setText(data[2]);
                    descTxt.setText(data[4]);
                }
            }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //This is used to edit the information for specific item
    private void editItem()
    {   
        //Identifier
        String category = categoryBox.getSelectedItem().toString();
        String foodID = codeBox.getSelectedItem().toString();
        
        //Data to be changed
        String newName = nameTxt.getText();
        String newPrice = priceTxt.getText();
        String newDesc = descTxt.getText();
        
        //Create new file and store these edited data with the original data
        String fileName = "Food.txt";
        String tempFile = "temp.txt";   
        File oldFile = new File(fileName);
        File newFile = new File(tempFile);
        
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile, true))))
        {
            try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
            {
                String information;
                while((information = br.readLine()) != null)
                {
                    String[] data = information.split(";");
                    //Search the item that want to be edited
                    if (data[0].equals(foodID) && data[3].equals(category))
                    {
                        //write the new data into the tempt txt file
                        pw.println(foodID+";"+newName+";"+newPrice+";"+category+";"+newDesc);
                        JOptionPane.showMessageDialog(this, "Food Item: "+foodID+" Has Been Modified Successfully!", "Information",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {   //write the old data into the tempt txt file
                        pw.println(information);
                    }
                }
                br.close();
                pw.close();
                //Delete the old Food.txt
                oldFile.delete();
                //Create a new file
                File dump = new File(fileName);
                //Rename it to Food.txt for the replacement
                newFile.renameTo(dump);
            }
            catch (IOException ioe)
            {
                JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "This is Error to write a file.","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //This is used to delete specific item from the list
    private void deleteItem()
    {
        //Identifier
        String foodID = codeBox.getSelectedItem().toString();
        
        //Create new file and store these edited data with the original data
        String fileName = "Food.txt";
        String tempFile = "temp.txt";   
        File oldFile = new File(fileName);
        File newFile = new File(tempFile);
        
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile, true))))
        {
            try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
            {
                String information;
                while((information = br.readLine()) != null)
                {
                    String[] data = information.split(";");
                    //It will skip writing the information in the tempt txt file
                    //when the foodID is match
                    if (!data[0].equals(foodID))
                    {
                        pw.println(information);
                    }
                }
                JOptionPane.showMessageDialog(this, "Food Item: "+foodID+" Has Been Deleted Successfully!", "Information",JOptionPane.INFORMATION_MESSAGE);
                br.close();
                pw.close();
                //Delete the old Food.txt
                oldFile.delete();
                //Create a new file
                File dump = new File(fileName);
                //Rename it to Food.txt for the replacement
                newFile.renameTo(dump);
                //Refresh the page, because the selected item is removed
                reset();
            }
            catch (IOException ioe)
            {
                JOptionPane.showMessageDialog(this, "Something wrong with reading file!", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "This is Error to write a file.","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //This is used to refresh the page, because the data is no longer exist
    private void reset()
    {
        nameTxt.setText("");
        priceTxt.setText("");
        descTxt.setText("");
        categoryBox.setSelectedItem("<-- Select -->");
        codeBox.setSelectedItem("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        priceTxt = new javax.swing.JTextField();
        categoryBox = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();
        addLab = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        codeLab = new javax.swing.JLabel();
        nameLab = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        priceLab = new javax.swing.JLabel();
        categoryLab = new javax.swing.JLabel();
        descLab = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        codeBox = new javax.swing.JComboBox<>();
        deleteBtn = new javax.swing.JButton();
        descTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        categoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-- Select -->", "Main Course", "Side Dish", "Dessert", "Beverages" }));
        categoryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBoxActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(153, 153, 153));
        backBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        addLab.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        addLab.setForeground(new java.awt.Color(255, 51, 51));
        addLab.setText("Modify Food Item");

        clearBtn.setBackground(new java.awt.Color(255, 51, 51));
        clearBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        codeLab.setText("Item Code:");

        nameLab.setText("Name:");

        editBtn.setBackground(new java.awt.Color(102, 255, 102));
        editBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        priceLab.setText("Price:");

        categoryLab.setText("Category:");

        descLab.setText("Description:");

        codeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeBoxActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(categoryLab)
                                    .addComponent(nameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(codeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(codeLab)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(priceLab, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(addLab, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descLab, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(addLab, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLab)
                    .addComponent(categoryLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceLab)
                    .addComponent(nameLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn)
                    .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(clearBtn)
                    .addComponent(deleteBtn))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categoryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBoxActionPerformed
        // TODO add your handling code here:
        
        String category = categoryBox.getSelectedItem().toString();
        if(category.equals("<-- Select -->"))
        {
            JOptionPane.showMessageDialog(this, "Please select 1 category!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        searchItem(category);
    }//GEN-LAST:event_categoryBoxActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        adminOption ao = new adminOption();
        ao.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        String category = categoryBox.getSelectedItem().toString();
        if (category.equals("<-- Select -->"))
        { 
            JOptionPane.showMessageDialog(this, "You have to select 1 item!\n First, select a category.", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            editItem(); 
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void codeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeBoxActionPerformed
        // TODO add your handling code here:
        String foodID = codeBox.getSelectedItem().toString();
        displayItem(foodID);
    }//GEN-LAST:event_codeBoxActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        String category = categoryBox.getSelectedItem().toString();
        if (category.equals("<-- Select -->"))
        { 
            JOptionPane.showMessageDialog(this, "You have to select 1 item!\n First, select a category.", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            int response = JOptionPane.showConfirmDialog
                (this, "Are you sure you want to delete this item?", 
                "Confirm!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(response == JOptionPane.YES_OPTION)
            {
                deleteItem();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(modifyFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifyFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifyFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifyFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new modifyFood().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLab;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JLabel categoryLab;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox<String> codeBox;
    private javax.swing.JLabel codeLab;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel descLab;
    private javax.swing.JTextField descTxt;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel nameLab;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel priceLab;
    private javax.swing.JTextField priceTxt;
    // End of variables declaration//GEN-END:variables
}
