package 바킹독.dp.RGB거리;

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

        int[][] dp = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Integer.parseInt(input[j]);
                }
            } else {
                dp[i][0] = Integer.parseInt(input[0]) + Math.min(dp[i - 1][1],dp[i - 1][2]);
                dp[i][1] = Integer.parseInt(input[1]) + Math.min(dp[i - 1][0],dp[i - 1][2]);
                dp[i][2] = Integer.parseInt(input[2]) + Math.min(dp[i - 1][0],dp[i - 1][1]);
            }
        }
        System.out.println(Arrays.stream(dp[N]).min().getAsInt());

    }


}
