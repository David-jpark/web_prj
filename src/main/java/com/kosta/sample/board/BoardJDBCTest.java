package com.kosta.sample.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kosta.sample.json.EmpVO;


public class BoardJDBCTest {
	//오라클 연결(자바기준) = give : parameter
	//				  = take : return
	static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static final String DB_ID = "it";
	static final String DB_PW = "0000";
	
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
//	public ArrayList<EmpVO> boardSelect(Connection conn) {
	public ArrayList<EmpVO> boardSelect() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		try {
			conn =  oracleConn();
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
	/**
	  		 Statement createStatement() 		vs 	PreparedStatement prepareStatement()
파라미터 "select * from emp where empno =" + empno		"select *from emp where empno=?"
컴파일		실행시점에 컴파일								사전 컴파일(DB는 컴파일 없이 바로 실행) - 캐싱기능
속도													효율적
바이너리데이터  X										O
주사용처 		SQL문의 변경이 거의 없는 경우 (DDL)				SQL문의 변경이 자주 일어나는 경우 (DML = where조건 등)
문법		stmt = conn.createStatement();				pstmt = conn.prepareStatement(sql)
													pstmt.setInt(1, empno);
보안			상당히 취약 (SQL Injection공격)
	 */
//	-------------------
//	**createStatement
//	-------------------
	public int boardDelete(int empno) {
		
		Connection conn = null;
		Statement stmt = null;
		int delCount = 0;
			try {
				conn =  oracleConn();
//				String sql = "select * from emp where empno =" + empno; // 하드코딩 메모리 적으로 단점
				/**
				 *차이점
				java.sql.Interface Connection
				public interface Connection{
					public abstract PreparedStatement	prepareStatement(String sql); 미리준비해라 SQL을
					public int executeUpdate(); **
					 
					public abstract Statement createStatement(); 
					public int executeUpdate(String sql); **
				}
				*/
				String sql = "select * from emp where empno =" + empno;
				stmt = conn.createStatement();
//				pstmt.setInt(1, empno); //-------------바인딩이 없다. 
				delCount = stmt.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				oracleClose(conn,stmt);
			} 
			return delCount;

	}
	public void oracleClose(Connection conn, Statement stmt,ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void oracleClose(Connection conn, Statement stmt) {
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	----------------------
//	 **PreparedStatement
//	----------------------
	/** 
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

				}
				
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
				
			
	}*/
	
//	내가 한 코드
//	public List<EmpVO> boardSelect() throws SQLException {
//		String sql = "select * from emp";
//		Connection conn =  oracleConn();
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
//		
//		
//		
//		while (rs.next()) {
//			EmpVO vo = new EmpVO();
//			vo.setEmpno(rs.getInt("empno"));
//			vo.setEname(rs.getString("ename"));
//			list.add(vo);
//		}
//		
//			System.out.println("총 :" + list.size());
//			for(int i = 0; i<list.size(); i++) {
//				int a = list.get(i).getEmpno();
//				String b = list.get(i).getEname();
//				System.out.println(a+"\t"+b);
//			}
//		return list;
//		
//	}
	
	/**	
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
	*/
//	-- 내가 구현한 기능
//	
//	public void oracleClose() throws SQLException{
//		String sql = "select * from emp";
//		Connection conn = oracleConn();
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		try {
//			if (rs != null) rs.close();
//			if (pstmt != null) pstmt.close();
//			if (conn != null) conn.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
	
	public static void main(String[] args) throws SQLException {	
		BoardJDBCTest board = new BoardJDBCTest();
//        List<EmpVO> empList = board.boardSelect();
//		board.oracleClose();
		
//		Connection conn = board.oracleConn(); 
//		Connection conn2 = board.oracleConn();
//		매번 conn을 선언해야하기 때문에 불편하다, 꺼내져있는 것 보다 밖으로 내보내는게 낫다.
		
//		ArrayList<EmpVO> list = board.boardSelect(conn); 구조 상 좋지 않은 설계
//		b.oracleClose(conn,pstmt, rs); // 할 수 없다. pstmt, rs가 없으니깐 이미 위에서 닫힘
		
		int delCount = board.boardDelete(7521);
		System.out.println("총 삭제 : " + delCount);

		ArrayList<EmpVO> list = board.boardSelect();
		
		System.out.println("총 :" + list.size());
		for(int i = 0; i<list.size(); i++) {
			int a = list.get(i).getEmpno();
			String b = list.get(i).getEname();
			System.out.println(a+"\t"+b);
		}
		
//		b.boardDelete(conn2, 7733);
		
	}
}
