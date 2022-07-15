package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	private String jdbcConnectionURL;
	private String username;
	private String password;

	public JDBC(String username, String password) {
		jdbcConnectionURL = "jdbc:mysql://localhost:3306/ims?serverTimezone=UTC";
		this.username = username;
		this.password = password;
	}

	public JDBC(String jdbcConnectionURL, String username, String password) {
		this.jdbcConnectionURL = jdbcConnectionURL;
		this.username = username;
		this.password = password;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcConnectionURL, username, password);
	}
}
