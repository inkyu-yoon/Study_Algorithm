package 바킹독.dp.퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        int[] dp = new int[N+2];

        for (int i = 1; i <= N+1; i++) {
            for (int j = 1; j < i; j++) {
                if (j + T[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[j] + P[j]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
