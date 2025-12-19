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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        int val1 = list1.val;
        int val2 = list2.val;
        if (val1 <= val2) {
            return new ListNode(val1, mergeTwoLists(list1.next, list2));
        } else {
            return new ListNode(val2, mergeTwoLists(list1, list2.next));
        }
    }
}