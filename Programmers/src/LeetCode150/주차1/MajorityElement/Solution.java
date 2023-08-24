package LeetCode150.주차1.MajorityElement;

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int result = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > n / 2) {
                result = key;
                break;
            }
        }

        return result;
    }

    public int majorityElement2(int[] nums) {
        int num = nums[0];
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[0] == num) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    num = nums[i];
                }
            }
        }

        return num;
    }
}
