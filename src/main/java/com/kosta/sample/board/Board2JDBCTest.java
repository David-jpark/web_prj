package com.kosta.sample.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.sql.PooledConnection;

import com.kosta.sample.json.EmpVO;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class Board2JDBCTest {

	static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static final String DB_ID = "it";
	static final String DB_PW = "0000";
	
	/**
	 * DBCP(DataBase Connection Pool) : 
	 * - Database connection pooling services
	 * - DB connection을 미리 만들어 풀로 관리하는 서비스
	 * 
	 * DataSource
	 * - 어플리케이션과 데이터베이스의 인터페이스
	 * - DataSource를 사용해 DBCP(Pool)에 있는 connection 사용
	 * - javax.sql.DataSource
	 */
	
//	-------------Oracle Connection Pooling------------------
	public DataSource myOracleDataSource() {
		OracleConnectionPoolDataSource obj = null;
		try {
			obj = new OracleConnectionPoolDataSource();
			obj.setURL(DB_URL);
			obj.setUser(DB_ID);
			obj.setPassword(DB_PW);
//			PooledConnection pc = obj.getPooledConnection();
//			Connection conn = pc.getConnection();
//			
//			conn.close();
//			pc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return obj ;
		
	}
	
	// Oracle Connection
	
	public Connection oracleConn() { 
		Connection conn = null;
		PreparedStatement pstmt = null;
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
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	
	public ArrayList<EmpVO> boardSelect() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		DataSource ds = null;
		
		try {
//			conn =  oracleConn();
			
			//---------DBCP를 사용한 DB연결-----------------
			ds = myOracleDataSource();
			conn = ds.getConnection(); // javax.sql.DataSource
								//OracleConnectionPoolDataSource.getPooledConnection();
			
			
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt("empno"));
				vo.setEname(rs.getString("ename"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			oracleClose(conn,pstmt, rs);
			}
		return list;
			
		}
	
	public int boardDelete(int empno) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int delCount = 0;
			try {
				conn =  oracleConn();
//				String sql = "select * from emp where empno =" + empno; // 하드코딩 메모리 적으로 단점
				/**
				java.sql.Interface Connection
				public interface Connection{
					public abstract PreparedStatement	prepareStatement(String sql);
					public abstract Statement createStatement();
				*/
				
				
				String sql = "select * from emp where empno =?"; // ----값이 변할 때
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, empno); //---------------(런타임 시) 동적 바인딩 (첫번째 물음표)
//					set바인딩값타입(1번째 물음표에, 바인딩될값) *반드시 실행 전에 해야한다
				delCount = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				oracleClose(conn,pstmt);
			} 
			return delCount;
				
			
	}

	public void oracleClose(Connection conn, PreparedStatement pstmt,ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void oracleClose(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		BoardJDBCTest board2 = new BoardJDBCTest();
		int delCount = board2.boardDelete(7521);
		System.out.println("총 삭제 : " + delCount);

		ArrayList<EmpVO> list = board2.boardSelect();
		
		System.out.println("총 :" + list.size());
		for(int i = 0; i<list.size(); i++) {
			int a = list.get(i).getEmpno();
			String b = list.get(i).getEname();
			System.out.println(a+"\t"+b);
		}
		

	}

}
