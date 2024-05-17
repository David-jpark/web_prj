package com.kosta.sample.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class MyOracleConnection {
	static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static final String DB_ID = "it";
	static final String DB_PW = "0000";
	
	public DataSource myOracleDataSource() {
		OracleConnectionPoolDataSource obj = null;
		try {
			obj = new OracleConnectionPoolDataSource();
			obj.setURL(DB_URL);
			obj.setUser(DB_ID);
			obj.setPassword(DB_PW);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return obj ;
		
	}
	
	public Connection oracleConn() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			if(conn != null) {
				System.out.println("connection ok");
			} else {
				System.out.println("connection faild");
			}
			String sql = "select * from board";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return conn;
	}
	public void oracleClose(Connection conn, PreparedStatement ps,ResultSet rs) {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	public void oracleClose(Connection conn, PreparedStatement ps) {
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
}
