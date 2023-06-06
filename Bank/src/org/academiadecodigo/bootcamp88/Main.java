package org.academiadecodigo.bootcamp88;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args) {


        User user1 = new User("Luis",Math.round((Math.random()*10000)*100.0)/100.0);
        Bank bankAccount1 = user1.createBankAccount(user1.getWallet().getBalance());
        Restaurant restaurant = new Restaurant();
        Scanner myScanner = new Scanner(System.in);

        boolean quitBank=false;

        while (!quitBank) {
            System.out.println("Welcome " + user1.getName() + " what would you like to do?\n[W] Withdraw from bank\n[D] Deposit to bank\n[C] Check financials\n[R] Go to restaurant\n[Q] Quit");
            String userInput = myScanner.nextLine().toLowerCase();

            if(Pattern.matches("[a-zA-Z]", userInput)) {
                switch (userInput) {
                    case "w":
                        user1.withdrawalMoney(bankAccount1);
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
                    case "q":
                        quitBank = true;
                        break;
                    default:
                        System.out.println("Option not available.");
                        break;
                }
            }else{
                System.out.println("Invalid option. Try again.");
            }
        }


        user1.myScanner.close();
        myScanner.close();


    }
}
