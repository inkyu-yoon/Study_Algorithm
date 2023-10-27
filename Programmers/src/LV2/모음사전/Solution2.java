package LV2.모음사전;

import java.util.*;

class Solution2 {
    StringBuilder sb;
    String[] words = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;
        for (int len = 1; len <= 5; len++) {
            sb = new StringBuilder();
            bt(len);
        }

        Collections.sort(list);

        return list.indexOf(word) + 1;
    }

    private void bt(int len) {
        if (sb.length() == len) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i <= 4; i++) {
            sb.append(words[i]);
            bt(len);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}