package com.atm;

class WhitdrawCash {
    private Account account;
    private double amount;

    public WhitdrawCash(Account account,double inputAmount){
        this.account = account;
        this.amount = inputAmount;
    }

    public void executeTransaction(){
        System.out.println("\n-------------------------------------");
        if(this.account.balance.getBalance() > amount){
            this.account.balance.lessBalance(amount);
            this.display(this.account.getAccountName(), this.account.getAccountBalance(), amount);
        }else {
            System.out.println("Teransaction failed, balance is not enough");
        }
        System.out.println("-------------------------------------");
    }
    public void display(String name,double balance, double amount){
        System.out.println("Teransaction succsess");
        System.out.println("Name \t\t: " + name);
        System.out.println("Balance\t\t: " + balance);
        System.out.println("Amount Withdraw Cash\t: " + amount);
    }
}
