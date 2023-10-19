package LV2.피로도;

import java.util.*;

class Solution2 {
    Stack<Integer> s = new Stack<>();
    int ans = 0;

    public int solution(int k, int[][] dungeons) {
        int N = dungeons.length;
        boolean[] checked = new boolean[N];
        backTracking(N, checked, k, dungeons);
        return ans;
    }

    private void backTracking(int N, boolean[] checked, int k, int[][] dungeons) {
        if (s.size() == N) {
            getAns(k, dungeons);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                s.push(i);
                backTracking(N, checked, k, dungeons);
                s.pop();
                checked[i] = false;
            }
        }
    }

    private void getAns(int k, int[][] dungeons) {
        int cnt = 0;
        for (int n : s) {
            int[] dungeon = dungeons[n];
            int need = dungeon[0];
            int waste = dungeon[1];
            if (k < need) {
                break;
            } else {
                k -= waste;
                cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }
}