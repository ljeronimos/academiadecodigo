package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;


public class User {

    //User properties
    private final String name;
    private final Wallet wallet1;
    private boolean isAGuest;
    private int roomNumber;

    //Program flags and utilities
    Scanner myScanner;

    //CONSTRUCTOR
    public User(String name, double money, Scanner myScanner){
        this.name = name;
        this.wallet1 = new Wallet(money);
        this.isAGuest = false;
        this.myScanner = myScanner;
    }

    //GETTERs & SETTERs
    public String getName(){return this.name;}
    public int getRoomNumber(){return this.roomNumber;}
    public double getWalletBalance(){
        return this.wallet1.getBalance();
    }
    public boolean getIsAGuest() {return isAGuest;}
    public void setIsAGuest(boolean status){
        this.isAGuest = status;
    }
    public void setRoomNumber(int room) {this.roomNumber = room;}


    //METHODS
    //Creates bank account
    public Bank createBankAccount(double money){
        this.wallet1.withdrawalWallet(money);
        return new Bank(this, money);
    }

    //Pay for services from money in wallet
    public boolean payService(double cost){
        if(wallet1.getBalance()>=cost){
            return wallet1.withdrawalWallet(cost);
        }else{
            System.out.println("You only have "+Math.round(wallet1.getBalance()*100.0)/100.0+"€ in your wallet.");
            return false;
        }
    }

    //Asks bank to withdraw money
    public void withdrawMoney(Bank bankAccount){

        System.out.println("How much money do you want to withdrawal?");
        String userInput = myScanner.nextLine();

        if(Pattern.matches("^[0-9]*$", userInput)) {
            double money = Double.parseDouble(userInput);
            if (money != 0) {
                if (money > 0) {
                    if (bankAccount.withdrawalRequest(money)) {
                        this.wallet1.addToWallet(money);
                    } else {
                        this.withdrawMoney(bankAccount);
                    }
                } else {
                    System.out.println("Please choose a positive value.");
                    this.withdrawMoney(bankAccount);
                }

            }
        } else {
            System.out.println("Invalid value.");
            withdrawMoney(bankAccount);
        }
    }

    //Deposits money in bank
    public void depositMoney(Bank bankAccount) {

        System.out.println("How much money do you want to deposit?");
        String userInput = myScanner.nextLine();

        if (Pattern.matches("^[0-9]*$", userInput)) {
            double money = Double.parseDouble(userInput);

            if (money != 0) {
                if (money > 0) {
                    if (this.wallet1.getBalance() >= money) {
                        this.wallet1.withdrawalWallet(money);
                        bankAccount.receiveDeposit(money);
                    } else {
                        System.out.println("You only have " + Math.round(this.wallet1.getBalance() * 100.0) / 100.0 + "€ in your wallet.");
                        this.depositMoney(bankAccount);
                    }
                } else {
                    System.out.println("Please choose a positive value.");
                    this.depositMoney(bankAccount);
                }
            }
        } else{
            System.out.println("Invalid value");
            depositMoney(bankAccount);
        }
    }

    //Prints bank and wallet balances
    public void checkMoney(Bank bankAccount1){
        System.out.println(this.getName()+" has "+Math.round(bankAccount1.getBalance()*100.0)/100.0+"€ in his bank account and "+Math.round(this.wallet1.getBalance()*100.0)/100.0+"€ in his wallet.");
    }

    //Launches Restaurant service
    public void goToRestaurant(Restaurant restaurant){
        restaurant.eatOut(this, this.myScanner);
    }
    //Launches Hotel service
    public void goToHotel(Hotel hotel){
        hotel.sleepOut(this, this.myScanner);
    }

}