package LeetCode150.주차1.RemoveElement;

import java.util.*;

class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int cnt = 0;

        for(int i=0;i<len;i++){
            if(nums[i]==val){
                nums[i] = 51;
                cnt++;
            }
        }

        Arrays.sort(nums);

        return len - cnt;
    }

    public int removeElement2(int[] nums, int val) {
        int idx = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }
}
