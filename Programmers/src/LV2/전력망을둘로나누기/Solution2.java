package LV2.전력망을둘로나누기;

import java.util.*;

class Solution2 {
    int[][] g;
    int N;

    public int solution(int n, int[][] wires) {
        setUp(n, wires);

        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int group1 = bfs(wire);
            int group2 = n - bfs(wire);
            answer = Math.min(answer, Math.abs(group1 - group2));
        }

        return answer;
    }

    private void setUp(int n, int[][] wires) {
        this.N = n;

        g = new int[N][N];
        for (int[] wire : wires) {
            int u = wire[0] - 1, v = wire[1] - 1;
            g[u][v] = 1;
            g[v][u] = 1;
        }

    }

    private int bfs(int[] removed) {
        int[][] copied = deepCopy();

        int u = removed[0] - 1, v = removed[1] - 1;
        copied[u][v] = 0;
        copied[v][u] = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[g.length];

        int count = 1;
        q.offer(0);
        checked[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < N; i++) {
                if (copied[node][i] == 1 && !checked[i]) {
                    q.offer(i);
                    checked[i] = true;
                    count++;
                }
            }
        }
        return count;

    }

    private int[][] deepCopy() {

        int[][] result = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                result[r][c] = g[r][c];
            }
        }
        return result;
    }
}
