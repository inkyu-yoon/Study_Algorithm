package 바킹독.dp.파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        int T = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        while (T-- > 0) {
            ans.append(dp[Integer.parseInt(br.readLine())]+"\n");
        }
        System.out.println(ans);

    }
}
