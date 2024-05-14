package com.kosta.sample.json;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest2 {

	public static void main(String[] args) {
		String jsonStr = "{\r\n"
				+ "  \"name\": \"KOSTA\",\r\n"
				+ "  \"id\": \"u0001\",\r\n"
				+ "  \"displayName\": {\r\n"
				+ "  	\"desc\": \"this is kosta\",\r\n"
				+ "  	\"code\": \"g01\"\r\n"
				+ "  },\r\n"
				+ "  \"types\": [\"type1\",\"type2\"],\r\n"
				+ "  \"primaryType\": \"ptype\"\r\n"
				+ "}";
		
		//id, code, type
		System.out.println("DVO활용 JSON");
		ObjectMapper map = new ObjectMapper();
		try {
			
			JTestVO jvo = map.readValue(jsonStr, JTestVO.class);
			DisplayName dn = jvo.getDisplayName();
			String id = jvo.getId();
			String code = dn.getCode();
			ArrayList<String> type = jvo.getTypes();
			System.out.println(id+"\t"+code+"\t"+type);
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
//		-------------------------------------------------------
//		Casting에 주의해야한다. 
		System.out.println("DVO없는 JSON");
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> map2;
		try {
			map2 = mapper.readValue(jsonStr, HashMap.class);
			String id = (String)map2.get("id");
//			System.out.println(map2.get("types").getClass()); // ArrayList Check
			ArrayList<String> ty = (ArrayList<String>) map2.get("types");

			HashMap<String,String> submap = (HashMap<String, String>)map2.get("displayName");
			String code = submap.get("code");
			System.out.println(id+"\t"+code+"\t"+ty);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
