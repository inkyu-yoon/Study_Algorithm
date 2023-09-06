package LeetCode150.주차3_1.AverageOfLevels;

import java.util.*;

class Solution2 {
    Queue<Info> q = new LinkedList<>();
    List<Double> ans = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {

        if (root != null) {
            q.offer(new Info(root, 0));
        }

        int prevDepth = 0;
        double sum = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            Info info = q.poll();
            TreeNode node = info.node;
            int depth = info.depth;

            if (depth == prevDepth) {
                sum += node.val;
                cnt++;
            } else {
                ans.add(sum / cnt);
                prevDepth = depth;
                sum = node.val;
                cnt = 1;
            }
            if (node.left != null) {
                q.offer(new Info(node.left, depth + 1));
            }
            if (node.right != null) {
                q.offer(new Info(node.right, depth + 1));
            }
        }

        ans.add(sum / cnt);


        return ans;
    }

    static class Info {
        TreeNode node;
        int depth;

        public Info(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
