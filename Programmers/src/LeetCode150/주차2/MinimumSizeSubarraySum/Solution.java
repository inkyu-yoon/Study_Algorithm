package LeetCode150.주차2.MinimumSizeSubarraySum;

import java.util.Arrays;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (right <= nums.length) {
            if (sum < target) {
                if (right == nums.length) {
                    break;
                }
                sum += nums[right++];
            } else {
                ans = Math.min(ans, right - left);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];
        int ans = Integer.MAX_VALUE;

        // 누적합 배열 만들기
        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        // a~b 의 합이 target 보다 큰 부분 구하기
        for (int i = 0; i < sum.length - 1; i++) {
            // fixed 는 sum[a]에 해당하는 값
            int fixed = sum[i];

            // sum[b]-sum[a] = 구간합 >= target 이 되는 부분 찾기
            int find = target + fixed;

            int result = Arrays.binarySearch(sum, find);

            if (result > 0 && result > i) {
                ans = Math.min(ans, result - i);
            } else {
                int idx = -result - 1;
                if (idx < sum.length) {
                    ans = Math.min(ans, idx - i);
                }
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen3(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];
        int ans = Integer.MAX_VALUE;

        // 누적합 배열 만들기
        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }

        // a~b 의 합이 target 보다 큰 부분 구하기
        for (int i = 0; i < sum.length - 1; i++) {
            // fixed 는 sum[a]에 해당하는 값
            int fixed = sum[i];

            // sum[b]-sum[a] = 구간합 >= target 이 되는 부분 찾기
            int find = target + fixed;

            // 이분탐색
            int left = i + 1, right = sum.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (find <= sum[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (sum[left] >= find) {
                ans = Math.min(ans, left - i);
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}