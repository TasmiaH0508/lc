class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                pref[i] = pref[i - 1] * nums[i];
            } else {
                pref[i] = nums[i];
            }
        }
        int[] suff = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                suff[i] = nums[i];
            } else {
                suff[i] = nums[i] * suff[i + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int prefixPoint = i - 1;
            int suffixPoint = i + 1;
            int prefixProd = 1;
            int suffixProd = 1;
            if (prefixPoint >= 0) {
                prefixProd = pref[prefixPoint];
            }
            if (suffixPoint <= nums.length - 1) {
                suffixProd = suff[suffixPoint];
            }
            nums[i] = prefixProd * suffixProd;
        }
        return nums;
    }
}