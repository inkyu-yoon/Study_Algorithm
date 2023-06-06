package 바킹독.dp.피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[41][2];

        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};

        for (int i = 2; i <= 40; i++) {
            dp[i] = new int[]{dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]};
        }

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0] + " " + dp[n][1] + "\n");
        }
        System.out.println(sb);
    }
}
