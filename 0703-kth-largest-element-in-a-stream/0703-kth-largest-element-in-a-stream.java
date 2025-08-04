class KthLargest {

    Queue<Integer> pq = new PriorityQueue<>(); 
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else {
                int min = pq.peek();
                if (num > min) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else {
            int min = pq.peek();
            if (val > min) {
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */