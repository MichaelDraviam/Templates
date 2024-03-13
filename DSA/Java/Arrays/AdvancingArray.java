package DSA.Java.Arrays;

public class AdvancingArray {

    public static void main(String[] args) {
        AdvancingArray aa = new AdvancingArray();
        int[] input = new int[] { 3, 3, 1, 0, 2, 0, 1 };
        System.out.println("For given Input");
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
        long start, end;
        boolean possible;
        int steps;

        start = System.currentTimeMillis();
        steps = aa.minSteps(input);
        end = System.currentTimeMillis();

        System.out.println("Can reach end in " + steps);
        System.out.println("Code ran in " + (end - start) + " ms");

    }

    private boolean reachEnd(int[] a) {
        int n = a.length;
        int max = 0;
        for (int i = 0; i <= max && max < n - 1; i++) {
            max = Math.max(max, a[i] + i);
        }
        return max >= n - 1;
    }

    /*
     * this is a greedy bfs solution
     * The main idea is based on greedy.
     * Let's say the range of the current jump is [curBegin, curEnd],
     * curFarthest is the farthest point that all points in [curBegin, curEnd] can
     * reach.
     * once the current point reaches curEnd, then trigger another jump,
     * and set the new curEnd with curFarthest, then keep the above steps, as the
     * following:
     */
    private int minSteps(int[] a) {
        int n = a.length;
        int steps = 0;
        int curFar = 0;
        int curEnd = 0;
        for (int i = 0; i < n - 1; i++) {
            curFar = Math.max(curFar, a[i] + i);
            if (i == curEnd) {
                steps++;
                curEnd = curFar;
            }
        }

        return steps;
    }
}
