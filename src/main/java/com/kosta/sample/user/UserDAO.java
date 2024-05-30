package com.kosta.sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.kosta.sample.common.MyOracleConnection;

// Data Access Object : DML

public class UserDAO {
	
	public int userInsert(UserVO uvo) {
		MyOracleConnection obj = new MyOracleConnection(); // 클래스를 분리시켰기 때문에 인스턴스 생성
		Connection conn = null;
		PreparedStatement ps = null;
//		ResultSet rs = null;
		DataSource ds = null;
		int insertRows = 0;
		// 파라미터가 잘 넘어왔는지 확인용 코드( seq=0, regdate =null)
		System.out.println(uvo.toString());
		
		try {
//			conn = obj.oracleConn();
			ds = obj.myOracleDataSource();
			conn =  ds.getConnection();
			
			if(conn != null) {
				System.out.println("conn pool ok");
				
				String sql = "insert into users values(users_seq.nextval,?,?,?,?,sysdate,'u')"; 
				//(seq, userid, uname, email, passwd, regdate, grade default)
				ps = conn.prepareStatement(sql);
				ps.setString(1, uvo.getUserid());
				ps.setString(2, uvo.getUname());
				ps.setString(3, uvo.getEmail());
				ps.setString(4, uvo.getPasswd());
				
				insertRows =  ps.executeUpdate();
			} else {
				System.out.println("conn pool fail");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			obj.oracleClose(conn,ps);
		}
		
		
		return 1; // 유저가 insert 되면 리턴1
		
	}
	
	public UserVO userLogin(String userid, String passwd) {
		MyOracleConnection obj = new MyOracleConnection();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DataSource ds = null;
		UserVO uvo = null;
		
		boolean userCheck = false; //rs.next();
		
		try {
			ds = obj.myOracleDataSource();
			conn = ds.getConnection();
			String sql = "select userid, uname, grade from users where userid =? and passwd =?";
			ps = conn.prepareStatement(sql);
//			인덱스에서 누락된 IN 또는 OUT 매개변수:: 2 무조건 바인딩을 안해서 오류
			ps.setString(1, userid);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			
			
			if(rs.next()) { //userCheck이 true고 while을 사용하면 한줄한줄 확인하기 때문에 if가 낫다. 
				//가져올게 있으면 next
				uvo = new UserVO();
//				userid = rs.getString("userid");
//				String uname = rs.getString("uname");
//				String email = rs.getString("email");
//				System.out.println(userid + "\t" + uname + "\t" + email);
				uvo.setUserid(rs.getString("userid"));
				uvo.setUname(rs.getString("uname"));
				uvo.setGrade(rs.getString("grade"));
				userCheck = true; // 좀 더 안전하게 모두 값을 넣고나서 true 출력
				
			}
			
		} catch (SQLException e) {
//			userCheck = false;
			e.printStackTrace();
		} finally {
			obj.oracleClose(conn,ps,rs);
		}
		
		return uvo; // 아이디 패스워드를 비교해서 true면 userCheck반환
		
	}
	
}
