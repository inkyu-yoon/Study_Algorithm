package 바킹독.다익스트라.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        int K = Integer.parseInt(br.readLine())-1;

        List<List<Node>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0])-1;
            int v = Integer.parseInt(input[1])-1;
            int cost = Integer.parseInt(input[2]);

            g.get(u).add(new Node(v, cost));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, dist[K]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int u = now.idx;
            if (now.cost > dist[u]) {
                continue;
            }
            int len = g.get(u).size();
            for (int i = 0; i < len; i++) {
                Node next = g.get(u).get(i);
                if (dist[next.idx] > next.cost + now.cost) {
                    dist[next.idx] = next.cost + now.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));

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
