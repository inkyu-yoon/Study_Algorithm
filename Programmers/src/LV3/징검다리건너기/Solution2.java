package LV3.징검다리건너기;

// 0이 k연속으로 존재하는 경우 넘어갈 수 없음

import java.util.*;

class Solution2 {
    public int solution(int[] stones, int k) {
        int left = 0, right = 200000000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(stones, mid, k)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean check(int[] arr, int target, int k) {
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - target <= 0) {
                cnt++;
            } else {
                result = Math.max(cnt, result);
                cnt = 0;
            }
        }
        result = Math.max(cnt, result);

        return result < k;
    }
}