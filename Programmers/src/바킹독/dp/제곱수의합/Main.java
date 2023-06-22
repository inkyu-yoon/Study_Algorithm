package 바킹독.dp.제곱수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 제곱수의 항이 최소가 되도록 합으로 표현하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        dp[2] = 2;

        // 제곱수 표시
        for (int i = 0; i * i <= N; i++) {
            dp[i * i] = 1;
        }

        for (int i = 3; i <= N; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                for (int j = 1; j <= (int) Math.floor(Math.sqrt(i)); j++) {
                    dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
                }
            }
        }
        System.out.println(dp[N]);
    }
}
