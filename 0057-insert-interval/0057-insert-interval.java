class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Queue<int[]> ll = new LinkedList<>();
        boolean inserted = false;
        for (int[] interval : intervals) {
            boolean canInsert = !inserted && newInterval[0] <= interval[0];
            if (canInsert) {
                inserted = true;
                ll.add(newInterval);
            } 
            ll.add(interval);
        }

        if (!inserted) {
            ll.add(newInterval);
        }

        if (ll.isEmpty()) {
            return new int[][]{newInterval};
        }
        int[] prev = ll.poll();

        List<int[]> resList = new LinkedList<>();
        while (!ll.isEmpty()) {
            int[] curr = ll.poll();

            if (curr[0] >= prev[0] && curr[0] <= prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                resList.add(prev);
                prev = curr;
            }
        }
        resList.add(prev);

        int[][] res = new int[resList.size()][2];
        int i = 0;
        for (int[] l : resList) {
            res[i] = l;
            i++;
        }
        return res;
    }
}