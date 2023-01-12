package com.example.task2.serviceses.typeOfConstruct;

import com.example.task2.model.Cargo;
import com.example.task2.serviceses.Career;
import com.example.task2.serviceses.CargoYard;
import com.example.task2.serviceses.TankFarm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CargoIfConstruct {
    private final CargoYard cargoYard;
    private final TankFarm tankFarm;
    private final Career career;


    public void chooseOperation(Cargo cargo) {

        if (cargo.getType().equals("сыпучие")) {
            if (cargo.isFully()) {
                career.unloading(cargo);
            } else {
                career.upload(cargo);
            }
        }

        if (cargo.getType().equals("налив")) {
            if (cargo.isFully()) {
                tankFarm.unloading(cargo);
            } else {
                tankFarm.upload(cargo);

            }
        }

        if (cargo.getType().equals("тарные")) {
            if (cargo.isFully()) {
                cargoYard.unloading(cargo);
            } else {
                cargoYard.upload(cargo);
            }

        }
    }
}
