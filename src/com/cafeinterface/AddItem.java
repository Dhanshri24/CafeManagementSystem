package com.cafeinterface;

import java.awt.Font;
import static com.cafeinterface.ConnectionDemo.*;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Choice;
import java.awt.Color;

public class AddItem extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton btnNewButton ;
    String iname,icategory;
    double price;
    int id;
    ConnectionDemo cd=new ConnectionDemo();
	Choice choiceempid;

	public AddItem() 
	{
		try {
			cd.rs=cd.st.executeQuery("select max(ItemId) from ItemInfo");
			while(cd.rs.next())
			{
				id=cd.rs.getInt(1);
			}
			
		}
		catch(Exception e){
			
		}
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Item");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBounds(325, 57, 234, 62);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Id");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(73, 166, 173, 48);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField.setBounds(258, 166, 301, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Item Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(73, 249, 121, 35);
		getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_1.setBounds(258, 251, 301, 40);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Item Price");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(73, 337, 155, 35);
		getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_2.setBounds(258, 339, 301, 40);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Item Category");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(73, 436, 173, 40);
		getContentPane().add(lblNewLabel_4);
		
//		textField_3 = new JTextField();
//		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
//		textField_3.setBounds(258, 436, 301, 40);
//		getContentPane().add(textField_3);
//		textField_3.setColumns(10);
	choiceempid=new Choice();
		choiceempid.setBounds(258,436,301,40);
		choiceempid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		choiceempid.add("  ");
		getContentPane().add(choiceempid);
		try {
			
			 cd.rs=cd.st.executeQuery("select * from Category");
			while(cd.rs.next()) {
				//System.out.println("1");
				choiceempid.add(cd.rs.getString(1));
				
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		 btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(206, 513, 109, 40);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
	
		
	    setSize(800,600);
		setLocation(500,150);
		setResizable(false);
		setVisible(true);
		textField.setText(""+(id+1));
		textField.setEditable(false);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnBack.setBounds(432, 513, 109, 40);
		getContentPane().add(btnBack);
		 
	
	}

	public static void main(String[] args) {
		
		new AddItem();
        
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==btnNewButton)
			
		{
			iname=textField_1.getText();
			try {
				price=Double.parseDouble(textField_2.getText());
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this,"Please Enter Valid Price");
			}
			icategory=choiceempid.getSelectedItem();
			if(price > 0 || price < 999) {
				try {
					cd.st.executeUpdate("insert into ItemInfo(ItemName,ItemPrice,ItemCategory)values('"+iname+"',"+price+",'"+icategory+"')");
				     
					JOptionPane.showMessageDialog(this,"Item added successfuly");	 
				 } catch (SQLException e)
				 {
					
					
					e.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(this,"Please Enter Valid Price");
			}
		 
		}
		
	}
}
