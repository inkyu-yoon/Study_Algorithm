package 바킹독.bfs.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int R;
    int C;
    int[][] map;
    boolean[][] checked;
    Queue<int[]> q = new LinkedList<>();
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        checkTomato();
        bfs();
        getAns();

    }

    private void getAns() {
        int ans = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 0) {
                    System.out.println(-1);
                    return;
                } else if (map[r][c] != 1) {
                    ans = Math.max(ans, map[r][c]);
                }
            }
        }

        System.out.println(ans);
    }

    private void checkTomato() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 1 && !checked[r][c]) {
                    q.offer(new int[]{r, c, 0});
                    checked[r][c] = true;
                }
            }
        }

    }

    private void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            int d = point[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && !checked[nr][nc] && map[nr][nc] != -1) {
                    q.offer(new int[]{nr, nc, d + 1});
                    map[nr][nc] = d + 1;
                    checked[nr][nc] = true;
                }
            }
        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        C = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        map = new int[R][C];
        checked = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            input = br.readLine().split(" ");
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(input[c]);
            }
        }
    }
}
