package com.atm;

class Balance {
    private double balance;

    public Balance(){
    }

    public void addBalance(double amount){
        this.balance += amount;
    }
    public void lessBalance(double amount){
        this.balance -= amount;
    }
    public double getBalance(){
        return this.balance;
    }
}
