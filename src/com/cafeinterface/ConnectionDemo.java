package com.cafeinterface;
import java.awt.Choice;
import java.sql.*;
import javax.swing.JTable;
 public class ConnectionDemo {
	 Connection cn;
	   Statement st;
	   ResultSet rs;
	 JTable table;
	 Choice choiceempid;
	
	 ConnectionDemo()
	 {
		 try
	 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe","root","Sandy");
	      st=cn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	 }	
public static void main(String args[])
{
	new ConnectionDemo();
	
}

}	


