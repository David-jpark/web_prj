package com.kosta.sample.shop;

public class Member extends User {
//	private final int ORDER_POINT = 100; // 값 변경 불가, 직접 접근 불가
//	public int getOrderPoint() {
//		return this.ORDER_POINT;
//	} // 상속으로 있는 효과
	
	
	@Override
	public int order(int price) {
//		int res = 0;
		int res = price + getOrderPoint() + (int)(price*0.1);
		return res;
		
/////////////////////////////////////////////////////////////////
//		int order1 = price;
//		order1 = price * (int)0.1;
//		return order1;
	}

}