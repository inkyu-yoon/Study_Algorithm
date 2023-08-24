package LeetCode150.주차1.RotateArray;

class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k = k % N;

        int[] tmp = new int[k];

        for (int i = 0; i < k; i++) {
            tmp[i] = nums[N - k + i];
        }

        for (int i = N - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        int N = nums.length;

        k = k % N;
        while (k-- > 0) {
            int tmp = nums[N - 1];
            for (int i = N - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;
        }
    }

    public void rotate3(int[] nums, int k) {
        int N = nums.length;
        k = k%N;

        // 1번째 블럭 역순
        reverse(nums,0,N-1-k);

        // 2번째 블럭 역순
        reverse(nums,N-k,N-1);

        // 전체 블럭 역순
        reverse(nums,0,N-1);

    }

    private void reverse(int [] nums, int start, int end){
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}