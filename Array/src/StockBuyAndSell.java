import java.util.ArrayList;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int [] ar = {7,1,5,3,6,4};
//        System.out.println(maxProfit(ar));
        System.out.println(maxTotalProfit(ar));
//        int [] ar = {32,30,20,10,4,3,2};
//        ArrayList<ArrayList<Integer>> al= stockBuySell(ar,ar.length);
//        System.out.println(al);
    }
    // Maximum profit at buy once and sell once i.e which is the best time to buy and sell
    // Answer is similar to maxDifference
    public static int maxProfit(int [] prices){
        if(prices.length<2) return 0;
        int profit = prices[1] - prices[0];
        int buy = Math.min(prices[1], prices[0]);
        for (int i = 2; i < prices.length; i++) {
            if (prices[i]>buy) {
                if (profit < prices[i] - buy) {
                    profit = prices[i] - buy;
                }
            }
            else buy = prices[i];
        }
        return Math.max(profit, 0);
    }

    // Task is to get maximum profit by doing multiple buy and sells
    public static int maxTotalProfit(int [] prices){
        int profit = 0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]>prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }

    //When to buy and when to sell
    static ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
        // code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int ind =0;
        boolean buy = false;
        boolean sell = true;
        for (int i=1;i<A.length;i++){
            if(!buy && A[i]>A[i-1]){
                sell = false;
                al.add(new ArrayList<>());
                al.get(ind).add(i-1);
                buy = true;
            }
            if ( !sell && A[i]<A[i-1]){
                al.get(ind).add(i-1);
                ind++;
                sell = true;
                buy = false;
            }
        }
        if(!sell){
            al.get(ind).add(n-1);
        }
        return al;
    }
}
