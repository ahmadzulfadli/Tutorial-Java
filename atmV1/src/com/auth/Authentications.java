package com.auth;

import com.atm.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class Authentications {
    private int proses;
    private boolean transaction = true;

    private Account account = new Account();
    private Account accountLogin;

    Scanner keyboard = new Scanner(System.in);

    public Authentications(){
        auth();
    }

    public void auth(){
        try {
            System.out.println("------------ATM-----------");
            System.out.println("       SELAMAT DATANG     ");
            System.out.println("        BANK PASAMAN      ");
            System.out.println("                          ");
            System.out.println("--------------------------");

            System.out.println ("\n--------------------------");
            System.out.println("SILAHKAN INPUTKAN NAMA ANDA");
            System.out.print("-> ");
            String userLogin = keyboard.next();

            System.out.println ("SILAHKAN INPUTKAN PIN ANDA");
            System.out.print   ("-> ");
            int pinInputLogin = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println ("--------------------------");

            String pinLogin = String.valueOf(pinInputLogin);

            accountLogin= findAccount(userLogin);

            if(accountLogin != null && pinLogin.equals(accountLogin.getAccountNumber())){
                loopMain();
            }else{
                proses ++;
            }
        } catch (Exception e){
            auth();
        }
    }
    private void loopMain(){
        System.out.println ("\n--------------------------");
        System.out.println ("MENU TRANSAKSI ANDA");
        System.out.println ("A/n NAMA");
        System.out.println ("SILAHKAN PILIH OPTION");

        System.out.println  ("-> 1. INFO SALDO");
        System.out.println  ("-> 2. TRANSFER");
        System.out.println  ("-> 3. PENARIKAN");
        System.out.println  ("-> 4. HISTORY TRANSACTION");
        System.out.println  ("-> 5. KELUAR");
        System.out.println ("--------------------------");

        System.out.print("OPTION -> ");
        int option = keyboard.nextInt();

        switch (option){
            case 1:
                getSaldo();
                isLoopMain();
                break;
            case 2:
                transfer();
                isLoopMain();
                break;
            case  3:
                withdrawCash();
                isLoopMain();
                break;
            case 4:
                history();
                isLoopMain();
                break;
            default:
                System.out.println("Terimakasih telah menggunakan bank Pasaman");
                auth();
        }
    }
    private void isLoopMain(){
        System.out.println("APAKAH KAMU INGIN TRANSAKSI LAGI");
        System.out.print("y/n -> ");
        String isTransaction = keyboard.next();

        transaction = isTransaction.equalsIgnoreCase("y");

        System.out.println(transaction);
        if (transaction){
            loopMain();
        }else {
            auth();
        }
    }
    private void getSaldo(){
        System.out.println ("\n--------------------------");
        accountLogin.showBalance();
        System.out.println ("--------------------------");
    }
    private void transfer(){
        try {
            System.out.println ("\n--------------------------");
            System.out.println("INPUT NOMOR REKENING TUJUAN");
            System.out.print("-> ");
            int inputNoRek = keyboard.nextInt();
            String no_rekening = String.valueOf(inputNoRek);

            System.out.println("INPUT JUMLAH TRANSFER");
            System.out.print("-> ");
            double jumlah = keyboard.nextDouble();
            System.out.println ("--------------------------");

            accountLogin.transfer(no_rekening,jumlah);
        } catch (Exception e) {
            isLoopMain();
        }

    }
    private void withdrawCash(){
        try {
            System.out.println ("\n--------------------------");
            System.out.print ("Masukan jumlah uang >> ");
            double penarikan = keyboard.nextInt();
            accountLogin.whithdrawCash(penarikan);
            System.out.println ("--------------------------");
        } catch (Exception e) {
            isLoopMain();
        }

    }
    private void history(){
        try {
            System.out.println ("\n--------------------------");
            ArrayList<String> history = accountLogin.getHistory();

            int length = history.size();
            int startIndex = Math.max(length - 5, 0); // Indeks elemen pertama yang ingin ditampilkan
            for (int i = length - 1; i >= startIndex; i--) {
                System.out.println(history.get(i));
            }
            System.out.println ("--------------------------");
        }catch (Exception e) {
            isLoopMain();
        }

    }
    public Account findAccount(String nameInput){
        for(Account accountReciving : account.getArrayAccounts()){
            if (accountReciving.getAccountName().equals(nameInput)){
                return accountReciving;
            }
        }
        return null;
    }
}


