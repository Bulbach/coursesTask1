package com.example.task2;

import com.example.task2.model.Cargo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task2Application {

    public static void main(String[] args) {
        SpringApplication.run(Task2Application.class, args);

//        Cargo cargo = Cargo.builder()
//                .name("щебень")
//                .type("сыпучие")
//                .build();
//
//
//        System.out.println(cargo.isFully());
    }

}
