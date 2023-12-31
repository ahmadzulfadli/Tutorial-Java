package com.atm;

import java.util.ArrayList;

class Transfer {

    private Account sender;
    private String nameReciving;
    private String numberAccountReciving;
    private double amountSent;


    public Transfer(Account accountSender, String numberAccountReciving,double inputAmountSent){
        this.sender = accountSender;
        this.numberAccountReciving = numberAccountReciving;
        this.amountSent = inputAmountSent;
    }
    public void executeTransfer(){
        System.out.println ("\n--------------------------");
        Account reciving = findAccount(numberAccountReciving);
        this.nameReciving = reciving.getAccountName();
        if(sender.getAccountBalance() > amountSent){
            this.display(reciving.getAccountName(), reciving.getAccountNumber(), amountSent);
            sender.balance.lessBalance(amountSent);
            reciving.balance.addBalance(amountSent);
            sender.addHistory(" ke rekening " + reciving.getAccountName(), amountSent);
            reciving.addHistory(" dari rekening "+ sender.getAccountName(), amountSent);
        }else {
            System.out.println("Teransaction failed, balance is not enough");
        }
        System.out.println ("--------------------------");
    }
    public String getNameReciving(){
        return nameReciving;
    }
    public Account findAccount(String numberAccount){
        for(Account accountReciving : sender.getArrayAccounts()){
            if (accountReciving.getAccountNumber().equals(numberAccount)){
                return accountReciving;
            }
        }
        return null;
    }
    public void display(String nameReciving, String numberReciving, double amountSent ){
        System.out.println("Name Reciving\t: " + nameReciving);
        System.out.println("Number Reciving\t: " + numberReciving);
        System.out.println("Amount Sent\t\t: " + amountSent);
    }
}
