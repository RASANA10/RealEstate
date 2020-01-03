package org.btm.jdbcDeleteApp;

import java.sql.*;

public class jdbcDeleteDemo
{
public static void main(String[] args)
{
Connection Con=null;
try
{
class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver class loaded and ragister");
Con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=root");
}
cat
}
}
