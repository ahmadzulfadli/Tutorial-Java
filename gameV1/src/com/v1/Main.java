package com.v1;

//class Player
class Player{
    String nama;
    double healt;
    //int level;
    Weapon weapon;
    Armor armor;

    //constructor
    Player(String inputNama, double inputHealt){
        this.nama = inputNama;
        this.healt = inputHealt;
    }

    //fungsi setWeapon
    void equipWeapon(Weapon inputWeapon){
        this.weapon = inputWeapon;
    }

    // fusngsi setArmor
    void equipArmor(Armor inputArmor){
        this.armor = inputArmor;
    }

    //fungsi menyerang
    void attack(Player opponent){
        double attackPower = this.weapon.attackPower;

        System.out.println(this.nama + " attacking " + opponent.nama + " with power " + attackPower);
        opponent.defense(attackPower);
    }

    //fungsi bertahan
    void defense(double attackPower){
        double demage;
        if(this.armor.defencePower < attackPower){
            demage = attackPower - this.armor.defencePower;
        }else{
            demage = 0;
        }
        this.healt -= demage;
        System.out.println(this.nama + " gets demages " + demage);
    }

    //fungsi display
    void display(){
        System.out.println("\nNama  : " + this.nama);
        System.out.println("Healt : " + this.healt);
        this.weapon.display();
        this.armor.display();
    }
}

//class Weapon
class Weapon{
    String nama;
    double attackPower;

    Weapon(String inputNama, double inputAttackPower){
        this.nama = inputNama;
        this.attackPower = inputAttackPower;
    }

    void display(){
        System.out.println("Weapon : " + this.nama + ", Attack Power : " + this.attackPower);
    }

}

//class Armor
class Armor{
    String nama;
    double defencePower;

    Armor(String inputNama, double inputDefencePower){
        this.nama = inputNama;
        this.defencePower = inputDefencePower;
    }

    void display(){
        System.out.println("Armor : " + this.nama + ", Defence Power : " + this.defencePower);
    }
}

public class Main {
    public static void main(String[] args){

        // Player 1
        Player player1 = new Player("Ucup", 100);
        Weapon pedang = new Weapon("Pedang", 20);
        Armor bajuBesi = new Armor("Baju Besi", 15);
        player1.equipWeapon(pedang);
        player1.equipArmor(bajuBesi);
        player1.display();

        // Player 2
        Player player2 = new Player("Joko", 100);
        Weapon bambuRuncing = new Weapon("Bambu Runcing", 19);
        Armor rompi = new Armor("Rompi", 12);
        player2.equipWeapon(bambuRuncing);
        player2.equipArmor(rompi);
        player2.display();

        //Pertempuran
        System.out.println("\nPertempuran");
        System.out.println("Episode-1");
        player1.attack(player2);
        player1.display();
        player2.display();

        System.out.println("\nEpisode-2");
        player2.attack(player1);
        player1.display();
        player2.display();
    }
}