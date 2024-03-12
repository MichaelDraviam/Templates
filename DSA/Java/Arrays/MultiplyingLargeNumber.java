package DSA.Java.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiplyingLargeNumber {

    public static void main(String[] args) {
        MultiplyingLargeNumber mln = new MultiplyingLargeNumber();
        long start, end;
        List<Integer> a = new ArrayList<>(List.of(1, 1, 0, 2, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9));
        List<Integer> b = new ArrayList<>(List.of(-1, 8, 3, 2, 9, 0, 9, 0, 0, 1, 1));
        List<Integer> ans;
        List<Integer> ans2;
        System.out.println("input array a " + a);
        System.out.println("input array b " + b);
        start = System.currentTimeMillis();
        ans = mln.multiply(a, b);
        ans2 = mln.fasterMultiply(a, b);
        end = System.currentTimeMillis();
        System.out.println("Multiply array " + ans);
        System.out.println("Faster Multiply array " + ans);
        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private List<Integer> multiply(List<Integer> a, List<Integer> b) {
        int sign = 1;
        List<Integer> ans = new ArrayList<>();
        if (a.get(0) < 0 ^ b.get(0) < 0) {
            sign = -1;
        } else if (a.get(0) == 0 || b.get(0) == 0) {
            ans.add(0);
            return ans;
        }
        a.set(0, Math.abs(a.get(0)));
        b.set(0, Math.abs(b.get(0)));
        int place = 1;
        for (int i = b.size() - 1; i >= 0; i--) {
            if (b.get(i) == 0) {
                place *= 10;
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(a);
            int p = place;
            while (p > 1) {
                tmp.add(tmp.size(), 0);
                p /= 10;
            }
            multiply(tmp, b.get(i));
            add(ans, tmp);
            place *= 10;
        }
        ans.set(0, sign * ans.get(0));
        return ans;
    }

    private void add(List<Integer> a, List<Integer> b) {
        int carry = 0;
        int n = a.size(), m = b.size();

        int size = Math.min(n, m);
        for (int i = n - 1; i >= 0 && i > n - m - 1; i--) {
            carry += a.get(i) + b.get(m + i - n);
            a.set(i, carry % 10);
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
        final int sign = a.get(0) < 0 ^ b.get(0) < 0 ? -1 : 1;
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
