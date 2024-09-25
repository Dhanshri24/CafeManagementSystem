package com.cafeinterface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import static com.cafeinterface.TakeOrder.*;
import java.awt.Font;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BillReceipt extends JFrame {
	ConnectionDemo cd1=new ConnectionDemo();
	JTable table;
	String name;
	static LocalDate date=LocalDate.now();
	static LocalTime time=LocalTime.now();
	//DateTimeFormatter time=DateTimeFormatter.ofPattern("HH:mm:ss");
	Font f1=new Font("SAN_SERIF",Font.BOLD,15);
	Font f=new Font("SAN_SERIF",Font.BOLD,13);
	public BillReceipt() {
		JTable table=new JTable();
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Royal Cafe");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(290, 33, 199, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(136, 102, 76, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Time:-");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(136, 127, 86, 26);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name:-");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(412, 102, 265, 26);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("OrderId:-");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(412, 127, 101, 26);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("------------------------------------------------------------------------");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(60, 171, 644, 13);
		getContentPane().add(lblNewLabel_2);
		try
		{
			cd1.rs=cd1.st.executeQuery("select CustName from OrderInfo where OrderId="+oid+"");
			while(cd1.rs.next())
			{
				name=cd1.rs.getString(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		String query="select ItemName,ItemPrice,Total from OrderInfo where OrderId="+oid+"";
		try {
			 cd1.rs=cd1.st.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
			
		}catch(Exception E) {
			E.printStackTrace();
		}
		JScrollPane jp=new JScrollPane(table);
		jp.setBounds(50,180,640,300);
		getContentPane().add(jp);
		
		JLabel lblNewLabel_3 = new JLabel("------------------------------------------------------------------------");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(60, 484, 644, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("TotalPrice:-");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(186, 514, 131, 26);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel(""+date);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(212, 102, 126, 26);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2_2 = new JLabel(name);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_2.setBounds(498, 102, 131, 26);
		getContentPane().add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel(""+time);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(212, 127, 190, 26);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(""+oid);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(508, 127, 101, 26);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel(""+totalprice);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1_1.setBounds(327, 514, 131, 26);
		getContentPane().add(lblNewLabel_1_2_1_1);
		setSize(800,600);
		setLocation(500,150);
		setResizable(false);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
               new BillReceipt();
	}
}
