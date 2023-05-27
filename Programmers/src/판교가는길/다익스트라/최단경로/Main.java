package 판교가는길.다익스트라.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Main {
    int V;
    int E;
    int K;
    List<List<Node>> list;
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        K = Integer.parseInt(br.readLine())-1;

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0])-1;
            int v = Integer.parseInt(input[1])-1;
            int w = Integer.parseInt(input[2]);
            list.get(u).add(new Node(v, w));
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        dist[K] = 0;
        pq.offer(new Node(K, dist[K]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > dist[now.idx]) {
                continue;
            }

            int len = list.get(now.idx).size();
            for (int i = 0; i < len; i++) {
                Node next = list.get(now.idx).get(i);
                if (dist[next.idx] > next.cost + now.cost) {
                    dist[next.idx] = next.cost + now.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : dist) {
            if (i == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
    }

    class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node next){
            return this.cost - next.cost;
        }
    }
}
