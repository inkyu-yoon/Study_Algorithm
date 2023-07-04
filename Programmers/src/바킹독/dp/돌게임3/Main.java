package 바킹독.dp.돌게임3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 1 상근 0 창영
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 5];
        dp[0] = 1;
        dp[1] = 1;
        dp[3] = 1;
        dp[4] = 1;


        for (int i = 5; i <= N; i++) {
            if (dp[i - 1] == 0 || dp[i - 3] == 0 || dp[i - 4] == 0) {
                dp[i] = 1;
            }
        }

        System.out.println(dp[N] == 1 ? "SK" : "CY");
    }
}
