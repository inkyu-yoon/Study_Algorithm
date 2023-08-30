package LeetCode150.주차2_1.ContainsDuplicate;

import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int idx = map.get(num);
                if (i - idx <= k) {
                    return true;
                } else {
                    map.put(num, i);
                }
            } else {
                map.put(num, i);
            }
        }
        return false;
    }
}