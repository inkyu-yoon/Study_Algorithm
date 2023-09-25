package 바킹독.트리.노드사이의거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<int[]>> nodes;
    static boolean[] checked;
    static int N;
    static TreeNode head;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        nodes = new ArrayList<>();


        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }



        for (int i = 1; i < N; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            nodes.get(u).add(new int[]{v, c});
            nodes.get(v).add(new int[]{u, c});
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            head = new TreeNode(u, 0);
            checked = new boolean[N + 1];
            makeTree(head);
            getDistance(head,v,0);
            sb.append(result + "\n");
        }
        System.out.println(sb);

    }

    private static void getDistance(TreeNode node, int u,int distance) {
        if (node.value == u) {
            result = distance;
            return;
        }

        for (TreeNode child : node.children) {
            distance += child.cost;
            getDistance(child, u, distance);
            distance -= child.cost;
        }


    }

    private static void makeTree(TreeNode node) {
        int value = node.value;
        checked[value] = true;
        List<int[]> connects = nodes.get(value);
        for (int[] connect : connects) {
            if (!checked[connect[0]]) {
                TreeNode child = new TreeNode(connect[0], connect[1]);
                node.children.add(child);
                makeTree(child);
            }
        }
    }

}

class TreeNode {
    int value;
    int cost;
    List<TreeNode> children;

    public TreeNode(int value, int cost) {
        this.value = value;
        this.cost = cost;
        this.children = new ArrayList<>();
    }
}
