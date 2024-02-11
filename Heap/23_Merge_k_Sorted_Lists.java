/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> (Integer.compare(a.val, b.val)));

        for (int index = 0; index < lists.length; index++) {
            if (lists[index] != null) {
                minHeap.offer(lists[index]);
            }

        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (minHeap.size() > 0) {
            ListNode curr = minHeap.poll();

            ListNode next = curr.next;
            curr.next = null;

            if (next != null) {
                minHeap.offer(next);
            }

            prev.next = curr;
            prev = curr;
        }

        return dummy.next;
    }
}