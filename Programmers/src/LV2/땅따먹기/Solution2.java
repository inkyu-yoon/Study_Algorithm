package LV2.땅따먹기;

import java.util.*;

class Solution2 {
    int solution(int[][] land) {
        int answer = 0;
        int R = land.length;
        int C = land[0].length;
        int[][] dp = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (r == 0) {
                    dp[r][c] = land[r][c];
                } else {
                    for (int k = 0; k < C; k++) {
                        if (k != c) {
                            dp[r][c] = Math.max(dp[r][c], dp[r - 1][k] + land[r][c]);
                        }
                    }
                }
            }
        }

        return Arrays.stream(dp[R - 1]).max().getAsInt();
    }
}
