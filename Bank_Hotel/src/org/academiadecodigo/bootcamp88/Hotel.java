package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Hotel {

    private int numRoom;
    private Room[] rooms;
    public Hotel(int numRoom){
        this.numRoom = numRoom;

        rooms = new Room[numRoom];
        for(int i = 0; i < numRoom; i++){
            rooms[i] = new Room(i + 1);
        }
    }

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
                        //System.out.println("You chose checkIn");
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

                        if(user1.getWallet().getBalance()>=user1.getRoomTaken().getRoomPrice()) {
                            this.checkout(user1);
                            user1.getWallet().setBalance(user1.getRoomTaken().getRoomPrice());
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

    public boolean checkin(User user, RoomType roomType) {
        if (user.getIsAGuest()) {
            System.out.println("You are already a guest. Cannot do check-in.");
        } else {
            for (int i = 0; i < this.numRoom; i++) {
                if (!rooms[i].getIsOccupied() && rooms[i].getTypeRoom()==roomType) {

                    user.setRoomGuest(rooms[i], true);
                    rooms[i].setOccupied(true);
                    System.out.println("Your room number is: " + rooms[i].getRoomNumber());
                    return true;
                }
            }
            System.out.println("We dont have "+roomType+" available");
        }
        return false;
    }

    public void checkout(User user){
        if(!user.getIsAGuest()){
            System.out.println("You are not a guest, cannot do check-out");
        } else {
            user.getRoomTaken().setOccupied(false);
            user.setIsAGuest(false);

            System.out.println("Thank you, come again");
        }
    }

    public void roomStatus(){
        System.out.println("{");
        for(int i=0;i<this.numRoom;i++){
            System.out.println(rooms[i].getRoomNumber()+" is a "+rooms[i].getTypeRoom()+" and is "+(rooms[i].getIsOccupied()? "Occupied":"Free"));
        }
        System.out.println("}");
    }
}
