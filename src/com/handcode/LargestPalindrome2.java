package com.handcode;

public class LargestPalindrome2 {

    public static void main(String[] args) {
        int result = getLargestPalindrome(999);
        System.out.println(result);
    }

    private static int getLargestPalindrome(int n) {
        int max = -1;

        for (int i = 999; i >= 1; i--) {
            if (max >= i * 999) {
                break;
            }
            for (int j = 999; j >= i; j--) {
                int p = i * j;
                System.out.println(i + " * " + j + " = " + p);
                if (max < p && isPalindrome(p)) {
                    max = p;
                }
            }
        }
        return max;
    }

    private static boolean isPalindrome(int p) {
        if (new StringBuilder("" + p).reverse().toString().equals("" + p)) {
            return true;
        }
        return false;
    }


}
