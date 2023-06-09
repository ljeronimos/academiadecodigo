package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {

    public static Car getNewCar() {

        if(Math.random()<0.5){
            return new Fiat();
        }else{
            return new Mustang();
        }
    }
}
