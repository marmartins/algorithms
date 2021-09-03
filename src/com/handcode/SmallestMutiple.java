package com.handcode;

public class SmallestMutiple {

    public static void main(String[] args) {
        int n = smallestMiltiple(20);
        System.out.println(n);
    }

    private static int smallestMiltiple(int n) {
        int v = 1;
        for (int i = 1; i < n; i++) {
            if (v % i != 0) {
                i = 0;
                v++;
            }
        }
        return v;
    }
}
