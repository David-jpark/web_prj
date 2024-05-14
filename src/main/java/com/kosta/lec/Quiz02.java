package com.kosta.lec;

public class Quiz02 {

	public static void main(String[] args) {
		//3-2
		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket = numOfApples%sizeOfBucket + (numOfApples%sizeOfBucket > 0 ? 1 :0);
		
		System.out.println("필요한 바구니의 수 :" + numOfBucket);
		
		//3-3
//		int num = 10;
//		System.out.println(num == 0 ? "0" : (num > 1) ? "양수" : "음수");
		
		//3-4
//		int num = 456;
//		System.out.println((num/100)*100);
//		int fnum = (int)((float)num *0.01f);
//		System.out.println(fnum*100);
		
		//3-5
//		int num = 333;
//		System.out.println(num/10*10+1);
		
		//3-6
//		int num = 24;
//		System.out.println(10-num%10);
//		System.out.println((num/10+1)*10-num);
		
		//3-7
		int fahrenheit = 100;
		float celcius = ((float)(fahrenheit-32)*5/9);
		
		System.out.println("Fahrenheit :"+ fahrenheit);
		System.out.println("celcius:"+celcius);
		
		
		
		
	}

}
