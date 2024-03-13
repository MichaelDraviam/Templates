package DSA.Java.Arrays;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplicatesSortedArray {

    public static void main(String[] args) {
        DeleteDuplicatesSortedArray dd = new DeleteDuplicatesSortedArray();
        List<Integer> input = new ArrayList<>(List.of(2, 3, 5, 5, 7, 11, 11, 11, 13));
        System.out.println("For given Input");
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
        long start, end;

        start = System.currentTimeMillis();
        dd.removeDuplicates(input);
        end = System.currentTimeMillis();

        System.out.println("Output ");
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private void removeDuplicates(List<Integer> input) {
        int i = 1;
        int prev = input.get(0);
        while (i < input.size()) {
            if (input.get(i) == prev) {
                input.remove(i);
            } else {
                prev = input.get(i);
                i++;
            }
        }
    }
}
