package com.cafeinterface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage  extends JFrame{

	 MainPage() 
	{

		 
		    getContentPane().setLayout(null);
	        
	        setBounds(0,0,1600,850);
	        setVisible(true);
			 
			 JButton btnNewButton = new JButton("Menu Management");
			 btnNewButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		new Menu1();
			 	
			 	}
			 });
			 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
			 btnNewButton.setBounds(117, 331, 213, 56);
			 getContentPane().add(btnNewButton);
			 
			 JButton btnNewButton_1 = new JButton("Order Management");
			 btnNewButton_1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		new Order();
			 	}
			 });
			 btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			 btnNewButton_1.setBounds(1154, 331, 225, 56);
			 getContentPane().add(btnNewButton_1);
			 
			 JLabel lblNewLabel = new JLabel("ROYAL CAFE MANAGEMENT SYSTEM");
			 lblNewLabel.setBackground(new Color(255, 255, 255));
			 lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			 lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
			 lblNewLabel.setForeground(new Color(255, 255, 255));
			 lblNewLabel.setBounds(471, 123, 761, 65);
			 getContentPane().add(lblNewLabel);
			 
      		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/cafe1.jpg"));
         	 Image i2=i1.getImage().getScaledInstance(1600,850,Image.SCALE_DEFAULT);	 
         	 ImageIcon i3=new ImageIcon (i2);
         	 JLabel l=new JLabel(i3);
             l.setBounds(0,10,1600,850);
             getContentPane().add(l);       
			 
	}

	public static void main(String[] args) 
	{
		
      new MainPage();
	}
}
