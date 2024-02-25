/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        postorderIterativeTraversal(root, output);
        return output;
    }


    void postorderIterativeTraversal(TreeNode root, List<Integer> output) {
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

        Collections.reverse(output);
    }

    void postorderRecursiveTraversal(TreeNode curr, List<Integer> output) {
        if(curr==null) return;
        postorderRecursiveTraversal(curr.left, output);
        postorderRecursiveTraversal(curr.right, output);
        output.add(curr.val);
    }
}