package com.v1_5;

//class Player
class Player {
    //data member
    String nama;
    double healt;
    Weapon weapon;
    Armor armor;

    //method
    //constructor
    Player(String inputNama, double inputHealt){
        this.nama = inputNama;
        this.healt = inputHealt;
    }
    //setWeapon
    void setWeapon(Weapon inputWeapon){
        this.weapon = inputWeapon;
    }
    //SetArmor
    void setArmor(Armor inputArmor){
        this.armor = inputArmor;
    }
    //attack
    void attack(Player opponent){
        double attackPower = this.weapon.attackPower;
        double defencePower = opponent.armor.defencePower;
        System.out.println(this.nama + " menyerang " + opponent.nama + " dengan attack power " + attackPower);
        System.out.println(opponent.nama + " bertahan dengan defence power " + defencePower);
        this.defence(attackPower,defencePower);
    }
    //defence
    void defence(double attackPower, double defencePower){
        double demages;
        if (attackPower > defencePower){
            demages = attackPower -defencePower;
        }else{
            demages =0;
        }
        this.healt -= demages;
        System.out.println("Healt " + this.nama + " berkurang " + demages + " hp");
    }
    //display
    void display(){
        System.out.println("\nNama\t: " + this.nama);
        System.out.println("Health\t: " + this.healt);
        System.out.println("Senjata\t: " + this.weapon.nama);
        System.out.println("Pertahanan\t: " + this.armor.nama);
    }
}

//class Weapon
class Weapon {
    //data member
    String nama;
    double attackPower;

    //method
    //constructor
    Weapon(String inputNama, double inputAttackPower){
        this.nama = inputNama;
        this.attackPower = inputAttackPower;
    }
    //display
    void display(){
        System.out.println("Jenis Senjata\t: " + this.nama);
        System.out.println("Attack Power\t: " + this.attackPower);
    }
}

//class Armor
class Armor {
    //data member
    String nama;
    double defencePower;

    //method
    //constructor
    Armor(String inputNama, double inputDefencePower){
        this.nama = inputNama;
        this.defencePower = inputDefencePower;
    }
    //display
    void display(){
        System.out.println("Jenis Pertahanan\t: " + this.nama);
        System.out.println("Defence Power\t: " + this.defencePower);
    }

}

//class Main
public class Main {
    public static void main(String[] args){

        //Weapon
        Weapon pedang = new Weapon("Pedang", 10);
        Weapon pistol = new Weapon("Pistol", 12);

        //Armor
        Armor tameng = new Armor("Tameng",5);
        Armor rompi = new Armor("Rompi", 5);

        //player1
        Player player1 = new Player("Dadang",100);
        player1.setWeapon(pedang);
        player1.setArmor(tameng);
        player1.display();

        //player2
        Player player2 = new Player("Dudung",100);
        player2.setWeapon(pistol);
        player2.setArmor(rompi);
        player2.display();

        //Pertempuran
        System.out.println("\nPertempuran");
        System.out.println("Episode-1");
        player1.attack(player2);
        player1.display();
        player2.display();

    }
}
