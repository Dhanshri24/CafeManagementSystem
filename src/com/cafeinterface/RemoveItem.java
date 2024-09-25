
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

public class RemoveItem  extends JFrame {
	ConnectionDemo cd= new ConnectionDemo();
	private JTextField textField;
	int id;
	

	public RemoveItem()
	{
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Item");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(282, 42, 210, 58);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Id");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(128, 162, 138, 50);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(282, 166, 305, 46);
		getContentPane().add(textField);
		//textField.setFont(new Font("Times New Roman",Font.BOLD,size));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(textField.getText().length()>0) {
				id=Integer.parseInt(textField.getText());
				try {
					cd.st.executeUpdate("Delete from ItemInfo where Itemid="+id+"");
					JOptionPane.showMessageDialog(null,"Item remove successfuly");
				} catch (SQLException e) {
					
					
					e.printStackTrace();
				}
				}else {
					JOptionPane.showMessageDialog(null,"Plz select Item for Remove");
				}
				
			
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(148, 308, 132, 50);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Menu1();
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1.setBounds(487, 308, 108, 50);
		getContentPane().add(btnNewButton_1);
		setSize(800,600);
		setLocation(500,150);
		setResizable(false);
		setVisible(true);
		 
	}

	public static void main(String[] args)
	{
	 new RemoveItem();

	}

}
