package LeetCode150.주차2.LongestSubstring;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Queue<Character> q = new LinkedList<>();
        char[] split = s.toCharArray();
        int N = split.length;
        for (int i = 0; i < N; i++) {
            if (q.contains(split[i])) {
                while (!q.isEmpty() && q.peek() != split[i]) {
                    q.poll();
                }
                q.poll();
                q.offer(split[i]);
            } else {
                q.offer(split[i]);
            }
            ans = Math.max(ans, q.size());
        }

        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int ans = 0;

        char[] split = s.toCharArray();
        int N = split.length;
        int pointer = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            char target = split[i];
            if (set.contains(target)) {
                while (split[pointer] != target) {
                    set.remove(split[pointer++]);
                }
                set.remove(split[pointer++]);
                set.add(target);
            } else {
                set.add(target);
            }
            ans = Math.max(ans, set.size());
        }

        return ans;
    }
}