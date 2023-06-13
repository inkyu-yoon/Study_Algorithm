package LV3.섬연결하기;

import java.util.*;

class Solution3 {
    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for (int[] cost : costs) {
            int u = cost[0], v = cost[1];
            if (find(u) != find(v)) {
                union(u, v);
                answer += cost[2];
            }
        }

        return answer;
    }

    int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return find(parent[a]);
    }

    void union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (a != b) {
            parent[b] = a;
        }
    }
}
