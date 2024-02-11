/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        preorderIterativeTraversal(root, output);
        return output;
    }

    void preorderIterativeTraversal(TreeNode root, List<Integer> output) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {

            while (curr != null) {
                output.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }

    void preorderRecursiveTraversal(TreeNode curr, List<Integer> output) {
        if (curr == null)
            return;
        output.add(curr.val);
        preorderRecursiveTraversal(curr.left, output);
        preorderRecursiveTraversal(curr.right, output);
    }
}