package com.solent2.againjaxrs.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseConfiguration {
	

	
	private static DatabaseConfiguration newInstance = null;
	
	private DatabaseConfiguration() {
		
	}
	
	public static DatabaseConfiguration getInstance() {
		if(newInstance == null) {
			newInstance = new DatabaseConfiguration();
		}
		
		return newInstance;
	}
	
	public Connection getDbConnection() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardb", "root", "mysql");
		Connection conn = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-02.cleardb.com/heroku_beb17b1657af8fb", "b33a7e97cdf108", "4b9c42d3");
		return conn;
	}
	
}
