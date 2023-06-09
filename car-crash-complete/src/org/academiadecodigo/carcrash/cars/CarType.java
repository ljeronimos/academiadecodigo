package org.academiadecodigo.carcrash.cars;

public enum CarType {
    FIAT("F"),
    MUSTANG("M"),
    CRASHED("C");

    public final String carCursor;

    private CarType(String carCursor){
        this.carCursor = carCursor;
    }
}
