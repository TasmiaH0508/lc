class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int[] windowSize = new int[nums.length];
        windowSize[nums.length - 1] = 0;
        if (nums[nums.length - 1] == 0) {
            windowSize[nums.length - 1] = 1;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                windowSize[i] = windowSize[i + 1] + 1;
            }
        }

        long numSubarrays = 0;
        for (int size : windowSize) {
            numSubarrays += size;
        }
        return numSubarrays;
    }
}