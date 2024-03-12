package DSA.Java.Arrays;

import java.util.Arrays;

/*Given an Array of papers with their reference, find h where h papers are referenced at least h times */
public class HIndex {
    public static void main(String[] args) {
        HIndex hi = new HIndex();
        int[] input = new int[] { 1, 4, 1, 4, 2, 1, 3, 5, 6 };
        System.out.println("For given Input");
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
        long start, end;
        
        start = System.currentTimeMillis();
        int hIndex = hi.hIndex(input);
        end = System.currentTimeMillis();

        System.out.println("Then H-Index is " + hIndex);
        System.out.println("Code ran in " + (end - start) + " ms");
    }

    private int hIndex(int[] input) {//O(nlogn)
        Arrays.sort(input);//O(nlogn)
        int n = input.length;
        for (int i = 0; i < n; i++) {//O(n)
            if (input[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

}
