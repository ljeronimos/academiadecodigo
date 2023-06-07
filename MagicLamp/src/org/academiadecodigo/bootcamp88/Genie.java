package org.academiadecodigo.bootcamp88;

public class Genie {
    private int maxWishes;
    private int wishesLeft;

    public Genie(int maxWishes, int wishesToGrant){
        this.maxWishes = maxWishes;
        this.wishesLeft = wishesToGrant;
    }

    public int getMaxWishes(){
        return maxWishes;
    }

    public int getWishesLeft() {
        return wishesLeft;
    }

    public void setWishesLeft(int wishesLeft) {
        this.wishesLeft = wishesLeft;
    }

    public int grantWish(int numWishes){

        if (numWishes > 0) {
            System.out.println("*****Wish granted!*****");
            numWishes--;
            return numWishes;
        }
        return numWishes;
    }
}
