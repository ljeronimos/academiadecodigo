package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Restaurant {

    double currentCheck = 0;
    boolean doneEating=false;
    public void eatOut(User user1, Scanner myScanner){

        //if(user1.getWallet().getBalance()>=currentCheck && user1.getWallet().getBalance()>=13) {
        if(user1.getWalletBalance()>=currentCheck && user1.getWalletBalance()>=13) {

            while(!doneEating) {
                System.out.println("What would you like to eat?\n[1] Sushi 13€\n[2] Sirloin Steak 22€\n[3] Bacalhau com Natas 16€\n[0] Ask for the bill");
                String userInput = myScanner.nextLine();

                if(Pattern.matches("^[0-3]*$", userInput)) {
                    switch (Integer.parseInt(userInput)) {
                        case 1:
                            System.out.println("You chose Sushi.");
                            if (user1.getWalletBalance() >= 13) {
                                currentCheck += 13;
                                System.out.println("Hmmmm that was delicious!");
                            } else
                                System.out.println("You cannot afford this dish.");
                            break;
                        case 2:
                            System.out.println("You chose Sirloin Steak.");
                            if (user1.getWalletBalance() >= 22) {
                                currentCheck += 22;
                                System.out.println("Hmmmm that was delicious!");
                            } else
                                System.out.println("You cannot afford this dish.");
                            break;
                        case 3:
                            System.out.println("You chose Bacalhau com Natas.");
                            if (user1.getWalletBalance() >= 16) {
                                currentCheck += 16;
                                System.out.println("Hmmmm that was delicious!");
                            } else
                                System.out.println("You cannot afford this dish.");
                            break;
                        case 0:
                            System.out.println("Here's your bill: " + Math.round(currentCheck*100.0)/100.0 + "€");
                            user1.payService(currentCheck);
                            doneEating = true;
                            break;
                        default:
                            System.out.println("Not on the menu. Try a different restaurant!");
                            break;
                    }

                    if (user1.getWalletBalance() < currentCheck && user1.getWalletBalance() < 13) {
                        System.out.println("You cannot afford anymore dishes at this restaurant!");
                        System.out.println("Here's your bill: " + Math.round(currentCheck*100.0)/100.0 + "€");
                        user1.payService(currentCheck);
                        doneEating = true;
                    }
                }else{
                    System.out.println("Invalid option. Try again.");
                }
            }
        }else {
            System.out.println("You cannot afford any dishes at this restaurant!");
        }
    }
}
