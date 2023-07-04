package 바킹독.dp.색상환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 인접한 두 색은 사용하지 않음
public class Main {
    static final int MOD = 1000000003;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 5][N + 5];
        for (int n = 4; n <= N; n++) {
            dp[n][1] = n;
        }
        dp[4][2] = 2;
        dp[5][2] = 5;

        for (int n = 6; n <= N; n++) {
            for (int k = 2; k <= n / 2; k++) {
                dp[n][k] = (dp[n - 1][k]%MOD + dp[n - 2][k - 1]%MOD)%MOD;
            }
        }

        System.out.println(dp[N][K]%MOD);
    }
}
