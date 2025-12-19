/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode res = new ListNode(head.val);
        ListNode ptr = head.next;
        while (ptr != null) {
            res = new ListNode(ptr.val, res);
            ptr = ptr.next;
        }
        return res;
    }
}