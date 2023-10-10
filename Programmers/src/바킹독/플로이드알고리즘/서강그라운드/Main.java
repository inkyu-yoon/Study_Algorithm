package 바킹독.플로이드알고리즘.서강그라운드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);
        final int MAX = 1600;
        input = br.readLine().split(" ");
        int[] items = new int[N+1];
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(input[i - 1]);
        }

        int[][] g = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r != c) {
                    g[r][c] = MAX;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            g[a][b] = c;
            g[b][a] = c;
        }

        for (int m = 1; m <= N; m++) {
            for (int u = 1; u <= N; u++) {
                for (int v = 1; v <= N; v++) {
                    if (g[u][v] > g[u][m] + g[m][v]) {
                        g[u][v] = g[u][m] + g[m][v];
                    }
                }
            }
        }
        int ans = 0;
        for (int r = 1; r <= N; r++) {
            int total = 0;
            for (int c = 1; c <= N; c++) {
                if (g[r][c] <= M) {
                    total += items[c];
                }
            }
            ans = Math.max(ans, total);
        }
        System.out.println(ans);
    }
}
