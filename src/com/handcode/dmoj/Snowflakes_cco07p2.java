package com.handcode.dmoj;

import java.util.*;
import java.util.logging.Handler;

/**
 * {@see https://dmoj.ca/problem/cco07p2}
 * This solution not pass on the test...
 */
public class Snowflakes_cco07p2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Long, List<long[]>> snowflakes = new HashMap<>();
        long[] snowflake = new long[6];
        boolean isTwinSnowflakeFound = false;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                snowflake[j] = scanner.nextLong();
            }
            long snowflakeCode = getSnowflakeCode(snowflake);
            if (snowflakes.get(snowflakeCode) == null) {
                validSnowFlake(snowflakes, snowflake, snowflakeCode);
                snowflake = new long[6];
                continue;
            }

            for (long[] longs : snowflakes.get(snowflakeCode)) {
                isTwinSnowflakeFound = true;
                for (int j = 1; j <= 4; j++) {
                    if (!validateTwins(longs, snowflake, j)) {
                        isTwinSnowflakeFound = false;
                        break;
                    }
                }
                if (isTwinSnowflakeFound) {
                    break;
                }
            }
            if (isTwinSnowflakeFound) {
                break;
            }
            validSnowFlake(snowflakes, snowflake, snowflakeCode);
            snowflake = new long[6];
        }

        if (isTwinSnowflakeFound) {
            System.out.println("Twin snowflakes found.");
        } else {
            System.out.println("No two snowflakes are alike.");
        }
    }

    private static void validSnowFlake(Map<Long, List<long[]>> repo, long[] snowflake, long snowflakeCode) {
        repo.computeIfAbsent(snowflakeCode, k -> new ArrayList<>());
        repo.get(snowflakeCode).add(snowflake);
    }

    private static long getSnowflakeCode(long[] snowflake) {
        long sum = 0;
        for (int i = 0; i < snowflake.length; i++) {
            sum += snowflake[i];
        }
        return sum;
    }

    public static boolean validateTwins(long[] s1, long[] snowflake, int s1Index) {
        long v = s1[s1Index];
        long vNearSide = s1[s1Index - 1];
        long vOverSide = s1[s1Index + 1];

        for (int j = 0; j < snowflake.length; j++) {
            if (snowflake[j] == v) {
                int jOverside = j > 4 ? 0 : j + 1;
                int jNearSide = j == 0 ? 5 : j - 1;
                if ((snowflake[jOverside] == vOverSide && snowflake[jNearSide] == vNearSide)
                || snowflake[jNearSide] == vOverSide && snowflake[jOverside] == vNearSide) {
                    return true;
                }
            }
        }
        return false;
    }
}
