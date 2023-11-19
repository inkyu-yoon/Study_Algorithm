package LV2.무인도여행;

import java.util.*;

class Solution2 {
    String[][] map;
    int R;
    int C;
    boolean[][] checked;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    Queue<int[]> q = new LinkedList<>();

    public int[] solution(String[] maps) {
        setUp(maps);
        List<Integer> answer = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!map[r][c].equals("X") && !checked[r][c]) {

                    answer.add(bfs(r, c));
                }
            }
        }
        int[] ans = answer.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(ans);
        return ans.length == 0 ? new int[]{-1} : ans;
    }

    private void setUp(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        map = new String[R][];
        for (int r = 0; r < R; r++) {
            String info = maps[r];
            map[r] = info.split("");
        }
        checked = new boolean[R][C];
    }

    private int bfs(int startR, int startC) {
        int result = 0;

        q.offer(new int[]{startR, startC});
        checked[startR][startC] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            result += Integer.parseInt(map[r][c]);
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && !map[nr][nc].equals("X") && !checked[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    checked[nr][nc] = true;
                }
            }
        }

        return result;
    }
}