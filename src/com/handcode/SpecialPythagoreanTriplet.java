package com.handcode;

import static com.handcode.external.Library.sqrt;

public class SpecialPythagoreanTriplet {

    public static void main(String[] args) {
        System.out.println("Value is :: " + find2(12));
    }

    private static int find(int n) {

        for (int ai = 1; ai < n / 2; ai++) {
            for (int bi = 1; bi < n / 2; bi++) {
                for (int ci = 1; ci < n / 2; ci++) {
                    if ((ai + bi + ci) == n && ((ai * ai) + (bi * bi) == (ci * ci))) {
                        return ai * bi * ci;
                    }
                }
            }
        }
        return 0;
    }

    private static double find2(int n) {

        for (int ai = 1; ai < n / 2; ai++) {
            for (int bi = 1; bi < n / 2; bi++) {
                double c = (ai * ai) + (bi * bi);
                c = Math.sqrt(c);
                if ((ai + bi + c) == n) {
                    return ai * bi * c;
                }
            }
        }
        return 0;
    }


}
