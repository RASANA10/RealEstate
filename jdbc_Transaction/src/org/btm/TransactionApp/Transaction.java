package org.btm.TransactionApp;

import java.sql.*;
import java.util.Scanner;
public class Transaction
{
public static void main(String[] args)
{
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	String stded="Insert into btm1.studentedu values(?,?,?,?)";
	String stper="Insert into btm1.studentper values(?,?,?)";
	Scanner kb=new Scanner(System.in);
	System.out.println("enter the id");
	int id=kb.nextInt();
	System.out.println("enter the name");
	String name=kb.next();
	System.out.println("enter the dept");
	String dept=kb.next();
	System.out.println("enter the perc");
	double perc=kb.nextDouble();
	System.out.println("enter the place");
	String place=kb.next();
	kb.close();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver class loaded and ragistered");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		System.out.println("establish the connection");
		con.setAutoCommit(false);
		pstmt=con.prepareStatement(stded);
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, dept);
		pstmt.setDouble(4, perc);
		pstmt.executeUpdate();
		System.out.println("student educational details executes!!!");
	 
	    
	    pstmt1=con.prepareStatement(stper);
	    pstmt1.setInt(1, id);
	    pstmt1.setString(2, name);
	    pstmt1.setString(3, place);
	    pstmt1.executeUpdate();
	    System.out.println("Student personal detail executed");
	    con.commit();
	} 
	catch (ClassNotFoundException | SQLException e) 
	{
		try 
		{
			con.rollback();
			System.out.println("OPERATION ROLLED BACK");
		} 
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		e.printStackTrace();
	}
	finally
	{
		if(pstmt1!=null)
		{
			try
			{
			pstmt1.close();	
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		if(pstmt!=null)
		{
			try
			{
			pstmt.close();	
			} 
			catch (SQLException e)
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
		System.out.println("closed all costly resources");
	}
}
}
