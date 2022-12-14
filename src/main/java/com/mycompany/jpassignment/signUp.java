/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.jpassignment;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.regex.Pattern;
/**
 *
 * @author zhong
 */
public class signUp extends javax.swing.JFrame {

    /**
     * Creates new form signUp
     */
    public signUp() {
        initComponents();
    }
    
    //This method is for checking the username is in the file or not
    //User cannot use the same username with others
    public Boolean checkUser(String Username)
    {
        Boolean found = false;
        try(BufferedReader br = new BufferedReader(new FileReader("Customer.txt")))
        {
            String information;
            while((information = br.readLine()) != null)
            {   
                String[] data = information.split(";");
                //When the username exists in the file
                //return true means that username is found
                if(Username.equals(data[0]))
                {
                    found = true;
                    return found;
                }
            }
            br.close();
            
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(this, "This is Error1","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        //When the username does not exist in the file
        //return false means that username is found
        return found;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerLab = new javax.swing.JLabel();
        usernameLab = new javax.swing.JLabel();
        nameLab = new javax.swing.JLabel();
        phoneLab = new javax.swing.JLabel();
        pwLab1 = new javax.swing.JLabel();
        dobLab = new javax.swing.JLabel();
        emailLab = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        pwLab2 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        pwTxt1 = new javax.swing.JPasswordField();
        pwTxt2 = new javax.swing.JPasswordField();
        phoneTxt = new javax.swing.JTextField();
        dobTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        cardLab = new javax.swing.JLabel();
        holderLab = new javax.swing.JLabel();
        dateLab = new javax.swing.JLabel();
        cvvLab = new javax.swing.JLabel();
        holderTxt = new javax.swing.JTextField();
        dateTxt = new javax.swing.JTextField();
        cvvTxt = new javax.swing.JTextField();
        addressLab = new javax.swing.JLabel();
        addressTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(404, 522));

        registerLab.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        registerLab.setForeground(new java.awt.Color(102, 102, 255));
        registerLab.setText("Sign Up");

        usernameLab.setText("Username:");

        nameLab.setText("Full Name: ");

        phoneLab.setText("Contact Number:");

        pwLab1.setText("Password:");

        dobLab.setText("Date of Birth: dd/mm/yyyy");

        emailLab.setText("Email:");

        registerBtn.setBackground(new java.awt.Color(102, 255, 102));
        registerBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(255, 0, 0));
        clearBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        pwLab2.setText("Confirmed Password:");

        phoneTxt.setToolTipText("");

        cardLab.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        cardLab.setForeground(new java.awt.Color(255, 51, 51));
        cardLab.setText("Card");

        holderLab.setText("Cardholder:");

        dateLab.setText("Expiry Date:");

        cvvLab.setText("CVV:");

        addressLab.setText("Address:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addressLab, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cardLab, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cvvLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(holderLab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateLab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(holderTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(dateTxt)
                            .addComponent(cvvTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(registerLab, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(nameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(emailTxt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pwTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(pwTxt2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pwLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneLab))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(dobLab))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addComponent(pwLab2))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailLab, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(dobTxt)))
                    .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerLab)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLab)
                    .addComponent(nameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwLab1)
                    .addComponent(pwLab2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dobLab)
                    .addComponent(phoneLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addressLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardLab)
                    .addComponent(holderLab)
                    .addComponent(holderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLab)
                    .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cvvLab)
                    .addComponent(cvvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn)
                    .addComponent(clearBtn)
                    .addComponent(cancelBtn))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        //Reset all the data input
        usernameTxt.setText("");
        nameTxt.setText("");
        pwTxt1.setText("");
        pwTxt2.setText("");
        phoneTxt.setText("");
        dobTxt.setText("");
        emailTxt.setText("");
        addressTxt.setText("");
        holderTxt.setText("");
        dateTxt.setText("");
        cvvTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed
    
    //This method is used for checking there is no numbers in the name
    private static final Pattern LETTERS = Pattern.compile("\\p{Alpha}+");
    
    public static final boolean isAlpha(String text)
    {
        return LETTERS.matcher(text).matches();
    }
    
    private void register()
    {
        try {
            File file = new File("Customer.txt");
            String username = usernameTxt.getText().trim();
            String name = nameTxt.getText().trim();
            String password1 = pwTxt1.getText().trim();
            String password2 = pwTxt2.getText().trim();
            String phone = phoneTxt.getText().trim();
            String dob = dobTxt.getText().trim();
            String email = emailTxt.getText().trim();
            String address = addressTxt.getText().trim();
            String cardholder = holderTxt.getText().trim();
            String expiry = dateTxt.getText().trim();
            String cvv = cvvTxt.getText().trim();
            
            //Using Inheritance here
            Customer c = new Customer(username, name, password1, phone, dob, email, address, cardholder, expiry, cvv);
            String[] information = {c.getID(), c.getName(), c.getPW(), c.getPN(), c.getDOB(), c.getEA(),c.getAD(), c.getCN(), c.getED(), c.getCVN()};
            
            //Create a list array
            List<String> list = Arrays.asList(information);
            
            //Check is there any empty data in the list
            if(list.contains(""))
            {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields!","Error Message", JOptionPane.ERROR_MESSAGE);
            }
            else
            {   
                //Check the name contains alphabet only
                if (isAlpha(name))
                {   
                    //Check the password and confirmed password is the same
                    if (!password1.equals(password2))
                    {   
                        JOptionPane.showMessageDialog(this, "Password Does Not Match!");
                    }
                    else
                    {   
                        //Create a writer to write data into the file
                        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Customer.txt", true)))) 
                        {   
                            //false means username not exists in the file
                            //Only new username can be registered
                            if(checkUser(username) == false)
                            {
                                //Taking the elements from the list as data
                                //Write those data 1 by 1 into the file
                                for (String data : list)
                                {
                                    writer.print(data+";");
                                }
                                writer.println("");
                                JOptionPane.showMessageDialog(this, "Registered Successfully!\nYou can now login to your account.\nPlease remember your username: "+username, "Information",JOptionPane.INFORMATION_MESSAGE);
                                CustomerLogin cl = new CustomerLogin();
                                cl.setVisible(true);
                                this.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this, "The Username Is Used!\nPlease try another username.");
                            }
                            writer.close();
                        }
                        catch(IOException ioe)
                        {
                            JOptionPane.showMessageDialog(this, "This is Error to write a file.","Error Message",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Only alphabet is accecpted for your full name!\nPlease provide your real name");
                } 
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "This is Error to create a file.","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        //Get all the data from the input fields
        register(); 
    }//GEN-LAST:event_registerBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        CustomerLogin cl = new CustomerLogin();
        cl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new signUp().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLab;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel cardLab;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel cvvLab;
    private javax.swing.JTextField cvvTxt;
    private javax.swing.JLabel dateLab;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel dobLab;
    private javax.swing.JTextField dobTxt;
    private javax.swing.JLabel emailLab;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel holderLab;
    private javax.swing.JTextField holderTxt;
    private javax.swing.JLabel nameLab;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel phoneLab;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JLabel pwLab1;
    private javax.swing.JLabel pwLab2;
    private javax.swing.JPasswordField pwTxt1;
    private javax.swing.JPasswordField pwTxt2;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel registerLab;
    private javax.swing.JLabel usernameLab;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
