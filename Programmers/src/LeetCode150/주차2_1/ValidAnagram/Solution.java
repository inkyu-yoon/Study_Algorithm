package LeetCode150.주차2_1.ValidAnagram;

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        char[] split = s.toCharArray();

        for (char ch : split) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        split = t.toCharArray();

        for (char ch : split) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }

        return true;

    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;

    }
}