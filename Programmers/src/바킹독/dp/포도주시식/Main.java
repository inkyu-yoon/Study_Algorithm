package 바킹독.dp.포도주시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] drinks = new int[n+2];

        for (int i = 1; i <= n; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 2];

        dp[1] = drinks[1];
        dp[2] = drinks[2]+dp[1];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(drinks[i] + dp[i-2], dp[i-1]),drinks[i]+drinks[i-1]+dp[i-3]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());




    }
}
