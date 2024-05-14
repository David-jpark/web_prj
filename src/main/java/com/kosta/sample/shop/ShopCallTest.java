package com.kosta.sample.shop;

public class ShopCallTest {

	public static void main(String[] args) {
		Member m = new Member(); //member class 사용
		int res = m.order(1000); // 1000 + 100 기본 + 100 추가10%
		System.out.println("회원구매:" + res);
		
		Guest g = new Guest(); // guest class 사용
		int gres = g.order(1000);// 1000 + 100
		System.out.println("비회원구매:"+ gres);
		
		
	}

}
