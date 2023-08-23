package LeetCode150.주차1.MergeSortedArray;

import java.util.*;

class Solution {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);

        System.out.println(Arrays.toString(nums1));
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (idx1 < m && idx2 < n) {
                if (nums1[idx1] >= nums2[idx2]) {
                    result[i] = nums2[idx2++];
                } else {
                    result[i] = nums1[idx1++];
                }
            } else if (idx2 >= n) {
                result[i] = nums1[idx1++];
            } else if (idx1 >= m) {
                result[i] = nums2[idx2++];
            }
        }

        nums1 = result;
        System.out.println(Arrays.toString(nums1));

    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (idx1 >= 0 && idx2 >= 0) {
                if (nums1[idx1] <= nums2[idx2]) {
                    nums1[i] = nums2[idx2--];
                } else {
                    nums1[i] = nums1[idx1--];
                }
            } else if (idx2 < 0) {
                nums1[i] = nums1[idx1--];
            } else if (idx1 < 0) {
                nums1[i] = nums2[idx2--];
            }
        }
    }
}