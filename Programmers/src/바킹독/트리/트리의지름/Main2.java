package 바킹독.트리.트리의지름;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    static int sum = 0;
    static int ans = 0;
    static int maxIdx = 0;
    static boolean[] checked;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        checked = new boolean[N + 1];
        nodes = new Node[N + 1];

        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            Node U = new Node(u, cost);
            Node V = new Node(v, cost);

            nodes[u].connects.add(V);
            nodes[v].connects.add(U);

        }

        dfs(1);
        dfs(maxIdx);

        System.out.println(ans);

    }

    private static void dfs(int i) {
        Node root = nodes[i];
        checked[root.idx] = true;
        dfs(root);
        checked[root.idx] = false;
    }

    private static void dfs(Node node) {
        if (ans < sum) {
            ans = sum;
            maxIdx = node.idx;
        }

        for (Node connect : node.connects) {
            if (!checked[connect.idx]) {
                sum += connect.cost;
                checked[connect.idx] = true;
                dfs(nodes[connect.idx]);
                sum -= connect.cost;
                checked[connect.idx] = false;
            }
        }

    }


    static class Node {
        int idx;
        List<Node> connects = new ArrayList<>();
        int cost;

        public Node(int idx) {
            this.idx = idx;
        }

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
