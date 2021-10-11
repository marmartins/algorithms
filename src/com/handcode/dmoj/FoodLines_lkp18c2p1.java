package com.handcode.dmoj;

import java.util.Scanner;

//lkp18c2p1
public class FoodLines_lkp18c2p1 {

    private static final int MAX_LINE_SIZE = 100;
    private static final int[] lanes = new int[MAX_LINE_SIZE];

    public static void main(String[] args) {
        FoodLines_lkp18c2p1 c = new FoodLines_lkp18c2p1();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            lanes[i] = scanner.nextInt();
        }
        c.run(n, m);
    }

    public void run(int n, int m) {
        for (int i = 0; i < m; i++) {
            int small[] = getSmallLane(lanes, n);
            System.out.println(small[1]);
            lanes[small[0]]++;
        }
    }

    public int[] getSmallLane(int[] lanes, int n) {
        int small = lanes[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (lanes[i] < small) {
                small = lanes[i];
                index = i;
            }
        }
        return new int[]{index, small};
    }

}
