package com.handcode;

import java.math.BigInteger;

public class SumSquareDifference {

    public static void main(String[] args) {
        sumSqr(100);
    }

    private static void sumSqr(int n) {
        long sSqr = 0, sN = 0, d = 0;

        for (int i = 1; i <=n ; i++) {
            sSqr += (long) i * i;
            sN += i;
        }

        System.out.println("(1+2+ ... " + n + ")²=" + sSqr );
        System.out.println("(1+2+ ... " + n + ")=" + sN + "² =" + (sN * sN) );
        System.out.println("Diff=" + ((sN * sN) - sSqr));
    }

}
