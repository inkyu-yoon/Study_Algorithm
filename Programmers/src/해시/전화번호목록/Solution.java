package 해시.전화번호목록;

import java.util.*;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        //전화번호를 일단 map에 다 집어 넣는다.
        for (String s : phone_book) {
            map.put(s, 1);
        }

        //다시 전화번호 하나씩, 각 전화번호 길이의 -1 만큼 substring해서 이미 키로 등록되어있는지 확인해본다.
        //substring(a,b) 는 a이상 b미만
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                System.out.println(j);
                System.out.println("phone_book[i].substring(0, j) = " + phone_book[i].substring(0, j));
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return answer;
    }
}
