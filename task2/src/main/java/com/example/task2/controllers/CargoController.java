package com.example.task2.controllers;

import com.example.task2.model.Cargo;
import com.example.task2.serviceses.typeOfConstruct.CargoIfConstruct;
import com.example.task2.serviceses.typeOfConstruct.CargoMapConstruct;
import com.example.task2.serviceses.typeOfConstruct.CargoSwitchConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class CargoController {
    @Autowired
    private CargoIfConstruct cargoIfConstruct;
    @Autowired
    private CargoSwitchConstruct cargoSwitchConstruct;
    @Autowired
    private CargoMapConstruct cargoMapConstruct;


    @PostMapping("/cargo")
    public Cargo treatment(@RequestBody Cargo cargo){
        cargoMapConstruct.chooseOperation(cargo);
        return cargo;
    }
}
