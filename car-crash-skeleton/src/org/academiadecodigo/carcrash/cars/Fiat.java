package org.academiadecodigo.carcrash.cars;

public class Fiat extends Car{
    public Fiat(){
        super(CarType.FIAT);
    }

    /*private static int speedBump=0;
    public void move(){

        if(speedBump<=1){
            speedBump++;
            return;
        }
        if(getCarDirection()==Direction.UP){
            getPos().setRow(getPos().getRow()-1);
        } else if (getCarDirection() == Direction.DOWN) {
            getPos().setRow(getPos().getRow()+1);
        } else if (getCarDirection() == Direction.LEFT) {
            getPos().setCol(getPos().getCol()-1);
        } else if (getCarDirection() == Direction.RIGHT) {
            getPos().setCol(getPos().getCol()+1);
        }
        incrementStepsCount();
        speedBump=0;
    }*/
}
