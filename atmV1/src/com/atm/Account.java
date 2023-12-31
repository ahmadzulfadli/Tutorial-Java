package com.atm;

import java.util.ArrayList;

public class Account {
    private static int countAccount;
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    private String name;
    private String phoneNumber;
    private String accountNumber;
    private boolean isFrozen;
    Balance balance = new Balance();

    private ArrayList<String> transactionHistory = new ArrayList<String>();

    //constructor
    public Account(String inputName, String inputPhoneNumber, double inputBalance){
        Account.countAccount++;
        this.name = inputName;
        this.phoneNumber = inputPhoneNumber;
        this.accountNumber = setAccountNumber();
        this.isFrozen = setIsFrozen();
        this.balance.addBalance(inputBalance);
        Account.accounts.add(this);
    }
    //overloading constructor
    public Account(){}

    //---------------------method----------------------------------------
    private boolean setIsFrozen(){
        return false;
    }
    private String setAccountNumber() {
        return "100" + Account.countAccount;
    }
    public String getAccountName(){
        return this.name;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
    public ArrayList<Account> getArrayAccounts(){
        return Account.accounts;
    }
    public double getAccountBalance(){
        return this.balance.getBalance();
    }
    public ArrayList<String> getHistory(){
        return this.transactionHistory;
    }
    public void addHistory(String name, double amount){
        this.transactionHistory.add("Transfer " + name + ", dengan jumlah " + amount);
    }

    //------------------------------Transaksi------------------------------------
    public void transfer(String accountNumber, double amountSent){
        Transfer transfer = new Transfer(this, accountNumber, amountSent);
        transfer.executeTransfer();
        this.showBalance();

    }
    public void whithdrawCash(double amount){
        WhitdrawCash whitdrawCash = new WhitdrawCash(this, amount);
        whitdrawCash.executeTransaction();
        this.transactionHistory.add("Penarikan sebesar " + amount);
    }
    public void showBalance(){
        System.out.println("\nNama\t\t\t: " + this.name);
        System.out.println("Account Number\t: "+this.accountNumber);
        System.out.println("Balance\t\t\t: " + this.balance.getBalance());
    }
}
