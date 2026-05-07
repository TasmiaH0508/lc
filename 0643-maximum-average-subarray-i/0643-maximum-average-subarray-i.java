class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0;
        for (int i = 0; i < k; i++) {
            maxAvg += nums[i];
        }
        maxAvg /= k;

        double currAvg = maxAvg;
        for (int i = k; i < nums.length; i++) {
            double currSum = currAvg * k - nums[i - k];

            currAvg = (currSum + nums[i]) / k;
            maxAvg = Math.max(maxAvg, currAvg);
        }
        
        return maxAvg;
    }
}