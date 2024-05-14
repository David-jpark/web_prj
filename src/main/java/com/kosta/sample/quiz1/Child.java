package com.kosta.sample.quiz1;

public class Child extends Parent {
	
	private int[] scores = new int[3];
	
	//생성자 : 기본생성자
	public Child() {}
	
//	public Sukang(int kor, int eng, int math) {
//		scores[0] = kor;
//		scores[1] = eng;
//		scores[2] = math;
//		new Score(scores);
//	}
	//생성자 
	public Child(int kor, int eng, int math) {
		super(kor, eng, math);
	}
//	public Sukang(int[] ss) {
//		super(ss);
////		for(int i=0; i<ss.length; i++) {
////			System.out.print(ss[i]+"\t");
////		}
//		
//	}
	public Child(int[] scores) {
		super(scores);
	}
	
//	public void printsum() {
//		super.subjectSum(super.array);
//	}
	
	
	
//	public static void main(String[] args) {
//		new Sukang(100,90,70);
//		new Sukang(70,80,90);
//		//int[] ss = new int[] {20,30,40};
//		Sukang s = new Sukang(ss);
		
//	}
}
