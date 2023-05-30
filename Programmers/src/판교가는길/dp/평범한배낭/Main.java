package 판교가는길.dp.평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    // N개의 물건. 각 물건은 무게 W와 가치 V를 갖는다.
    // 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있따.
    // 배낭에 넣을 수 있는 물건들의 가치의 최댓값

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);
        List<int[]> items = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int W = Integer.parseInt(input[0]), V = Integer.parseInt(input[1]);
            items.add(new int[]{W, V});

        }
        Collections.sort(items, (a, b) -> a[0] - b[0]);
        List<int[]> saved = new ArrayList<>();

        int[] dp = new int[K + 1];
        for (int[] item : items) {
            int weight = item[0];
            int value = item[1];
            for (int i = 0; i <= K; i++) {
                if (dp[i] != 0 && i + weight <= K) {
                    saved.add(new int[]{i + weight, dp[i] + value});
                }
            }
            if (weight <= K) {
                dp[weight] = Math.max(dp[weight], value);
            }

            for (int[] ints : saved) {
                dp[ints[0]] = Math.max(dp[ints[0]], ints[1]);
            }

            saved.clear();
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());


    }
}
