package com.cafeinterface;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdateItem extends JFrame {
  ConnectionDemo cd=new ConnectionDemo();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
     int id,maxId;
     
	public UpdateItem() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Item");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(282, 63, 334, 72);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Id");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(120, 172, 103, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(120, 240, 119, 38);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Item Price");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(120, 335, 129, 30);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Item Category");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(120, 431, 191, 30);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField.setBounds(292, 172, 367, 47);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_1.setBounds(292, 256, 367, 54);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_2.setBounds(292, 335, 367, 55);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_3.setBounds(292, 431, 367, 48);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i=cd.st.executeUpdate("Update ItemInfo set ItemName='"+textField_1.getText()+"',ItemPrice="+Double.parseDouble(textField_2.getText())+",ItemCategory='"+textField_3.getText()+"'  where ItemId="+Integer.parseInt(textField.getText()));
				if(i!=0)
				{
					JOptionPane.showMessageDialog(null,"Record updated successfully");
				}else {
					
					JOptionPane.showMessageDialog(null,"Something went wrong");
				}
				
				}
				catch(Exception e1){
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(200, 510, 111, 43);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				//new Menu1();
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(458, 510, 101, 43);
		getContentPane().add(btnNewButton_1);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id=Integer.parseInt(textField.getText());
				try {
					cd.rs=cd.st.executeQuery("select max(ItemId) from ItemInfo ");
					while(cd.rs.next())
					{
						maxId=cd.rs.getInt(1);
					}
					if(id>0 && id<=maxId)
					{
						cd.rs=cd.st.executeQuery("select * from ItemInfo where ItemId="+id+"");
						if(cd.rs.next())
						{
							textField_1.setText(""+cd.rs.getString("ItemName"));
							textField_2.setText(""+cd.rs.getDouble("ItemPrice"));
							textField_3.setText(""+cd.rs.getString("ItemCategory"));
						}
					}
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnView.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnView.setBounds(669, 172, 111, 43);
		getContentPane().add(btnView);
		setSize(850,600);
		setLocation(500,150);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateItem();

	}
}
