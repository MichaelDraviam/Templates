package DSA.Java.BitOperations;

public class CountBits {

    public static void main(String[] args) {
        CountBits cb = new CountBits();
        int input = 12344667; // 101111000101110101011011
        int count;
        long start, end;

        System.out.println("For given Input  " + input);

        start = System.currentTimeMillis();
        count = cb.countBits(input);
        end = System.currentTimeMillis();

        System.out.println("Number of 1 bits " + count);

        System.out.println("Code ran in " + (end - start) + " ms");

        System.out.println("For given Input  " + input);

        start = System.currentTimeMillis();
        count = cb.countBitsFaster(input);
        end = System.currentTimeMillis();

        System.out.println("Number of 1 bits " + count);

        System.out.println("Code ran in " + (end - start) + " ms");
    }

    private int countBits(int x) {//O(n) n bits
        int count = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                count++;
            }
            x >>>= 1;
        }
        return count;
    }
 
    private int countBitsFaster(int x){// O(k) k 1 bits
        int count = 0;
        while(x != 0){
            count++;
            x &=(x-1);
        }
        return count;
    }
}
