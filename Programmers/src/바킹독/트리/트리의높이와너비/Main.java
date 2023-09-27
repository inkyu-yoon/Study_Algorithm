package 바킹독.트리.트리의높이와너비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static TreeNode[] nodes;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        parents[0] = -1;

        nodes = new TreeNode[N + 1];
        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new TreeNode(i);
        }

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int left = Integer.parseInt(input[1]);
            int right = Integer.parseInt(input[2]);
            TreeNode parentNode = nodes[parent];
            if (left != -1) {
                parentNode.left = nodes[left];
                parents[left] = parent;
            }
            if (right != -1) {
                parentNode.right = nodes[right];
                parents[right] = parent;
            }
        }

        int rootNode = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[i] == 0) {
                rootNode = i;
            }
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(nodes[rootNode]);
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            if (poll.left != null) {
                poll.left.depth = poll.depth + 1;
                q.offer(poll.left);
            }
            if (poll.right != null) {
                poll.right.depth = poll.depth + 1;
                q.offer(poll.right);
            }
        }


        for (int i = 1; i <= N; i++) {
            TreeNode parent = nodes[i];
            parent.cntOfTotalLeftChild = getCntOfNodes(parent.left);
            parent.cntOfTotalRightChild = getCntOfNodes(parent.right);
        }

        nodes[rootNode].position = nodes[rootNode].cntOfTotalLeftChild + 1;

        q.offer(nodes[rootNode]);
        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            if (parent.left != null) {
                parent.left.position = parent.position - parent.left.cntOfTotalRightChild - 1;
                q.offer(parent.left);
            }
            if (parent.right != null) {
                parent.right.position = parent.position + parent.right.cntOfTotalLeftChild + 1;
                q.offer(parent.right);
            }
        }

        Map<Integer, Integer> maxValue = new HashMap<>();
        Map<Integer, Integer> minValue = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            TreeNode node = nodes[i];
            int depth = node.depth;
            int position = node.position;
            maxValue.put(depth, Math.max(maxValue.getOrDefault(depth, 0), position));
            minValue.put(depth, Math.min(minValue.getOrDefault(depth, Integer.MAX_VALUE), position));
        }
        int ansIdx = 0;
        int ansWidth = 0;

        for (int i = 1; i <= maxValue.size(); i++) {
            int width = maxValue.get(i) - minValue.get(i) + 1;
            if (width > ansWidth) {
                ansIdx = i;
                ansWidth = width;
            }
        }
        System.out.println(ansIdx + " " + ansWidth);


    }

    private static int getCntOfNodes(TreeNode left) {
        int cnt = 0;
        if (left == null) {
            return cnt;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(left);
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            cnt++;
            if (poll.left != null) {
                q.offer(poll.left);
            }
            if (poll.right != null) {
                q.offer(poll.right);
            }
        }
        return cnt;


    }


    static class TreeNode {
        int idx;
        TreeNode left;
        TreeNode right;
        int cntOfTotalLeftChild = 0;
        int cntOfTotalRightChild = 0;
        int depth = 1;
        int position = 0;

        public TreeNode(int idx) {
            this.idx = idx;
        }
    }
}


/*
3
3 2 -1
2 1 -1
1 -1 -1
 */