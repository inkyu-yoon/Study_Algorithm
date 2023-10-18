package LV2.뉴스클러스터링;

import java.util.*;

// 합집합의 개수는 두 집합을 그냥 모두 더한 뒤, 교집합을 한번 빼주면 됨

class Solution {
    HashMap<String, Integer> mapA;
    HashMap<String, Integer> mapB;

    public int solution(String str1, String str2) {
        int answer = 0;
        mapA = new HashMap<>();
        mapB = new HashMap<>();

        getCombination(mapA, str1.toLowerCase());
        getCombination(mapB, str2.toLowerCase());

        int inter = getInter();
        int total = getTotal();

        if (total == 0) {
            return 65536;
        }
        answer = (int) Math.floor((double) inter / (total - inter) * 65536);
        return answer;
    }

    int getTotal() {
        int total = 0;
        for (Integer value : mapA.values()) {
            total += value;
        }
        for (Integer value : mapB.values()) {
            total += value;
        }
        return total;
    }

    int getInter() {
        int result = 0;
        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            String text = entry.getKey();
            int num1 = entry.getValue();
            if (mapB.containsKey(text)) {
                result += Math.min(num1, mapB.get(text));
            }
        }
        return result;
    }

    void getCombination(HashMap<String, Integer> map, String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (isAlpha(arr[i]) && isAlpha(arr[i + 1])) {
                String text = String.format("%s%s", arr[i], arr[i + 1]);
                map.put(text, map.getOrDefault(text, 0) + 1);
            }
        }
    }

    boolean isAlpha(char ch) {
        if ('a' <= ch && ch <= 'z') {
            return true;
        }
        return false;
    }
}