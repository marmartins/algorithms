package com.handcode;

import java.math.BigInteger;

public class FactorialDigitSum_20 {

    public static void main(String[] args) {
        System.out.println(run(100));
    }

    private static long run(int n) {
        long sum = 0;
        BigInteger mult = BigInteger.ONE;
        for (int i = n; i > 1; i--) {
            mult = mult.multiply(BigInteger.valueOf(i));
        }
        for(char c : mult.toString().toCharArray()) {
            sum += Long.parseLong(String.valueOf(c));
        }
        return sum;
    }
}
