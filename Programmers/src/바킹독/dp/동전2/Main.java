package 바킹독.dp.동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        List<Integer> coins = new ArrayList<>();
        int n = input[0];
        int target = input[1];

        while (n-- > 0) {
            int coin = Integer.parseInt(br.readLine());
            if (!coins.contains(coin)) {
                coins.add(coin);
            }
        }

        Collections.sort(coins, (a, b) -> b - a);

        int[] dp = new int[target + 1];
        int MAX = Integer.MAX_VALUE;

        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (Integer coin : coins) {
            for (int i = 1; i <= target; i++) {
                if (i - coin >= 0 && dp[i - coin] != MAX) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[target] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[target]);
        }
    }
}
