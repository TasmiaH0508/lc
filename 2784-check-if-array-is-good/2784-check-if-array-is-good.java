class Solution {
    public boolean isGood(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        int n = nums.length - 1;

        int[] freq = new int[n]; // use 1 indexing so that freq[0] is the freq when nums = 1
        for (int i : nums) {
            if (i > n) {
                return false; // becomes invalid
            }

            freq[i - 1]++;
        }

        boolean isAppearOnce = true;
        for (int i = 0; i < freq.length - 1; i++) {
            if (freq[i] != 1) {
                isAppearOnce = false;
            }
        }

        boolean isNAppearTwice = freq[n - 1] == 2;
        return isAppearOnce && isNAppearTwice;
    }
}