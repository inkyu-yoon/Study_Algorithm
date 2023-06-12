package 바킹독.dp.자두나무;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int T = Integer.parseInt(input[0]), W = Integer.parseInt(input[1]);

        int[][] dp = new int[T + 1][W+1];

        for (int i = 1; i <= T; i++) {
            int tree = Integer.parseInt(br.readLine());

            if (tree == 1) {
                dp[i][0] = dp[i - 1][0] + 1;
                for (int j = 1; j <= W; j++) {
                    if (j % 2 == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                }
            } else {
                for (int j = 1; j <= W; j++) {
                    if (j % 2 == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                }
            }

        }
        System.out.println(Arrays.stream(dp[T]).max().getAsInt());
    }
}
