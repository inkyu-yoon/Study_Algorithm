package 바킹독.dp.동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 동전을 적당히 사용해서 가치의 합을 k원으로 만들기
// 각각의 동전은 몇 개라도 사용할 수 있다.
// 순서만 다른 것은 같은 경우
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = input[0], k = input[1];
        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (Integer coin : coins) {
            for (int i = 1; i <= k; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        System.out.println(dp[k]);

    }
}
