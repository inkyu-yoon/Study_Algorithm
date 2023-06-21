package 바킹독.dp.공일타일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 타일이 1 아니면 00 만 있다

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 15746;
        }

        System.out.println(dp[N] % 15746);

    }
}
