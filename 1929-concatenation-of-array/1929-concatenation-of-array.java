class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < res.length; i++) {
            int index = i;
            if (index >= nums.length) {
                index -= nums.length;
            }
            res[i] = nums[index];
        }
        return res;
    }
}