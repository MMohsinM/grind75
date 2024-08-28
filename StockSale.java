class Profit {
    int minIndex;
    int maxIndex;
    int minPrice = 10_000;
    int maxPrice;
    int maxProfit;
    int profit;
}

public class StockSale {

    public static int maxProfitBruteForce(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int currentProfit = prices[j] - prices[i];
                if (currentProfit > profit) {
                    profit = currentProfit;
                }
            }
        }
        return profit;
    }

    public static int maxProfit(int[] prices) {
        int minPrice = 10_000;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }

            if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        if (maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }) != 5) {
            throw new RuntimeException("1");
        }
        if (maxProfit(new int[] { 7, 6, 4, 3, 1 }) != 0) {
            throw new RuntimeException("2");
        }
        if (maxProfit(new int[] { 2, 4, 1 }) != 2) {
            throw new RuntimeException("3");
        }

        if (maxProfit(new int[] { 2, 1, 2, 1, 0, 1, 2 }) != 2) {
            throw new RuntimeException("4");
        }

        if (maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }) != 4) {
            throw new RuntimeException("5");
        }
    }
}