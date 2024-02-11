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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode oddTailPtr = head, evenTailPtr = head.next, evenHead = evenTailPtr, evenNext;

        // 1->2->3->4-5
        // oddTailPtr = 3
        // evenTailPtr = 4
        // curr = 5
        // next =
        // 1->3->2->4->5
        // 1->3->5->2->4
        while (evenTailPtr != null && evenTailPtr.next != null) {
            evenNext = evenTailPtr.next.next;

            oddTailPtr.next = evenTailPtr.next;
            evenTailPtr.next = evenNext;

            oddTailPtr = oddTailPtr.next;
            evenTailPtr = evenTailPtr.next;

        }

        oddTailPtr.next = evenHead;

        return head;
    }
}