package LeetCode150.주차3_2.FindKPairs;

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);

        for (int i = 0; i < Math.min(k, nums2.length); i++) {
            pq.offer(new int[]{nums1[0], nums2[i], 0, nums1[0] + nums2[i]});
        }

        while (!pq.isEmpty() && k-- > 0) {
            int[] poll = pq.poll();
            int num1 = poll[0], num2 = poll[1];
            ans.add(List.of(num1, num2));

            int idx1 = poll[2];
            if (idx1 + 1 < nums1.length) {
                // num2와 제거한 num1 뒤에 있는 수의 조합을 추가
                pq.offer(new int[]{nums1[idx1 + 1], num2, idx1 + 1, nums1[idx1 + 1] + num2});
            }
        }


        return ans;
    }
}