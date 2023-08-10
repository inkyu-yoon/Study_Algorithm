package 바킹독.bfs.불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int R;
    int C;
    String[][] map;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] checked;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        setFire();
        bfs();

    }

    private void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            String target = map[r][c];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if (target.equals("J")) {
                        if (map[nr][nc].equals(".")) {
                            map[nr][nc] = "J";
                            q.offer(new int[]{nr, nc, point[2] + 1});
                        }
                    } else if (target.equals("F")) {
                        if (!checked[nr][nc] && !map[nr][nc].equals("#")) {
                            map[nr][nc] = "F";
                            q.offer(new int[]{nr, nc});
                            checked[nr][nc] = true;
                        }
                    }
                } else {
                    if (target.equals("J")) {
                        System.out.println(point[2] + 1);
                        return;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private void setFire() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c].equals("F")) {
                    q.offer(new int[]{r, c});
                    checked[r][c] = true;
                }
            }
        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new String[R][C];
        checked = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            input = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                map[r][c] = input[c];

                if (map[r][c].equals("J")) {
                    q.offer(new int[]{r, c, 0});

                }

            }
        }
    }
}
