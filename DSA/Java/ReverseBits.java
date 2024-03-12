package DSA.Java;

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        int input = 12344667; // 101111000101110101011011
        int returned;
        long start, end;

        System.out.println("For given Input  " + input + " In Binary " + Integer.toBinaryString(input));

        start = System.currentTimeMillis();
        returned = rb.reverseBits(input);
        end = System.currentTimeMillis();

        System.out.println("Reversed Bits Value " + returned + " In Binary " + Integer.toBinaryString(returned));

        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private int reverseBits(int x) {
        for (int i = 0; i < 16; i++) {
            x = swapBits(x, i, 31 - i);
        }
        return x;
    }

    private int swapBits(int x, int i, int j) {
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
