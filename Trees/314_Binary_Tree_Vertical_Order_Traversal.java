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
            Pair p = queue.poll();
            TreeNode currNode = (TreeNode) p.getKey();
            column = (int) p.getValue();

            List<Integer> temp = columnTable.getOrDefault(column, new ArrayList<>());
            temp.add(currNode.val);
            columnTable.put(column, temp);

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