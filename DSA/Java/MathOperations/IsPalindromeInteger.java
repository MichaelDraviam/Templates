package DSA.Java.MathOperations;

public class IsPalindromeInteger {

    public static void main(String[] args) {
        IsPalindromeInteger ip = new IsPalindromeInteger();
        int x = 123521;
        boolean returned;
        long start, end;

        System.out.println("For given x " + x);

        start = System.currentTimeMillis();
        returned = ip.isPalindrome(x);
        end = System.currentTimeMillis();

        System.out.println(x + " is " + (returned ? "" : " not") + " Palindrome");

        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private boolean isPalindrome(int x) {//O(n) n is no of digits
        if (x <= 0) {
            return x == 0;
        }

        int numOfDigits = 1 + (int) Math.floor(Math.log10(x));
        int mask = (int) Math.pow(10, numOfDigits - 1);
        for (int i = 0; i < numOfDigits / 2; i++) {
            if (x / mask != x % 10) {
                return false;
            }
            x %= mask;
            x /= 10;
            mask /= 100;
        }
        return true;
    }

}
