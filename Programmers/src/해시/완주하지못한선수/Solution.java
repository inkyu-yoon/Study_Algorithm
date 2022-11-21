package 해시.완주하지못한선수;

import java.util.*;

//완주하지 못한 선수의 이름을 return
//단 한명만 완주를 못함
//completion의 길이는 participant의 길이보다 1 작음
//participant에 동명이인이 있을 수 있음
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> check = new HashMap<>();

        //참석자 입력
        for(String input : participant){
            if(check.containsKey(input)){
                check.put(input,check.get(input)+1);
            }else{
                check.put(input,1);
            }
        }

        //완주자 value 값 -1씩 하기
        for(String finish : completion){
            check.put(finish,check.get(finish)-1);
        }

        // 최종 value 값이 1인 사람이 완주를 못한 사람일 것
        for(String key : check.keySet()){
            if(check.get(key)==1){
                answer = key;
            }
        }

        return answer;
    }
}