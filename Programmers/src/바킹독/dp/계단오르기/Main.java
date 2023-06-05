package 바킹독.dp.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
// 연속된 3개는 밟으면 안됨
// 마지막 계단은 꼭 밟아야 함

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMaxScore(stairs, N));

    }

    private static int getMaxScore(int[] stairs, int N) {
        if (N == 1) {
            return stairs[1];
        } else if (N == 2) {
            return stairs[1]+stairs[2];
        }

        int[] dp = new int[N + 3];

        dp[1] = stairs[1];
        dp[2] = stairs[1]+stairs[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(stairs[i] + stairs[i - 1] + dp[i - 3], stairs[i] + dp[i - 2]);
        }

        return dp[N];
    }

}
