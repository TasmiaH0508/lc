class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            int f = freq.getOrDefault(n, 0) + 1;
            freq.put(n, f);
        }

        Comparator<int[]> c = (a, b) -> Integer.compare(a[1], b[1]);
        Queue<int[]> pq = new PriorityQueue<>(c);
        for (int key : freq.keySet()) {
            int f = freq.get(key);
            int[] arr = new int[]{key, f};

            if (pq.size() < k) {
                pq.add(arr);
            } else {
                int minF = pq.peek()[1];

                if (f > minF) {
                    pq.poll();
                    pq.add(arr);
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            int val = pq.poll()[0];
            res[i] = val;
        }
        return res;
    }
}