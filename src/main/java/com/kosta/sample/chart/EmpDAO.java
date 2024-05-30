package com.kosta.sample.chart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kosta.sample.common.MyOracleConnection;

public class EmpDAO {
	public ArrayList<EmpVO> empSelect(){
		MyOracleConnection obj = new MyOracleConnection();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DataSource ds = null;
		
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			ds = obj.myOracleDataSource();
			conn =  ds.getConnection();
			String sql = "select empno, ename, nvl(sal,0) as sal from emp"; //null처리 중요
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("Ename"));
				evo.setSal(rs.getInt("sal"));
				list.add(evo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			obj.oracleClose(conn,ps,rs);
		} 
		return list;
	}
	
	
	public static void main(String[] args) {
//		EmpDAO dao = new EmpDAO();
//		ArrayList<EmpVO> list = dao.empSelect();
//		System.out.println("총:" + list.size());
//		for(EmpVO evo : list) {
//			System.out.println(evo.getSal());
//		}
	}
}
