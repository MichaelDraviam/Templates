package DSA.Java.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiplyingLargeNumber {

    public static void main(String[] args) {
        MultiplyingLargeNumber mln = new MultiplyingLargeNumber();
        long start, end;
        List<Integer> b = new ArrayList<>(List.of(1, 1, 0, 2, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9));
        List<Integer> a = new ArrayList<>(List.of(-1, 8, 3, 2, 9, 0, 9, 0, 0, 1, 1));
        List<Integer> a2 = new ArrayList<>(List.of(1, 1, 0, 2, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9));
        List<Integer> b2 = new ArrayList<>(List.of(-1, 8, 3, 2, 9, 0, 9, 0, 0, 1, 1));
        List<Integer> ans;
        List<Integer> ans2;
        System.out.println("input array a " + a);
        System.out.println("input array b " + b);
        start = System.currentTimeMillis();
        ans = mln.multiply(a, b);
        ans2 = mln.fasterMultiply(a2, b2);
        end = System.currentTimeMillis();
        System.out.println("Multiply array ");
        mln.print(ans);
        System.out.println("Faster Multiply array ");
        mln.print(ans2);
        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private List<Integer> multiply(List<Integer> a, List<Integer> b) {
        int sign = 1;
        List<Integer> ans = new ArrayList<>();
        if (a.get(0) < 0 ^ b.get(0) < 0) {
            sign = -1;
        } else if (a.get(0) == 0 || b.get(0) == 0) {
            return List.of(0);
        }
        a.set(0, Math.abs(a.get(0)));
        b.set(0, Math.abs(b.get(0)));
        for (int i = b.size() - 1; i >= 0; i--) {
            if (b.get(i) == 0) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(a);
            int p = b.size() - i;
            while (p > 1) {
                tmp.add(0);
                p--;
            }
            multiply(tmp, b.get(i));
            add(ans, tmp);
        }
        ans.set(0, sign * ans.get(0));
        return ans;
    }

    private void print(List<Integer> a) {
        for (int i = a.size() - 1; i >= 0; i--) {
            System.out.print(a.get(i) + ",");
        }
        System.out.println();
    }

    private void add(List<Integer> a, List<Integer> b) {
        int carry = 0;
        int n = a.size(), m = b.size();

        int size = Math.min(n, m);
        for (int i = 0; i < size; i++) {
            carry += a.get(n - i - 1) + b.get(m - i - 1);
            a.set(n - i - 1, carry % 10);
            carry /= 10;
        }
        while (size < n && carry != 0) {
            carry += a.get(n - size - 1);
            a.set(n - size - 1, carry % 10);
            carry /= 10;
            size++;
        }
        while (size < m) {
            carry += b.get(m - size - 1);
            a.add(0, carry % 10);
            carry /= 10;
            size++;
        }
        while (carry != 0) {
            a.add(0, carry % 10);
            carry /= 10;
        }

    }

    private void multiply(List<Integer> al, int x) {
        int n = al.size();
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            carry += al.get(i) * x;
            al.set(i, carry % 10);
            carry /= 10;
        }
        while (carry != 0) {
            al.add(0, carry % 10);
            carry /= 10;
        }
    }

    private List<Integer> fasterMultiply(List<Integer> a, List<Integer> b) {// O(nm)
        int sign = a.get(0) < 0 ^ b.get(0) < 0 ? -1 : 1;
        a.set(0, Math.abs(a.get(0)));
        b.set(0, Math.abs(b.get(0)));
        List<Integer> ans = new ArrayList<>(Collections.nCopies(a.size() + b.size(), 0));

        for (int i = a.size() - 1; i >= 0; i--) {
            for (int j = b.size() - 1; j >= 0; j--) {
                ans.set(i + j + 1, ans.get(i + j + 1) + a.get(i) * b.get(j));
                ans.set(i + j, ans.get(i + j) + ans.get(i + j + 1) / 10);
                ans.set(i + j + 1, ans.get(i + j + 1) % 10);
            }
        }

        int firstNonZero = 0;
        while (firstNonZero < ans.size() && ans.get(firstNonZero) == 0) {
            ++firstNonZero;
        }

        ans = ans.subList(firstNonZero, ans.size());

        if (ans.isEmpty()) {
            return List.of(0);
        }

        ans.set(0, sign * ans.get(0));

        return ans;

    }
}
