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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        TreeMap<Integer, List<Integer>> columnTable = new TreeMap<>();
        queue.add(new Pair(root, 0));
        int column;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode currNode = p.getKey();
            column = p.getValue();

            List<Integer> temp = columnTable.computeIfAbsent(column, k -> new ArrayList<>());
            temp.add(currNode.val);

            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, column - 1));
            }

            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, column + 1));
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : columnTable.entrySet()) {
            output.add(entry.getValue());
        }

        return output;

    }
}