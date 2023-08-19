package com.v2;

class Player{
    private String name;
    private int baseHealt;
    private int baseAttack;
    private int incrementHealt;
    private int incrementAttack;
    private int level;
    private int totalDemage;
    private boolean isAlive;

    private Weapon weapon;
    private Armor armor;

    public Player(String name){
        this.name = name;
        this.baseHealt = 100;
        this.baseAttack =100;
        this.incrementHealt = 20;
        this.incrementAttack = 20;
        this.level = 1;
        this.isAlive = true;
    }
    public String getName(){
        return this.name;
    }
    public boolean getIsAlive(){
        return this.isAlive;
    }
    public int getHealt(){
        return this.maxHealth()-this.totalDemage;
    }
    public void display(){
        System.out.println("Name\t: " + this.name);
        System.out.println("Level\t: " + this.level);
        System.out.println("Health\t: " + this.getHealt() + "/" + this.maxHealth());
        System.out.println("Attack\t: " + this.getAttackPower());
        System.out.println("Alive\t: " + this.isAlive + "\n");
    }
    public void attack(Player opponent){
        int demage = getAttackPower();
        System.out.println(this.name + " attacking  " + opponent.name + " with " + demage + "hp");
        opponent.defence(demage);
        this.levelUp();
    }
    public void defence(int demage){
        int defencePower = this.armor.getDefencePower();
        int deltaDemage;

        System.out.println(this.name + " defence power = " + defencePower);
        if (defencePower <= demage){
            deltaDemage = demage - defencePower;
        }else{
            deltaDemage = 0;
        }

        System.out.println("Demage earned = " + deltaDemage + "\n");

        this.totalDemage += deltaDemage;

        if(this.getHealt() <= 0 ){
            this.isAlive = false;
            this.totalDemage = this.maxHealth();
            this.isAlive = false;
        }
        this.display();
    }
    private int getAttackPower(){
        return this.baseAttack + this.level * this.incrementAttack + this.weapon.getAttack();
    }
    private void levelUp(){
        this.level++;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public void setArmor(Armor armor){
        this.armor = armor;
    }
    public int maxHealth(){
        return this.baseHealt + this.level * this.incrementHealt + this.armor.getAddHealth();
    }
}
class Weapon{
    private String name;
    private int attackPower;

    public Weapon(String name, int attack){
        this.name = name;
        this.attackPower = attack;
    }
    public int getAttack(){
        return this.attackPower;
    }
}
class Armor{
    private String name;
    private int strength;
    private int health;

    public Armor(String name, int strength, int health){
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    public int getDefencePower(){
        return this.strength * 10 + this.health;
    }
    public int getAddHealth(){
        return this.strength * 2;
    }
}

public class Main {
    public static  void main(String[] args){

        Weapon weapon1 = new Weapon("Pedang",10);
        Weapon weapon2 = new Weapon("Pisau",10);

        Armor armor1 = new Armor("Tameng",7,100);

        Player player1 = new Player("Joko");
        player1.setWeapon(weapon1);
        player1.setArmor(armor1);

        Player player2 = new Player("Joni");
        player2.setWeapon(weapon2);
        player2.setArmor(armor1);

        player1.display();
        player2.display();

        boolean isFirstAttack = true;
        while (player1.getIsAlive() && player2.getIsAlive()){
            if(isFirstAttack){
                System.out.println("---------Game Play---------");
                isFirstAttack =false;
            }
            player1.attack(player2);
            player1.attack(player2);
            if(!player2.getIsAlive()){
                System.out.println(player2.getName() + " is defeated by " + player1.getName());
                System.out.println("---------Game Over---------");
                player1.display();
                player2.display();
                break;

            }
            player2.attack(player1);
            player2.attack(player1);
            if (!player1.getIsAlive()){
                System.out.println(player1.getName() + " is defeated by " + player2.getName());
                System.out.println("---------Game Over---------");
                player1.display();
                player2.display();
                break;
            }
        }
    }
}