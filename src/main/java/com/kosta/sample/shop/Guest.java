package com.kosta.sample.shop;

public class Guest extends User {
//	private final int ORDER_POINT = 100; // 값 변경 불가, 직접 접근 불가
//	public int getOrderPoint() {
//		return this.ORDER_POINT;
//	} // 상속으로 있는 효과
	
	@Override
	public int order(int price) { // 주문 적립금 
		int res = price + getOrderPoint();
		return res;
		
		
//////////////////////////////////////////////////		
//		int order1 = 0;
//		return order1;
	}


}
