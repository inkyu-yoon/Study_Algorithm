package 바킹독.dp.퇴사2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+2];
        int[] P = new int[N+2];
        int[] dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);

        }

        int max = -1;
        for (int i = 1; i <= N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], max + P[i]);
            }
        }
        System.out.println(Math.max(max,dp[N+1]));
    }
}
