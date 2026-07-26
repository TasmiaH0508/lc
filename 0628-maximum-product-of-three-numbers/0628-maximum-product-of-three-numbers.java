class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int prod1 = nums[0] * nums[1] * nums[nums.length - 1];
        int prod2 = nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
        return Math.max(prod1, prod2);
    }
}