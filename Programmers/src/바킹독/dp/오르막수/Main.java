package 바킹독.dp.오르막수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수의 자리가 오름차순을 이루는 수 ( 인접한 수가 같아도 오름차순)
// 2234 는 오르막 수 2232는 오르막 수가 아님
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k]%10007;
                }
            }
        }

        System.out.println(Arrays.stream(dp[N]).sum()%10007);

    }
}
