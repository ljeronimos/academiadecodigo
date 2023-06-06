package org.academiadecodigo.bootcamp88;

public class Room {

    //Room properties
    private boolean isOccupied;
    private int roomNumber;
    private RoomType typeRoom;
    private double roomPrice;

    //CONSTRUCTOR
    public Room(int roomNumber){
        this.isOccupied = false;
        this.roomNumber = roomNumber;
        this.typeRoom = RoomType.values()[(int)(Math.random()*4)];

        switch (this.typeRoom){
            case SINGLE:
                this.roomPrice=50;
                break;
            case DOUBLE:
                this.roomPrice=70;
                break;
            case SUITE:
                this.roomPrice=100;
                break;
            case SUITEMASTER:
                this.roomPrice=200;
                break;
            default:
                break;
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
