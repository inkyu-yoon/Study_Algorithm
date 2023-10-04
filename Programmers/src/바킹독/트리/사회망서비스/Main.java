package 바킹독.트리.사회망서비스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> connects;
    static int N;
    static boolean[] checked;
    static int[][] dp;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        checked = new boolean[N + 1];

        connects = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            connects.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            connects.get(u).add(v);
            connects.get(v).add(u);
        }

        TreeNode root = new TreeNode(1);
        makeTree(root);

        dp = new int[N + 1][2];
        dfs(root);
        System.out.println(Math.min(dp[1][0],dp[1][1]));

    }

    private static void dfs(TreeNode root) {
        dp[root.idx][1] = 1;

        for (TreeNode child : root.children) {
            dfs(child);
            dp[root.idx][0] += dp[child.idx][1];
            dp[root.idx][1] += Math.min(dp[child.idx][1], dp[child.idx][0]);
        }

    }


    private static void makeTree(TreeNode node) {
        int idx = node.idx;
        List<Integer> children = connects.get(idx);
        checked[idx] = true;
        for (int child : children) {
            if (!checked[child]) {
                TreeNode childNode = new TreeNode(child);
                node.children.add(childNode);
                checked[child] = true;
                makeTree(childNode);
            }
        }

    }

    static class TreeNode {
        int idx;
        List<TreeNode> children = new ArrayList<>();

        public TreeNode(int idx) {
            this.idx = idx;
        }
    }

}
