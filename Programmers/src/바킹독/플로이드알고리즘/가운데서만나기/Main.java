package 바킹독.플로이드알고리즘.가운데서만나기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MAX = 2001000;

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] g = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r != c) {
                    g[r][c] = MAX;
                }
            }
        }


        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int T = Integer.parseInt(input[2]);
            g[A][B] = Math.min(g[A][B], T);
        }

        int K = Integer.parseInt(br.readLine());
        int[] friends = new int[K + 1];
        input = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            friends[i + 1] = Integer.parseInt(input[i]);
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

        int[] result = new int[N + 1];
        result[0] = MAX;



        for (int end = 1; end <= N; end++) {
            int max = 0;
            for (int i = 1; i <= K; i++) {
                int friend = friends[i];
                int time = g[friend][end] + g[end][friend];
                max = Math.max(max, time);
            }
            result[end] = max;
        }


        int min = Arrays.stream(result).min().getAsInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == min) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);

    }
}
