class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Comparator<int[]> c = (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int[] interval : intervals) {
            pq.add(interval);
        }

        int[] curr = pq.poll();
        int count = 1;
        while (!pq.isEmpty()) {
            int[] later = pq.poll();

            boolean isSameStart = curr[0] == later[0];
            if (isSameStart) {
                if (curr[1] < later[1]) {
                    curr = later;
                }
            } else {
                if (curr[1] < later[1]) {
                    count++;
                    curr = later;
                }
            }
        }
        return count;
    }
}