package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;

//Interacts with Bank & Wallet
public class User {

    private String name;
    private Wallet wallet1;

    private boolean isAGuest;
    private Room roomTaken;
    Scanner myScanner = new Scanner(System.in);

    //CONSTRUCTOR - takes in name | Creates wallet
    public User(String name, double money){
        this.name = name;
        this.wallet1 = new Wallet(money);
        this.isAGuest = false;
    }

    //GETTER
    public Wallet getWallet(){
        return this.wallet1;
    }
    //GETTER
    public String getName(){
        return this.name;
    }

    public Room getRoom(){return this.roomTaken;}

    //Creates bank account
    public Bank createBankAccount(double money){
        this.wallet1.setBalance(-money);
        return new Bank(this, money);
    }

    public double spendMoney(double cost){

        return 0;
    }

    public void withdrawalMoney(Bank bankAccount){

        System.out.println("How much money do you want to withdrawal? [q] to exit");
        String userInput = myScanner.nextLine();

        if(!userInput.equals("q")){
            double withdrawal = Double.parseDouble(userInput);

            if(withdrawal>0){
                if(bankAccount.withdrawalRequest(withdrawal)){
                    this.wallet1.setBalance(withdrawal);
                }else{
                    this.withdrawalMoney(bankAccount);
                }
            } else{
                System.out.println("Please choose a positive value.");
                this.withdrawalMoney(bankAccount);
            }

        }
    }

    public void depositMoney(Bank bankAccount){

        System.out.println("How much money do you want to deposit? [q] to exit");
        String userInput = myScanner.nextLine();

        if(!userInput.equals("q")){
            double deposit = Double.parseDouble(userInput);

            if(deposit>0){
                if(this.wallet1.getBalance()>=deposit){
                    this.wallet1.setBalance(-deposit);
                    bankAccount.receiveDeposit(deposit);
                } else {
                    System.out.println("You only have " + this.wallet1.getBalance() + "€ in your wallet.");
                    this.depositMoney(bankAccount);
                }
            }else{
                System.out.println("Please choose a positive value.");
                this.depositMoney(bankAccount);
            }
        }
    }


    public void checkMoney(Bank bankAccount1){
        System.out.println(this.getName()+" has "+bankAccount1.checkBalance()+"€ in his bank account and "+this.getWallet().getBalance()+"€ in his wallet.");
    }
    public void goToRestaurant(Restaurant restaurant){

        restaurant.eatOut(this, this.myScanner);
    }

    public boolean getIsAGuest() {
        return isAGuest;
    }
    public Room getRoomTaken(){
        return roomTaken;
    }

    public void setRoomGuest(Room roomGuest, boolean status) {
        this.roomTaken = roomGuest;
        this.isAGuest = status;
    }

    public void setIsAGuest(boolean status){
        this.isAGuest = status;
    }

    public void goToHotel(Hotel hotel){
        hotel.sleepOut(this, this.myScanner);
    }

}
