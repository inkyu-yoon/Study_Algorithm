package 판교가는길.dp.동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main1 {
    public static void main(String[] args) throws IOException {
        new Main1().solution();
    }

    // 가치의 합이 k원
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = info[0], k = info[1];
        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(coins);
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= k; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
