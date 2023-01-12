package com.example.task2.serviceses.typeOfConstruct;

import com.example.task2.model.Cargo;
import com.example.task2.serviceses.Terminal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CargoMapConstruct {

    private Map<String, Terminal> yards;

    public CargoMapConstruct(List<Terminal> terminals){
        yards = terminals.stream().collect(Collectors.toMap(Terminal::myType, Function.identity()));
    }

    public void chooseOperation(Cargo cargo){
        Terminal terminal = yards.get(cargo.getType());
        if (cargo.isFully()) {
            terminal.unloading(cargo);
        } else {
            terminal.upload(cargo);
        }
    }
}
