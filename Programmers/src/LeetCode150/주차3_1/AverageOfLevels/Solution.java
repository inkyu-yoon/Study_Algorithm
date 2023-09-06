package LeetCode150.주차3_1.AverageOfLevels;

import java.util.*;

class Solution {
    List<Info> list = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        preOrder(root, 0);
        for (int i = 0; i < list.size(); i++) {
            Info info = list.get(i);
            ans.add(info.sum / info.cnt);
        }
        return ans;
    }

    private void preOrder(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (list.size() <= depth) {
            list.add(new Info(1, (double) node.val));
        } else {
            Info info = list.get(depth);
            info.cnt++;
            info.sum += node.val;
        }
        preOrder(node.right, depth + 1);
        preOrder(node.left, depth + 1);

    }

    static class Info{
        int cnt;
        double sum;

        public Info(int cnt, double sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
