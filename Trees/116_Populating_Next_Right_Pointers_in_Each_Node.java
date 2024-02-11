/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        // queue = [1, 2 ,3]
        // size = 1
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int index = 0; index < size; index++) {
                Node curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                curr.next = null;
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
            }
        }

        return root;

    }
}