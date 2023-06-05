package 바킹독.dp.일로만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] history;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        history = new int[N + 1];

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int count = 0;
        dp[1] = 0;
        for (int i = 1; i < N; i++) {
            check(i + 1, i, dp);

            if (2 * i <= N) {
                check(2 * i, i, dp);
            }

            if (3 * i <= N) {
                check(3 * i, i, dp);
            }

        }

        System.out.println(dp[N]);

        StringBuilder sb = new StringBuilder();
        while (N != 1) {
            sb.append(N + " ");
            N = history[N];
        }
        sb.append(1);
        System.out.println(sb);
    }

    private static void check(int target, int i, int[] dp) {
        if (dp[target] > dp[i] + 1) {
            dp[target] = dp[i] + 1;
            history[target] = i;
        }
    }
}
