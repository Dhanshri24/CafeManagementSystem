package com.cafeinterface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order extends JFrame {

	public Order()
	{

	    getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("ORDER MANAGEMENT SYSTEM");
	    lblNewLabel.setForeground(new Color(255, 255, 255));
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
	    lblNewLabel.setBounds(492, 137, 571, 86);
	    getContentPane().add(lblNewLabel);
	    
	    JButton btnNewButton = new JButton("Take Order");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new TakeOrder();
	    	}
	    });
	    btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    btnNewButton.setBounds(128, 384, 230, 60);
	    getContentPane().add(btnNewButton);
        setBounds(0,0,1600,850);
        setVisible(true);
        JButton btnNewButton_1_1 = new JButton("Back To Section");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		new MainPage();
        	}
        });
        btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        btnNewButton_1_1.setBounds(1167, 387, 290, 60);
        getContentPane().add(btnNewButton_1_1);
		 
	
        
        
 		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/cafe2.jpg"));
    	 Image i2=i1.getImage().getScaledInstance(1600,850,Image.SCALE_DEFAULT);	 
    	 ImageIcon i3=new ImageIcon (i2);
    	 JLabel l=new JLabel(i3);
		 l.setBounds(0,0,1600,850);
		 getContentPane().add(l);
}
       

	public static void main(String[] args) 
	{
		new Order();
		
	}

}
