package com.alex;

import java.util.Arrays;

import static java.util.stream.Collectors.groupingBy;

public class Runner {

    public static void main(String[] args) {

        int[] mass1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
        int[] mass2 = {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};
        int[] massZero = null;
        System.out.println(Arrays.toString(countOfMassive(mass1)));
        System.out.println(Arrays.toString(countOfMassive(mass2)));
        System.out.println(Arrays.toString(countOfMassive(massZero)));

        System.out.println(Arrays.toString(countOfMassiveToStream(mass1)));
        System.out.println(Arrays.toString(countOfMassiveToStream(mass2)));
        System.out.println(Arrays.toString(countOfMassiveToStream(massZero)));

        System.out.println(Arrays.toString(countOfMassiveToStreamCollect(mass1)));
        System.out.println(Arrays.toString(countOfMassiveToStreamCollect(mass2)));
        System.out.println(Arrays.toString(countOfMassiveToStreamCollect(massZero)));


    }

    public static int[] countOfMassive(int[] mass) {
        int count = 0;
        int sum = 0;

        if (isEmpty(mass)) {
            return new int[0];
        }

        for (int val : mass) {
            count += oneIfPositive(val);
            sum += valueIfNegative(val);
        }

        return new int[]{count, sum};
    }

    public static int[] countOfMassiveToStream(int[] mass) {

        if (isEmpty(mass)) {
            return new int[0];
        }

        int[] array = new int[]{0, 0};

        array[1] = Arrays.stream(mass)
                .peek(number -> array[0] += oneIfPositive(number))
                .filter(n -> n < 0)
                .sum();
        return array;
    }

    public static int[] countOfMassiveToStreamCollect(int[] mass) {
        if (isEmpty(mass)) {
            return new int[0];
        }

        return Arrays.stream(mass)
                .filter(x -> x != 0)
                .collect(() -> new int[]{0, 0}
                        , (acum, value) -> {
                            if (value > 0) {
                                ++acum[0];
                            } else if (value < 0) {
                                acum[1] += value;
                            }
                        }, (acum1, acum2) -> {
                            acum1[0] += acum2[0];
                            acum1[1] += acum2[1];
                        });
    }

    private static boolean isEmpty(int[] mass) {
        return mass == null || mass.length == 0;
    }

    private static int oneIfPositive(final int value) {
        return value > 0 ? 1 : 0;
    }

    private static int valueIfNegative(final int value) {
        return value < 0 ? value : 0;
    }
}
