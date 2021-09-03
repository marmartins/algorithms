package com.handcode;

import java.util.Arrays;

public class LargestPalindrome {

    public static void main(String[] args) {
        int result = getLargestPalindrome();
        System.out.println("MAX :: " + result);

    }

    private static int getLargestPalindrome() {
        int max = 0;
        for (int i = 999; i > 1; i--) {
            for (int j = 999; j >= 1; j--) {
                int r = i * j;
                if (new StringBuilder("" + r).reverse().toString().equals("" + r)) {
                    if (max <= r) {
                        max = r;
                    }
                }
            }
        }
        return max;
    }
}
