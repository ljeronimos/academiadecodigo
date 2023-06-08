package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

abstract public class Car {

    /** The position of the car on the grid */
    private Position pos;
    private CarType carType;
    private boolean crashed;
    private Direction carDirection;
    private int stepsCount;
    public static final int MAX_STEPS=5;

    public Car(CarType cartype){
        this.carType = cartype;
        this.crashed = false;
        this.stepsCount = 0;
        this.carDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
    }
    public Position getPos() {
        return pos;
    }

    public void crashed(){
        this.carType=CarType.CRASHED;
        this.crashed = true;
    }
    public boolean isCrashed() {

        return crashed;
    }

    public void setPos(Position pos){
        this.pos = pos;
    }

    public int getStepsCount(){
        return stepsCount;
    }
    public Direction getCarDirection(){
        return carDirection;
    }
    public void resetStepsCount(){
        this.stepsCount=0;
    }

    public void setCarType(CarType type){
        this.carType = type;
    }
    public void setCrashed(boolean crashed){
        this.crashed = crashed;
    }

    public boolean hitsWall(){

        if(carDirection==Direction.UP && pos.getRow()-MAX_STEPS<0){
            return true;
        }else if(carDirection==Direction.DOWN && pos.getRow()+MAX_STEPS> Field.getHeight()){
            return true;
        }else if(carDirection==Direction.LEFT && pos.getCol()-MAX_STEPS<0){
            return true;
        } else if (carDirection==Direction.RIGHT && pos.getCol()+MAX_STEPS>Field.getWidth()) {
            return true;
        }else {
            return false;
        }
    }

    public void move(){

        if(carDirection==Direction.UP){
            pos.setRow(pos.getRow()-1);
        } else if (carDirection == Direction.DOWN) {
            pos.setRow(pos.getRow()+1);
        } else if (carDirection == Direction.LEFT) {
            pos.setCol(pos.getCol()-1);
        } else if (carDirection == Direction.RIGHT) {
            pos.setCol(pos.getCol()+1);
        }

        stepsCount++;
    }

    public void newDirection(){
        carDirection=Direction.values()[(int) (Math.random() * Direction.values().length)];
        stepsCount=0;
    }

    @Override
    public String toString() {
        return carType.carCursor;
    }
}
