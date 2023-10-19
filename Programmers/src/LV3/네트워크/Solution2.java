package LV3.네트워크;

import java.util.*;

class Solution2 {
    boolean[] checked;
    Queue<Integer> q = new LinkedList<>();

    public int solution(int n, int[][] computers) {
        int answer = 0;
        checked = new boolean[n + 1];


        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                q.offer(i);
                bfs(computers);
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int[][] computers) {
        while (!q.isEmpty()) {
            int num = q.poll();
            for (int j = 0; j < computers[num].length; j++) {
                if (num != j && !checked[j] && computers[num][j] == 1) {
                    q.offer(j);
                    checked[j] = true;
                }
            }
        }


    }
}
