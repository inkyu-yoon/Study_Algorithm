package LeetCode150.주차2.SearchA2DMatrix;

import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] merged = new int[matrix.length * matrix[0].length];
        int idx = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                merged[idx++] = element;
            }
        }
        return Arrays.binarySearch(merged, target) >= 0 ? true : false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int[] merged = new int[matrix.length * matrix[0].length];
        int idx = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                merged[idx++] = element;
            }
        }
        return bs(merged, target);
    }

    private boolean bs(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < arr[mid]) {
                right = mid - 1;
            } else if (target == arr[mid]) {
                return true;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}