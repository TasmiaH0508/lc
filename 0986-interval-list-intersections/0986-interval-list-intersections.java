class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> res = new LinkedList<>();

        while (i < firstList.length && j < secondList.length) {
            int[] i1 = firstList[i];
            int[] i2 = secondList[j];

            boolean isOverlap = (i1[1] <= i2[1] && i1[1] >= i2[0]) || 
                                    (i2[1] <= i1[1] && i2[1] >= i1[0]);
            if (isOverlap) {
                int[] overlap = new int[2];
                overlap[0] = Math.max(i1[0], i2[0]);
                overlap[1] = Math.min(i1[1], i2[1]);
                res.add(overlap);
            } 

            if (i1[1] == i2[1]) {
                i++;
                j++;
            } else if (i1[1] < i2[1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] arr = new int[res.size()][2];
        int k = 0;
        for (int[] r : res) {
            arr[k] = r;
            k++;
        }
        return arr;
    }
}