package LeetCode150.주차2_1.RansomNote;

import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] split = magazine.toCharArray();
        for (char ch : split) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        split = ransomNote.toCharArray();

        for (char ch : split) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }

        return true;
    }
}