package com.handcode;

public class Miltiples {

    public static void main(String[] args) {
        int sum = multiples(new int[]{3,5}, 1000);
        System.out.println("Sum::" + sum);
    }

    private static int multiples(int[] ints, int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < ints.length; k++) {
                if (ints[k] > 0 && j % ints[k] == 0) {
                    System.out.println("num::" + j);
                    sum += j;
                    break;
                }
            }
        }
        return sum;
    }

}
