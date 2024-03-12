package DSA.Java.Arrays;

import java.util.Random;

public class DutchPartitionQuickSort {
    Random random = new Random();

    public static void main(String[] args) {
        DutchPartitionQuickSort qs = new DutchPartitionQuickSort();
        long start, end;
        int[] a = new int[] { 10, 7, 8, 9, 1, 5, 3, 2, 4, 6, 11, 65, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                25,
                26, 27, 28, 29, 30, 31, 2, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51,
                52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 21, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76,
                77,
                78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 65, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 };
        System.out.println("input array ");
        qs.print(a);
        start = System.currentTimeMillis();
        qs.quickSort(a, 0, a.length - 1);
        end = System.currentTimeMillis();
        qs.print(a);
        System.out.println("output array ");
        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int p = random.nextInt(r - l + 1) + l;
            swap(a, l, p);
            int[] pivot = dutchPartition(a, l, r);
            quickSort(a, l, pivot[0] - 1);
            quickSort(a, pivot[1] + 1, r);
        }
    }

    private int[] dutchPartition(int[] a, int l, int r) {

        if (r - l <= 1) {
            if (a[r] < a[l]) {
                swap(a, r, l);
            }
        }

        int pivot = a[l];
        int i = l, j = r;
        int k = i;
        while (k <= j) {
            if (a[k] > pivot) {
                swap(a, k, j);
                j--;
            } else if (a[k] < pivot) {
                swap(a, i, k);
                k++;
                i++;
            } else {
                k++;
            }
        }
        return new int[] { i, j };
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
