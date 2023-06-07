package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Lamp lamp = new Lamp(5);

        boolean finished = false;
        int cycle = 0;

        Scanner myScanner = new Scanner(System.in);

        while(!finished){
            System.out.println("Rub lamp? [y] or [n]");
            String userInput = myScanner.nextLine().toLowerCase();

            if(Pattern.matches("[a-zA-Z]", userInput)) {
                switch (userInput) {
                    case "y":
                        lamp.rubLamp(cycle, myScanner);
                        break;
                    case "n":
                        finished = true;
                        break;
                    default:
                        break;
                }
            }
            cycle++;
            System.out.println("Ciclo: " + cycle);
        }

        myScanner.close();

    }
}
