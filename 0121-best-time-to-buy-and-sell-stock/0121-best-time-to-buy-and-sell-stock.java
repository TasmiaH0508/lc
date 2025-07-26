class Solution {
    public int maxProfit(int[] prices) {
        int[] minBuyingPrice = new int[prices.length];
        minBuyingPrice[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minBuyingPrice[i] = Math.min(minBuyingPrice[i - 1], prices[i]);
        }

        int[] profit = new int[prices.length];
        for (int i = 0; i < profit.length; i++) {
            profit[i] = prices[i] - minBuyingPrice[i];
        }

        int maxProfit = 0;
        for (int i = 0; i < profit.length; i++) {
            maxProfit = Math.max(profit[i], maxProfit);
        }
        return maxProfit;
    }
}