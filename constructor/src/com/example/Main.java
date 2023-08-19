package com.example;
class Mahasiswa{
    String nama;
    String NIM;
    int umur;

    Mahasiswa(String inputNama, String inputNIM, int inputUmur){
        nama = inputNama;
        NIM = inputNIM;
        umur = inputUmur;

        System.out.println("Nama : " + nama);
        System.out.println("NIM : " + NIM);
        System.out.println("Umur : " + umur);
    }
}
public class Main {
    public static void main(String[] args) throws Exception{
        Mahasiswa mahasiswa1 = new Mahasiswa("Joko","212121",21);
        Mahasiswa mahasiswa2 = new Mahasiswa("Joni", "131223", 23);
    }
}
