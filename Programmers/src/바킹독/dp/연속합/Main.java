package 바킹독.dp.연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[n];
        dp[0] = arr[0];

        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] += dp[i - 1] + arr[i];
            } else {
                dp[i] = arr[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
