/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class CustomNode {

    Integer hd;
    Node ref;

    CustomNode(Integer hd, Node ref) {
        this.hd = hd;
        this.ref = ref;
    }

    Integer getKey() {
        return this.hd;
    }

    Node getValue() {
        return this.ref;
    }

}

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> output = new ArrayList<>();
        if (root == null)
            return output;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<CustomNode> queue = new LinkedList<>();

        queue.offer(new CustomNode(0, root));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int index = 0; index < levelSize; index++) {
                CustomNode p = queue.poll();
                int hd = p.getKey();
                Node curr = p.getValue();

                if (curr.left != null) {
                    queue.offer(new CustomNode(hd - 1, curr.left));
                }

                if (curr.right != null) {
                    queue.offer(new CustomNode(hd + 1, curr.right));
                }

                map.putIfAbsent(hd, curr.data);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            output.add(entry.getValue());
        }

        return output;

    }
}