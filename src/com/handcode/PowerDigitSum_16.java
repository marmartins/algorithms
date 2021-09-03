package com.handcode;

import java.math.BigInteger;

public class PowerDigitSum_16 {
    public static void main(String[] args) {
        System.out.println(run(2, 1000));
    }

    private static int run(int n, int p) {

        BigInteger pow = BigInteger.ONE;
        for (int i = 0; i < p; i++) {
            pow = pow.multiply(BigInteger.TWO);
        }
        System.out.println(pow);
        int s = String.valueOf(pow)
                .chars()
                .map(Character::getNumericValue)
                .sum();
        return s;
    }

}
