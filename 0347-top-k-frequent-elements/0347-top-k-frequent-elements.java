class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int f = 1;
            if (freqMap.containsKey(num)) {
                f += freqMap.get(num);
            }
            freqMap.put(num, f);
        }

        Comparator<int[]> c = (a, b) -> Integer.compare(a[1], b[1]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int key : freqMap.keySet()) {
            int f = freqMap.get(key);
            
            if (pq.size() < k) {
                int[] arr = new int[]{key, f};
                pq.add(arr);
            } else {
                int minF = pq.peek()[1];

                if (f > minF) {
                    pq.poll();
                    int[] arr = new int[]{key, f};
                    pq.add(arr);
                }
            }
        }
        
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            int num = pq.poll()[0];
            res[i] = num;
        }
        return res;
    }
}