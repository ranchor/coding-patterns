/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> originalToCloneMap = new HashMap<>();
        originalToCloneMap.put(null, null);

        Node curr = head;

        while (curr != null) {
            originalToCloneMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // 7'->13'->11'->10'->1'
        // 1<-7->13
        // (7->7', 13->13')
        // 7'(rand)->null
        // 13'(rand)->7'
        curr = head;
        while (curr != null) {
            originalToCloneMap.get(curr).next = originalToCloneMap.get(curr.next);
            originalToCloneMap.get(curr).random = originalToCloneMap.get(curr.random);
            curr = curr.next;
        }

        return originalToCloneMap.get(head);
    }

    // https://leetcode.com/problems/copy-list-with-random-pointer/solutions/43491/a-solution-with-constant-space-complexity-o-1-and-linear-time-complexity-o-n/
    public Node copyRandomListWithConstantSpace(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val, next, null);
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node copyHead = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;
            cur.next = next;
            if (next != null)
                copy.next = next.next;
            cur = next;
        }
        return copyHead;

    }
}
