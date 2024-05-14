package com.kosta.lec;
//접근제어자
public class Lec07modiSame {
	
	public int samePoint = 100;
	
	public void sameMethod() {
		System.out.println("sameMethod() 콜");
	}

	protected int samePoint2 = 222;
	int sameDefaultPoint = 444;
	
	private int samePrivatePoint = 555;
	public int getsamePrivatePoint() { //private를 read only로 값만 가져가게 만듬
		return this.samePrivatePoint;
	}
	
	
	public void dumy() {
		System.out.println(samePrivatePoint);
	}
}
