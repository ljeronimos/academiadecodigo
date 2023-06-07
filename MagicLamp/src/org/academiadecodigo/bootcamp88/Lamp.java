package org.academiadecodigo.bootcamp88;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Lamp {

    private Genie[] lampOfGenies;
    private int lampSize;
    private boolean demonExists;
    private int currentCycle;
    private DemonGenie demonGenie;

    public Lamp(int lampSize){
        this.lampOfGenies = new Genie[lampSize];
        this.lampSize = lampSize;
        this.demonExists=false;
        this.currentCycle=0;
    }

    public void createGenie(int genieIndex, int numRubs){
        if(numRubs % 2 == 0){
            //In case it rubs an even number of times - Friendly Genie
            this.lampOfGenies[genieIndex] = new FriendlyGenie((int)(Math.random()*10));

            Genie currentGenie = this.lampOfGenies[genieIndex];
            currentGenie.setWishesLeft(currentGenie.grantWish(currentGenie.getWishesLeft()));
        } else{
            //In case it rubs an odd number of times - Grumpy Genie
            this.lampOfGenies[genieIndex] = new GrumpyGenie((int)(Math.random()*10));
            Genie currentGenie = this.lampOfGenies[genieIndex];

            currentGenie.setWishesLeft(currentGenie.grantWish(currentGenie.getWishesLeft()));
        }
    }
    public void runDemon(){
        if(!demonExists){
            this.demonGenie = new DemonGenie((int)(Math.random()*10));
            this.demonExists = true;
            this.demonGenie.grantWish();
        } else{
            this.demonGenie.grantWish();
        }
    }

    public void resetLamp(){
        for (int i=0;i<lampOfGenies.length;i++){
            lampOfGenies[i]=null;
        }
        this.demonExists=false;
        this.currentCycle=0;
        this.demonGenie=null;
    }
    public void checkLamp(){
        for (int i=0;i<this.lampSize;i++){
            if(lampOfGenies[i]==null){
                break;
            }
            System.out.println("*****\n"
                    +(i+1)+" "
                    +(lampOfGenies[i] instanceof FriendlyGenie?"Friendly Genie":"Grumpy Genie")
                    +" has a maximum of "+lampOfGenies[i].getMaxWishes()
                    +" and can still grant "+lampOfGenies[i].getWishesLeft()+" wishes"
                    +"\n*****");
        }
    }
    public void rubLamp(Scanner myScanner){

        int numRubs=(int)(Math.random()*10);

        if(this.lampOfGenies.length>this.currentCycle){
            this.createGenie(this.currentCycle, numRubs);

            //Grants wishes from genies already created (that have wishes left to grant)
            for(int i = 0; i < this.currentCycle; i++){
                int wishes = this.lampOfGenies[i].getWishesLeft();
                this.lampOfGenies[i].setWishesLeft(this.lampOfGenies[i].grantWish(wishes));
            }
            this.currentCycle++;
        }else{
            this.runDemon();

            //Grants wishes from genies already created (that have wishes left to grant)
            for(int i = 0; i < this.lampOfGenies.length; i++){
                int wishes = this.lampOfGenies[i].getWishesLeft();
                this.lampOfGenies[i].setWishesLeft(this.lampOfGenies[i].grantWish(wishes));
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
                        System.out.println("Invalid option.");
                        break;
                }
            }
        }
    }
}
