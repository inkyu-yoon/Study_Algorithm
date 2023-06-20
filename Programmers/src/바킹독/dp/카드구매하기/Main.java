package 바킹독.dp.카드구매하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 카드 팩의 가격이 주어졌을 때, N 개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램
// N개보다 많은 개수의 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능하다.
// 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        String[] input = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(input[i-1]);
        }

        dp[1] = P[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = P[i];
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.max(dp[i], (i / j) * dp[j]);
                }
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }

        System.out.println(dp[N]);

    }
}