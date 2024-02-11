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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        inorderIterativeTraversal(root, output);
        return output;
    }

    void inorderIterativeTraversal(TreeNode root, List<Integer> output) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        // stack = [2]
        // output = [1, 3, 2]
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
        }

    }

    void inorderRecursiveTraversal(TreeNode curr, List<Integer> output) {
        if (curr == null)
            return;
        inorderRecursiveTraversal(curr.left, output);
        output.add(curr.val);
        inorderRecursiveTraversal(curr.right, output);
    }
}