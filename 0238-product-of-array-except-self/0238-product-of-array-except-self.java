class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        pref[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] * nums[i];
        }

        int[] suff = new int[nums.length];
        suff[suff.length - 1] = nums[nums.length - 1];
        for (int i = suff.length - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            int left = i - 1;
            int prod = 1;
            if (left >= 0) {
                prod *= pref[left];
            }

            int right = i + 1;
            if (right < nums.length) {
                prod *= suff[right];
            }
            
            res[i] = prod;
        }
        return res;
    }
}