package com.kosta.test;

public class Solution {
	 
	public String solution(String[] seoul) {
        String answer = "";
        
        for(int i = 0; i < seoul.length ; i++){
           
            if(seoul[1] == "Kim"){
                answer = "김서방은 1에 있다";
                
            } else if(seoul[0] == "Kim") {
                answer = "김서방은 0에 있다";
            }
        }
        
        return answer;
    }

}
