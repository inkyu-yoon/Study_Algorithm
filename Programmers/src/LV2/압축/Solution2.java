package LV2.압축;

import java.util.*;

class Solution2 {
    Map<String, Integer> dict = new HashMap<>();

    public int[] solution(String msg) {
        setDefaultDict();
        String[] splited = msg.split("");
        int N = splited.length;
        int idx = 0;
        List<Integer> ans = new ArrayList<>();

        while (idx < N) {
            String target = splited[idx];
            int pos = 0;
            while (dict.containsKey(target)) {
                pos = dict.get(target);
                idx++;
                if (idx == N) {
                    break;
                }
                target += splited[idx];
            }
            ans.add(pos);
            dict.put(target, dict.size() + 1);
        }


        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void setDefaultDict() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            dict.put(ch + "", ch - 'A' + 1);
        }
    }

}