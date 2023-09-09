package 바킹독.다익스트라.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        List<List<Node>> nodes = new ArrayList<>();

        int V = Integer.parseInt(input[0]), E = Integer.parseInt(input[1]);
        int K = Integer.parseInt(br.readLine())-1;

        for (int i = 0; i < V; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]) - 1, v = Integer.parseInt(input[1]) - 1, w = Integer.parseInt(input[2]);
            nodes.get(u).add(new Node(v, w));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(K, dist[K]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int i = node.idx;
            int cost = node.cost;
            List<Node> neighbors = nodes.get(i);
            for (int j = 0; j < neighbors.size(); j++) {
                Node v = neighbors.get(j);
                if (dist[v.idx] > v.cost + cost) {
                    dist[v.idx] = v.cost + cost;
                    pq.offer(new Node(v.idx, dist[v.idx]));
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    static class Node{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
