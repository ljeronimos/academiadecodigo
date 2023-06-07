package org.academiadecodigo.bootcamp88;

public class Genie {
    private int maxWishes;
    private int wishesToGrant;

    public Genie(int maxWishes, int wishesToGrant){
        this.maxWishes = maxWishes;
        this.wishesToGrant = wishesToGrant;
    }

    public int getMaxWishes(){
        return maxWishes;
    }

    public int getWishesToGrant() {
        return wishesToGrant;
    }

    public void setWishesToGrant(int wishesToGrant) {
        this.wishesToGrant = wishesToGrant;
    }

    public int grantWish(int numWishes){

        if (numWishes > 0) {
            System.out.println("Wish granted!");
            return numWishes--;
        }
        return numWishes;
    }
}
