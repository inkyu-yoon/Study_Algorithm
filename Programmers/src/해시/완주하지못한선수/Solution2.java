package 해시.완주하지못한선수;

import java.util.*;

class Solution2 {
    // 마라톤에 참여한 선수들의 이름이 담긴 배열 participant
    // 마라톤을 완주한 선수들이 담긴 배열 completion
    // 완주하지 못한 선수의 이름을 return
    // completion의 길이는 participant의 길이보다 1 작다.
    // 참가자 중에는 동명이인이 있을 수 있다.
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        // 마라톤에 참여한 선수들의 이름을 map에 넣는다.
        for(String person : participant){
            map.put(person,map.getOrDefault(person,0)+1);
        }

        // 마라톤을 완주한 선수들의 이름으로 1씩 제거
        for(String person : completion){
            map.put(person,map.get(person)-1);

            //value값이 0이면 아예 삭제
            if(map.get(person)==0){
                map.remove(person);
            }

        }

        //마지막 남은 한 사람이 완주하지 못한 선수
        Iterator it = map.keySet().iterator();
        answer = (String)it.next();

        return answer;
    }
}