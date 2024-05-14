package com.kosta.sample.json;

import java.util.HashMap;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

//import org.json.simple.*;
//import com.fasterxml.jackson.*;

public class JsonTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("empno","7733");
		map.put("ename", "smith");
		map.put("sal", "600");
		System.out.println(map);
		//{ename=smith, empno=7733, sal=600} // java map
		//{ename:smith, empno:7733, sal:600} // JSON map
		
//		{"ename":"smith", "empno":"7733", "sal":"600"}
		String jsonStr = "{\"ename\":\"smith\", \"empno\":\"7733\", \"sal\":\"600\"}";
		
		JSONObject obj = new JSONObject();
		
		JSONParser parser = new JSONParser();
		
		HashMap<String,String>map2 = new HashMap<String,String>();
		try {
			
			
			map2 = (HashMap<String,String>)parser.parse(jsonStr);
			System.out.println(map2);
			
			String a = map2.get("ename");
			String b = map2.get("empno");
			String c = map2.get("sal");
			System.out.println(a+","+b+","+c);
			

		} catch (ParseException e) {
			System.err.println("str --> map convert error");
			e.printStackTrace();
		}
		
		
		try {
			obj = (JSONObject)parser.parse(jsonStr);
			String mapToStr = obj.toJSONString(map2);
			System.out.println(mapToStr);
			
			mapToStr = obj.toString();
			System.out.println(mapToStr);
			
			mapToStr = obj.toJSONString();
			System.out.println(mapToStr);
			
			mapToStr = map2.toString(); // AbstractMap
			System.out.println(mapToStr);
		} catch(ParseException e) {
			System.err.println("str --> map convert error");
			e.printStackTrace();
		}
		
		
//		public java.lang.Object parse(java.io.Reader in)
//                throws java.io.IOException,
//                       ParseException // throw했기 때문에 반드시 catch해야한다. (예외처리)
		
		
		
	}

}
