/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode ptr = head;
        while (ptr != null) {
            if (seen.contains(ptr)) {
                return true;
            }
            seen.add(ptr);
            ptr = ptr.next;
        }
        return false;
    }
}