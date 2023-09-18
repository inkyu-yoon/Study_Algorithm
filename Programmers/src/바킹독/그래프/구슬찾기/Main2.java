package 바킹독.그래프.구슬찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int N;
    static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] smalls = new int[N][N];
        int[][] bigs = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r != c) {
                    smalls[r][c] = MAX;
                    bigs[r][c] = MAX;
                }
            }
        }


        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int big = Integer.parseInt(input[0]) - 1;
            int small = Integer.parseInt(input[1]) - 1;

            smalls[small][big] = 1;
            bigs[big][small] = 1;

        }

        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    smalls[u][v] = Math.min(smalls[u][v], smalls[u][m] + smalls[m][v]);
                    bigs[u][v] = Math.min(bigs[u][v], bigs[u][m] + bigs[m][v]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cntOfSmall = getCount(smalls, i);
            if (cntOfSmall >= (N + 1) / 2) {
                ans++;
                continue;
            }

            int cntOfBig = getCount(bigs, i);
            if (cntOfBig >= (N + 1) / 2) {
                ans++;
            }
        }
        System.out.println(ans);

    }

    private static int getCount(int[][] graph, int i) {
        int cnt = 0;
        for (int c = 0; c < N; c++) {
            if (graph[i][c] != MAX && graph[i][c] != 0) {
                cnt++;
            }
        }
        return cnt;
    }

}
