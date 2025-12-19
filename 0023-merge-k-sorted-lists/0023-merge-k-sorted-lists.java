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
        Comparator<int[]> c = (a, b) -> Integer.compare(a[0], b[0]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                int[] arr = new int[]{lists[i].val, i};
                pq.add(arr);
            }
        }

        if (pq.isEmpty()) {
            return null;
        }

        ListNode res = new ListNode();
        ListNode ptr = res;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[0];
            int index = curr[1];
            ptr.val = val;

            lists[index] = lists[index].next;
            if (lists[index] != null) {
                int[] arr = new int[]{lists[index].val, index};
                pq.add(arr);
            }

            if (!pq.isEmpty()) {
                ptr.next = new ListNode();
                ptr = ptr.next;
            } 
        }
        ptr = null;

        return res;
    }
}