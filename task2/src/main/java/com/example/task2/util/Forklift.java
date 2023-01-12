package com.example.task2.util;

import org.springframework.stereotype.Component;

@Component
public class Forklift implements Tool{
    @Override
    public void work() {
        System.out.println("Не потеряй его и не сломай");
    }
}
