package 바킹독.최소신장트리.행성연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int u = 0; u < N; u++) {
            String[] input = br.readLine().split(" ");
            for (int v = u+1; v < N; v++) {
                pq.offer(new int[]{u, v, Integer.parseInt(input[v])});
            }
        }

        long total = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0], v = poll[1], cost = poll[2];
            int a = find(u), b = find(v);
            if (a != b) {
                parent[b] = a;
                total += cost;
            }
        }
        System.out.println(total);


    }

    private static int find(int u) {
        if (parent[u] == u) {
            return u;
        }
        return find(parent[u]);
    }
}
