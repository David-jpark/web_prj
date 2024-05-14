package com.kosta.sample.shop;

public class User {
	private final int ORDER_POINT = 100; // 값 변경 불가, 직접 접근 불가
	public int getOrderPoint() {
		return this.ORDER_POINT;
	}
	
	public String getUserName(String uid) {
		//DB조회 select ename from emp where userid ..~
		return "홍길동";
	}

	public int order(int price) {
		int res = 0;
		return res;
	}
	
	public String getCompName() {
		return "KOSTA";
	}
	
	
	public int orderByUser(Order o, int price) {
		//런타임 타입체크 : isInstance() o.isInstance(MemOrder)
		//컴파일 타입체크 : instanceof	o instanceof MemOrder
//		if(o instanceof MemOrder) { // (객체 instanceof 클래스) 상속 관계에서 부모객체인지 자식 객체인지 확인
//			MemOrder mo = new MemOrder();
			int res = o.order(1000);
			return res;
			
		}
	
	
//	User u = Member()				다형성을 조금 더 향상시킨 예
//	u.orderByUser(null, ORDER_POINT)
//	
//	User u = Guest()
//	u.orderByUser(null, ORDER_POINT)
	
	
	
////////////////////내가 쓴 코드/////////////////////////////////	
//	protected String getUserName(String uid) {
//		String user1 = "진우";
//		return user1;
//	}
//	
//	private static void orderPoint(int point) {
//		int userPoint = 100;
//		System.out.println("당신의 포인트는 : " + userPoint);
//	}
//	
//	public void getCompName() {
//		
//	}
//	
//	public int order(int price) {
//		int order1 = price;
//		return order1;
//	}

}
