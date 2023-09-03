package LeetCode150.주차2_2.SearchInRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        int idx = getStartIdx(nums);
        int result1 = findIdx(nums, 0, idx - 1, target);
        int result2 = findIdx(nums, idx, nums.length - 1, target);

        return Math.max(result1, result2);
    }

    private int getStartIdx(int[] nums) {
        int left = 0, right = nums.length - 1;

        if (nums[left] <= nums[right]) {
            return 0;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int findIdx(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}