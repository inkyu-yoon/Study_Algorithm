package LeetCode150.주차2.TwoSum2;


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = null;
        for (int i = 0; i < numbers.length; i++) {
            int fixed = numbers[i];
            int find = target - fixed;

            int result = bs(numbers, i + 1, find);
            if (result != -1) {
                ans = new int[]{i + 1, result + 1};
            }

        }
        return ans;

    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum == target) {
                break;
            } else {
                left++;
            }
        }
        return new int[]{left + 1, right + 1};
    }

    private int bs(int[] numbers, int start, int target) {
        int left = start, right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < numbers[mid]) {
                right = mid - 1;
            } else if (target == numbers[mid]) {
                return mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }
}
