package com.example.task2.util;

import org.springframework.stereotype.Component;

@Component
public class BucketLoader implements Tool{
    @Override
    public void work() {
        System.out.println("Бери больше , вези дальше!");
    }
}
