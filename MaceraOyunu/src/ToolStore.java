public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
            super(player, "MAGAZA");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--------------Magazaya Hosgeldiniz-----------------");
        boolean showMenu=true;
       while (showMenu){
           System.out.println("\n1- Silahlar");
           System.out.println("2- Zirhlar");
           System.out.println("3-Cikis Yap");
           System.out.print("Seciminiz: ");
           int selectCel=Location.input.nextInt();

           while (selectCel<1||selectCel>3){
               System.out.println("\nYanlis Secim...\nLutfen Yeniden Seciniz");
               selectCel=Location.input.nextInt();
           }switch (selectCel){
               case 1:
                   printWeapon();
                   buyWeapon();
                   break;
               case 2:
                   printArmor();
                   buyArmor();
                   break;
               case 3:
                   System.out.println("\n\nBir Daha Bekleriz...");
                   showMenu=false;
                   break;

           }
       }
       return true;
    }
    public void printWeapon(){
        System.out.println("\n--------Silahlar----------");
        for (Weapon weapon : Weapon.weapons()){
            System.out.println(weapon.getId()+
                    "-"+weapon.getName()+
                    " <Para: "+weapon.getPrice()+
                    ", Hasar: "+weapon.getDamage()+
                    ">");
        }
        System.out.println("0 - Cikis Yap...");


    }
    public void buyWeapon(){
        System.out.println("Bie Silah Seciniz...");
        int selectWeaponId=Location.input.nextInt();
        while (selectWeaponId<0||selectWeaponId>Weapon.weapons().length){
            System.out.println("\nYanlis Secim...\nLutfen Yeniden Seciniz");
            selectWeaponId=Location.input.nextInt();

        }
        if (selectWeaponId !=0){

            Weapon selectedWeaon = Weapon.getWeaponObjById(selectWeaponId);
            if (selectedWeaon!=null){
                if (selectedWeaon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yetersiz Bakiye...");
                }
                else {
                    System.out.println(selectedWeaon.getName() + " Silahini Satin Aldiniz....");
                    int balance=this.getPlayer().getMoney() - selectedWeaon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiye: "+this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeaon);
                }

            }
        }

    }



    public void printArmor(){
        System.out.println("\n--------Zirhlar----------");
       for (Armor a: Armor.armors()){
           System.out.println(a.getId()+" - "+a.getName()+" <Para: "+a.getPrice()+", Zirh: "+a.getBlock()+" >");
        }
        System.out.println("0 - Cikis Yap...");
    }

    public void buyArmor() {
        System.out.println("Bie Zirh Seciniz...");
        int selectArmorId = Location.input.nextInt();
        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("\nYanlis Secim...\nLutfen Yeniden Seciniz");
            selectArmorId = Location.input.nextInt();
        }

        if (selectArmorId !=0){

            Armor selectedArmor = Armor.getArmorObjById(selectArmorId);
            if (selectedArmor!=null){
                if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yetersiz Bakiye...");
                }
                else {
                    System.out.println(selectedArmor.getName() + " Zirhini Satin Aldiniz....");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan Paraniz: "+this.getPlayer().getMoney());
                }

            }
        }
    }
}
