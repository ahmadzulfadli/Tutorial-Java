package com.auth;

import java.util.Scanner;

public class Authentications {
    private int proses;

    Scanner keyboard = new Scanner(System.in);

    public Authentications(){
        auth();
    }

    public void auth(){
        System.out.println("------------ATM-----------");
        System.out.println("       SELAMAT DATANG     ");
        System.out.println("          BANK ABC        ");
        System.out.println("                          ");
        System.out.println("--------------------------");

        do{
            System.out.println("SILAHKAN INPUTKAN NAMA ANDA");
            System.out.print("-> ");
            String userLogin = keyboard.nextLine();
            System.out.println ("SILAHKAN INPUTKAN PIN ANDA");
            System.out.print   ("-> ");
            int pinLogin = keyboard.nextInt();

            if(userLogin.equals("jeki") && pinLogin == 1234){
                System.out.println ("\n--------------------------");
                System.out.println ("MENU TRANSAKSI ANDA");
                System.out.println ("A/n NAMA");
                System.out.println ("SILAHKAN PILIH OPTION");

                System.out.println  ("-> 1. INFO SALDO");
                System.out.println  ("-> 2. TRANSFER");
                System.out.println  ("-> 3. PENARIKAN");
                System.out.println  ("-> 4. TRANSAKSI LAIN");
                System.out.println  ("-> 5. KELUAR");
                System.out.println ("--------------------------");

                System.out.print ("OPTION -> ");
                int option = keyboard.nextInt();

                switch (option){
                    case 1:
                        getSaldo();
                        break;
                    case 2:
                        transfer();
                        break;
                    case  3:
                        withdrawCash();
                        break;
                    case 4:
                        history();
                        break;
                    default:
                        System.out.println("Terimakasih telah menggunakan bank Pasaman");
                }
            }else{
                proses ++;
            }
        }while(proses >3);

    }
    private void getSaldo(){
        System.out.println ("================================");
        System.out.println ("SALDO ANDA SAAT INI : ");
        System.out.println ("================================");
    }
    private void transfer(){
        System.out.println ("=================================");
        System.out.println ("TRANSFER DANA KE BANK LAIN ");
        System.out.println ("=================================");

        System.out.print( "Masukan No Rekening     : " );
        String no_rekening = keyboard.nextLine();
        System.out.print( "Masukan Jumlah Transfer : " );
        double jumlah = keyboard.nextDouble();
    }
    private void withdrawCash(){
        System.out.println ("=================================");
        System.out.println ("PENARIKAN UANG ");
        System.out.println ("=================================");
        System.out.print ("Masukan jumlah uang >> ");
        double penarikan = keyboard.nextInt();
    }
    private void history(){
        System.out.println ("=================================");
        System.out.println ("HISTORY TRANSAKSI");
        System.out.println ("=================================");
        System.out.println ("Transksi Terakhir");
        System.out.println ("Penarikan Uang :");
        System.out.println ("Trasfer Uang   :");
        System.out.println ("Saldo Akhir    :");
    }
}


