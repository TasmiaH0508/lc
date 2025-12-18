class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> c = (a, b) -> Integer.compare(a[0], b[0]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int[] interval : intervals) {
            pq.add(interval);
        }

        List<int[]> merged = new LinkedList<>();
        int[] prev = pq.poll();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            if (prev[0] <= curr[0] && curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                merged.add(prev);
                prev = curr;
            }
        }
        merged.add(prev);

        int[][] res = new int[merged.size()][2];
        int i = 0;
        for (int[] interval : merged) {
            res[i] = interval;
            i++;
        }
        return res;
    }
}