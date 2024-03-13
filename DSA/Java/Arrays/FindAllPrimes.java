package DSA.Java.Arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllPrimes {

    public static void main(String[] args) {
        FindAllPrimes fp = new FindAllPrimes();

        int n = 108000;

        long start, end;
        List<Integer> ret;

        start = System.currentTimeMillis();
        ret = fp.fasterPrimes(n);
        end = System.currentTimeMillis();

        System.out.println("All primes ");
        for (int i : ret) {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("Code ran in " + (end - start) + " ms");
    }

    /*
     * seiving used
     * (removing all multiples from future consideration)
     */
    @SuppressWarnings("unused")
    private List<Integer> findPrimes(int n) {// O(nloglogn) time O(n) space
        List<Integer> prime = new LinkedList<>();
        prime.add(1);
        Boolean[] isPrime = new Boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                prime.add(i);

                for (int j = i * 2; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return prime;
    }

    private List<Integer> fasterPrimes(int n) {
        List<Integer> prime = new LinkedList<>();
        prime.add(1);
        if (n == 1) {
            return prime;
        }

        int size = (int) Math.floor(0.5 * (n - 3)) + 1;
        prime.add(2);
        Boolean[] isPrime = new Boolean[size];// i represents 2i+3 is prime or not
        Arrays.fill(isPrime, true);
        for (long i = 0; i < size; i++) {
            if (isPrime[(int) i]) {
                int p = (int) (2 * i + 3);
                prime.add(p);
                // p2 = 4i^2 +12i + 9, in terms of isPrime value it is p2 -3 /2, which is
                // 2i^2+6i+3
                for (long  j = ((i * i) * 2) + (6 * i) + 3; j < size; j += p) {
                    isPrime[(int) j] = false;
                }

            }
        }
        return prime;

    }

}
