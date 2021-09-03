package com.handcode;

public class _10001stPrime {

    public static void main(String[] args) {
        _10001stPrimeCheck();
    }

    private static void _10001stPrimeCheck() {
        int count = 6;
        long p = 13;
        long t = 13;
        while (count != 10001) {
            if (isPrime(++t)) {
                count++;
                p = t;
            }
        }
        System.out.println("The prime is::" + p);
    }

    private static boolean isPrime(long p) {
        for (int i = 2; i < (p / 2); i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

}
