package com.handcode;

import java.math.BigInteger;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci2(4000000));
    }

    private static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }
        return fibonacci(n -1) + fibonacci(n-2);
    }


    private static long fibonacci2(int n) {
        long a = 0;
        long b = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long c = a + b;
            a = b;
            b = c;

            if (b % 2 == 0) {
                sum += b;
            }

            if (b >= 4000000) {
                break;
            }
        }
        return sum;
    }

}
