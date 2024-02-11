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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode ptr1 = reverseList(l1);
        ListNode ptr2 = reverseList(l2);
        int carry = 0, sum;
        ListNode head = null;

        // 3->4->2->7
        // 4->6->5
        // 7->8->0->7
        while (ptr1 != null || ptr2 != null) {
            // get the current values
            int x = ptr1 != null ? ptr1.val : 0;
            int y = ptr2 != null ? ptr2.val : 0;

            // current sum and carry
            sum = x + y + carry;
            carry = sum / 10;

            // update the result: ADD TO FRONT
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;

            // move to the next elements in the lists
            if (ptr1 != null)
                ptr1 = ptr1.next;

            if (ptr2 != null)
                ptr2 = ptr2.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }

        return head;

    }

    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head, prev = null, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
}