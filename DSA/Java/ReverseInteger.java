package DSA.Java;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int x = 14767845;
        int returned;
        long start, end;

        System.out.println("For given x " + x);

        start = System.currentTimeMillis();
        returned = ri.reverseInt(x);
        end = System.currentTimeMillis();

        System.out.println("Reversed Value " + returned);

        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private int reverseInt(int x) {
        if (x < 0) {
            return -1 * reverseInt(-x);
        }
        int y = 0;
        while (x != 0) {
            y *= 10;
            y += x % 10;
            x = x / 10;
        }
        return y;
    }

}
