package 바킹독.bfs.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        q.offer(new int[]{0, 0, 1});
        checked[0][0] = true;

        bfs();

    }

    private void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            int d = point[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && !checked[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc, d + 1});
                    checked[nr][nc] = true;
                    if (nr == R - 1 && nc == C - 1) {
                        System.out.println(d+1);
                    }
                }
            }
        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new int[R][C];
        checked = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            input = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(input[c]);
            }
        }

    }
}
