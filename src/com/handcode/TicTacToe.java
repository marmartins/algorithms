package com.handcode;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    int size = 4;
    int[][] game = new int[size][size];
    int[] temp = new int[size * size];
    int ovenOddPlayer = 0;

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        System.out.println("The First to play is the ODD player");
        while (true) {
            System.out.println("Enter [0] or [1] to play. Anything different of [0] is lead as [1]");
            Scanner s = new Scanner(System.in);
            String n = s.next();
            if (n.equals("0") || n.equals("1")) {
                ticTacToe.play(Integer.parseInt(n));
                ticTacToe.print();
            } else {
                System.out.println("Invalid input, try again.");
                continue;
            }
        }
    }

    private void print() {
        System.out.println("---------------------------------------------");
        Arrays.stream(game)
                        .forEach(a -> System.out.println(Arrays.toString(a)));
    }

    private int[][] play(int val) {
        ovenOddPlayer++;
        System.arraycopy(temp, 0, temp,1 , temp.length - 1);
        temp[0] = val;
        for (int i = 0; i < temp.length; i += size ) {
            int col = i > 0 ? i / size : 0;
            for (int j = 0; j < size; j++) {
                game[col][j] = temp[i + j];
            }
        }
        checkWin();
        return game;
    }

    private void checkWin() {
        boolean isWin = false;
        for (int c = 0; c < game.length; c++) {
            for (int r = 0; r < game[c].length; r++) {
                if(game[c][r] == 1) {
                    isWin = true;
                } else {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                win();
            }
        }

        for (int r = 0; r < game.length; r++) {
            for (int c = 0; c < game.length; c++) {
                if(game[c][r] == 1) {
                    isWin = true;
                } else {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                win();
            }
        }
    }

    private void win() {
        System.out.println("Player " + ((ovenOddPlayer % 2 == 0) ? 2 : 1) + " Winner !!!!");
        System.out.println("We have a champion !!!");
        print();
        System.out.println("Start again");
        System.exit(0);
    }
}
