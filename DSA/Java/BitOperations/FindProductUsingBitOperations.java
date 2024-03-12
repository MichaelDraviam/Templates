package DSA.Java.BitOperations;

public class FindProductUsingBitOperations {

    public static void main(String[] args) {
        FindProductUsingBitOperations fp = new FindProductUsingBitOperations();
        int x = 123;
        int y = 654;
        int returned;
        long start, end;

        System.out.println("For given x " + x + " ,y " + y);

        start = System.currentTimeMillis();
        returned = fp.product(x, y);
        end = System.currentTimeMillis();

        System.out.println("Product Value " + returned + " compared to " + (x * y));

        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private int product(int x, int y) {
        int sum = 0;
        while (x != 0) {
            if ((x & 1) != 0) {
                sum = add(sum, y);
            }
            x >>>= 1;
            y <<= 1;
        }

        return sum;
    }

    private int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }

}
