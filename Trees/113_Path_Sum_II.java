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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;
        pathSumUtil(root, targetSum, new ArrayList<>(), output);
        return output;
    }

    // tempResult = [5]
    // output = [[5, 4, 11, 2]]
    void pathSumUtil(TreeNode root, int targetSum, List<Integer> tempResult, List<List<Integer>> output) {

        if (root == null)
            return;
        tempResult.add(root.val);

        if (root.left == null && root.right == null && targetSum == root.val) {
            output.add(new ArrayList<>(tempResult));
        } else {
            pathSumUtil(root.left, targetSum - root.val, tempResult, output);
            pathSumUtil(root.right, targetSum - root.val, tempResult, output);
        }
        tempResult.remove(tempResult.size() - 1);
    }
}