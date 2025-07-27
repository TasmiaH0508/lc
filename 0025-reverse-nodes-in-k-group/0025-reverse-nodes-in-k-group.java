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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        Stack<Integer> stack = new Stack<>();
        while (ptr != null && stack.size() < k) {
            int val = ptr.val;
            stack.push(val);
            ptr = ptr.next;
        }

        if (stack.size() < k) {
            return head;
        }

        int val = stack.pop();
        ListNode res = new ListNode(val);
        ListNode resPtr = res;
        while (!stack.empty()) {
            int v = stack.pop();
            resPtr.next = new ListNode(v);
            resPtr = resPtr.next; 
        }
        resPtr.next = reverseKGroup(ptr, k);
        return res;
    }
}