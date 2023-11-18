package LV2.배달;

import java.util.*;

class Solution6 {
    int[][] g;

    public int solution(int N, int[][] road, int K) {
        g = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    g[i][j] = 0;
                } else {
                    g[i][j] = 20000001;
                }
            }
        }
        for (int[] info : road) {
            int u = info[0] - 1, v = info[1] - 1, cost = info[2];
            g[u][v] = Math.min(g[u][v], cost);
            g[v][u] = Math.min(g[v][u], cost);
        }

        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    g[u][v] = Math.min(g[u][v], g[u][m] + g[m][v]);
                }
            }
        }


        return (int) Arrays.stream(g[0]).filter(i -> i <= K).count();
    }
}
