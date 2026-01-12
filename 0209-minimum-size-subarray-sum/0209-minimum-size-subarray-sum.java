class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] pref = new int[nums.length + 1];
        pref[0] = 0;
        for (int i = 1; i < pref.length; i++) {
            pref[i] = pref[i - 1] + nums[i - 1];
        }


        // check if target can be made
        // if so, we have found the smallest len
        // if the sum exceeds, this will also be the smallest possible len
        // else, dont change low

        int low = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] - pref[low] < target) {
                continue;
            }

            while (pref[i] - pref[low] >= target) {
                low++;
            }
            low--;
            int len = i - low;
            minLen = Math.min(minLen, len);
        }

        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        return minLen;
    }
}