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

    public boolean withdrawalWallet(double money){
        this.balance -=money;
        return true;
    }
    public void addToWallet(double money){
        this.balance += money;
    }

}
