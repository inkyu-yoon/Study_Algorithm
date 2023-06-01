package 판교가는길.dp.욕심쟁이판다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Main {
    int n;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    Stack<int[]> s;
    int[][] map;
    int[][] dp;
    int ans = 0;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    // 최대한 많은 칸 방문
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for (int r = 0; r < n; r++) {
            String[] input = br.readLine().split(" ");
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(input[c]);
            }
        }

        s = new Stack<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c] == 0) {
                    ans = Math.max(ans,dfs(r,c));

                }
            }
        }
        System.out.println(ans);


    }

    int dfs(int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        dp[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                if (map[r][c] < map[nr][nc]) {
                    dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
                }
            }
        }

        return dp[r][c];
    }
}
