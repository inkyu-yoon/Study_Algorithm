package 바킹독.플로이드알고리즘.플로이드2;

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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        final int MAX = 10000100;
        int[][] g = new int[N][N];
        path = new int[N][N];


        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r != c) {
                    g[r][c] = MAX;
                }
                path[r][c] = -1;
            }
        }
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1, b = Integer.parseInt(input[1]) - 1, c = Integer.parseInt(input[2]);
            g[a][b] = Math.min(g[a][b], c);
            path[a][b] = a;
        }

        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    if (g[u][v] > g[u][m] + g[m][v]) {
                        g[u][v] = g[u][m] + g[m][v];
                        path[u][v] = path[m][v];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int[] ints : g) {
            for (int n : ints) {
                if (n == MAX) {
                    sb.append(0 + " ");
                } else {
                    sb.append(n + " ");
                }
            }
            sb.append("\n");
        }


        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (path[r][c] != -1) {
                    trace = new ArrayList<>();
                    findPath(r, c);
                    trace.add(c + 1);
                    sb.append(convertToString());
                } else {
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static String convertToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(trace.size() + " ");
        for (int n : trace) {
            sb.append(n + " ");
        }
        sb.append("\n");
        return sb.toString();
    }

    static void findPath(int from, int to) {
        int prev = path[from][to];
        if (prev == from) {
            trace.add(from + 1);
            return;
        }
        findPath(from, prev);
        findPath(prev, to);
    }
}
