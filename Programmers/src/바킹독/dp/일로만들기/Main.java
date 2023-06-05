package 바킹독.dp.일로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i < N; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            if (2 * i <= N) {
                dp[2 * i] = Math.min(dp[2 * i], dp[i] + 1);
            }

            if (3 * i <= N) {
                dp[3 * i] = Math.min(dp[3 * i], dp[i] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
