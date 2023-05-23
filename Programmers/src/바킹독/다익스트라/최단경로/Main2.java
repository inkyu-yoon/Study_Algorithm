package 바킹독.다익스트라.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main2 {
    int V;
    int E;
    int K;
    int[][] graph;
    final int MAX = 200001;

    public static void main(String[] args) throws IOException {
        new Main2().solution();
    }

    void solution() throws IOException {
        setUp();
        dijkstra();

    }

    void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] checked = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, MAX);
        dist[0] = 0;

        pq.offer(new int[]{dist[0], 0});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int u = info[1];
            if (checked[u]) {
                continue;
            }
            checked[u] = true;
            for (int v = 0; v < V; v++) {
                if (dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.offer(new int[]{dist[v], v});
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
        K = Integer.parseInt(br.readLine());
        graph = new int[V][V];
        for (int r = 0; r < V; r++) {
            for (int c = 0; c < V; c++) {
                if (r == c) {
                    graph[r][c] = 0;
                } else {
                    graph[r][c] = MAX;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int u = input[0] - 1, v = input[1] - 1;
            int w = input[2];

            graph[u][v] = Math.min(graph[u][v], w);
        }
    }
}
