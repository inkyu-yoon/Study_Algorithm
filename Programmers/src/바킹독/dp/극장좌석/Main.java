package 바킹독.dp.극장좌석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] seats = new int[N + 1];
        boolean[] vips = new boolean[N + 1];

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            vips[Integer.parseInt(br.readLine())] = true;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (vips[i] || vips[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                if (i == 2) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }

        System.out.println(dp[N]);

    }
}
