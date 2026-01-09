class Solution {
    public int maxProfit(int[] prices) {
        int[] bestBuyingPrice = new int[prices.length];
        bestBuyingPrice[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            bestBuyingPrice[i] = Math.min(prices[i], bestBuyingPrice[i - 1]);
        }

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - bestBuyingPrice[i];
            max = Math.max(max, profit);
        }
        return max;
    }
}