class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int f = freqMap.getOrDefault(num, 0);
            f++;
            freqMap.put(num, f);
        }

        Comparator<int[]> c = (a, b) -> Integer.compare(-a[0], -b[0]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            int[] arr = new int[]{freq, key};
            pq.add(arr);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] arr = pq.poll();
            res[i] = arr[1];
        }
        return res;
    }
}