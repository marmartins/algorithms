package com.handcode.certification.operators;

public class Precedence {

    public static void main(String[] args) {
        int lion = 3;
        int tiger = ++lion - 1 + (++lion) * 5 / lion--;
        System.out.println("lion is " + lion);
        System.out.println("tiger is " + tiger);

        double d = 3.2;
        double f = 2.1;
        System.out.println(d + f);
    }

}
