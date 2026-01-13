class Solution {
    public int[] sortedSquares(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < minVal) {
                minVal = Math.abs(nums[i]);
                minIndex = i;
            }
        }

        int[] res = new int[nums.length];
        int low = minIndex - 1;
        int high = minIndex + 1;
        res[0] = minVal;
        for (int i = 1; i < res.length; i++) {
            int lowVal = Integer.MAX_VALUE;
            if (low >= 0) {
                lowVal = Math.abs(nums[low]);
            }

            int highVal = Integer.MAX_VALUE;
            if (high < nums.length) {
                highVal = Math.abs(nums[high]);
            }

            if (lowVal < highVal) {
                res[i] = lowVal;
                low--;
            } else {
                res[i] = highVal;
                high++;
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] * res[i];
        }
        return res;
    }
}