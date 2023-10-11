package 바킹독.플로이드알고리즘.우주탐사선;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    static int N;
    static Stack<Integer> s = new Stack<>();
    static int[][] g;
    static boolean[] checked;
    static int ans = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        checked = new boolean[N];
        int K = Integer.parseInt(input[1]);
        g = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                g[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    g[u][v] = Math.min(g[u][v], g[u][m] + g[m][v]);
                }
            }
        }

        bt(K);
        System.out.println(ans);

    }

    private static void bt(int K) {
        s.push(K);
        checked[K] = true;
        int sum = 0;
        bt(K, sum);
    }

    private static void bt(int start, int sum) {
        if (s.size() == N) {
            ans = Math.min(ans, sum);
            return;
        }
        for (int end = 0; end < N; end++) {
            if (!checked[end]) {
                checked[end] = true;
                s.push(end);
                sum += g[start][end];
                bt(end,sum);
                sum -= g[start][end];
                s.pop();
                checked[end] = false;
            }
        }
    }
}
