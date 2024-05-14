package com.kosta.sample.shop;


public class ShopCallTest2 {

	public static void main(String[] args) {
		User u = new User();
//		MemOrder mo = new MemOrder();
		int mRes = u.orderByUser(new MemOrder(), 1000);

		int gRes = u.orderByUser(new GuestOrder(), 1000);
//		GuestOrder go = new GuestOrder();
		
		System.out.println("MEMBER 연결 구매금액 : " + mRes);
		System.out.println("GUEST 연결 구매금액 : " + gRes);
	}

}
