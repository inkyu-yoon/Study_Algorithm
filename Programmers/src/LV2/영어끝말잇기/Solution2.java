package LV2.영어끝말잇기;

import java.util.*;

class Solution2 {
    Set<String> records = new HashSet<>();

    public int[] solution(int n, String[] words) {


        int failNum = 0;
        int turn = 0;
        records.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            int numOfPerson = i % n + 1;
            String word = words[i];

            if (checkDuplicate(word) || !isConnectable(words[i - 1], word)) {
                failNum = numOfPerson;
                turn = (int) Math.ceil((i + 1) / (double) (n));
                break;
            }
            records.add(word);
        }

        return new int[]{failNum, turn};
    }

    private boolean checkDuplicate(String word) {
        return records.contains(word);
    }

    private boolean isConnectable(String prev, String word) {
        return prev.charAt(prev.length() - 1) == word.charAt(0);
    }
}