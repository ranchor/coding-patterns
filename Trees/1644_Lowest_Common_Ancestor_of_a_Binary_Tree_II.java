/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        TreeNode ans;

        ans = lca(root, p, q);
        if (ans == p && !dfs(p, q) || ans == q && !dfs(q, p)) {
            return null;
        }

        return ans;
    }

    TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q)
            return node;

        TreeNode left = lca(node.left, p, q);
        TreeNode right = lca(node.right, p, q);
        if (left != null && right != null)
            return node;
        else if (left != null)
            return left;
        else if (right != null)
            return right;
        else
            return null;
    }

    boolean dfs(TreeNode node, TreeNode target) {
        if (node == null)
            return false;
        else if (node == target)
            return true;
        return dfs(node.left, target) || dfs(node.right, target);
    }
}