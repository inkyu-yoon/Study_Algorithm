package 바킹독.시뮬레이션.뿌요뿌요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] map;
    static Queue<int[]> q;
    static boolean[][] checked;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new String[12][];
        q = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().split("");
        }
        int result = 0;
        while (check()) {
            move();
            result++;
        }

        System.out.println(result);
    }

    private static void move() {
        for (int r = 11; r >= 0; r--) {
            for (int c = 0; c < 6; c++) {
                if (map[r][c].equals(".")) {
                    for (int i = r; i >= 0; i--) {
                        if (!map[i][c].equals(".")) {
                            map[r][c] = map[i][c];
                            map[i][c] = ".";
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean check() {
        boolean result = false;
        checked = new boolean[12][6];

        for (int r = 0; r < 12; r++) {
            for (int c = 0; c < 6; c++) {
                if (!checked[r][c] && !map[r][c].equals(".")) {
                    q.offer(new int[]{r, c});
                    if (bfs(map[r][c])) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    private static boolean bfs(String target) {
        boolean result = false;
        int cnt = 1;
        List<int[]> points = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];

            if (checked[r][c]) {
                continue;
            }

            checked[r][c] = true;
            points.add(point);
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (0 <= nr && nr < 12 && 0 <= nc && nc < 6 && map[nr][nc].equals(target) && !checked[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    cnt++;
                }
            }
        }

        if (cnt >= 4) {
            for (int[] point : points) {
                map[point[0]][point[1]] = ".";
            }
            result = true;
        }
        return result;
    }
}
