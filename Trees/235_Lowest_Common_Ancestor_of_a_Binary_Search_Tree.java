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
        return lca(root, p, q);
    }

    TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node.val == p.val || node.val == q.val) {
            return node;
        } else if ((node.val > p.val && node.val < q.val) || (node.val < p.val && node.val > q.val)) {
            return node;
        } else if (node.val > p.val && node.val > q.val) {
            return lca(node.left, p, q);
        } else if (node.val < p.val && node.val < q.val) {
            return lca(node.right, p, q);
        }

        return null;
    }
}