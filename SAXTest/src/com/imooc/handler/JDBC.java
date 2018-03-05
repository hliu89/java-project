package com.imooc.handler;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {
	private static final String URL="jdbc:mysql://localhost:3306/itmd515final?autoReconnect=true&useSSL=false";
	private static final String USER="root";
	private static final String PASSWORD="qwasqwas2271";
	
	private Connection conn=null;
	
	 {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return conn;
	
 }
}
