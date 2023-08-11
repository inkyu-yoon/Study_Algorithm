package 바킹독.bfs.유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int[][] map;
    boolean[][] checked;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int R;
    int C;
    int K;
    Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        new Main().sol();

    }

    private void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int cnt = 0;
            setUp(br);
            setMap(br);
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
            System.out.println(cnt);
        }
    }

    private void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && !checked[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    checked[nr][nc] = true;
                }
            }
        }
    }

    private void setMap(BufferedReader br) throws IOException {
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int c = Integer.parseInt(input[0]), r = Integer.parseInt(input[1]);
            map[r][c] = 1;
        }
    }

    private void setUp(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[2]);
        map = new int[R][C];
        checked = new boolean[R][C];
        q.clear();


    }

}
