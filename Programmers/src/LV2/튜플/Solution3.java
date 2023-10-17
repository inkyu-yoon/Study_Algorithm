package LV2.튜플;

import java.util.*;
import java.util.regex.*;

class Solution3 {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] solution(String s) {

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        int max = 0;
        while (m.find()) {
            int target = Integer.parseInt(m.group());
            map.put(target, map.getOrDefault(target, 0) + 1);
            max = Math.max(max, map.get(target));
        }

        int[] answer = new int[max];

        for (int key : map.keySet()) {
            int n = map.get(key);
            answer[max - n] = key;
        }


        return answer;
    }
}
