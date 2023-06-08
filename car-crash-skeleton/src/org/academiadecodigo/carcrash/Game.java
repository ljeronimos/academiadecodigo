package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.cars.Direction;
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

            // Update screen
            Field.draw(cars);

        }

    }

    private boolean checkCarCrash(int carIndex){

        for(int i = 0; i < cars.length; i++){
            if(carIndex!=i && cars[carIndex].getPos().getRow()==cars[i].getPos().getRow() && cars[carIndex].getPos().getCol()==cars[i].getPos().getCol()){
                cars[carIndex].crashed();
                cars[i].crashed();

                /*if (cars[carIndex].getCarDirection()== Direction.DOWN && cars[i].getCarDirection()==Direction.UP){
                    cars[carIndex].crashed();
                }*/
            }
        }
        return true;
    }
    private void moveAllCars() {

        for (int i = 0; i < cars.length; i++) {

            if(!cars[i].isCrashed()) {
                while (cars[i].hitsWall())
                    cars[i].newDirection();

                if (cars[i].getStepsCount() == Car.MAX_STEPS) {
                    cars[i].newDirection();
                    //cars[i].resetStepsCount();
                }
                cars[i].move();
                checkCarCrash(i);
            }

        }
    }

}
