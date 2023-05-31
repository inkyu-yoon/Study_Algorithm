package 판교가는길.dp.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");
        int R = str1.length + 1, C = str2.length + 1;
        int[][] dp = new int[R][C];

        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                if (str1[r - 1].equals(str2[c - 1])) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }

        System.out.println(dp[R-1][C-1]);
    }
}
