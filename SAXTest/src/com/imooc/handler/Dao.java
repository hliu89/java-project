package com.imooc.handler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Dao {

	public void insertCar(String id, String type, String seat, float per_hour, float per_week) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
			try {
				stat = conn.createStatement();
	      String sql = "INSERT INTO car (id,type,seat,per_hour,per_week) values("+"'"+id+"',"+
		"'"+type+"',"+"'"+seat+"',"+"'"+per_hour+"',"+"'"+per_week+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void insertCustomer(String id, String name, String password) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
			try {
				stat = conn.createStatement();
	      String sql = "INSERT INTO customer (id,name,password) values("+"'"+id+"',"+
		"'"+name+"',"+"'"+password+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void insertDriver(String id, String name, String password, float receipt, String car_id) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
			try {
				stat = conn.createStatement();
	      String sql = "INSERT INTO driver (id,name,password,receipt,car_id) values("+"'"+id+"',"+
		"'"+name+"',"+"'"+password+"',"+"'"+receipt+"',"+"'"+car_id+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void insertRootUser(String id, String name, String password,String administrator) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
			try {
				stat = conn.createStatement();
	      String sql = "INSERT INTO rootuser (id,name,password,administrator) values("+"'"+id+"',"+
		"'"+name+"',"+"'"+password+"',"+"'"+administrator+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
//	"CREATE TABLE Transaction (" + 
//		"id varchar(20) not null primary key," + 
//		"duration varchar(30)," + 
//		"date Date," + 
//		"Money float,"+
//		"car_id varchar(100),"+
//		"driver_id varchar(100),"+
//		"state varchar(100),"+
//		"customer_id varchar(20));";
	public void insertTransaction(String id, String duration, float money,String car_id, String driver_id, String state, String customer_id) {
		// TODO Auto-generated method stub
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
			try {
				Date date=new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String d = sdf.format(date);
				stat = conn.createStatement();
	      String sql = "INSERT INTO transaction (id,duration, date,money,car_id,driver_id,state,customer_id) values("+"'"+id+"',"+
		"'"+duration+"',"+"'"+d+"',"+"'"+money+"',"+"'"+car_id+"',"+"'"+driver_id+"',"+"'"+state+"',"+"'"+customer_id+"'"+")";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
