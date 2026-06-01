class Solution {
    public int minimumCost(int[] cost) {
        Comparator<Integer> c = (a, b) -> Integer.compare(-a, -b);
        Queue<Integer> pq = new PriorityQueue<>(c);
        for (int i : cost) {
            pq.add(i);
        }

        int totalCost = 0;
        while (pq.size() >= 3) {
            int top1 = pq.poll();
            int top2 = pq.poll();

            pq.poll();
            totalCost += (top1 + top2);
        }
        
        while (!pq.isEmpty()) {
            totalCost += pq.poll();
        }
        
        return totalCost;
    }
}