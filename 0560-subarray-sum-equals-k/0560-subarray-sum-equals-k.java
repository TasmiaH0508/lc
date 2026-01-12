class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pref = new int[nums.length + 1];
        pref[0] = 0;
        for (int i = 1; i < pref.length; i++) {
            pref[i] = pref[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        for (int i = 0; i < pref.length; i++) {
            // curr - needed = k -> curr - k = needed
            int needed = pref[i] - k;
            int f = freq.getOrDefault(needed, 0);
            count += f;

            int newF = freq.getOrDefault(pref[i], 0) + 1;
            freq.put(pref[i], newF);
        }
        return count;
    }
}