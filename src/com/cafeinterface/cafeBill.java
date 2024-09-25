package com.cafeinterface;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class cafeBill extends JFrame  {
	ConnectionDemo cd=new ConnectionDemo();
	public cafeBill() 
	{
		try
		{
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Id :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(89, 136, 165, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(89, 198, 202, 35);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item Name :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(89, 265, 152, 35);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(89, 323, 124, 36);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(89, 381, 142, 35);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Total :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setBounds(89, 448, 111, 27);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cafe Bill Receipt");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_6.setBounds(252, 35, 351, 49);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(347, 498, 124, 39);
		getContentPane().add(btnNewButton);
		setSize(800,600);
		setLocation(500,150);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new cafeBill();

	}


}
