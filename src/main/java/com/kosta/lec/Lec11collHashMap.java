package com.kosta.lec;
/**
 *  Collection ----------------------------Map
 *  List, ArrayList, Vector				   HashMap
 *  set,  HashSet
 *  
 *  Map<K, V>
 *  
 *  JSON(JavaScript Object Notation) --> {key : val}
 *  Python 프로그램 Dictionary(딕셔너리)  --> {key : val}
 *  	-Django, Flask -> FrameWork 에서는 자동 변환
 *  Java프로그램 MAP 					 --> {key = val}
 */


import java.util.HashMap;

public class Lec11collHashMap {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("name","abc");
		map.put("age",10);
		map.put("score",'A');
		map.put("score",'B'); // 동일한 키 값이면 덮어쓰기 한다. (수정)
		
		System.out.println("class,type check : "+map.get("name").getClass());
		System.out.println("class,type check : "+map.get("age").getClass());
		System.out.println("HashMap     : "+map); // 순서가 고정x
//		{key = val , key2 = val, key3 = val} 키 값은 동일해선 안된다.
		
		
		/**
		*작은 <-- 큰 : down casting(강제 형변환)
		* 큰 <--작은 : up   casting(형변환 생략가능)
		* 
		* 레퍼클래스(wrapper class)
		* int --> Integer
		*/
//		int age = map.get("age"); // error, 객체(Object)가 더 크기 때문에 캐스팅
//		int age = (Integer)map.get("age"); // 원래는 이런 형태로 해야됨
		int age = (int)map.get("age");
		String str = (String)map.get("name");
		System.out.println("Casting     : "+age+","+str);
		
		// 수정  
		// 1.put     (기존키, 변경값)
		// 2.replace (기존키, 변경값)
		
		map.put("name","zzz"); // 추천하는 방식
//		map.replace("age", 20);
		System.out.println("put,Replace : "+map);
		
		
		/**형이 같은 경우 강제 형변환을 할 필요 없다.
		 * - 제네릭(Generic) : 클래스, 메소드 등에서 사용할 데이터 타입을 컴파일시 미리 지정하는 방법
		 * - 컴파일 시 컴파일러가 사전에(구동 전에) 타입 체크
		 * 
		 *  타입 안정성, 코드 가독성, 성능향상(런타임시 오버헤드 감소)
		 */
		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("name","abc");
		map2.put("addr","seoul");
		
		String str2 = map2.get("name"); //제네릭을 사용하므로써 형 변환 생략가능
		
		
		
		
		
	}

}
