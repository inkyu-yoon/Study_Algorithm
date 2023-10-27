package LV2.게임맵최단거리;

import java.util.*;

class Solution2 {
    public int solution(int[][] maps) {
        int answer = 0;
        int R = maps.length, C = maps[0].length;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] checked = new boolean[R][C];
        q.offer(new int[]{0, 0});
        checked[0][0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c = p[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && maps[nr][nc] == 1 && !checked[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    checked[nr][nc] = true;
                    maps[nr][nc] = maps[r][c] + 1;
                }
            }
        }

        return checked[R - 1][C - 1] ? maps[R - 1][C - 1] : -1;
    }
}