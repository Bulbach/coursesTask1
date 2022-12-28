package com.alex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class RunnerTest {
    int[] mass1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};

    @Test
    void countOfMassive() {
        int[] massive = Runner.countOfMassive(mass1);
        Assertions.assertArrayEquals(new int[]{10,-65}, massive);
    }

    @Test
    void countOfMassiveToStream() {
    }
}