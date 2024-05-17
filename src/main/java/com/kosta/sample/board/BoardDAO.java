package com.kosta.sample.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO extends MyOracleConnection{
	
	public ArrayList<BoardVO> selectBoard(){
		MyOracleConnection obj = new MyOracleConnection();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DataSource ds = null;
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			ds = obj.myOracleDataSource();
			conn =  ds.getConnection();
			String sql = "select * from board";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setSeq(rs.getInt("seq"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContents(rs.getString("contents"));
				bvo.setRegid(rs.getString("regid"));
				bvo.setRegdate(rs.getString("regdate"));
				list.add(bvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			obj.oracleClose(conn,ps,rs);
		} 
		return list;
	}
	public int deleteBoard(int seq) {
		Connection conn = null;
		PreparedStatement ps = null;
		MyOracleConnection obj = new MyOracleConnection();
		DataSource ds = null;
		int delRows = 0;
		
			try {
				ds = obj.myOracleDataSource();
				conn =  ds.getConnection();
				String sql = "select * from board where seq=?"; // ----값이 변할 때
				ps = conn.prepareStatement(sql);
				ps.setInt(1, seq);
				delRows = ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				obj.oracleClose(conn,ps);
			} 
			return delRows;
	}
	
//	public int boardInsert() {
//		int insertRows = 0;
//		String sql = "insert into board values(board_seq.nextval,?,?,?,sysdate)";
//		
//		return insertRows;
//	}
//	// public int boardUpdate(String title.....~) 매번 추가해야하는 단점
//	public int boardUpdate(BoardVO bvo) {
//		int updateRows = 0;
//		String sql = "update board set title=?, contents=? where seq =?";
//		return updateRows;
//
//	}
	
	
}
