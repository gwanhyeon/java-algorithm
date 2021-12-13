package _2021.스터디.단체;

public class leetcode_BestTimeToBuyAndSellStock_kgh {
    public static void main(String[] args) {
        maxProfit(new int[]{7,1,5,3,6,4});
    }
    static int maxProfit(int[] prices){
        int minPrice = prices[0];
        int maxPrice = 0;
        for(int i=1; i<prices.length; i++){
            maxPrice = Math.max(maxPrice, Math.abs(prices[i]-minPrice));
            minPrice = Math.min(minPrice, prices[i]);
        }
        System.out.println(maxPrice);
        return maxPrice;
    }
}
