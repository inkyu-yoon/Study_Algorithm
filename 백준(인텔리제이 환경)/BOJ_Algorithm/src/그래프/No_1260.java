package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class No_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        int V = Integer.valueOf(input[2]);

        Graph g1 = new Graph(N);
        Graph g2 = new Graph(N);
        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            g1.addEdge(Integer.valueOf(input2[0]), Integer.valueOf(input2[1]));
            g2.addEdge(Integer.valueOf(input2[0]), Integer.valueOf(input2[1]));
        }
        g1.dfs(V);
        System.out.println();
        g2.bfs(V);

    }
    static class Graph {
        class Node {
            int data;
            boolean marked;
            LinkedList<Node> neighbor;

            public Node(int data) {
                this.data = data;
                this.marked = false;
                neighbor = new LinkedList<>();
            }
        }

        Node[] nodes;

        public Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i + 1);
            }
        }

        void addEdge(int i1, int i2) {
            Node n1 = nodes[i1 - 1];
            Node n2 = nodes[i2 - 1];
            if (!n1.neighbor.contains(n2)) {
                n1.neighbor.add(n2);
            }
            if (!n2.neighbor.contains(n1)) {
                n2.neighbor.add(n1);
            }
            Collections.sort(n1.neighbor,(a,b)->{
                return a.data-b.data;
            } );
            Collections.sort(n2.neighbor,(a,b)->{
                return a.data-b.data;
            } );
        }

        void dfs(int start) {
            Node n = nodes[start - 1];
            if (n == null) {
                return;
            }
            n.marked = true;
            System.out.print(n.data+" ");

            for (Node r : n.neighbor) {

                if (r.marked == false) {
                    dfs(r.data);
                }
            }
        }

        void bfs(int index) {
            Node root = nodes[index-1];
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            root.marked = true;

            //큐가 완전히 비게될 때 까지 수행
            while (!queue.isEmpty()) {
                Node r = queue.poll();
                for (Node n : r.neighbor) {
                    if (n.marked == false) {
                        n.marked = true;
                        queue.add(n);
                    }
                }
                System.out.print(r.data+" ");
            }
        }
    }


}

