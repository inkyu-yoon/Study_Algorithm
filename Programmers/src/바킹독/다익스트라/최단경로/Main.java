package 바킹독.다익스트라.최단경로;

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
    final int MAX = Integer.MAX_VALUE;

    List<List<Node>> list;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        setUp();
        dijkstra();
    }

    void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        Arrays.fill(dist, MAX);
        dist[K] = 0;

        pq.add(new Node(K, dist[K]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > dist[now.idx]) {
                continue;
            }

            int len = list.get(now.idx).size();

            for (int v = 0; v < len; v++) {
                Node next = list.get(now.idx).get(v);
                if (dist[next.idx] > now.cost + next.cost) {
                    dist[next.idx] = now.cost + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : dist) {
            if (i != MAX) {
                sb.append(String.format("%d\n", i));
            } else {
                sb.append(String.format("%s\n", "INF"));
            }
        }
        System.out.println(sb);


    }

    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        V = info[0];
        E = info[1];
        K = Integer.parseInt(br.readLine())-1;

        list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int u = input[0] - 1, v = input[1] - 1;
            int w = input[2];
            list.get(u).add(new Node(v, w));
        }
    }
}

class Node implements Comparable<Node> {
    int idx, cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }

}
