package 바킹독.플로이드알고리즘.플로이드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    static int[][] path;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        final int MAX = 10000100;
        int[][] g = new int[N + 1][N + 1];
        path = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r != c) {
                    g[r][c] = MAX;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            g[u][v] = Math.min(g[u][v], c);
            path[u][v] = u;
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

        StringBuilder ans = new StringBuilder();
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (g[r][c] == MAX) {
                    ans.append("0 ");
                } else {
                    ans.append(g[r][c] + " ");
                }
            }
            ans.append("\n");
        }
        for (int u = 1; u <= N; u++) {
            for (int v = 1; v <= N; v++) {
                list.clear();
                if (path[u][v] != 0) {
                    findPath(u, v);
                    list.add(v);
                    ans.append(list.size() + " ");
                    for (int n : list) {
                        ans.append(n + " ");
                    }
                    ans.append("\n");
                } else {
                    ans.append("0\n");
                }
            }
        }
        System.out.println(ans);
    }

    static void findPath(int from, int to) {
        int prev = path[from][to];
        if (prev == from) {
            list.add(from);
            return;
        }
        findPath(from, prev);
        findPath(prev, to);
    }
}
