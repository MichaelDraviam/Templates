package DSA.Java.Arrays;

import java.util.ArrayList;
import java.util.List;

public class BuyStockI {

    public static void main(String[] args) {
        BuyStockI bs = new BuyStockI();

        List<Integer> input = new ArrayList<>(List.of(12, 11, 13, 9, 12, 8, 14, 13, 15));
        System.out.println("For given Input");
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
        int max;
        long start, end;

        start = System.currentTimeMillis();
        max = bs.makeProfitTwice(input);
        end = System.currentTimeMillis();

        System.out.println("Max Profit " + max);
        System.out.println("Code ran in " + (end - start) + " ms");
    }

    @SuppressWarnings("unused")
    private int makeProfitOne(List<Integer> prices) {
        int buy = Integer.MAX_VALUE, profit = Integer.MIN_VALUE;
        for (int price : prices) {
            buy = Math.min(price, buy);
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }

    private int makeProfitTwice(List<Integer> prices) {
        int buy1 = Integer.MAX_VALUE, profit1 = Integer.MIN_VALUE,
                buy2 = Integer.MAX_VALUE, profit2 = Integer.MIN_VALUE;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }
        return profit2;
    }

}
