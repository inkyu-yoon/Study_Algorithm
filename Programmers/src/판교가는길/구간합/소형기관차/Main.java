package 판교가는길.구간합.소형기관차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    // 소형 기관차 3대로 운송할 수 있는 최대 손님 수
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }


        for (int i = 1; i <= N; i++) {
            sum[i]=sum[i-1]+arr[i];
        }


        int M = Integer.parseInt(br.readLine());

        int[][] dp = new int[4][N + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = i * M; j <= N; j++) {
                if (j == i * M) {
                    dp[i][j] = sum[j];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], sum[j] - sum[j - M] + dp[i - 1][j - M]);
                }
            }
        }
        System.out.println(dp[3][N]);


    }
}
