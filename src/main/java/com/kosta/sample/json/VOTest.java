package com.kosta.sample.json;

//Entitiy 클래스 : 값을 넣고 빼기 위한 용도의 클래스
//	- VO : Value Object (읽기)
//	- DTO: Data Transfer Object (읽기/수정)
//	private int num;
//	setter(): 넣기
//	getter(): 꺼내기

//import com.kosta.sample.json.EmpVO; -- 다른 패키지는 import
public class VOTest {

	public static void main(String[] args) {
		EmpVO evo = new EmpVO();
		evo.setEmpno(7733);
		evo.setEname("smith");
		evo.setSal(600);
		
		int a = evo.getEmpno();
		String b = evo.getEname();
		int c = evo.getSal();
		System.out.println(a+","+b+","+c);
		
		EmpVO evo2 = new EmpVO(8888,"king", 500);
		System.out.println(evo2.toString());
	}

}
