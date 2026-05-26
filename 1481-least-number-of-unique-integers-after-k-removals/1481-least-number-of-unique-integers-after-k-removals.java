class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : arr) {
            int f = freq.getOrDefault(a, 0) + 1;
            freq.put(a, f);
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for (int key : freq.keySet()) {
            int f = freq.get(key);
            pq.add(f);
        }

        int elemsRemoved = 0;
        while (elemsRemoved < k && !pq.isEmpty()) {
            int currF = pq.poll();

            int numElemsNeeded = k - elemsRemoved;
            if (currF <= numElemsNeeded) {
                elemsRemoved += currF;
            } else {
                elemsRemoved += numElemsNeeded;
                currF -= numElemsNeeded;
                pq.add(currF);
            }
        }
        return pq.size();
    }
}