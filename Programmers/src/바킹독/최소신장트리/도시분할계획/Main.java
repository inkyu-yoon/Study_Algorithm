package 바킹독.최소신장트리.도시분할계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]), B = Integer.parseInt(input[1]), C = Integer.parseInt(input[2]);
            pq.offer(new Edge(A, B, C));
        }
        int total = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int u = poll.start, v = poll.end;
            int cost = poll.cost;
            int a = find(u), b = find(v);
            if (a != b) {
                parent[b] = a;
                total += cost;
                cnt++;
            }
            if (cnt == N - 1) {
                total -= cost;
                break;
            }
        }

        System.out.println(total );


    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge next) {
            return this.cost - next.cost;
        }
    }
}
