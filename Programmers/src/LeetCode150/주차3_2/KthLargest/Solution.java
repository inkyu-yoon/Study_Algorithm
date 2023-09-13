package LeetCode150.주차3_2.KthLargest;

import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.offer(num);
        }

        int ans = 0;
        while (k-- > 0) {
            ans = pq.poll();
        }
        return ans;
    }
}