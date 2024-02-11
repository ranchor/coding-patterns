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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slowPtr = head, fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        ListNode ptr2, ptr1 = head;
        if (fastPtr != null) {
            // odd list
            ptr2 = reverseLL(slowPtr.next);
        } else {
            // even list
            ptr2 = reverseLL(slowPtr);
        }

        while (ptr1 != slowPtr && ptr2 != null) {
            if (ptr1.val != ptr2.val) {
                return false;
            } else {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }

        if (ptr1 == slowPtr && ptr2 == null) {
            return true;
        } else {
            return false;
        }

    }

    ListNode reverseLL(ListNode head) {
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