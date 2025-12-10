class Solution {
    public long findScore(int[] nums) {
        Comparator<int[]> c = (a, b) -> a[0] == b[0] ? 
            Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int i = 0; i < nums.length; i++) {
            int[] arr = new int[]{nums[i], i};
            pq.add(arr);
        }

        boolean[] isMarked = new boolean[nums.length];
        long res = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[0];
            int index = curr[1];

            if (isMarked[index]) {
                continue;
            }
            int[] indicesToMark = new int[]{index - 1, index, index + 1};
            for (int i : indicesToMark) {
                if (i >= 0 && i < nums.length) {
                    isMarked[i] = true;
                }
            }
            res += val;
        }

        return res;
    }
}