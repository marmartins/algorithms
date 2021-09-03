package com.handcode;

import java.util.BitSet;

public class HighlyDivisibleTriangularNumber_12 {

    public static void main(String[] args) {
        System.out.println("Result :: " + run(5));
    }

    private static long run(int i) {

        long j = 0;
        long c = 0;
        long m = 0;
        while (m < i) {
            c += j;
            m = findFactors((int) c);
            j++;
        }
        return c;
    }


    private static long findFactors(int num) {

        int i = 2;
        int p = 1;
        int n = num;

        if (n == 1) return 1;

        while (i * i <= n) {
            int c = 1;
            while (n % i == 0) {
                n /= i;
                c++;
            }
            i++;
            p *= c;
        }

        if (n == num || n > 1) {
            p *= 1 + 1;
        }

        return p;
    }

}
