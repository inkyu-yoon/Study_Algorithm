package 바킹독.다익스트라.최소비용구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]), v = Integer.parseInt(input[1]), w = Integer.parseInt(input[2]);
            nodes.get(u).add(new Node(v, w));
        }

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]), end = Integer.parseInt(input[1]);

        int[] dist = new int[N + 1];
        int[] trace = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        dist[start] = 0;
        pq.offer(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.idx;
            int cost = node.cost;

            if (dist[end] < cost) {
                continue;
            }

            List<Node> connects = nodes.get(u);
            for (Node v : connects) {
                if (dist[v.idx] > v.cost + cost) {
                    dist[v.idx] = v.cost + cost;
                    trace[v.idx] = u;
                    pq.offer(new Node(v.idx, dist[v.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end] + "\n");

        Stack<Integer> path = new Stack<>();
        path.push(end);
        while (true) {
            int prev = trace[end];
            if (prev == start) {
                path.push(start);
                break;
            } else {
                path.push(prev);
                end = prev;
            }
        }
        sb.append(path.size() + "\n");
        while (!path.isEmpty()) {
            sb.append(path.pop() + " ");
        }
        System.out.println(sb);




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
