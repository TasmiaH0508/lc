class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            distinct.add(num);
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i : distinct) {
            if (pq.size() < 3) {
                pq.add(i);
            } else {
                int currMin = pq.peek();
                if (currMin < i) {
                    pq.poll();
                    pq.add(i);
                }
            }
        }

        if (pq.size() == 3) {
            return pq.poll();
        }

        int res = 0;
        while (!pq.isEmpty()) {
            res = pq.poll();
        }
        return res;
    }
}