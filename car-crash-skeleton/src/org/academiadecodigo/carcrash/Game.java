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
            /*moveMustang();
            moveMustang();
            moveFiat();*/

            // Update screen
            Field.draw(cars);

        }

    }

    private void checkCarCrash(int carIndex){

        for(int i = 0; i < cars.length; i++){
            if(carIndex!=i && cars[carIndex].getPos().getRow()==cars[i].getPos().getRow() && cars[carIndex].getPos().getCol()==cars[i].getPos().getCol()){
                cars[carIndex].crashed();
                cars[i].crashed();
            }
        }
    }
    private void moveAllCars() {

        for (int i = 0; i < cars.length; i++) {

            if(!cars[i].isCrashed()) {
                while (cars[i].hitsWall())
                    cars[i].newDirection();

                //Gets a new direction if it has taken the max number of steps in the same direction
                if (cars[i].getStepsCount() == Car.MAX_STEPS) {
                    cars[i].newDirection();
                }
                cars[i].move();
                checkCarCrash(i);
            }
        }
    }

    private void moveFiat(){

        for (int i = 0; (i < cars.length && (cars[i] instanceof Fiat)); i++) {

            if(!cars[i].isCrashed()) {
                while (cars[i].hitsWall())
                    cars[i].newDirection();

                //Gets a new direction if it has taken the max number of steps in the same direction
                if (cars[i].getStepsCount() == Car.MAX_STEPS) {
                    cars[i].newDirection();
                }
                cars[i].move();
                checkCarCrash(i);
            }
        }
    }

    private void moveMustang(){

        for (int i = 0; (i < cars.length && (cars[i] instanceof Mustang)); i++) {

            if(!cars[i].isCrashed()) {
                while (cars[i].hitsWall())
                    cars[i].newDirection();

                //Gets a new direction if it has taken the max number of steps in the same direction
                if (cars[i].getStepsCount() == Car.MAX_STEPS) {
                    cars[i].newDirection();
                }
                cars[i].move();
                checkCarCrash(i);
            }
        }
    }

}
