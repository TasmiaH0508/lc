class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] left = new int[nums.length];
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        int[] right = new int[nums.length];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.abs(left[i] - right[i]);
        }
        return res;
    }
}