package 판교가는길.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class Main {
    int[][] map;
    int maxHeight = 0;
    int minHeight = 101;
    int N;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    Stack<int[]> s;
    boolean[][] checked;
    int ans = 0;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        setUp();
        for (int h = minHeight - 1; h <= maxHeight; h++) {
            ans = Math.max(ans, getNumOfSafeArea(h));
        }
        System.out.println(ans);
    }

    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];
                maxHeight = Math.max(maxHeight, input[j]);
                minHeight = Math.min(minHeight, input[j]);
            }
        }
        s = new Stack<>();
    }

    int getNumOfSafeArea(int h) {
        int cnt = 0;
        checked = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] > h && !checked[r][c]) {
                    s.push(new int[]{r, c});
                    checked[r][c] = true;
                    dfs(h);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(int h) {
        while (!s.isEmpty()) {
            int[] p = s.pop();
            int r = p[0], c = p[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !checked[nr][nc] && map[nr][nc] > h) {
                    s.push(new int[]{nr, nc});
                    checked[nr][nc] = true;
                }
            }
        }
    }
}
