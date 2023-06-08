package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {

    public static Car getNewCar() {

        Car createdCar;

        if(Math.random()<0.5){
            //Create Fiat
            createdCar = new Fiat();
        }else{
            //Create Mustang
            createdCar = new Mustang();
        }

        Position pos = new Position();
        pos.setCol((int)(Math.random()*Field.getWidth()));
        pos.setRow((int)(Math.random()*Field.getHeight()));

        createdCar.setPos(pos);

        return createdCar;

    }
}
