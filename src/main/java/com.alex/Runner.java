package com.alex;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

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


    }

    public static int[] countOfMassive(int[] mass) {
        int count = 0;
        int sum = 0;
        if (mass==null|| mass.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] > 0) {
                count++;
            }
            if (mass[i] < 0) {
                sum += mass[i];
            }
        }
        return new int[]{count, sum};
    }

    public static int[] countOfMassiveToStream(int[] mass) {

        if (mass==null|| mass.length == 0) {
            return new int[0];
        }

        int[] array = new int[2];

        array[1] = Arrays.stream(mass)
                .peek(number -> {
                    if (number > 0) {
                        array[0]++;
                    }
                })
                .filter(n -> n < 0)
                .reduce((x, y) -> x + y)
                .getAsInt();
        return array;
    }
}
