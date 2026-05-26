class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int a : arr) {
            int f = freqMap.getOrDefault(a, 0) + 1;
            freqMap.put(a, f);
        }

        if (k == 0) {
            return freqMap.size();
        }

        // maintain max heap of size k
        Comparator<Integer> c = (a, b) -> Integer.compare(-a, -b);
        Queue<Integer> pq = new PriorityQueue<>(c);
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);

            if (pq.size() < k) {
                pq.add(freq);
            } else {
                int maxFreq = pq.peek();

                if (freq < maxFreq) {
                    pq.poll();
                    pq.add(freq);
                }
            }
        }

        Queue<Integer> minPq = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            minPq.add(curr);
        } 

        int uniqueElemsRemovedFully = 0;
        int totalElemsRemoved = 0;
        while (totalElemsRemoved < k && !minPq.isEmpty()) {
            int additionalElemsToRemove = k - totalElemsRemoved;

            int currF = minPq.poll();
            if (currF <= additionalElemsToRemove) {
                uniqueElemsRemovedFully++;
                totalElemsRemoved += currF;
            } else {
                totalElemsRemoved += additionalElemsToRemove;
            }
        }

        int remUniqueElems = freqMap.size() - uniqueElemsRemovedFully;
        return remUniqueElems;
    }
}