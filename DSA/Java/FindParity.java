package DSA.Java;

public class FindParity {

    public static void main(String[] args) {
        FindParity fp = new FindParity();
        int input = 12344667; // 101111000101110101011011
        int parity;
        long start, end;

        System.out.println("For given Input  " + input);

        start = System.currentTimeMillis();
        parity = fp.findParity(input);
        end = System.currentTimeMillis();

        System.out.println("Parity is  " + parity);

        System.out.println("Code ran in " + (end - start) + " ms");

        System.out.println("For given Input  " + input);

        start = System.currentTimeMillis();
        parity = fp.findParityFaster(input);
        end = System.currentTimeMillis();

        System.out.println("Parity is  " + parity);

        System.out.println("Code ran in " + (end - start) + " ms");

        System.out.println("For given Input  " + input);

        start = System.currentTimeMillis();
        parity = fp.findParityFastest(input);
        end = System.currentTimeMillis();

        System.out.println("Parity is  " + parity);

        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private int findParity(int x) {// O(n) no of bits
        int parity = 0;
        while (x != 0) {
            parity ^= x & 1;
            x >>>= 1;
        }
        return parity;
    }

    private int findParityFaster(int x) {// O(k) k <= n, k is the no of bits with 1
        int parity = 0;
        while (x != 0) {
            parity ^= 1;
            x &= x - 1; //x&(x-1) removes the last 1 bit 
        }
        return parity;
    }

    private int findParityFastest(int x) {// O(logn) the parity of(11010111) is the same as parity of(1101)^(0111) 
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return x&1; //last bit
    }
}
