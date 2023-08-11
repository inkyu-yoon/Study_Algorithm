package 바킹독.bfs.토마토2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int R;
    int C;
    int H;
    int[][][] map;
    boolean[][][] checked;
    Queue<int[]> q = new LinkedList<>();
    int[] dr = {1, -1, 0, 0, 0, 0};
    int[] dc = {0, 0, 1, -1, 0, 0};
    int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        bfs();
        System.out.println(getAns());

    }

    private int getAns() {
        int ans = 0;
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[h][r][c] == 0) {
                        return -1;
                    }
                    ans = Math.max(ans, map[h][r][c]);
                }
            }
        }

        return ans - 1;
    }

    private void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int h = point[0], r = point[1];
            int c = point[2];
            for (int i = 0; i < 6; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                int nh = h + dh[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && 0 <= nh && nh < H &&!checked[nh][nr][nc] && map[nh][nr][nc] == 0) {
                    q.offer(new int[]{nh, nr, nc});
                    checked[nh][nr][nc] = true;
                    map[nh][nr][nc] = map[h][r][c] + 1;
                }
            }
        }


    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[2]);
        map = new int[H][R][C];
        checked = new boolean[H][R][C];

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                input = br.readLine().split(" ");
                for (int c = 0; c < C; c++) {
                    map[h][r][c] = Integer.parseInt(input[c]);
                    if (map[h][r][c] == 1) {
                        q.offer(new int[]{h, r, c});
                        checked[h][r][c] = true;
                    }
                }
            }
        }
    }
}
