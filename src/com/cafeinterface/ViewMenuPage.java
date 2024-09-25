package com.cafeinterface;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class ViewMenuPage extends JFrame implements ActionListener {
	Choice choiceempid;
	JTable table;
	JButton bsearch,print;
	Font f1=new Font("SAN_SERIF",Font.BOLD,15);
	Font f=new Font("SAN_SERIF",Font.BOLD,13);
	ConnectionDemo cd1=new ConnectionDemo();

	public ViewMenuPage() {

		getContentPane().setBackground(new Color(192, 192, 192));
		
		JLabel search=new JLabel("Search By Item Id ");
		search.setBounds(357,20,201,25);
		search.setFont(new Font("Dialog", Font.BOLD, 20));
		getContentPane().add(search);
		
		choiceempid=new Choice();
		choiceempid.setBackground(new Color(255, 255, 255));
		choiceempid.setBounds(596,20,150,25);
		choiceempid.setFont(f1);
		choiceempid.add(""+101);
		getContentPane().add(choiceempid);
		try {
			
			 cd1.rs=cd1.st.executeQuery("select * from ItemInfo");
			while(cd1.rs.next()) {
				//System.out.println("1");
				choiceempid.add(cd1.rs.getString("ItemId"));
				
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		/*To fetch Employee id's from table and add to the dropdown*/
		table=new JTable();
		try {
			 cd1.rs=cd1.st.executeQuery("select *  from ItemInfo");
			//To convert data of resultset into the table
			table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	JScrollPane jp=new JScrollPane(table);
	jp.setBounds(0,100,1000,600);
	getContentPane().add(jp);
		
	bsearch=new JButton("View Details");
	bsearch.setForeground(new Color(0, 0, 0));
	bsearch.setBounds(406,70,141,25);
	bsearch.setBackground(new Color(255, 255, 255));
	bsearch.setFont(new Font("Dialog", Font.BOLD, 15));
	getContentPane().add(bsearch);

	print=new JButton("Print");
	print.setForeground(new Color(0, 0, 0));
	print.setBounds(618,70,80,25);
	print.setBackground(new Color(255, 255, 255));
	print.setFont(new Font("Dialog", Font.BOLD, 15));
	getContentPane().add(print);

	bsearch.addActionListener(this);
	print.addActionListener(this);

		setSize(1000,700);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==bsearch) {
			String query="select *from ItemInfo where ItemId='"+choiceempid.getSelectedItem()+"'";
			try {
				 cd1.rs=cd1.st.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
				
			}catch(Exception E) {
				E.printStackTrace();
			}
		}
		else if(e.getSource()==print) {
			try {
				table.print();
			}catch(Exception E) {
				E.printStackTrace();
			}
		}
	}

	public static void main(String[] args) 
	{
		
      new ViewMenuPage();
	}

}
