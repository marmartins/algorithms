package com.handcode;

public class LongestCollatzSequence_14 {

    public static void main(String[] args) {
        System.out.println(run(1000000));
    }

    private static int run(int n) {

        int maxC = 0;
        int startN = 0;
        int[] c = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            long ni = i;
            int cSize = 1;
            while (ni != 1) {
                if (c[i] > 0) {
                    cSize += c[i];
                    break;
                }
                if (ni % 2 == 0) {
                    ni /= 2;
                } else {
                    ni = (3 * ni) + 1;
                }
                cSize++;
            }
            c[i] = cSize;

            if (cSize > maxC) {
                maxC = cSize;
                startN = i;
            }
        }
        System.out.println("Start num: " + startN + " Size:" + maxC);
        return startN;
    }

}
