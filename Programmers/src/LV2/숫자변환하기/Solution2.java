package LV2.숫자변환하기;

import java.util.*;

class Solution2 {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);

            }
            if (2 * i <= y) {
                dp[2 * i] = Math.min(dp[2 * i], dp[i] + 1);
            }
            if (3 * i <= y) {
                dp[3 * i] = Math.min(dp[3 * i], dp[i] + 1);
            }
            if (dp[y] != Integer.MAX_VALUE) {
                break;
            }
        }


        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}
