package com.handcode.external;

import java.math.BigInteger;

public class Library {

    // Returns all the prime numbers less than or equal to n, in ascending order.
    // For example: listPrimes(97) = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, ..., 83, 89, 97}.
    public static int[] listPrimes(int n) {
        boolean[] isPrime = listPrimality(n);
        int count = 0;
        for (boolean b : isPrime) {
            if (b)
                count++;
        }

        int[] result = new int[count];
        for (int i = 0, j = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }

    // Returns a Boolean array 'isPrime' where isPrime[i] indicates whether i is prime, for 0 <= i <= n.
    // For a large batch of queries, this is faster than calling isPrime() for each integer.
    // For example: listPrimality(100) = {false, false, true, true, false, true, false, true,
    // false, false, false, true, false, true, false, false, false, true, ...} (array length 101).
    public static boolean[] listPrimality(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Negative array size");
        boolean[] result = new boolean[n + 1];
        if (n >= 2)
            result[2] = true;
        for (int i = 3; i <= n; i += 2)
            result[i] = true;
        // Sieve of Eratosthenes
        for (int i = 3, end = sqrt(n); i <= end; i += 2) {
            if (result[i]) {
                // Note: i * i does not overflow
                for (int j = i * i, inc = i * 2; j <= n; j += inc)
                    result[j] = false;
            }
        }
        return result;
    }


    // Returns floor(sqrt(x)), for x >= 0.
    public static long sqrt(long x) {
        if (x < 0)
            throw new IllegalArgumentException("Square root of negative number");
        long y = 0;
        for (long i = 1L << 31; i != 0; i >>>= 1) {
            y |= i;
            if (y > 3037000499L || y * y > x)
                y ^= i;
        }
        return y;
    }

    // Returns floor(sqrt(x)), for x >= 0.
    public static int sqrt(int x) {
        if (x < 0)
            throw new IllegalArgumentException("Square root of negative number");
        int y = 0;
        for (int i = 1 << 15; i != 0; i >>>= 1) {
            y |= i;
            if (y > 46340 || y * y > x)
                y ^= i;
        }
        return y;
    }

}
