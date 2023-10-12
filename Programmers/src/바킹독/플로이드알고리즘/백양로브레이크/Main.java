package 바킹독.플로이드알고리즘.백양로브레이크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] g = new int[n + 1][n + 1];
        final int MAX = 300;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if(r!=c){
                    g[r][c] = MAX;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            g[u][v] = 0;
            if (b == 0) {
                g[v][u] = 1;
            } else {
                g[v][u] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int u = 1; u <= n; u++) {
                for (int v = 1; v <= n; v++) {
                    g[u][v] = Math.min(g[u][v], g[u][i] + g[i][v]);
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            sb.append(g[u][v] + "\n");
        }
        System.out.println(sb);
    }
}
