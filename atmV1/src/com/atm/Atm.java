package com.atm;

import com.auth.Authentications;

class Atm {

    public static void main(String[] args){
        Account client1 = new Account("Joni","0812665", 2000);
        //client1.showBalance();

        Account client2 = new Account("Jeri","0812665", 1000);
        //sclient2.showBalance();

        Account client3 = new Account("Ucup","0812665", 2000);
        //client1.showBalance();

        Account client4 = new Account("Jeki","0812665", 1000);
        //sclient2.showBalance();

        Authentications main = new Authentications();

    }
}
