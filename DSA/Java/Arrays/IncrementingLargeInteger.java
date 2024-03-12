package DSA.Java.Arrays;

import java.util.ArrayList;
import java.util.List;

public class IncrementingLargeInteger {

    public static void main(String[] args) {
        IncrementingLargeInteger ili = new IncrementingLargeInteger();
        long start, end;
        List<Integer> al = new ArrayList<>(List.of(1, 9, 9, 5, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9));

        System.out.println("input array " + al);
        start = System.currentTimeMillis();
        ili.incrementLargeInt(al);
        end = System.currentTimeMillis();
        System.out.println("output array " + al);
        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private void incrementLargeInt(List<Integer> al) {
        int n = al.size();
        int carry = 1;
        for (int i = n - 1; i >= 0 && carry != 0; i--) {
            carry += al.get(i);
            al.set(i, carry % 10);
            carry /= 10;
        }
        if (carry == 1) {
            al.add(0, carry);
        }
    }

}
