package 바킹독.dp.자두나무;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // T초 동안 자두가 떨어지고, 최대 W번 움직인다. 최초 위치는 1이고 나무는 1 아니면 2
        int T = Integer.parseInt(input[0]), W = Integer.parseInt(input[1]);

        int[][] dp = new int[T + 1][W + 1];

        for (int t = 1; t <= T; t++) {
            int tree = Integer.parseInt(br.readLine());

            // 자두가 1번 나무에 떨어졌을 경우
            if (tree == 1) {
                for (int cnt = 0; cnt <= W; cnt++) {

                    // 움직인 횟수가 2로 나누어진다는 뜻은, 1번 나무에 있다는 의미
                    if (cnt % 2 == 0) {

                        // 단 움직인 횟수가 0인 경우는 다른 나무에서 넘어올 경우의 수가 없으므로 이전 값에서 +1
                        if (cnt == 0) {
                            dp[t][cnt] = dp[t - 1][cnt] + 1;

                            // 움직인 횟수가 2,4 ... 인 경우는 2번 나무에서 넘어온 경우도 있다.
                        } else {
                            dp[t][cnt] = Math.max(dp[t - 1][cnt] + 1, dp[t - 1][cnt - 1] + 1);
                        }

                        // 움직인 횟수가 2로 나누어지지 않는 다는 뜻은 2번 나무에 있다는 뜻이므로
                        // 1번 나무에 자두가 떨어진 것은 영향을 주지 않는다.
                    } else {
                        dp[t][cnt] = Math.max(dp[t - 1][cnt], dp[t - 1][cnt - 1]);
                    }

                }

                //2번 나무에 자두가 떨어지는 경우
            } else if (tree == 2) {
                for (int cnt = 1; cnt <= W; cnt++) {

                    // 움직인 횟수가 2로 나누었을 때 1이 남아야 2번 나무에 있다는 의미
                    if (cnt % 2 != 0) {
                        // 1번나무에 있다가 넘어온 경우와 2번 나무에 그대로 있었던 경우의 수 중 최댓값
                        dp[t][cnt] = Math.max(dp[t - 1][cnt] + 1, dp[t - 1][cnt - 1] + 1);
                    } else {

                        // 1번 나무에 위치한 경우 자두 수에 영향을 주지 않는다.
                        dp[t][cnt] = Math.max(dp[t - 1][cnt], dp[t - 1][cnt - 1]);
                    }
                }
            }
        }

        System.out.println(Arrays.stream(dp[T]).max().getAsInt());
    }
}