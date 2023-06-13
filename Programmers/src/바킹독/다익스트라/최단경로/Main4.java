package 바킹독.다익스트라.최단경로;

import java.io.*;
import java.util.*;

public class Main4 {
    static int V;
    static int E;
    static int start;

    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        start = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            list.get(u).add(new Node(v, cost));
        }

        dijkstra();


    }

    private static void dijkstra() {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int u = now.idx;
            int cost = now.cost;
            int len = list.get(u).size();
            for (int i = 0; i < len; i++) {
                Node next = list.get(u).get(i);
                int v = next.idx;
                if (dist[v] > next.cost + cost) {
                    dist[v] = next.cost + cost;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i] + "\n");
            }
        }
        System.out.println(sb);

    }

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

}
