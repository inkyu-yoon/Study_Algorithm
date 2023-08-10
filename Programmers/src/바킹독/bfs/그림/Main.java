package 바킹독.bfs.그림;

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
    int maxArea = 0;
    int cnt = 0;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }
    private void sol() throws IOException {
        setUp();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!checked[r][c] && map[r][c] == 1) {
                    q.offer(new int[]{r, c});
                    checked[r][c] = true;
                    bfs();
                    cnt++;
                }
            }
        }

        System.out.println(cnt+"\n"+maxArea);

    }

    private void bfs() {
        int area = 1;
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && map[nr][nc]==1 && !checked[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    checked[nr][nc] = true;
                    area++;
                }
            }
        }
        maxArea = Math.max(maxArea, area);
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
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
