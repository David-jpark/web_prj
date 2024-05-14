package com.kosta.sample.quiz1;

public class Parent {
	//개별 점수를 넣기
	private int[] scores = new int[3];
	static int korSum;
	static int engSum;
	static int mathSum;
//	private int[][] scoreSum = new int[2][3];
	
	
	public Parent() {
		System.out.println("국어\t영어\t수학");
	}
	public Parent(int kor, int eng, int math) {
		this(); //= new Score();
		korSum += kor;
		engSum += eng;
		mathSum += math;
		System.out.println(kor+"\t"+eng+"\t"+ math);
		
	}
	public Parent(int[] scores) {
		this();
		for(int i=0; i<scores.length; i++) {
			System.out.print(scores[i]+"\t");
		}
//		korSum += scores[0];
//		engSum += scores[1];
//		mathSum += scores[2];
	}
	public static String subjectSum() {
		String msg = "총합" + korSum + "\t총합" + engSum + "\t총합" + mathSum;
		return msg;
		
//		int[] s = {korSum, engSum, mathSum};
//		return s;
		
	}
}
