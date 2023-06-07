package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        int maxLamps = 3;

        Lamp[] lampArray = new Lamp[maxLamps];
        //lampArray[0] = new Lamp(5);

        int lampCount = 0;

        boolean finished = false;

        Scanner myScanner = new Scanner(System.in);

        while(!finished){
            System.out.println("[R] Rub lamp \n[C] Check Lamps \n[N] Create New lamp\n[Q] Quit");
            String userInput = myScanner.nextLine().toLowerCase();

            if(Pattern.matches("[a-zA-Z]", userInput)) {
                switch (userInput) {
                    case "r":
                        if(lampCount==0){
                            System.out.println("There are no lamps to rub. Create a lamp first!");
                        }else if(lampCount>1){
                            System.out.println("Which lamp?");
                            for (int i = 0; i < lampCount; i++) {
                                System.out.print("["+(i+1)+"] ");
                            }
                            System.out.println("");
                            String userInput2 = myScanner.nextLine().toLowerCase();

                            if (Pattern.matches("^[1-9]*$", userInput2)) {
                                int lamp = Integer.parseInt(userInput2);
                                if(lamp>lampCount){
                                    System.out.println("That lamp does not exist.");
                                }else {
                                    lampArray[lamp - 1].rubLamp(myScanner);
                                }
                            }
                        }else {
                            lampArray[lampCount - 1].rubLamp(myScanner);
                        }
                        break;
                    case "c":
                        if(lampCount==0){
                            System.out.println("There are no lamps to check. Create a lamp first!");
                        }else if(lampCount>1){
                            System.out.println("Which lamp?");
                            System.out.print("[0 - all] ");
                            for (int i = 0; i < lampCount; i++) {
                                System.out.print("["+(i+1)+"] ");
                            }
                            System.out.println("");
                            String userInput2 = myScanner.nextLine().toLowerCase();

                            if (Pattern.matches("^[0-9]*$", userInput2)) {
                                int lamp = Integer.parseInt(userInput2);
                                if(lamp>lampCount){
                                    System.out.println("That lamp does not exist.");
                                } else if (lamp == 0) {
                                    for(int i=0;i<lampCount;i++){
                                        System.out.println("---- Lamp "+(i+1)+" ----");
                                        System.out.println("Capacity: "+lampArray[i].getLampSize()+" Remaining wishes: "+lampArray[i].getRemainingWishesInLamp()+" Recharged times: "+lampArray[i].getResetTimes());
                                        lampArray[i].checkLamp();
                                    }
                                } else {
                                    System.out.println("---- Lamp "+(lamp-1)+" ----");
                                    System.out.println("Capacity: "+lampArray[lamp-1].getLampSize()+" Remaining wishes: "+lampArray[lamp-1].getRemainingWishesInLamp()+" Recharged times: "+lampArray[lamp-1].getResetTimes());
                                    lampArray[lamp - 1].checkLamp();
                                }
                            }
                        }else {
                            System.out.println("---- Lamp 1 ----");
                            System.out.println("Capacity: "+lampArray[lampCount-1].getLampSize()+" Remaining wishes: "+lampArray[lampCount-1].getRemainingWishesInLamp()+" Recharged times: "+lampArray[lampCount-1].getResetTimes());
                            lampArray[lampCount - 1].checkLamp();
                        }
                        break;
                    case "n":
                        if(lampCount<maxLamps){
                            lampArray[lampCount] = new Lamp((int)(Math.random()*5));
                            lampCount++;
                        }else{
                            System.out.println("Reached maximum number of lamps to create: "+maxLamps+"!");
                        }
                        break;
                    case "q":
                        finished = true;
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }

        }

        myScanner.close();

    }
}
