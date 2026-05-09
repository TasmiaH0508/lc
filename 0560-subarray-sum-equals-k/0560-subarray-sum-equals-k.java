class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pref = new int[nums.length + 1]; 
        for (int i = 1; i < pref.length; i++) {
            pref[i] = pref[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(pref[0], 1); 
        int count = 0;
        for (int i = 1; i < pref.length; i++) {
            int prefToLookFor = pref[i] - k;

            int f = freq.getOrDefault(prefToLookFor, 0);
            count += f;

            int currFreq = freq.getOrDefault(pref[i], 0) + 1;
            freq.put(pref[i], currFreq);
        }
        return count;
    }
}