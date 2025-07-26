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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(0, l1, l2);
    }

    public ListNode addTwoNumbers(int c, ListNode l1, ListNode l2) {
        if (c == 0 && l1 == null && l2 == null) {
            return null;
        }

        int val1 = 0;
        ListNode l1Tail = null;
        if (l1 != null) {
            val1 = l1.val;
            l1Tail = l1.next;
        }
        int val2 = 0;
        ListNode l2Tail = null;
        if (l2 != null) {
            val2 = l2.val;
            l2Tail = l2.next;
        }

        int sum = c + val1 + val2;
        int carryOver = sum / 10;
        int stay = sum % 10;
        ListNode res = new ListNode(stay, addTwoNumbers(carryOver, l1Tail, l2Tail));
        return res;
    }
}