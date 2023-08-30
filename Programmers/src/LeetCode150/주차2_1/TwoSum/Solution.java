package LeetCode150.주차2_1.TwoSum;

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (map.containsKey(search)) {
                return new int[]{i, map.get(search)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int N = nums.length;
        int[][] nodes = new int[N][2];
        for (int i = 0; i < N; i++) {
            nodes[i] = new int[]{nums[i], i};
        }

        Arrays.sort(nodes, (a, b) -> a[0] - b[0]);

        int left = 0, right = nodes.length - 1;
        while (left < right) {
            int sum = nodes[left][0] + nodes[right][0];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                break;
            }
        }

        return new int[]{nodes[left][1], nodes[right][1]};
    }

}
