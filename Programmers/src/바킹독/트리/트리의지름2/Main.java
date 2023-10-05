package 바킹독.트리.트리의지름2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Node[] nodes;
    static boolean[] checked;
    static int ans = 0;
    static int maxIdx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        checked = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            Node U = new Node(u);
            for (int j = 1; j < input.length - 1; j += 2) {
                int v = Integer.parseInt(input[j]);
                int cost = Integer.parseInt(input[j + 1]);
                Node V = new Node(v, cost);
                U.children.add(V);
            }
            nodes[u] = U;
        }
        dfs(1);
        dfs(maxIdx);

        System.out.println(ans);


    }

    private static void dfs(int start) {
        Node root = nodes[start];
        checked[root.idx] = true;
        dfs(root, 0);
        checked[root.idx] = false;
    }

    private static void dfs(Node root, int sum) {
        if (ans < sum) {
            ans = sum;
            maxIdx = root.idx;
        }
        for (Node child : root.children) {
            if (!checked[child.idx]) {
                sum += child.cost;
                checked[child.idx] = true;
                dfs(nodes[child.idx], sum);
                sum -= child.cost;
                checked[child.idx] = false;
            }
        }

    }

    static class Node {
        int idx;
        int cost;
        List<Node> children = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
