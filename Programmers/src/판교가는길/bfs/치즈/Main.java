package 판교가는길.bfs.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    int N;
    int M;
    int[][] map;
    int[][] copied;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    Queue<int[]> q;
    boolean[][] checked;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        setUp();
        int time = 0;
        while (true) {
            checkAirArea();
            if (!getCheeseNearAir()) {
                break;
            }
            time++;
        }
        System.out.println(time);

    }

    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split(" ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(input[c]);
            }
        }
    }

    void checkAirArea() {
        copied = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                copied[r][c] = map[r][c];
            }
        }
        q = new LinkedList<>();
        checked = new boolean[N][M];
        copied[0][0] = -1;
        checked[0][0] = true;
        q.offer(new int[]{0, 0});
        bfsForMarking();
    }

    void bfsForMarking() {
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c = p[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && !checked[nr][nc] && copied[nr][nc] == 0) {
                    q.offer(new int[]{nr, nc});
                    checked[nr][nc] = true;
                    copied[nr][nc] = -1;
                }
            }
        }
    }

    boolean getCheeseNearAir() {
        boolean flag = false;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (copied[r][c] == 1 && isNearAir(r, c)) {
                    map[r][c] = 0;
                    flag = true;
                }
            }
        }
        return flag;
    }

    boolean isNearAir(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (0 <= nr && nr < N && 0 <= nc && nc < M && copied[nr][nc] == -1) {
                cnt++;
            }
            if (cnt == 2) {
                return true;
            }
        }
        return false;
    }
}
/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
 */