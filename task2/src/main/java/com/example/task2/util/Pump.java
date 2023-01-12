package com.example.task2.util;

import org.springframework.stereotype.Component;

@Component
public class Pump implements Tool{
    @Override
    public void work() {
        System.out.println("Качаем, качаем.");
    }
}
