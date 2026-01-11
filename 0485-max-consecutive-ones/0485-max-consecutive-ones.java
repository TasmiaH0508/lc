class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] maxLen = new int[nums.length];
        maxLen[0] = nums[0] == 0 ? 0 : 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxLen[i] = 0;
            } else {
                maxLen[i] = maxLen[i - 1] + 1;
            }
        }

        int max = 0;
        for (int m : maxLen) {
            max = Math.max(max, m);
        }
        return max;
    }
}