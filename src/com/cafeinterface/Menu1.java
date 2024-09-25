package com.cafeinterface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Menu1 extends JFrame {

	public Menu1() {
		
		 getContentPane().setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("MENU MANAGEMENT SECTION");
		 lblNewLabel.setForeground(new Color(255, 255, 255));
		 lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		 lblNewLabel.setBounds(470, 25, 636, 47);
		 getContentPane().add(lblNewLabel);
		 
		 JButton btnNewButton = new JButton("Add Item");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		new AddItem();
		 		
		 	}
		 });
		 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 btnNewButton.setBounds(142, 213, 237, 52);
		 getContentPane().add(btnNewButton);
		 
		 JButton btnRemoveItem = new JButton("Remove Item");
		 btnRemoveItem.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e)
		 	{
		 		new RemoveItem();
		 	}
		 });
		 btnRemoveItem.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 btnRemoveItem.setBounds(142, 298, 237, 52);
		 getContentPane().add(btnRemoveItem);
		 
		 JButton btnUpdateItem = new JButton("Update Item");
		 btnUpdateItem.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		new UpdateItem();
		 	}
		 });
		 btnUpdateItem.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 btnUpdateItem.setBounds(142, 398, 237, 52);
		 getContentPane().add(btnUpdateItem);
		 
		 JButton btnViewItem = new JButton("View Item");
		 btnViewItem.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		new ViewMenuPage();
		 	}
		 });
		 btnViewItem.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 btnViewItem.setBounds(142, 496, 242, 52);
		 getContentPane().add(btnViewItem);
		 setBounds(0,0,1600,850);
	     setVisible(true);
	     
	     
		 JButton btnBack = new JButton("Back");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		new MainPage();
		 	}
		 });
		 btnBack.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 btnBack.setBounds(137, 677, 242, 43);
		 getContentPane().add(btnBack);
		 
		 JButton btnNewButton_1 = new JButton("Today Order");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		new TodaysOrder();
		 	}
		 });
		 btnNewButton_1.setBounds(142, 592, 237, 43);
		 btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 getContentPane().add(btnNewButton_1);
		
	     
	     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/cafe7.jpg"));
		 Image i2=i1.getImage().getScaledInstance(1600,850,Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon (i2);
		 JLabel l=new JLabel(i3);
		 l.setFont(new Font("Times New Roman", Font.BOLD, 25));
		 l.setBounds(0,-38,1610,822);
		 getContentPane().add(l);
		 
		 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Menu1();

	}
}
