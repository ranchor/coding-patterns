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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> output = new ArrayList<>();
        if (root == null || target == null)
            return output;

        Map<Integer, List<Integer>> lookup = new HashMap<>();
        preorder(root, lookup);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        if (!lookup.containsKey(target.val))
            return output;
        queue.offer(target.val);
        visited.add(target.val);
        int count = 0;
        // lookup = {3->{5, 1}, 5->{3, 6, 2}, 1->{3, 0, 8}, 6->{5}, 2->{5, 7, 4},
        // 7->{2}, 4->{2}, 0->{1}, 8->{1}}
        // queue = {1, 7, 4}
        // neighbours = {1}
        // visited = [5, 3, 6 ,2, 1, 7, 4]
        while (!queue.isEmpty() && count < k) {
            int levelSize = queue.size();
            for (int index = 0; index < levelSize; index++) {
                int key = queue.poll();
                List<Integer> neighbours = lookup.get(key);
                for (int neighbour : neighbours) {
                    if (visited.contains(neighbour))
                        continue;
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }
            }
            count++;
        }

        if (count != k) {
            return output;
        }

        while (!queue.isEmpty()) {
            output.add(queue.poll());
        }

        return output;
    }

    // curr = 6
    // currList = {5}
    // childList = {5}
    // lookup = {3->{5, 1}, 5->{3, 6, 2}, 1->{3, 0, 8}, 6->{5}, 2->{5, 7, 4},
    // 7->{2}, 4->{2}, 0->{1}, 8->{1}}
    void preorder(TreeNode curr, Map<Integer, List<Integer>> lookup) {
        if (curr == null)
            return;
        List<Integer> currList = lookup.getOrDefault(curr.val, new ArrayList<>());
        List<Integer> childList;
        if (curr.left != null) {
            childList = lookup.getOrDefault(curr.left.val, new ArrayList<>());
            childList.add(curr.val);
            currList.add(curr.left.val);
            lookup.put(curr.left.val, childList);
        }

        if (curr.right != null) {
            childList = lookup.getOrDefault(curr.right.val, new ArrayList<>());
            childList.add(curr.val);
            currList.add(curr.right.val);
            lookup.put(curr.right.val, childList);
        }

        lookup.put(curr.val, currList);
        preorder(curr.left, lookup);
        preorder(curr.right, lookup);

    }
}