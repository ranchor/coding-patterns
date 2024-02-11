/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> visited = new HashMap<>();

    // visitedNodes = {1->1', 2->2', 3->3', 4->4'}
    // 1->2,4 2->1,3 3->2,4 4->1,3
    // 1'->{2', 4''} 2'->{1', 3'} 3'->{2', 4'} 4'->{1', 3'}
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;

    }
}