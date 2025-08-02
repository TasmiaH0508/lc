class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> c = (a, b) -> Integer.compare(-a[2], -b[2]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            int[] arr = new int[]{point[0], point[1], dist};
            if (pq.size() < k) {
                pq.add(arr);
            } else {
                int[] currMax = pq.peek();
                int maxDistance = currMax[2];
                if (dist < maxDistance) {
                    pq.poll();
                    pq.add(arr);
                }
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int[] coordinate = new int[]{arr[0], arr[1]};
            res[i] = coordinate;
            i++;
        }
        return res;
    }
}