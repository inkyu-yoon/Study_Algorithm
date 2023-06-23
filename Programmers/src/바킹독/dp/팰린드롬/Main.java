package 바킹독.dp.팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i <= N-1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len; i++) {
                if (arr[i] == arr[i + len] && dp[i + 1][i + len - 1] == 1) {
                    dp[i][i + len] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int S = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            sb.append(dp[S][E] + "\n");
        }
        System.out.println(sb);

    }
}
