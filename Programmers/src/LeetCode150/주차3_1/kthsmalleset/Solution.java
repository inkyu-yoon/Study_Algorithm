package LeetCode150.주차3_1.kthsmalleset;

class Solution {
    int ans = 0;
    int idx = 1;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrder(node.left, k);

        if (idx == k) {
            ans = node.val;
        }

        idx++;

        inOrder(node.right, k);
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
