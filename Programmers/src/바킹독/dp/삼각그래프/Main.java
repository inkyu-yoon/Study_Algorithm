package 바킹독.dp.삼각그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int[][] g = new int[N][3];

            for (int r = 0; r < N; r++) {
                String[] input = br.readLine().split(" ");
                for (int c = 0; c < 3; c++) {
                    g[r][c] = Integer.parseInt(input[c]);
                }
            }

            g[0][2] += g[0][1];

            for (int c = 0; c < 3; c++) {
                if (c == 0) {
                    g[1][0] += g[0][1];
                } else if (c == 1) {
                    g[1][1] += Math.min(Math.min(g[0][1], g[0][2]), g[1][0]);
                } else {
                    g[1][2] += Math.min(Math.min(g[0][1], g[0][2]), g[1][1]);
                }
            }

            for (int r = 2; r < N; r++) {
                for (int c = 0; c < 3; c++) {
                    if (c == 0) {
                        g[r][0] += Math.min(g[r-1][0],g[r-1][1]);
                    } else if (c == 1) {
                        g[r][1] += Math.min(Math.min(Math.min(g[r-1][0], g[r-1][1]), g[r-1][2]),g[r][0]);
                    } else {
                        g[r][2] += Math.min(Math.min(g[r-1][1], g[r-1][2]), g[r][1]);
                    }
                }
            }

            sb.append(String.format("%d. %d\n", testCase++, g[N-1][1]));

        }
        System.out.println(sb);

    }
}
