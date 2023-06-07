package 바킹독.dp.쉬운계단수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[101][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j < 10; j++) {
                int result = 0;
                if (j == 0) {
                    result = dp[i - 1][1];
                } else if (j == 9) {
                    result = dp[i - 1][8];
                } else {
                    result = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
                dp[i][j] = result%1000000000;
            }
        }
        long ans = 0;
        for (int i = 1; i < 10; i++) {
            ans += dp[N][i] % 1000000000;
        }

        System.out.println(ans% 1000000000);



    }
}
