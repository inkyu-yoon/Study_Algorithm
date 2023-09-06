package LeetCode150.주차3_1.BinaryTreeRight;


import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    int maxLevel = -1;

    public List<Integer> rightSideView(TreeNode root) {
        order(root, 0);

        return list;
    }

    private void order(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level > maxLevel) {
            list.add(node.val);
            maxLevel = level;
        }

        order(node.right, level + 1);
        order(node.left, level + 1);

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