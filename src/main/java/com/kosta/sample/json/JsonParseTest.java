package com.kosta.sample.json;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParseTest {
	
	public static void main(String[] args) {
//		String jsonStr = "{\r\n"
//				+ "\"elements\":"
//				+ "[\r\n"
//				+ "{\"profile_nickname\":\"사랑하는 아내♥\",\r\n"
//				+ "\"profile_thumbnail_image\":\"\",\r\n"
//				+ "\"id\":\"149\"\r\n"
//				+ "\"uuid\":\"Q3JAcU..xxxxxx.Up6T3sd\",\r\n"
//				+ "\"favorite\":1}\r\n"
//				+ "],\r\n"
//				+ "\r\n"
//				+ "\"total_count\":1,\r\n"
//				+ "\"after_url\":null,\"result_id\":\"zbnYtN-...xxxxx...pdPgCA\",\"favorite_count\":1\r\n"
//				+ "}";
		
		String jsonStr = "{\"elements\":[{\"profile_nickname\":\"사랑하는 아내♥\",\""
				+ "profile_thumbnail_image\":\"\",\"id\":\"149..xxx...378\",\""
				+ "uuid\":\"Q3JAcU..xxxxxx.Up6T3sd\",\"favorite\":true}],"
				+ "\"total_count\":1,\"after_url\":null,\""
				+ "result_id\":\"zbnYtN-...xxxxx...pdPgCA\",\""
				+ "favorite_count\":1}";
//		nickname, id, uuid, total_count
		
		//simple JSON
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();

		try {
			HashMap<String,String>map2 = new HashMap<String,String>();
			parser.parse(jsonStr);
			map2 = (HashMap<String,String>)parser.parse(jsonStr);
			obj = (JSONObject)parser.parse(jsonStr);
			JSONArray elementsArray = (JSONArray) obj.get("elements");
			JSONObject elementObject = (JSONObject) elementsArray.get(0);
			String a = (String)elementObject.get("profile_nickname");
			String b = (String)elementObject.get("id");
			String c = (String)elementObject.get("uuid");
			Long d = (Long)obj.get("total_count");
			System.out.println(a+"\t"+b+"\t"+c+"\t"+d);
		} catch (ParseException e) {
			System.err.println("str --> map convert error");
			e.printStackTrace();
		}
			
		// same class / jackson
		ObjectMapper mapper = new ObjectMapper();
		try{
		HashMap map = mapper.readValue(jsonStr, HashMap.class);
		ArrayList<HashMap<String,Object>> elementsList = (ArrayList<HashMap<String,Object>>)map.get("elements");
		String nick = (String)elementsList.get(0).get("profile_nickname"); // array화에서 0번째의 nickname
		String id = (String)elementsList.get(0).get("id");
		String uuid = (String)elementsList.get(0).get("uuid");
		Integer total = (Integer)map.get("total_count"); // map -> total을 뽑음.
		System.out.println(nick + "\t" + id + "\t" + uuid + "\t" + total);
		} catch(JsonMappingException e) {
			e.printStackTrace();
		} catch(JsonProcessingException f) {
			f.printStackTrace();
		}
		
		// def class ( Jackson + Entity )
		mapper = new ObjectMapper();
		try {
			DataVO dvo = mapper.readValue(jsonStr, DataVO.class);
			Element[] elements = dvo.getElements();
			for(Element e : elements) {  //for(변수 명 : 루프 변수)
//				for(int i = 0; i<elements.length; i++){
//					String nick = elements[i].getprofile_nickname;
				String nick2 = e.getProfile_nickname();
				String uuid2 = e.getUuid();
				String id2 = e.getId();
				int total2 = dvo.getTotal_count();
				System.out.println(nick2 + "\t" + id2 + "\t" + uuid2 + "\t" + total2);
				}		
			}  catch(JsonMappingException e) {
				e.printStackTrace();
			} catch(JsonProcessingException f) {
				f.printStackTrace();
			}
		
		}
		
	

}
