package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Hotel {

    //Hotel properties
    private final int numberOfRooms;
    private final Room[] roomsArray;

    //CONSTRUCTOR
    public Hotel(int numRoom){
        this.numberOfRooms = numRoom;
        this.roomsArray = new Room[numRoom];
        for(int i = 0; i < numRoom; i++){
            roomsArray[i] = new Room(i + 1);
        }
    }

    //METHODS
    //Launches hotel menu
    public void sleepOut(User user1, Scanner myScanner){

        boolean doneHotel=false;

        while(!doneHotel) {
            System.out.println("What would you like to do?\n[1] Check In\n[2] Check Out\n[3] See available rooms\n[0] Quit");
            String userInput = myScanner.nextLine();

            if(Pattern.matches("^[0-3]*$", userInput)) {
                switch (Integer.parseInt(userInput)) {
                    case 1:
                        if (user1.getIsAGuest()) {
                            System.out.println("You are already a guest. Cannot do check-in.");
                            break;
                        }
                        System.out.println("What type of room would you like?\n[1] Single 50€\n[2] Double 70€\n[3] Suite 100€\n[4] Suite Master 200€\n[0] Quit");
                        String userInput2 = myScanner.nextLine();
                        if(Pattern.matches("^[0-4]*$", userInput2)) {
                            switch (Integer.parseInt(userInput2)){
                                case 1:
                                    if(this.checkin(user1,RoomType.SINGLE)) {
                                        doneHotel = true;
                                    }
                                    break;
                                case 2:
                                    if(this.checkin(user1,RoomType.DOUBLE)) {
                                        doneHotel = true;
                                    }
                                    break;
                                case 3:
                                    if(this.checkin(user1,RoomType.SUITE)) {
                                        doneHotel = true;
                                    }
                                    break;
                                case 4:
                                    if(this.checkin(user1,RoomType.SUITEMASTER)) {
                                        doneHotel = true;
                                    }
                                    break;
                                case 0:
                                    doneHotel=true;
                                default:
                                    System.out.println("Invalid option. Try again.");
                                    break;
                            }
                        } else{
                            System.out.println("Invalid option. Try again.");
                        }
                        break;
                    case 2:
                        if(user1.payService(this.roomsArray[user1.getRoomNumber()-1].getRoomPrice())) {
                            this.checkout(user1);
                        }
                        else
                            System.out.println("Go to work, malandro!");

                        doneHotel = true;
                        break;
                    case 3:
                        this.roomStatus();
                        break;
                    case 0:
                        doneHotel=true;
                        break;
                    default:
                        break;
                }
            }else{
                System.out.println("Invalid option. Try again.");
            }
        }

    }

    //Check in user
    public boolean checkin(User user, RoomType roomType) {
        if (user.getIsAGuest()) {
            System.out.println("You are already a guest. Cannot do check-in.");
        } else {
            for (int i = 0; i < this.numberOfRooms; i++) {
                if (!roomsArray[i].getIsOccupied() && roomsArray[i].getTypeRoom()==roomType) {

                    user.setRoomNumber(roomsArray[i].getRoomNumber());
                    user.setIsAGuest(true);
                    roomsArray[i].setOccupied(true);
                    System.out.println("Your room number is: " + roomsArray[i].getRoomNumber());
                    return true;
                }
            }
            System.out.println("We don't have "+roomType+" available");
        }
        return false;
    }

    //Check out user
    public void checkout(User user){
        if(!user.getIsAGuest()){
            System.out.println("You are not a guest, cannot do check-out");
        } else {
            this.roomsArray[user.getRoomNumber()-1].setOccupied(false);
            user.setIsAGuest(false);
            user.setRoomNumber(0);

            System.out.println("Thank you, come again");
        }
    }

    //Prints all rooms showing their status and type
    public void roomStatus(){
        System.out.println("{");
        for(int i = 0; i<this.numberOfRooms; i++){
            System.out.println(roomsArray[i].getRoomNumber()+" is a "+ roomsArray[i].getTypeRoom()+" and is "+(roomsArray[i].getIsOccupied()? "Occupied":"Free"));
        }
        System.out.println("}");
    }
}
