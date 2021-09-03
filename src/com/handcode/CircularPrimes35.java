package com.handcode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class CircularPrimes35 {

    public static void main(String[] args) {
        System.out.println("Result :: " + find(1000000));
    }

    private static int find(int n) {
        List<Integer> primes = getPrimes(n);
        int count = 0;
        for (Integer p : primes) {
            if (isCircular(primes, p)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isCircular(List<Integer> primes, int p) {
        if (p < 10) {
            return true;
        }
        int m10 = 0;
        int remain = 0;
        int cir = 0;
        int pow = getPow(p);
        while (cir != p) {
            if (cir == 0)
                cir = p;
            if (cir > pow) {
                m10 = cir / 10;
                remain = cir % 10;
            }
            cir = remain * pow + m10;
//            System.out.println(p + "-" + cir);
            if (!primes.contains(cir)) {
                return false;
            }
        }
        return true;
    }

    private static int getPow(int p) {
        return p > 100000 ? 100000 :
                p > 10000 ? 10000 :
                        p > 1000 ? 1000 :
                                p > 100 ? 100 : 10;

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
