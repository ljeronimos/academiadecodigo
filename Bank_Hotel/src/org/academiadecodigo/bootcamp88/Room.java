package org.academiadecodigo.bootcamp88;

public class Room {

    private boolean isOccupied;
    private int roomNumber;
    private RoomType typeRoom;
    private double roomPrice;

    public Room(int roomNumber){
        this.isOccupied = false;
        this.roomNumber = roomNumber;
        this.typeRoom = RoomType.values()[(int)(Math.random()*4)];

        switch (this.typeRoom){
            case SINGLE:
                roomPrice=50;
                break;
            case DOUBLE:
                roomPrice=70;
                break;
            case SUITE:
                roomPrice=100;
                break;
            case SUITEMASTER:
                roomPrice=200;
                break;
            default:
                break;
        }
    }

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

    public void setOccupied(boolean  status) {
        isOccupied=status;
    }
}
