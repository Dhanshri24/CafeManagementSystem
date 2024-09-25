package com.cafeinterface;

import java.awt.Font;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class TakeOrder extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;
	JButton btnNewButton ;
    String icname,icategory;
    double price;
    static public int oid=0;
    static double  totalprice,qprice;
    int qty=1;
    Choice choiceempid;
    Font f1=new Font("SAN_SERIF",Font.BOLD,15);
	Font f=new Font("SAN_SERIF",Font.BOLD,13);
    int id;
    ConnectionDemo cd=new ConnectionDemo();

	public TakeOrder() {
		getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 25));
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DELIGHT ORDER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(262, 10, 312, 52);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Order Id");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(83, 87, 133, 38);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField.setBounds(324, 85, 347, 40);
		getContentPane().add(textField);
		//textField.setColumns(10);
		try
		{
			cd.rs=cd.st.executeQuery("select max(OrderId) from OrderInfo");
			while(cd.rs.next())
			{
				oid=cd.rs.getInt(1);
			}
		}
		catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		textField.setText(""+(oid+1));
		textField.setEditable(false);
		oid=Integer.parseInt(textField.getText());
		
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(83, 150, 178, 38);
		getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_1.setBounds(324, 151, 347, 45);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Item Name");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(83, 221, 146, 38);
		getContentPane().add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setBounds(83, 507, 146, 30);
		getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_4.setBounds(324, 504, 347, 45);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Print Bill");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BillReceipt();			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1.setBounds(153, 567, 155, 52);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Menu1();
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_2.setBounds(517, 567, 119, 52);
		getContentPane().add(btnNewButton_2);
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 25));
//		comboBox.setBounds(324, 218, 347, 52);
//		getContentPane().add(comboBox);
		choiceempid=new Choice();
		choiceempid.setBounds(324, 218, 347, 52);
		choiceempid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		choiceempid.add("  ");
		getContentPane().add(choiceempid);
		try {
			
			 cd.rs=cd.st.executeQuery("select * from ItemInfo");
			while(cd.rs.next()) {
				//System.out.println("1");
				choiceempid.add(cd.rs.getString("ItemName"));
				
			}
		
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		JLabel lblNewLabel_4 = new JLabel("Item Price");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(83, 298, 146, 38);
		getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_3.setBounds(324, 291, 347, 45);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		choiceempid.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				try {
					cd.rs=cd.st.executeQuery("select ItemPrice from ItemInfo where ItemName='"+choiceempid.getSelectedItem()+"'");
					while(cd.rs.next()) 
					{
						price=cd.rs.getInt(1);
					}
					
				}
				catch(Exception e1) 
				{
					System.out.println(e1);
				}
				textField_3.setText(""+price);
				textField_3.setEditable(false);
				
			}
		});
		
	
		
		JLabel lblNewLabel_6 = new JLabel("Quantity");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_6.setBounds(91, 373, 125, 30);
		getContentPane().add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_2.setBounds(326, 374, 133, 38);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(""+qty);
		textField_2.setEditable(false);
		
		JButton btnNewButton_3 = new JButton("+");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qty+=1;
				textField_2.setText(""+qty);
				textField_2.setEditable(false);
				
			}
		});
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_3.setBounds(472, 380, 85, 30);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("-");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(qty>1)
				{
					qty-=1;
					textField_2.setText(""+qty);	
				}
				
				
				
			}
		});
		btnNewButton_3_1.setForeground(Color.RED);
		btnNewButton_3_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		btnNewButton_3_1.setBounds(567, 380, 85, 30);
		getContentPane().add(btnNewButton_3_1);
		
		JButton btnAdd = new JButton("Buy");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField_1.getText();
				
				for(int i=0; i<s.length();i++) {
					char ch = s.charAt(i);
					if(ch>=48 && ch<=57) {
						
							JOptionPane.showMessageDialog(null,"Enter Valid Customer Name");
						
					}
				}
				
					try {
						qprice=(price*qty);
						
					
						cd.st.executeUpdate("insert into OrderInfo values("+oid+",'"+textField_1.getText()+"','"+choiceempid.getSelectedItem()+"',"+price+","+qty+","+qprice+")");
						JOptionPane.showMessageDialog(null,"Item added successfully");
						totalprice=totalprice+(price*qty);
						textField_4.setText(""+totalprice);
						textField_4.setEditable(false);
						
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}

				}	
			
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnAdd.setBounds(401, 438, 105, 37);
		getContentPane().add(btnAdd);
		setSize(800,700);
	   // setLocation(400,150);
	    setResizable(false);
	    setVisible(true);
	    setLocationRelativeTo(null);
			 
	}

	public static void main(String[] args) {


		new TakeOrder();
	}
}
