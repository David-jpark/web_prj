package com.kosta.sample.quiz1;

public class Calltest {

	public static void main(String[] args) {
		new Child(100,90,70);
		new Child(70,80,90);
		
		Parent sc = new Parent();
		String res = sc.subjectSum();
		System.out.println(res);
		
//		int[] temp = new int[] {100,90,80};
//		new Sukang(temp);
//		System.out.println();
//		new Sukang(new int[] {88,77,66});
   }
}
