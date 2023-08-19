package com.example;

class Mahasiswa{
    String nama;
    String NIM;

    //constructor
    Mahasiswa(String inputNama, String inputNIM){
        this.nama = inputNama;
        this.NIM = inputNIM;
    }
    void show(){
        System.out.println("Nama : " + this.nama);
        System.out.println("NIM  : " + this.NIM);
    }

    //fungsi setter
    void setNama(String inputNama){
        this.nama = inputNama;
    }
    void setNIM(String inputNIM){
        this.NIM = inputNIM;
    }

    //fungsi getter
    String getNama(){
        return this.nama;
    }
    String getNIM(){
        return this.NIM;
    }

    //fungsi dengan return dan parameter
    String pesanInfo (String pesan){
        return pesan + " juga, nama saya adalah " + this.nama;
    }
}

public class Main {
    public static void main(String[] args){
        Mahasiswa mahasiswa1 = new Mahasiswa("Joko", "122314");
        mahasiswa1.show();

        mahasiswa1.setNama("Joni");
        mahasiswa1.setNIM("1246");
        System.out.println("Nama : " + mahasiswa1.getNama());
        System.out.println("NIM  : " + mahasiswa1.getNIM());

        String pesan = mahasiswa1.pesanInfo("Hallo");
        System.out.println(pesan);
    }
}
