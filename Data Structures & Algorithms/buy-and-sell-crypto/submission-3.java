class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minBuy = prices[0];
        for (int sell : prices) {
            minBuy = Math.min(minBuy, sell);
            maxProfit = Math.max(maxProfit, sell - minBuy);
        }
        return maxProfit;
    }
}
