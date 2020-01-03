package org.btm.jdbcUpdateApp;

import java.sql.*;

public class jdbcUpdateDemo 
{
public static void main(String[] args)
{
	Connection con=null;
	Statement stmt=null;
	String qry="Update btm.student setname='adarsh' where ID=4";
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Class loaded and Ragistered");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		System.out.println("connection establised with database Server");
		stmt=con.createStatement();
		System.out.println("plateform created");
		stmt.executeUpdate(qry);
        System.out.println("Data UPDATED!!!");
	}
	catch (ClassNotFoundException |SQLException e) 
	{
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null)
		{
		 try
		 {
			stmt.close();
		 }
		 catch(SQLException e)
		 {
		   e.printStackTrace();
		 }	
		}
		
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch (SQLException e) 
			{
			 e.printStackTrace();
			}
		}
     System.out.println("Close all costly resources!!!");
    }
  }
}
