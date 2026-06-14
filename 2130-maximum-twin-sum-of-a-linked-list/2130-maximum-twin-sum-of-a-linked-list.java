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
    public int pairSum(ListNode head) {
        Deque<Integer> vals = new ArrayDeque<>();
        ListNode ptr = head;
        while (ptr != null) {
            int currVal = ptr.val;
            vals.add(currVal);

            ptr = ptr.next;
        }

        int maxSum = Integer.MIN_VALUE;
        while (!vals.isEmpty()) {
            int front = vals.pollFirst();
            int back = vals.pollLast();

            int sum = front + back;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}