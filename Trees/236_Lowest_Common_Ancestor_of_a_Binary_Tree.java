public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        return lca(root, p, q);
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

}
