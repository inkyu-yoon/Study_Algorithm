package 바킹독.트리.회사문화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] parents = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int[] dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int target = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);
            dp[target] += value;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] += dp[parents[i - 1]];
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(dp[i] + " ");
        }
        System.out.println(sb);

    }

}
