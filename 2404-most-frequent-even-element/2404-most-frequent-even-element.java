class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freqEven = new HashMap<>();

        for (int a : nums) {
            if (a % 2 == 0) {
                int f = freqEven.getOrDefault(a, 0) + 1;
                freqEven.put(a, f);
            }
        }

        int maxFreq = 0;
        int res = -1;
        for (int key : freqEven.keySet()) {
            int freq = freqEven.get(key);
            if (freq == maxFreq) {
                res = Math.min(res, key);
            } else if (freq > maxFreq) {
                maxFreq = freq;
                res = key;
            }
        }

        return res;
    }
}