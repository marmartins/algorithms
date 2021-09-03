package com.handcode;

import java.util.ArrayList;
import java.util.List;

public class SumOfPrimes {
    

    public static void main(String[] args) {
        System.out.println(sumPrimes(2000000));
    }

    private static long sumPrimes(int limit) {
        long sum = 10;
        for (int i = 6; i < limit; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < (n > 10000 ? n / 100 : n/2); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
