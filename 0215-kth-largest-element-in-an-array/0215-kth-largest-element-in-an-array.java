class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else {
                int currMin = pq.peek();
                if (num > currMin) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        return pq.poll();
    }
}