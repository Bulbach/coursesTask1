package com.example.task2.serviceses;

import com.example.task2.model.Cargo;
import com.example.task2.util.Forklift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CargoYard implements Terminal{
    @Autowired
    private Forklift forklift;
    @Override
    public void upload(Cargo cargo) {
        cargo.setFully(true);
        forklift.work();
        System.out.println("Все палеты на местах, глуши погрузчик");
    }

    @Override
    public void unloading(Cargo cargo) {
        cargo.setFully(false);
        System.out.println("Все вынесли, не забудь подмести");
    }

    @Override
    public String myType() {
        return "тарные";
    }
}
