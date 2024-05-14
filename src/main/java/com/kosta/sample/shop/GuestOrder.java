package com.kosta.sample.shop;

public class GuestOrder extends Order {
	
	@Override
	public int order(int price) {
		int point100 = super.order(price); // super : 상속받은 부모의 생성자를 호출
		int res = price + point100 ;
		return res;
	}
}
