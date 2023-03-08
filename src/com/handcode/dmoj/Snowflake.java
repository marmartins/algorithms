import java.util.Scanner;

public class Snowflake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of snowflakes
        int[][] snowflakes = new int[n][6]; // array to store snowflake arm lengths
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                snowflakes[i][j] = input.nextInt(); // read in arm lengths
            }
        }
        boolean identical = false; // flag for whether any identical snowflakes were found
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean match = true; // flag for whether corresponding arms match
                for (int k = 0; k < 6; k++) {
                    if (snowflakes[i][k] != snowflakes[j][k]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    identical = true;
                    System.out.println("Snowflakes " + (i+1) + " and " + (j+1) + " may be identical.");
                }
            }
        }
        if (!identical) {
            System.out.println("No two snowflakes are identical.");
        }
    }
}
