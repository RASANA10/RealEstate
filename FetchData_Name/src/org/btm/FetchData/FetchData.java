package org.btm.FetchData;
import java.sql.*;
import java.util.Scanner;
public class FetchData
{
public static void main(String[] args) 
{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String qry="Select * from btm.student where name=?";
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter name");
	String name=sc.next();
	sc.close();
	
try
{
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver class loaded and ragistered");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
	System.out.println("establish the connection");
	pstmt=con.prepareStatement(qry);
	System.out.println("plateform created");
	pstmt.setString(1, name);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		int id=rs.getInt(1);
		double perc=rs.getDouble(3);
		System.out.println(id+" "+perc);
	}
	else
	{
		System.out.println("this name is not present in database");
	}
} 
catch (ClassNotFoundException | SQLException e)
{
	e.printStackTrace();
}	
finally
{
	if(rs!=null)
	{
		try 
		{
			rs.close();
		} 
		catch(SQLException e) 
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
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}
	System.out.println("closed all costly resources");
	
}
}
}
