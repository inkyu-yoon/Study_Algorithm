package 바킹독.플로이드알고리즘.택배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[][] path;
    static List<Integer> trace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        final int MAX = 2000000;
        int[][] g = new int[N + 1][N + 1];
        int[][] ans = new int[N + 1][N + 1];
        path = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r != c) {
                    g[r][c] = MAX;
                }
            }
        }


        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            g[u][v] = c;
            g[v][u] = c;
            path[u][v] = u;
            path[v][u] = v;
        }


        for (int m = 1; m <= N; m++) {
            for (int u = 1; u <= N; u++) {
                for (int v = 1; v <= N; v++) {
                    if (g[u][v] > g[u][m] + g[m][v]) {
                        g[u][v] = g[u][m] + g[m][v];
                        path[u][v] = path[m][v];
                    }
                }
            }
        }

        for (int u = 1; u <= N; u++) {
            for (int v = 1; v <= N; v++) {
                trace = new ArrayList<>();
                if (g[u][v] != 0) {
                    findPath(u, v);
                    trace.add(v);
                    ans[u][v] = trace.get(1);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r == c) {
                    sb.append("- ");
                } else {
                    sb.append(ans[r][c] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }


    static void findPath(int from, int to) {
        int prev = path[from][to];
        if (prev == from) {
            trace.add(from);
            return;
        }
        findPath(from, prev);
        findPath(prev, to);
    }
}
