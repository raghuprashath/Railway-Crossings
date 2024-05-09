package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static boolean c=true;
	public static Connection getConnection()
	{
		Connection conObj = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/traincrossings","root", "223004067@Sastra");
		} catch (Exception e) {
			System.out.println("Unable to connect to database"+e);
		} 
		return conObj;
	}
}