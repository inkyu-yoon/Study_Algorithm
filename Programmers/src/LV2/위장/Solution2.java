package LV2.위장;

import java.util.*;

class Solution2 {
    Map<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {
        int answer = 1;
        for (String[] cloth : clothes) {
            String category = cloth[1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        return answer - 1;
    }
}
