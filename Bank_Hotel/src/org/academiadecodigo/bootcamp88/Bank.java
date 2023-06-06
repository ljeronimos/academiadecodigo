package org.academiadecodigo.bootcamp88;

//Keep money
//Allow deposits
//Allow withdrawals
public class Bank {

    private double balance;

    //CONSTRUCTOR - takes in money
    public Bank(User user1, double money){
        this.balance = money;

        System.out.println("User "+user1.getName()+" has a bank account with "+this.checkBalance()+"€.");
    }
    //GETTER
    public double checkBalance(){
        return this.balance;
    }

    public boolean withdrawalRequest(double money){

        if(this.balance>=money){
            this.balance-=money;
            System.out.println("Withdrawal successful.");
            return true;
        }else {
            System.out.println("Not enough funds.");
            return false;
        }
    }

    //TO-DO - Create savings account (multiple)
    public void receiveDeposit(double money){
        this.balance+=money;
        System.out.println("Deposit successful.");
    }




}
