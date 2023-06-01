package 판교가는길.dp.가장긴증가하는부분수열4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int[] dp = new int[N];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLength = Arrays.stream(dp).max().getAsInt()+1;
        System.out.println(maxLength);
        int[] ans = new int[maxLength];
        for (int i = dp.length - 1; i >= 0; i--) {
            if (maxLength-1 == dp[i]) {
                ans[maxLength-1] = arr[i];
                maxLength--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : ans) {
            sb.append(n + " ");
        }
        System.out.println(sb);
    }


}
