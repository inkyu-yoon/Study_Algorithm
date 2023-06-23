package 바킹독.dp.동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M + 1];
            dp[0] = 1;

            for (Integer coin : coins) {
                for (int i = 1; i <= M; i++) {
                    if (i - coin >= 0) {
                        dp[i] += dp[i - coin];
                    }
                }
            }
            sb.append(dp[M]+"\n");
        }
        System.out.println(sb);
    }
}
