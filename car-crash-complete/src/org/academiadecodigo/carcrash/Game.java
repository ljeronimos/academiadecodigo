package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.*;
import org.academiadecodigo.carcrash.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 20;

    /** Container of Cars */
    private Car[] cars;

    /** Animation delay */
    private int delay;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Checks if all cars are crashed
            if(areAllCrashed()){
                Field.clearScreen();
            }else{
                // Update screen
                Field.draw(cars);
            }



        }
    }

    //Checks if a car has the same position as any of the other cars, and it's not the same one
    private void checkCarCrash(int carIndex){

        for(int i = 0; i < cars.length; i++){
            if(carIndex!=i && cars[carIndex].getPos().getRow()==cars[i].getPos().getRow() && cars[carIndex].getPos().getCol()==cars[i].getPos().getCol()){
                cars[carIndex].crashed();
                cars[i].crashed();
            }
        }
    }

    private boolean areAllCrashed(){

        for (Car car : cars) {
            if (!car.isCrashed()) {
                return false;
            }
        }
        return true;
    }

    private void moveAllCars() {

        for (int i = 0; i < cars.length; i++) {

            if(!cars[i].isCrashed()) {

                //Gets a new direction if it has taken the max number of steps in the same direction
                if (cars[i].getStepsCount() >= Car.MAX_STEPS) {
                    cars[i].newDirection();
                }
                cars[i].move();
                checkCarCrash(i);

                if(cars[i] instanceof Mustang && !cars[i].isCrashed()){
                    cars[i].move();
                    checkCarCrash(i);
                }
            }
        }
    }
}
