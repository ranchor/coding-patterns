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

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        int sum, carry = 0;

        // 5->4->6
        // 5->6->4
        // 0->1->1->
        while (ptr1 != null || ptr2 != null || carry != 0) {

            int x = (ptr1 != null) ? ptr1.val : 0;
            int y = (ptr2 != null) ? ptr2.val : 0;

            sum = x + y + carry;
            carry = sum / 10;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;

            if (ptr1 != null)
                ptr1 = ptr1.next;

            if (ptr2 != null)
                ptr2 = ptr2.next;
        }

        return dummy.next;

    }
}