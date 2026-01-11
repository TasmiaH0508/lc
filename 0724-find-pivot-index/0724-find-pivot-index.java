class Solution {
    public int pivotIndex(int[] nums) {
        int[] pref = new int[nums.length];
        pref[0] = nums[0];
        for (int i = 1; i < pref.length; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }

        for (int i = 0; i < pref.length; i++) {
            int leftSum = 0;
            int left = i - 1;
            if (left >= 0) {
                leftSum = pref[left];
            }

            int rightSum = 0;
            int right = i + 1;
            if (right < pref.length) {
                rightSum = pref[pref.length - 1] - pref[i];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}