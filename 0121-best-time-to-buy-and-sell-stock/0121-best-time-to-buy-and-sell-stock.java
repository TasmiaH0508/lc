class Solution {
    public int maxProfit(int[] prices) {
        int[] bestBuyingPrices = new int[prices.length];
        bestBuyingPrices[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            bestBuyingPrices[i] = Math.min(bestBuyingPrices[i - 1], prices[i]);
        }

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(prices[i] - bestBuyingPrices[i], max);
        }
        return max;
    }
}