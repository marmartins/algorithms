package com.handcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimePairSet {

    public static void main(String[] args) {

        long p = isPrime(23);
        System.out.println(p);

        long nextP = nextPrime(15);
        System.out.println(nextP);

        long sumSet = primePairSet(5);
        System.out.println(sumSet);
    }

    private static long primePairSet(long n) {
        List<Long> pair = new ArrayList<>();
        long p = 2;
        while (pair.size() < n) {
            p = nextPrime(p);
            if (pair.isEmpty()) {
                pair.add(p);
            }
            if (isPairSet(pair, p)) {
                pair.add(p);
            }
        }
        System.out.println(pair);
        return pair.stream().reduce(0L, Long::sum);
    }

    private static boolean isPairSet(List<Long> pair, long p) {
        if (pair.size() < 1 || p == 3) {
            return false;
        }
        boolean isPair = false;
        for (Long i : pair) {
            if ((isPrime(Long.parseLong(i + "" + p)) != 0)
                    && (isPrime(Long.parseLong(p + "" + i)) != 0)) {
                isPair = true;
            } else {
                isPair = false;
                break;
            }
        }
        return isPair;
    }

    private static long nextPrime(long n) {
        if (isPrime(n) != 0) n++;
        long p;
        while((p = isPrime(n)) == 0) {
            n++;
        }
        return p;
    }

    private static long isPrime(long n) {
        boolean isPrime = true;
        if (n <= 2) {
            n = 3; //because it is the first prime
        }
        for (long i = 2; i < (n > 1000000 ? n / 1000 : n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime ? n : 0;
    }

}
