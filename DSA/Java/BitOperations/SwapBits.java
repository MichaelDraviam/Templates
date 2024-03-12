package DSA.Java.BitOperations;

public class SwapBits {

    public static void main(String[] args) {
        SwapBits sb = new SwapBits();
        int input = 12344667; // 101111000101110101011011
        int i = 3;
        int j = 4;
        int returned;
        long start, end;

        System.out.println("For given Input  " + input + " and i " + i + ", j " + j);

        start = System.currentTimeMillis();
        returned = sb.swapBits(input, i, j);
        end = System.currentTimeMillis();

        System.out.println("Swapped Bits Value " + returned);

        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private int swapBits(int x, int i, int j) {//O(1)
        if (i > 31 || j > 31 || i < 0 || j < 0) {
            return x;
        }
        int mask1 = 1 << i;
        int mask2 = 1 << j;

        if (((x & mask1) == 0) ^ ((x & mask2) == 0)) {
            x ^= (mask1 | mask2);
        }

        return x;
    }
}
