package org.academiadecodigo.bootcamp88;

//Keep money
public class Wallet{

    private double balance;

    //CONSTRUCTOR
    public Wallet(double money){
        this.balance = 0.00;
        this.balance = money;
    }

    //GETTER
    public double getBalance(){
        return balance;
    }
    //SETTER
    public void setBalance(double money){
        this.balance += money;
    }


}
