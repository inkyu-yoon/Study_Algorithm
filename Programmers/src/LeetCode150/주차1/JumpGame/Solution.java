package LeetCode150.주차1.JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        int start = 0;
        while (true) {
            int maxJump = start + nums[start];

            if (maxJump >= nums.length - 1) {
                return true;
            }

            int maxIdx = start;

            for (int i = start + 1; i <= maxJump; i++) {
                if (nums[i] + i > nums[maxIdx] + maxIdx) {
                    maxIdx = i;
                }
            }

            if (start == maxIdx) {
                return false;
            }

            start = maxIdx;
        }
    }

    public boolean canJump2(int[] nums) {
        int limit = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i > limit) {
                return false;
            }

            int jump = nums[i] + i;

            if (jump > limit) {
                limit = jump;
            }

        }
        return true;
    }
}