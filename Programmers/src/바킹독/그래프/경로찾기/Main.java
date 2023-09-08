package 바킹독.그래프.경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static boolean[] checked;
    static int[][] g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        checked = new boolean[N];

        g = new int[N][N];

        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                g[r][c] = Integer.parseInt(input[c]);
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(g[r][c] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int u) {
        Queue<Integer> q = new LinkedList<>();

        for (int c = 0; c < N; c++) {
            if (g[u][c] == 1) {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int c = 0; c < N; c++) {
                if (g[v][c] == 1 && g[u][c] != 1) {
                    g[u][c] = 1;
                    q.offer(c);
                }
            }
        }



    }


}
