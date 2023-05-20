package 판교가는길.bfs.미로탐색;

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
    Queue<int[]> q;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    boolean[][] checked;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        setUp();
        q.offer(new int[]{0, 0, 1});
        checked[0][0] = true;
        bfs();
        System.out.println(map[R - 1][C - 1]);

    }

    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        R = info[0];
        C = info[1];
        checked = new boolean[R][C];
        q = new LinkedList<>();
        map = new int[R][C];

        for (int r = 0; r < R; r++) {
            int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
            for (int c = 0; c < C; c++) {
                map[r][c] = input[c];
            }
        }

    }

    void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            int d = point[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && !checked[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc, d + 1});
                    map[nr][nc] = d + 1;
                    checked[nr][nc] = true;
                }
            }
        }

    }
}
