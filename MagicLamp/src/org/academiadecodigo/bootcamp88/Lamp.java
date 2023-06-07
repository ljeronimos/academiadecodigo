package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Lamp {

    private Genie[] lampOfGenies;
    private boolean demonExists=false;

    private DemonGenie demonGenie;

    public Lamp(int lampSize){
        this.lampOfGenies = new Genie[lampSize];
    }

    public void runArray(int cycle, int numRubs){
        if(numRubs % 2 == 0){
            this.lampOfGenies[cycle] = new FriendlyGenie((int)(Math.random()*10));
            Genie currentGenie = this.lampOfGenies[cycle];
            currentGenie.setWishesToGrant(currentGenie.grantWish(currentGenie.getWishesToGrant()));
            System.out.println("N wishes: " + currentGenie.getWishesToGrant());
        } else{
            this.lampOfGenies[cycle] = new GrumpyGenie((int)(Math.random()*10));
            Genie currentGenie = this.lampOfGenies[cycle];
            currentGenie.setWishesToGrant(currentGenie.grantWish(currentGenie.getWishesToGrant()));
            System.out.println("N wishes: " + currentGenie.getWishesToGrant());
        }
    }
    public void runDemon(){
        if(!demonExists){
            this.demonGenie = new DemonGenie((int)(Math.random()*10));
            this.demonGenie.grantWish(1);
            System.out.println("Demon: " + this.demonGenie.grantWish());
        } else{
            this.demonGenie.grantWish(1);
        }

    }

    public void resetLamp(){
        for (int i=0;i<lampOfGenies.length;i++){
            lampOfGenies[i]=null;
        }
    }
    public void rubLamp(int cycle, Scanner myScanner){

        int numRubs=(int)(Math.random()*10);

        if(this.lampOfGenies.length>cycle){
            this.runArray(cycle, numRubs);

            for(int i = 0; i < cycle; i++){
                int wishes = this.lampOfGenies[i].getWishesToGrant();
                this.lampOfGenies[i].setWishesToGrant(this.lampOfGenies[i].grantWish(wishes));
                System.out.println("N wishes do for: " + this.lampOfGenies[i].grantWish(wishes));
            }

        }else{
            this.runDemon();

            for(int i = 0; i < this.lampOfGenies.length; i++){
                int wishes = this.lampOfGenies[i].getWishesToGrant();
                this.lampOfGenies[i].setWishesToGrant(this.lampOfGenies[i].grantWish(wishes));
            }

            System.out.println("Recycle demon? [y] or [n]");
            String userInput = myScanner.nextLine().toLowerCase();

            if(Pattern.matches("[a-zA-Z]", userInput)) {
                switch (userInput) {
                    case "y":
                        this.resetLamp();
                        break;
                    case "n":
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
