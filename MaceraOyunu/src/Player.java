import java.util.Scanner;

public class Player {
   private int damage;
   private int healthy;
   private int orjinalHealthy;
   private int money;
   private String name;
   private String charName;
   private Inventory inventory;
    private Scanner input=new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory=new Inventory();
    }
    public void selectChar(){


        GameChar[] gameChars={new Samurai(),new Archer(), new Knight(),new Test()};
        System.out.println("-------------------------------------------------------\n");
        System.out.println("\n---------------KARAKTERLER-----------------\n");
        for (GameChar gameChar : gameChars){
            System.out.println("-------------------------------------------------------\n");
            System.out.println(
                    "Karakter id: "+gameChar.getId() +
                    " \t Karakter: "+gameChar.getName()+
                    " \t Hasar: "+gameChar.getDamage()+
                    " \t Saglik: "+gameChar.getHealth()+
                    " \t Para: "+gameChar.getMoney());
        }
        System.out.println("-------------------------------------------------------\n");
        System.out.println("\n Lutfen bir karakter seciniz...\n");
        int selectChar=input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());



        }
        System.out.println(
                "Secilen Karakter : "+this.getCharName()+
                "\t Hasar: "+this.getDamage()+
                "\t Saglik: "+this.getHealthy()+
                "\t Para: "+this.getMoney());

    }

    public void printInfo(){
        System.out.println(
                        "Silah: "+this.getInventory().getWeapon().getName()+
                        "\t Zirh: "+this.getInventory().getArmor().getName()+
                        "\t Bloklama: "+this.getInventory().getArmor().getBlock()+
                        "\t Hasar: "+this.getTotalDamage()+
                        "\t Saglik: "+this.getHealthy()+
                        "\t Para: "+this.getMoney());
    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealthy(gameChar.getHealth());
        this.setOrjinalHealthy(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());


    }
    public int getTotalDamage(){
         return damage+this.getInventory().getWeapon().getDamage();


    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
    public Armor getArmor(){
        return this.getInventory().getArmor();
    }

    public int getOrjinalHealthy() {
        return orjinalHealthy;
    }

    public void setOrjinalHealthy(int orjinalHealthy) {
        this.orjinalHealthy = orjinalHealthy;
    }
}
