package org.btm.jdbc_UpdateApp;

import java.sql.*;

public class jdbcUpdate
{
public static void main(String[] args) 
{
	Connection con=null;
	Statement stmt=null;
	
	String qry="update Student.btm set name='Ak' where id=4";
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver class loaded and ragistered..!!!");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
	    System.out.println("Connection establised with DBServer..!!!");
	    stmt=con.createStatement();
	    System.out.println("plateform created..!!!");
	    stmt.executeUpdate(qry);
	    System.out.println("Data inserted...!!");
	} 
	catch (ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null)
	    try
		{
	    	stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(con!=null)
		try
		{
			con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Closed all costly resources");
	}
}
}
