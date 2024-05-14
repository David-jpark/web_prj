package com.kosta.sample.json;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

//https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind/latest/index.html
//https://github.com/FasterXML/jackson-docs



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JacksonTest {
	
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		//EmpVO (1) : str --> EmpVO
		String jsonStr = "{\"ename\":\"smith\", \"empno\":\"7733\", \"sal\":\"600\"}";
		
		//HashMap : str --> HashMap
		EmpVO vo = new EmpVO();
		ObjectMapper mapper = new ObjectMapper();
		try{
			vo = mapper.readValue(jsonStr, EmpVO.class);
		} catch(JsonMappingException e) {
			e.printStackTrace();
		} catch(JsonProcessingException f) {
			f.printStackTrace();
		}
		System.out.println(vo.toString());
		
		
		// map --> str
		try {
			String jsonString = mapper.writeValueAsString(vo);
			System.out.println(jsonString);
			
		}catch(JsonMappingException e) {
			e.printStackTrace();
		}
		
		
//		------------------------------------
//		jackson Factory config ... JavaType
//		readValue(jsonStr, 제네릭효과);
//		------------------------------------
//******************************Jackson의 핵심 장점***********************************
		// jackson factory
//		JsonNode root = mapper.readTree(jsonStr);
//		System.out.println(root);
		
//		HashMap<String,String> map = new HashMap<String,String>();
		mapper = new ObjectMapper();
		try{
//			HashMap<String,Object> map = mapper.readValue(jsonStr, HashMap.class);
			HashMap<String,Object> map = mapper.readValue(jsonStr, new TypeReference<HashMap<String,Object>>(){} );
			System.out.println(map.get("ename"));
		} catch(JsonMappingException e) {
			e.printStackTrace();
		} catch(JsonProcessingException f) {
			f.printStackTrace();
		}
		
//******************************Jackson의 핵심 장점***********************************
		TypeFactory fact = mapper.getTypeFactory();
//		HashMap<String,Object> map = mapper.readValue(jsonStr, new TypeReference<HashMap<String,Object>>(){} );
//		같은 타입
		JavaType javaType = fact.constructType(EmpVO.class); 
		// JavaType =다형성 jackson에서는 자바의 최상단의 object type처럼 가장 큰 javatype으로 컨버팅해서 담는다.
		try{
			EmpVO vo2 = mapper.readValue(jsonStr, javaType);
			System.out.println(vo2.getEname());
		} catch(JsonMappingException e) {
			e.printStackTrace();
		} catch(JsonProcessingException f) {
			f.printStackTrace();
		}
		
		
	}

}
