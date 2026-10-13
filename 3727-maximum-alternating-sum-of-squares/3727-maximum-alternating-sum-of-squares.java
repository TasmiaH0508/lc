class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        int toSub = nums.length / 2;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < toSub) {
                res -= nums[i];
            } else {
                res += nums[i];
            }
        }
        return res;
    }
}