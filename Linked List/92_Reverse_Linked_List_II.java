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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || right <= left)
            return head;

        ListNode leftMostNode = new ListNode(-1), rightMostNode = null, curr = head, next;
        int count = 0;
        leftMostNode.next = head;

        // head = [1,2,3,4,5], left = 2, right = 4
        // count=3
        // curr=4
        // leftMostNode=1
        // rightMostNode=5
        // prev=5
        // 2->3->4->5
        // 4->3->2->5
        // curr=2
        while (curr != null) {
            if (count < left - 1) {
                leftMostNode = curr;
            }
            if (count < right) {
                rightMostNode = curr.next;
            }

            count++;
            curr = curr.next;
        }
        ListNode ptr = reverseList(leftMostNode.next, rightMostNode);
        leftMostNode.next = ptr;

        return left == 1 ? leftMostNode.next : head;

    }

    ListNode reverseList(ListNode head, ListNode rightMostNode) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head, next, prev = rightMostNode;
        while (curr != rightMostNode) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}