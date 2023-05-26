package 판교가는길.dp.동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    //합이 k원이 되는 경우의 수
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = info[0], k = info[1];
        int[] dp = new int[k + 1];
        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins.add(coin);
        }
        Arrays.fill(dp, 10001);
        dp[0]=0;
        for (int i = 1; i <= k; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        System.out.println((dp[k] == 10001 ? -1 : dp[k]));


    }
}
