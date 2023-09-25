package 바킹독.트리.트리순회2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int oneWay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeNode[] nodes = new TreeNode[N + 1];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int left = Integer.parseInt(input[1]);
            TreeNode leftNode = getNode(nodes, left);
            int right = Integer.parseInt(input[2]);
            TreeNode rightNode = getNode(nodes, right);

            TreeNode parentNode = getNode(nodes, parent);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
        }

        order(nodes[1]);
        System.out.println((N - 1) * 2 - (oneWay - 1));
    }

    private static void order(TreeNode node) {
        if (node == null) {
            return;
        }
        oneWay++;
        order(node.right);

    }

    private static TreeNode getNode(TreeNode[] nodes, int idx) {
        TreeNode node;

        if (idx == -1) {
            return null;
        }

        if (nodes[idx] == null) {
            node = new TreeNode(idx);
            nodes[idx] = node;
        } else {
            node = nodes[idx];
        }
        return node;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;


        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
