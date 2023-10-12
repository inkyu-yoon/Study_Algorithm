package 바킹독.플로이드알고리즘.궁금한민호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MAX = 250000;
        int[][] g = new int[N][N];
        for (int u = 0; u < N; u++) {
            String[] input = br.readLine().split(" ");
            for (int v = 0; v < N; v++) {
                g[u][v] = Integer.parseInt(input[v]);
            }
        }

        int[][] costs = deepCopy(g);

        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    if (costs[u][v] == costs[u][m] + costs[m][v] && (u != v && v != m && u != m)) {
                        costs[u][v] = MAX;
                        costs[v][u] = MAX;
                    }
                }
            }
        }

        int ans = 0;
        for (int r = 0; r < N; r++) {
            for (int c = r + 1; c < N; c++) {
                if (costs[r][c] != MAX) {
                    ans += costs[r][c];
                }
            }
        }

        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    costs[u][v] = Math.min(costs[u][v], costs[u][m] + costs[m][v]);
                }
            }
        }

        if (isSame(costs, g)) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }


    }

    private static boolean isSame(int[][] costs, int[][] g) {
        int N = g.length;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (costs[r][c] != g[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] deepCopy(int[][] g) {
        int N = g.length;
        int[][] result = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                result[r][c] = g[r][c];
            }
        }
        return result;
    }
}
