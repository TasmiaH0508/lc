class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        boolean isIncreasing = nums[0] < nums[1];
        boolean isDecreasing = nums[0] > nums[1];
        int maxLen = 1;
        int start = 1;
        if (isIncreasing || isDecreasing) {
            maxLen = 2;
            start = 0;
        }

        for (int i = 1; i < nums.length; i++) {
            boolean currIsIncreasing = nums[i - 1] < nums[i];
            boolean currIsDecreasing = nums[i - 1] > nums[i];

            boolean isSameDirection = (isIncreasing && currIsIncreasing) || (isDecreasing && currIsDecreasing);
            if (!isSameDirection) {
                boolean isSameAsPrev = !currIsIncreasing && !currIsDecreasing;
                if (isSameAsPrev) {
                    start = i;
                } else {
                    start = i - 1;
                }
            }
            int currLen = i - start + 1;
            maxLen = Math.max(maxLen, currLen);
            isIncreasing = currIsIncreasing;
            isDecreasing = currIsDecreasing;
        }
        return maxLen;
    }
}