package com.kosta.test;

public class Subject extends ScoreTest {
	private int[] scores = new int[3];
	
	public Subject() {	//기본생성자
		super();
	}
	
	public Subject(int a, int b, int c) {
		super(a,b,c);
		scores[0] = a;
		scores[1] = b;
		scores[2] = c;
	}
}
