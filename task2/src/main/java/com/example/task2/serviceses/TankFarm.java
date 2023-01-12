package com.example.task2.serviceses;

import com.example.task2.model.Cargo;
import com.example.task2.util.Pump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TankFarm implements Terminal{
    @Autowired
    private Pump pump;
    @Override
    public void upload(Cargo cargo) {
        cargo.setFully(true);
        pump.work();
        System.out.println("Во налили , по самые плечики");
    }

    @Override
    public void unloading(Cargo cargo) {
        cargo.setFully(false);
        System.out.println("Слили до капельки, не забудь промыть");
    }

    @Override
    public String myType() {
        return "налив";
    }
}
