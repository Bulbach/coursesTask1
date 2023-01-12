package com.example.task2.serviceses.typeOfConstruct;

import com.example.task2.model.Cargo;
import com.example.task2.serviceses.Career;
import com.example.task2.serviceses.CargoYard;
import com.example.task2.serviceses.TankFarm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CargoSwitchConstruct {

    @Autowired
    private CargoYard cargoYard;
    @Autowired
    private TankFarm tankFarm;
    @Autowired
    private Career career;


    public void chooseOperation(Cargo cargo) {


        switch (cargo.getType()) {
            case "сыпучие":
                if (cargo.isFully()) {
                    career.unloading(cargo);
                } else {
                    career.upload(cargo);
                }
                break;
            case "налив":
                if (cargo.isFully()) {
                    tankFarm.unloading(cargo);
                } else {
                    tankFarm.upload(cargo);
                }
                break;
            case "тарные":
                if (cargo.isFully()) {
                    cargoYard.unloading(cargo);
                } else {
                    cargoYard.upload(cargo);
                }
                break;
            default:
                System.out.println("Нет технических средств для загрузки данного вагона");
        }
    }
}
