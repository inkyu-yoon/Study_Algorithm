package 바킹독.dp.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word1 = br.readLine().split("");
        String[] word2 = br.readLine().split("");

        int R = word2.length + 1;
        int C = word1.length + 1;

        int[][] dp = new int[R][C];

        for (int c = 1; c < C; c++) {
            for (int r = 1; r < R; r++) {
                if (word2[r - 1].equals(word1[c - 1])) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }

        System.out.println(dp[R-1][C-1]);

    }
}
