package org.academiadecodigo.bootcamp88;

public class DemonGenie extends Genie{

    public DemonGenie(int maxWishes) {
        super(maxWishes,Integer.MAX_VALUE);
    }

    public boolean grantWish(){
        System.out.println("Wish granted!");
        return true;
    }
}
