class Solution {
    public long getDescentPeriods(int[] prices) {
        Stack<Integer> windowEnd = new Stack<>();
        for (int i = 1; i < prices.length; i++) {
            boolean isSmooth = (prices[i - 1] - prices[i] == 1);
            if (!isSmooth) {
                windowEnd.push(i - 1);
            }
        }

        int startIndex = prices.length - 1;
        long res = 0;
        while (startIndex >= 0) {
            int windowStart = 0;
            if (!windowEnd.empty()) {
                windowStart = windowEnd.pop() + 1;
            }

            long windowSize = startIndex - windowStart + 1;
            long numWindows = (windowSize * (windowSize + 1)) / 2;
            res += numWindows;

            startIndex = windowStart - 1;
        }
        return res;
    }
}