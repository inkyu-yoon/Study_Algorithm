package 바킹독.dp.정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][];

        dp[0] = new int[]{0};
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }
            dp[i] = arr;
        }



        for (int i = 2; i <= n; i++) {
            int len = dp[i].length;
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][0];
                } else if (j == len - 1) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j];
                }
            }
        }

        System.out.println(Arrays.stream(dp[n]).max().getAsInt());

    }
}
