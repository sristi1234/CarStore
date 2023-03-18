package com.training.inventory.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	
     private static final String URl = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String UserName = "HR";
	private static final String Password = "hr";
	private  static Connection connection;

	public static Connection getConnection() throws SQLException {
		return  DriverManager.getConnection(URl, UserName, Password);
	}

	

}
