package com.example.task2.serviceses;

import com.example.task2.model.Cargo;
import org.springframework.stereotype.Component;

@Component
public interface Terminal {

    void upload(Cargo cargo);

    void unloading(Cargo cargo);

    String myType();

}
