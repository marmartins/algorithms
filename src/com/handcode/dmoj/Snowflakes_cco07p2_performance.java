package com.handcode.dmoj;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * {@see https://dmoj.ca/problem/cco07p2}
 * This solution not pass on the test...
 */
public class Snowflakes_cco07p2_performance {

    public static final int SNOW_ARMS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<int[]>> snowflakes = new HashMap<>();
        int[] snowflake = new int[SNOW_ARMS];
        boolean isTwinSnowflakeFound = false;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < SNOW_ARMS; j++) {
                snowflake[j] = scanner.nextInt();
            }
            Integer snowflakeCode = getSnowflakeCode(snowflake);
            if (snowflakes.get(snowflakeCode) == null) {
                snowflake = composeSnowflake(snowflakes, snowflake, snowflakeCode);
            }

            final int[] tempS = snowflake;
            isTwinSnowflakeFound = snowflakes.get(snowflakeCode).stream()
                    .parallel()
                    .anyMatch(s -> validateTwins(s).test(tempS));

            if (isTwinSnowflakeFound) {
                break;
            }

            snowflake = composeSnowflake(snowflakes, snowflake, snowflakeCode);
        }

        if (isTwinSnowflakeFound) {
            System.out.println("Twin snowflakes found.");
        } else {
            System.out.println("No two snowflakes are alike.");
        }

    }

    private static int[] composeSnowflake(Map<Integer, List<int[]>> repo, int[] snowflake, Integer snowflakeCode) {
        repo.computeIfAbsent(snowflakeCode, k -> new ArrayList<>());
        repo.get(snowflakeCode).add(snowflake);
        return new int[SNOW_ARMS];
    }

    private static Integer getSnowflakeCode(int[] snowflake) {
        return IntStream.of(snowflake).sum();
    }

    public static Predicate<int[]> validateTwins(int[] s1) {
        return snowflake ->
        {
            for (int j = 1; j <= 4; j++) {
                int s1Index = j;
                if (IntStream.range(0, snowflake.length)
                        .filter(idx -> Objects.equals(snowflake[idx], s1[s1Index]))
                        .filter(idx -> {
                            int vNearSide = s1[s1Index - 1];
                            int vOverSide = s1[s1Index + 1];
                            int sOverside = idx > 4 ? 0 : idx + 1;
                            int sNearSide = idx == 0 ? 5 : idx - 1;
                            if ((snowflake[sOverside] == vOverSide && snowflake[sNearSide] == vNearSide)
                                    || snowflake[sNearSide] == vOverSide && snowflake[sOverside] == vNearSide) {
                                return true;
                            }
                            return false;
                        })
                        .findFirst().isPresent()) {
                    continue;
                }
                return false;
            }
            return true;
        };
    }
}
