package 판교가는길.bfs.다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    int N;
    int[][] map;
    int[][] distance;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    Queue<int[]> q;
    boolean[][] checked;
    int ans = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        setUp();
        labeling();
        getLandsNearOcean();
        bfs();
        System.out.println(ans);
    }

    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(input[c]);
            }
        }
    }

    void labeling() {
        int land = -1;
        q = new LinkedList<>();
        checked = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1 && !checked[r][c]) {
                    q.offer(new int[]{r, c});
                    checked[r][c] = true;
                    bfsForLabel(land--);
                }
            }
        }
    }

    void bfsForLabel(int land) {
        while (!q.isEmpty()) {
            int[] info = q.poll();
            int r = info[0], c = info[1];
            map[r][c] = land;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !checked[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    checked[nr][nc] = true;
                }
            }
        }
    }

    void getLandsNearOcean() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] != 0 && isNearOcean(r, c)) {
                    q.offer(new int[]{r, c, map[r][c],0});
                }
            }
        }
    }

    boolean isNearOcean(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] == 0) {
                return true;
            }
        }
        return false;
    }

    void bfs() {
        distance = new int[N][N];
        checked = new boolean[N][N];

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int r = info[0], c = info[1];
            int land = info[2], d = info[3];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                    if (!checked[nr][nc] && map[nr][nc] == 0) {
                        q.offer(new int[]{nr, nc, land, d + 1});
                        checked[nr][nc] = true;
                        map[nr][nc]=land;
                        distance[nr][nc]=d+1;
                    }

                    if (map[nr][nc] != 0 && map[nr][nc] != land) {
                        ans = Math.min(ans, distance[r][c] + distance[nr][nc]);
                    }
                }
            }
        }
    }
}
/*
1 1 0 0 0 2
1 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
3 0 0 0 0 0
0 0 0 0 0 0
 */