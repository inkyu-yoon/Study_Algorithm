package 바킹독.dp.스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2행 n열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = Integer.parseInt(input[j - 1]);
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int c = 2; c <= n; c++) {
                for (int r = 0; r < 2; r++) {
                    if (r == 0) {
                        dp[r][c] = Math.max(stickers[r][c] + dp[1][c - 1], dp[0][c - 1]);
                    } else {
                        dp[r][c] = Math.max(stickers[r][c] + dp[0][c - 1], dp[1][c - 1]);
                    }
                }
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }

    }
}
