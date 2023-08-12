package 바킹독.bfs.불2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int R;
    int C;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    List<int[]> fires = new ArrayList<>();
    Queue<int[]> q = new LinkedList<>();
    String[][] map;
    boolean[][] checked;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            setUp(br);
            bfs();
        }
    }


    private void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            String target = map[r][c];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if (target.equals("@")) {
                        if (map[nr][nc].equals(".")) {
                            q.offer(new int[]{nr, nc, point[2] + 1});
                            map[nr][nc] = "@";
                        }
                    } else {
                        if (!map[nr][nc].equals("#") && !checked[nr][nc]) {
                            q.offer(new int[]{nr, nc});
                            checked[nr][nc] = true;
                            map[nr][nc] = "*";
                        }
                    }
                } else {
                    if (target.equals("@")) {
                        System.out.println(point[2] + 1);
                        return;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private void setUp(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[0]);
        map = new String[R][C];
        checked = new boolean[R][C];

        q.clear();
        fires.clear();

        for (int r = 0; r < R; r++) {
            input = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                map[r][c] = input[c];
                if (map[r][c].equals("@")) {
                    q.offer(new int[]{r, c, 0});
                } else if (map[r][c].equals("*")) {
                    fires.add(new int[]{r, c});
                }
            }
        }

        for (int[] fire : fires) {
            q.offer(fire);
            checked[fire[0]][fire[1]] = true;
        }
    }

}
