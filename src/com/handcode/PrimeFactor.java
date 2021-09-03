package com.handcode;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

    public static void main(String[] args) {
        List<Long> factors = new ArrayList<>();
        findFactors(Long.parseLong("600851475143"), factors);
        System.out.println("Impl 1 :: " + factors);
        Instant start = Instant.now();
        System.out.println("Impl 2 :: " + findFactors2(Long.parseLong("600851475143")));
        System.out.println("Finished in :: " + (Instant.now().compareTo(start)));
        Instant start2 = Instant.now();
        System.out.println("Impl 3 :: " + findFactors3(Long.parseLong("600851475143")));
        System.out.println("Finished in :: " + (Instant.now().compareTo(start2)));
    }

    private static List<Long> findFactors(long n, List<Long> factors) {
        boolean isMinimum = true;
        for (long j = 2; j < n; j++) {
            if (n % j == 0) {
                factors.add(j);
                findFactors(n / j, factors);
                isMinimum = false;
                break;
            }
        }
        if (isMinimum) {
            factors.add(n);
        }
        return factors;
    }

    private static long findFactors2(long n) {
        for (long j = 2; j < n; j++) {
            if (n % j == 0) {
                return findFactors2(n / j);
            }
        }
        return n;
    }

    private static long findFactors3(long n) {
        long div = n;
        for (long j = 2; j < div; j++) {
            if (div % j == 0) {
                div = div / j;
            }
        }
        return div;
    }

}
