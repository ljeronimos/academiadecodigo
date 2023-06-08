package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {

    public static Car getNewCar() {

        Car createdCar;

        if(Math.random()<0.5){
            createdCar = new Fiat();
        }else{
            createdCar = new Mustang();
        }

        Position pos = new Position((int)(Math.random()*Field.getWidth()),(int)(Math.random()*Field.getHeight()));

        createdCar.setPos(pos);

        return createdCar;

    }
}
