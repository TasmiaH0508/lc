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

    Set<ListNode> visited = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (visited.contains(head)) {
            return true;
        }
        visited.add(head);
        return hasCycle(head.next);
    }
}