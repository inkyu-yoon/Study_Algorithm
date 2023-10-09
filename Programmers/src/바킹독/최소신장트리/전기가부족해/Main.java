package 바킹독.최소신장트리.전기가부족해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]), K = Integer.parseInt(input[2]);
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            parent[Integer.parseInt(input[i])] = 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            pq.offer(new int[]{u, v, c});
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0];
            int v = poll[1];
            int a = find(u);
            int b = find(v);
            if (a != b) {
                parent[b] = a;
                ans += poll[2];
            }
        }
        System.out.println(ans);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

}
