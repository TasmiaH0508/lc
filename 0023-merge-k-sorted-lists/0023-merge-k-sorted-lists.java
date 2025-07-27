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
    public ListNode mergeKLists(ListNode[] lists) {
        int minVal = Integer.MAX_VALUE;
        int indexOfList = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                int val = lists[i].val;
                if (val < minVal) {
                    minVal = val;
                    indexOfList = i;
                }
            }
        }

        if (indexOfList == -1) {
            return null;
        }

        lists[indexOfList] = lists[indexOfList].next;
        ListNode res = new ListNode(minVal, mergeKLists(lists));
        return res;
    }
}