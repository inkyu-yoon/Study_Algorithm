package 구름톤첼린지.통증2;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] dp = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 2; i <= N; i++) {
            for (int item : input) {
                if (i - item >= 0 && dp[i - item] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - item] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);

    }
}