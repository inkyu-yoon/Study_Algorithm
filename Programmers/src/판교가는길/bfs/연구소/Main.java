package 판교가는길.bfs.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {
    int R;
    int C;
    int[][] map;
    Queue<int[]> q;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    boolean[][] checked;
    int count;
    Stack<int[]> s;
    int ans = 0;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        setUp();
        bt(0);
        getSafeArea();
        System.out.println(ans);

    }
    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        R = info[0];
        C = info[1];
        map = new int[R][C];
        q = new LinkedList<>();
        s = new Stack<>();

        for (int r = 0; r < R; r++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int c = 0; c < C; c++) {
                map[r][c] = input[c];
            }
        }
    }
    void bt(int depth) {
        if (depth == 3) {
            getSafeArea();
            return;
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != 0) {
                    continue;
                }
                map[r][c]=1;
                bt(depth+1);
                map[r][c]=0;
            }
        }
    }
    void getSafeArea() {
        int[][] copied = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                copied[r][c] = map[r][c];
            }
        }

        checked = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (copied[r][c] == 2 && !checked[r][c]) {
                    q.offer(new int[]{r, c});
                    checked[r][c] = true;
                    bfs(copied);
                }
            }
        }
        count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (copied[r][c] == 0) {
                    count++;
                }
            }
        }
        ans = Math.max(ans, count);
    }

    void bfs(int[][] copied) {
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c = p[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && !checked[nr][nc] && copied[nr][nc] == 0) {
                    q.offer(new int[]{nr, nc});
                    checked[nr][nc] = true;
                    copied[nr][nc] = 2;
                }
            }
        }
    }
}
