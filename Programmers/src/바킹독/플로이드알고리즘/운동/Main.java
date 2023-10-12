package 바킹독.플로이드알고리즘.운동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        final int MAX = 10001 * 400;
        int[][] g = new int[V + 1][V + 1];
        for (int r = 1; r <= V; r++) {
            for (int c = 1; c <= V; c++) {
                g[r][c] = MAX;
            }
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            g[u][v] = c;
        }

        for (int m = 1; m <= V; m++) {
            for (int u = 1; u <= V; u++) {
                for (int v = 1; v <= V; v++) {
                    g[u][v] = Math.min(g[u][v], g[u][m] + g[m][v]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int r = 1; r <= V; r++) {
            for (int c = 1; c <= V; c++) {
                if (r == c) {
                    ans = Math.min(ans, g[r][c]);
                }
            }
        }

        System.out.println(ans == MAX ? -1 : ans);
    }
}
