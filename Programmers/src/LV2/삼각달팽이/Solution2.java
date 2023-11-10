package LV2.삼각달팽이;

import java.util.*;

class Solution2 {
    int[] dr = {1, 0, -1};
    int[] dc = {0, 1, -1};

    public int[] solution(int n) {
        int[][] g = new int[n][];
        int last = (n + 1) * n / 2;

        for (int r = 0; r < n; r++) {
            g[r] = new int[r + 1];
            Arrays.fill(g[r], -1);
        }

        int idx = 1;
        int r = 0, c = 0;
        int dir = 0;
        while (idx <= last) {
            g[r][c] = idx++;
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr >= n || nc >= g[r].length || g[nr][nc] != -1) {
                dir = (dir + 1) % 3;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            r = nr;
            c = nc;
        }
        List<Integer> list = new ArrayList<>();
        for (int[] a : g) {
            for (int num : a) {
                list.add(num);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
