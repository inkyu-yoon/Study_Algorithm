package 바킹독.dp.타일채우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 4];
        dp[2] = 3;
        dp[4] = 11;
        for (int i = 6; i <= N; i += 2) {
            dp[i] += dp[i - 2] * dp[2] + 2;
            for (int j = 2; j <= i - 4; j+=2) {
                dp[i] += 2 * dp[j];
            }
        }
        System.out.println(dp[N]);
    }
}
