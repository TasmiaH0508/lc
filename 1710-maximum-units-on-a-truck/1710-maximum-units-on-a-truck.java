class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Comparator<int[]> c = (a, b) -> Integer.compare(-a[1], -b[1]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int[] arr : boxTypes) {
            pq.add(arr);
        }

        int numBoxes = 0;
        int numUnits = 0;
        while (numBoxes < truckSize && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int numCurrBoxes = curr[0];
            int numCurrUnits = curr[1];

            int numBoxesThatCanBeAdded = Math.min(numCurrBoxes, truckSize - numBoxes);
            numUnits += (numBoxesThatCanBeAdded * numCurrUnits);
            numBoxes += numBoxesThatCanBeAdded;
        }
        return numUnits;
    }
}