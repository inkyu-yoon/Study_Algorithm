package LV2.배달;

import java.util.*;

class Solution5 {
    int N;
    List<List<Node>> nodes = new ArrayList<>();

    public int solution(int N, int[][] road, int K) {
        this.N = N;

        for (int i = 0; i < N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] info : road) {
            int u = info[0] - 1, v = info[1] - 1;
            int cost = info[2];
            nodes.get(u).add(new Node(v, cost));
            nodes.get(v).add(new Node(u, cost));
        }


        return dijkstra(K);
    }

    private int dijkstra(int K) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(0, dist[0]));

        while (!pq.isEmpty()) {
            Node u = pq.poll();
            for (Node v : nodes.get(u.idx)) {
                if (dist[v.idx] > v.cost + u.cost) {
                    dist[v.idx] = v.cost + u.cost;
                    pq.offer(new Node(v.idx, dist[v.idx]));
                }
            }
        }

        return (int) Arrays.stream(dist).filter(i -> i <= K).count();
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
