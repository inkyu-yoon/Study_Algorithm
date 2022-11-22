package 해시.완주하지못한선수;

import java.util.*;

class Solution {
    // 단 한명의 선수를 제외하고 모든 선수가 마라톤 완주
    // completion의 길이는 participant의 길이보다 1 작음
    // 동명이인이 있을 수 있음

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> check = new HashMap<>();

        //참가자를 먼저 map에 등록(동명이인이 있을 수 있음)
        for (String person : participant) {
            if (check.containsKey(person)) {
                check.put(person, check.get(person) + 1);
            } else {
                check.put(person, 1);
            }
        }

        // 완주한 사람 이름은 value값을 -1씩 한다.
        for (String finish : completion) {
            check.put(finish, check.get(finish) - 1);
        }

        // 한 명만 완주를 못했으므로, value 값이 여전히 1인 사람이 완주를 못한 것
        for (String person : check.keySet()) {
            if (check.get(person) == 1) {
                answer = person;
            }
        }


        return answer;
    }
}