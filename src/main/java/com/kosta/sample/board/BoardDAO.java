package com.kosta.sample.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.kosta.sample.common.MyOracleConnection;

public class BoardDAO extends MyOracleConnection{
	
	//5.20
	
	//프로토타입 개발 : 무엇을 쓸지 맞춰놓고 후에 코드 작성
	// 조인 사용 x번 게시물 + reply 목록
	public BoardVO boardReplySelect(int seq){
		MyOracleConnection obj = new MyOracleConnection();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DataSource ds = null;
		
		BoardVO bvo = null;
		
		try {
			ds = obj.myOracleDataSource();
			conn =  ds.getConnection();
			String sql = "select b.seq, b.title, b.contents, b.regid, b.regdate, "
					+ "r.rseq, r.reply, r.regid as rregid, r.regdate as rregdate from board b, reply r "
					+ "where b.seq=? and b.seq = r.seq(+) order by r.rseq desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
			ArrayList<ReplyVO> replyList = new ArrayList<ReplyVO>();
			while (rs.next()) {
				if (bvo == null) { // bvo가 null값인 경우 담아라.
					
				bvo = new BoardVO();
				bvo.setSeq(rs.getInt("seq"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContents(rs.getString("contents"));
				bvo.setRegid(rs.getString("regid"));
				bvo.setRegdate(rs.getString("regdate"));
			}
				ReplyVO rvo = new ReplyVO();
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setReply(rs.getString("reply"));
				rvo.setRegid(rs.getString("rregid"));
				rvo.setRegdate(rs.getString("rregdate"));
				replyList.add(rvo);
				
			}
			bvo.setReplies(replyList); // replylist에 담아서 return값과 맞춘다.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			obj.oracleClose(conn,ps,rs);
		}
		return bvo;
	}
	
	////////////////////////////////////////////////////////
//	x번 게시물의 reply목록 가져오기
	////////////////////////////////////////////////////////
	public ArrayList<ReplyVO> replyList(int seq){
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();
		//변수들
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DB
		MyOracleConnection obj = new MyOracleConnection();
		DataSource ds = null;
		try {
			ds = obj.myOracleDataSource();
			conn = ds.getConnection();
			String sql = "select * from reply where seq=? order by rseq desc";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
			
			while(rs.next()){
				ReplyVO rvo = new ReplyVO();
				
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setReply(rs.getString("reply"));
				rvo.setRegid(rs.getString("regid"));
				rvo.setRegdate(rs.getString("regdate"));
				list.add(rvo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			obj.oracleClose(conn,ps,rs);
		}
		return list; 
	}
	/////////////////////////////////////////////////////////////////
	
	
	public BoardVO selectBoardOne(int seq){ //1건만 가져오기
		MyOracleConnection obj = new MyOracleConnection();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DataSource ds = null;
		
		BoardVO bvo = new BoardVO();
		try {
			ds = obj.myOracleDataSource();
			conn = ds.getConnection();
			String sql = "select * from board where seq=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
			rs.next();
			
			bvo.setSeq(rs.getInt("seq"));
			bvo.setTitle(rs.getString("title"));
			bvo.setContents(rs.getString("contents"));
			bvo.setRegid(rs.getString("regid"));
			bvo.setRegdate(rs.getString("regdate"));
//			bvo.setReplies(rs.get("replies"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			obj.oracleClose(conn,ps,rs);
		} 
		
		return bvo;
	}
	
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
	// ROW 삭제
	public int deleteBoard(int seq) {
		Connection conn = null;
		PreparedStatement ps = null;
		MyOracleConnection obj = new MyOracleConnection();
		DataSource ds = null;
		int delRows = 0;
		
			try {
				ds = obj.myOracleDataSource();
				conn =  ds.getConnection();
//				String sql = "select * from board order seq desc";
				String sql = "delete from board where seq=?"; // ----값이 변할 때
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
	
	public int boardInsert(BoardVO bvo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int insertRows = 0;
		DataSource ds = null;
		MyOracleConnection obj = new MyOracleConnection();
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			ds = obj.myOracleDataSource();
			conn = ds.getConnection();  

			String sql = "insert into board values(board_seq.nextval,?,?,?,sysdate)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bvo.getTitle());
			ps.setString(2, bvo.getContents());   	
			ps.setString(3, bvo.getRegid());
			insertRows =  ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			obj.oracleClose(conn, ps);
		}
		return insertRows;
	}
	
	// public int boardUpdate(String title.....~) 매번 추가해야하는 단점
	public int boardUpdate(BoardVO bvo) {
		Connection conn = null;
		PreparedStatement ps  = null;
		int updateRows = 0;
		DataSource ds = null;
		MyOracleConnection obj = new MyOracleConnection(); 
		
		//---------------DBCP를 사용한 DB 연결 -----------------------
		try {
			//conn = moc.oracleConn();
			ds = obj.myOracleDataSource();
			conn = ds.getConnection();  

			String sql = "update board set title=?, contents=? where seq=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bvo.getTitle());
			ps.setString(2, bvo.getContents());   	
			ps.setInt(3, bvo.getSeq());   	
			updateRows =  ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			obj.oracleClose(conn, ps);
		}
		return updateRows;

	}
	
	public int deleteReply(int rseq) {
		Connection conn = null;
		PreparedStatement ps = null;
		MyOracleConnection obj = new MyOracleConnection();
		DataSource ds = null;
		int delRows = 0;
		
			try {
				ds = obj.myOracleDataSource();
				conn =  ds.getConnection();
//				String sql = "select * from board order seq desc";
				String sql = "delete from reply where rseq=?"; // ----값이 변할 때
				ps = conn.prepareStatement(sql);
				ps.setInt(1, rseq);
				delRows = ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				obj.oracleClose(conn,ps);
			} 
			return delRows;
	}
	
	public int replyInsert(ReplyVO rvo) {
		//rseq, reply, regid, 				regdate, seq
		//nextval 		session,cookies		sysdate
		Connection conn = null;
		PreparedStatement ps = null;
		int insertRows = 0;
		DataSource ds = null;
		MyOracleConnection obj = new MyOracleConnection();
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			ds = obj.myOracleDataSource();
			conn = ds.getConnection();  

			String sql = "insert into reply values(reply_seq.nextval,?,'testid',sysdate,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, rvo.getReply());
			ps.setInt(2, rvo.getSeq());   	
			insertRows =  ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			obj.oracleClose(conn, ps);
		}
		return insertRows;
	}
	
}
