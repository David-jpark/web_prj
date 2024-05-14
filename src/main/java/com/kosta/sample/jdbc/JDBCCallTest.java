package com.kosta.sample.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kosta.sample.json.EmpVO;

import java.sql.DriverManager;

public class JDBCCallTest {
	static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static final String DB_ID = "it";
	static final String DB_PW = "0000";
	public static void main(String[] args) {
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
		
		
			//--------------------------------------------------
			//ArrayList(EmpVO)
			//--------------------------------------------------
			ArrayList<EmpVO> list = new ArrayList<EmpVO>();
			while (rs.next() == true) { // 튜플을 읽는다. 더이상 읽을게 없으면 빠져나간다. rs.next() == true 와 같다.
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt("empno"));
				vo.setEname(rs.getString("ename"));
				list.add(vo);
			}
				System.out.println("총 :" + list.size());
				for(int i = 0; i<list.size(); i++) {
					int a = list.get(i).getEmpno();
					String b = list.get(i).getEname();
					System.out.println(a+"\t"+b);
				}
		

			//--------------------------------------------------
			//ArrayList(HashMap)
			//--------------------------------------------------
//			ArrayList<HashMap<String, Object>> amap = new ArrayList<HashMap<String, Object>>();
//			while (rs.next()) { // 튜플을 읽는다. 더이상 읽을게 없으면 빠져나간다. rs.next() == true 와 같다.
//				int eno = rs.getInt("empno"); // 컬럼이름을 넣는다. ""안에
//				String name = rs.getString("ename");
//				HashMap<String, Object> map = new HashMap<String, Object>();
//				map.put("empno", eno);
//				map.put("ename", name);
//				amap.add(map);
////				System.out.println(eno + "\t" + name);			
//			}
//			for(int i= 0; i<amap.size(); i++) {
//				int a = (int)amap.get(i).get("empno");
//				String b = (String)amap.get(i).get("ename");
//				System.out.println(a+"\t"+b);
//			}
//			System.out.println(amap);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				pstmt.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		

	}

}
