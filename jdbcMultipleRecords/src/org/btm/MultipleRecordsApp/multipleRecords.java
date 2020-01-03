package org.btm.MultipleRecordsApp;

import java.sql.*;

public class multipleRecords 
{
public static void main(String[] args)
{
	Connection Con=null;
	Statement stmt=null;
	String qr1="Insert into btm.student values(1,'akanksha',87.09)";
	String qr2="Insert into btm.student values(2,'ak',77.09)";

	String qr3="Insert into btm.student values(3,'akan',47.09)";

 try
 {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("driver classes load and ragistered");
    Con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
    System.out.println("establish the connection");
    stmt=Con.createStatement();
    System.out.println("plateform created");
    stmt.executeUpdate(qr1);
    System.out.println("data inserted");
    
  } 
 catch (ClassNotFoundException | SQLException e ) 
 {
	e.printStackTrace();
 } 
 finally
 {
 if(Con!=null)
 {
	 try 
	 {
		Con.close();
	 }
	 catch (Exception e) 
	 {
		 e.printStackTrace();
	 }
 }
 if(stmt!=null)
 {
	 try 
	 {
		stmt.close();
	 }
	 catch (Exception e) 
	 {
		e.printStackTrace(); 
	 }
	 }
	 
	 
 }
}
}
