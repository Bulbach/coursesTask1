package com.example.task2.model;

import lombok.*;

@Data
@Builder

public class Cargo {

    private String name;

    private String type;

    private boolean fully = false;

    public boolean isFully() {
        return this.fully;
    }
}
