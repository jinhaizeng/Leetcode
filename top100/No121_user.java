class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int result[] = new int[length];
        result[0] = 0;
        int min = prices[0];
        for (int i=1; i < length; ++i) {
            min = min > prices[i - 1] ? prices[i -1] : min;
            result[i] = Math.max(result[i - 1], prices[i] - min);
        }
        return result[length - 1];
    }
}