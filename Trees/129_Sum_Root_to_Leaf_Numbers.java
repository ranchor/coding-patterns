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
    int rootToLeaf = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbersUtil(root, 0);
        return rootToLeaf;
    }

    void sumNumbersUtil(TreeNode root, int currNumber) {
        if (root == null)
            return;
        currNumber = currNumber * 10 + root.val;

        if (root.left == null && root.right == null) {
            rootToLeaf += currNumber;
        } else {
            sumNumbersUtil(root.left, currNumber);
            sumNumbersUtil(root.right, currNumber);
        }
    }
}