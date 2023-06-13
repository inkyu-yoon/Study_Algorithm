package 바킹독.dp.일이삼더하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 1,2,3 의 합으로 나타내는 방법의 수를 구하라
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] % 1000000009 + dp[i - 2] % 1000000009 + dp[i - 3] % 1000000009) % 1000000009;
        }

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]+"\n");
        }
        System.out.println(sb);
    }
}
