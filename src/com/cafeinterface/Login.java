package com.cafeinterface;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame{
	private JTextField textField;
	private JTextField textField_1;

	public Login() {
		 
		   JLabel lblNewLabel = new JLabel("ROYAL CAFE MANAGEMENT SYSTEM");
		   lblNewLabel.setForeground(new Color(255, 255, 255));
		   lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		   lblNewLabel.setBounds(242, 82, 750, 49);
		   getContentPane().add(lblNewLabel);
		   
		   JLabel lblNewLabel_1 = new JLabel("Username");
		   lblNewLabel_1.setForeground(new Color(0, 0, 0));
		   lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		   lblNewLabel_1.setBounds(1037, 306, 143, 49);
		   getContentPane().add(lblNewLabel_1);
		   
		   textField = new JTextField();
		   textField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		   textField.setBounds(1230, 308, 285, 49);
		   getContentPane().add(textField);
		   textField.setColumns(10);
		   
		   JLabel lblNewLabel_1_1 = new JLabel("Password");
		   lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		   lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		   lblNewLabel_1_1.setBounds(1037, 409, 143, 41);
		   getContentPane().add(lblNewLabel_1_1);
		   
		   textField_1 = new JTextField();
		   textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		   textField_1.setColumns(10);
		   textField_1.setBounds(1230, 407, 285, 49);
		   getContentPane().add(textField_1);
		   
		   JButton btnNewButton = new JButton("Login");
		   btnNewButton.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   	  if(textField.getText().trim().length()>0)
	 	         {   
	 	           if(textField_1.getText().trim().length()>0)
	 	              {
	 	                  if("Admin".equals(textField.getText()))
	 	                   {

	 	                    if("Admin@24".equals(textField_1.getText()))
	 	                     {
	 	                        new MainPage();
	 	                        dispose();
	 	                                  }
	 	                 else
	 	                  JOptionPane.showMessageDialog(null,"Invalid Password");

	 	                        }
	 	           else
	 	           {
	 	               JOptionPane.showMessageDialog(null,"Invalid LoginId");
	 	                 }

	 	           }
	 	     else
	 	      {
	 	        JOptionPane.showMessageDialog(null,"Plz Enter Password");
	 	          }

	 	   }
	 	else
	 	{
	 	JOptionPane.showMessageDialog(null,"Plz Enter LoginId");
	 	}
	 	
		   	}
		   });
		   btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		   btnNewButton.setBounds(1086, 516, 105, 49);
		   getContentPane().add(btnNewButton);
		   
		   JButton btnSignIn = new JButton("Cancel");
		   btnSignIn.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   	}
		   });
		   btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		   btnSignIn.setBounds(1340, 516, 105, 49);
		   getContentPane().add(btnSignIn);
		   
		   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/cafe4.jpg"));
    	   Image i2=i1.getImage().getScaledInstance(1650,1080,Image.SCALE_DEFAULT);	 
    	   ImageIcon i3=new ImageIcon (i2);
    	   JLabel l1=new JLabel(i3);
           l1.setBounds(0,-28,1540,1108);
           getContentPane().add(l1);
		   
		   getContentPane().setLayout(null);
	       setBounds(0,0,1920,1080);
           setVisible(true);
            
 		              
 	
	}

	public static void main(String[] args)
	{
	
          new Login();
	}
}
