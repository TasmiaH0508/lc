class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> c = (a, b) -> Integer.compare(a[0], b[0]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int[] interval : intervals) {
            pq.add(interval);
        }

        int[] prev = pq.poll();
        List<int[]> ll = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            boolean canMerge = curr[0] <= prev[1];
            if (canMerge) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                ll.add(prev);
                prev = curr;
            }
        }
        ll.add(prev);

        int[][] res = new int[ll.size()][2];
        int i = 0;
        for (int[] interval : ll) {
            res[i] = interval;
            i++;
        }
        return res;
    }
}