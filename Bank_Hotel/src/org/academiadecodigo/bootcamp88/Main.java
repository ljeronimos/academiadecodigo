package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args) {

        //Program flags, variables and utilities
        Scanner myScanner = new Scanner(System.in);
        boolean quitMain=false;

        //Create User with random amount of money in wallet
        User user1 = new User("Luis",(Math.random()*10000),myScanner);
        //Create user's bank account with all the money in the wallet
        Bank bankAccount1 = user1.createBankAccount(user1.getWalletBalance());

        //Create Services
        Restaurant restaurant = new Restaurant();
        Hotel hotel = new Hotel(5);



        while (!quitMain) {
            System.out.println("Welcome " + user1.getName() + " what would you like to do?\n[W] Withdraw from bank\n[D] Deposit to bank\n[C] Check financials\n[R] Go to restaurant\n[H] Go to Hotel\n[Q] Quit");
            String userInput = myScanner.nextLine().toLowerCase();

            if(Pattern.matches("[a-zA-Z]", userInput)) {
                switch (userInput) {
                    case "w":
                        user1.withdrawMoney(bankAccount1);
                        break;
                    case "d":
                        user1.depositMoney(bankAccount1);
                        break;
                    case "c":
                        user1.checkMoney(bankAccount1);
                        break;
                    case "r":
                        user1.goToRestaurant(restaurant);
                        break;
                    case "h":
                        user1.goToHotel(hotel);
                        break;
                    case "q":
                        quitMain = true;
                        break;
                    default:
                        System.out.println("Option not available.");
                        break;
                }
            }else{
                System.out.println("Invalid option. Try again.");
            }
        }


        //user1.myScanner.close();
        myScanner.close();


    }
}
