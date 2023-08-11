package 바킹독.bfs.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int N;
    Queue<int[]> q = new LinkedList<>();
    String[][] map;
    boolean[][] checked;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        System.out.println(getCnt(true)+" "+getCnt(false));
    }

    private int getCnt(boolean isNormal) {
        int cnt = 0;
        checked = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!checked[r][c]) {
                    q.offer(new int[]{r, c});
                    checked[r][c] = true;
                    bfs(isNormal);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(boolean isNormal) {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            String color = map[r][c];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !checked[nr][nc]) {
                    if (isNormal) {
                        if (color.equals(map[nr][nc])) {
                            q.offer(new int[]{nr, nc});
                            checked[nr][nc] = true;
                        }
                    } else {
                        if (color.equals("R") || color.equals("G")) {
                            if (map[nr][nc].equals("R") || map[nr][nc].equals("G")) {
                                q.offer(new int[]{nr, nc});
                                checked[nr][nc] = true;
                            }
                        } else {
                            if (color.equals(map[nr][nc])) {
                                q.offer(new int[]{nr, nc});
                                checked[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split("");
            for (int c = 0; c < N; c++) {
                map[r][c] = input[c];
            }
        }

    }
}
