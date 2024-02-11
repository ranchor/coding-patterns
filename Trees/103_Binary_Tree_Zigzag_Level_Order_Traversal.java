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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean isOrderLeftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> tempResult = new ArrayList<>();
            for (int index = 0; index < levelSize; index++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                if (isOrderLeftToRight) {
                    tempResult.add(curr.val);
                } else {
                    tempResult.add(0, curr.val);
                }

            }
            isOrderLeftToRight = !isOrderLeftToRight;

            output.add(tempResult);
        }

        return output;

    }
}