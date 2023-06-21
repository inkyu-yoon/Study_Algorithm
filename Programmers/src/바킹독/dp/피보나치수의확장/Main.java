package 바킹독.dp.피보나치수의확장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [] dp = new long[Math.abs(n) + 2];
        dp[0] = 0;
        dp[1] = 1;
        if (n > 0) {
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1]%1000000000 + dp[i - 2]%1000000000)%1000000000;
            }
        } else {
            for (int i = 2; i <= Math.abs(n); i++) {
                dp[i] = (dp[i - 2]%1000000000 - dp[i - 1]%1000000000)%1000000000;
            }
        }
        n = Math.abs(n);
        int sign = 0;
        if (dp[n] > 0) {
            sign = 1;
        } else if (dp[n] < 0) {
            sign = -1;
        }

        System.out.println(sign);
        System.out.println(Math.abs(dp[n])%1000000000);
    }
}
