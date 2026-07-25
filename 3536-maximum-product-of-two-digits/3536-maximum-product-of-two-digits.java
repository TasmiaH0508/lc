class Solution {
    public int maxProduct(int n) {
        Queue<Integer> pq = new PriorityQueue<>(); 

        int i = n;
        while (i > 0) {
            int curr = i % 10;
            i /= 10;

            if (pq.size() < 2) {
                pq.add(curr);
            } else {
                int smallest = pq.peek();
                if (smallest < curr) {
                    pq.poll();
                    pq.add(curr);
                }
            }
        }

        int num1 = pq.poll();
        int num2 = pq.poll();
        int res = num1 * num2;
        return res;
    }
}