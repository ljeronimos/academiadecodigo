package org.academiadecodigo.bootcamp88;

public class Room {

    //Room properties
    private boolean isOccupied;
    private final int roomNumber;
    private final RoomType typeRoom;
    private double roomPrice;

    //CONSTRUCTOR
    public Room(int roomNumber){
        this.isOccupied = false;
        this.roomNumber = roomNumber;
        this.typeRoom = RoomType.values()[(int)(Math.random()*4)];

        switch (this.typeRoom) {
            case SINGLE -> this.roomPrice = 50;
            case DOUBLE -> this.roomPrice = 70;
            case SUITE -> this.roomPrice = 100;
            case SUITEMASTER -> this.roomPrice = 200;
            default -> {
            }
        }
    }

    //GETTERs & SETTERs
    public boolean getIsOccupied() {
        return isOccupied;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public double getRoomPrice(){
        return roomPrice;
    }
    public RoomType getTypeRoom(){
        return typeRoom;
    }
    public void setOccupied(boolean status) {
        isOccupied=status;
    }
}
