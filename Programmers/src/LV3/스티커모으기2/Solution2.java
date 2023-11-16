package LV3.스티커모으기2;

import java.util.*;

class Solution2 {
    public int solution(int sticker[]) {
        int answer = 0;
        int N = sticker.length;
        if (N == 1) {
            return sticker[0];
        } else if (N == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int[] dp1 = Arrays.copyOfRange(sticker, 0, N - 1);
        dp1[0] = sticker[0];

        int[] dp2 = Arrays.copyOfRange(sticker, 1, N);
        dp2[0] = sticker[1];

        for (int i = 1; i < N - 1; i++) {
            if (i == 1) {
                dp1[1] = Math.max(dp1[0], sticker[1]);
                dp2[1] = Math.max(dp2[0], sticker[2]);
            } else {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i + 1]);
            }
        }

        return Math.max(Arrays.stream(dp1).max().getAsInt(), Arrays.stream(dp2).max().getAsInt());
    }
}
