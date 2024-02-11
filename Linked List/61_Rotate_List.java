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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0)
            return head;

        int length = 1;
        ListNode curr = head, prev = null, ptr1;
        while (curr.next != null) {
            length++;
            curr = curr.next;
        }

        if (k % length == 0)
            return head;

        int nodesToTravel = (length - k % length);
        // current the end node with head to make cycle
        curr.next = head;
        for (int index = 0; index < nodesToTravel; index++) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;

    }
}