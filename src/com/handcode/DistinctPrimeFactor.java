package com.handcode;

import java.util.*;

public class DistinctPrimeFactor {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(find(4));
        System.out.println("In :: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int find(int f) {
        List<Integer> primes = getPrimes(700);

        int value = 2 * 2 * 2 * 2;

        while (!factor(primes, value, f, f)) {
            value++;
        }
        return value;
    }

    private static boolean factor(List<Integer> primes, int value, int f, int ori){
        int remain = 1;
        int temp = value;
        int mult = 1;
        for (int i = 0; i < primes.size(); i++) {
            boolean isMult = false;
            while (temp >= primes.get(i) && (remain = temp % primes.get(i)) == 0) {
                temp = temp / primes.get(i) + remain;
                isMult = true;
            }
            if (temp < primes.get(i)) {
                break;
            }
            if(isMult)
                mult++;
        }
        if (remain == 0 && mult == ori) {
            if (f == 1) {
                return true;
            }
            return factor(primes, value + 1, f - 1, ori);
        }
        return false;
    }

    private static List<Integer> getPrimes(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        if (n == 2) {
            return List.of(2);
        }

        BitSet primes = new BitSet(n + 1);
        primes.set(0, n + 1);

        for (int p = 2; p * p <= n; p++) {
            if (primes.get(p)) {
                for (int i = p * p; i <= n; i += p) {
                    primes.clear(i);
                }
            }
        }

        List<Integer> r = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (primes.get(i))
                r.add(i);
        }
        return r;
    }

}
