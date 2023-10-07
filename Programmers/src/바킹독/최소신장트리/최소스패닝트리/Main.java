package 바킹독.최소신장트리.최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        parent = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            pq.offer(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])});
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0];
            int v = poll[1];
            int cost = poll[2];
            if (find(u) != find(v)) {
                ans += cost;
                union(u, v);
            }
        }

        System.out.println(ans);
    }

    private static int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return find(parent[i]);
    }

    private static void union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (a != b) {
            parent[b] = a;
        }
    }
}
