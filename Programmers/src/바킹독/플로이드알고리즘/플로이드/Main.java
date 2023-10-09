package 바킹독.플로이드알고리즘.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] g = new int[N][N];
        final int MAX = 100000100;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    g[i][j]=MAX;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1, v = Integer.parseInt(input[1]) - 1, c = Integer.parseInt(input[2]);

            g[u][v] = Math.min(g[u][v],c);
        }



        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    if (g[u][v] > g[u][m] + g[m][v]) {
                        g[u][v] = g[u][m] + g[m][v];
                    }
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (g[i][j] == MAX) {
                    g[i][j] = 0;
                }
            }
        }
        StringBuilder ans = new StringBuilder();

        for (int[] ints : g) {
            for (int val : ints) {
                ans.append(val + " ");
            }
            ans.append("\n");
        }
        System.out.println(ans);

    }
}
