package LV3.단어변환;

import java.util.*;

class Solution2 {

    boolean[] checked;

    public int solution(String begin, String target, String[] words) {
        int N = words.length;
        checked = new boolean[N];
        Queue<Word> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String word = words[i];
            if (canConvert(begin, word)) {
                q.offer(new Word(word, 1));
                checked[i] = true;
            }
        }

        while (!q.isEmpty()) {
            Word word = q.poll();
            String str = word.text;
            int depth = word.depth;
            if (str.equals(target)) {
                return depth;
            }

            for (int i = 0; i < N; i++) {
                String s = words[i];
                if (!checked[i] && canConvert(str, s)) {
                    q.offer(new Word(s, depth + 1));
                    checked[i] = true;
                }
            }
        }

        return 0;
    }

    private boolean canConvert(String word1, String word2) {
        int len = word1.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                cnt++;
            }
        }

        if (cnt == 1) {
            return true;
        }

        return false;
    }

    static class Word {
        String text;
        int depth;

        public Word(String text, int depth) {
            this.text = text;
            this.depth = depth;
        }
    }
}
