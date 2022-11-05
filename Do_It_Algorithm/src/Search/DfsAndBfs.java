package Search;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DfsAndBfs {
    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.bfs(1);
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

            Collections.sort(n1.neighbor, (a, b) -> {
                return a.data - b.data;
            });
            Collections.sort(n2.neighbor, (a, b) -> {
                return a.data - b.data;
            });
        }

        void dfs(int start) {
            Node root = nodes[start - 1];
            root.marked = true;
            System.out.print(root.data + " ");

            for (Node node : root.neighbor) {
                if (node.marked == false) {
                    dfs(node.data);
                }
            }
        }

        void bfs(int start) {
            Node root = nodes[start - 1];
            root.marked = true;
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node r = q.poll();
                for (Node node : r.neighbor) {
                    if (node.marked == false) {
                        node.marked = true;
                        q.add(node);

                    }
                }
                System.out.print(r.data + " ");
            }
        }
    }


}