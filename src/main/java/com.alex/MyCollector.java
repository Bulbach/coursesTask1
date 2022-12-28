package com.alex;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyCollector implements Collector<Integer, int[], int[]> {

    public static MyCollector myCollector() {
        return new MyCollector();
    }

    @Override
    public Supplier<int[]> supplier() {
        return () -> new int[]{0, 0};

    }

    @Override
    public BiConsumer<int[], Integer> accumulator() {
        return (acum, value) -> {
            if (value > 0) {
                ++acum[0];
            } else if (value < 0) {
                acum[1] += value;
            }
        };
    }

    @Override
    public BinaryOperator<int[]> combiner() {
        return (acum1, acum2) -> {
            acum1[0] += acum2[0];
            acum1[1] += acum2[1];
            return acum1;
        };
    }

    @Override
    public Function<int[], int[]> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collectors.toSet().characteristics();
    }
}
