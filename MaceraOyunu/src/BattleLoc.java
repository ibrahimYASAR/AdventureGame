import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;

    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Suan Buradasiniz: "+this.getName());
        System.out.println("Dikkatli Ol ! Burada "+obsNumber+" Tane "+this.getObstacle().getName()+" Yasiyor !");
        System.out.println("<S>avas Veya <K>ac ");
        String selectCase=input.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)){
            System.out.println("Savas Islemleri Olacak...");
            //Savasma islemi


                System.out.println(this.getName() + "Tum Dusmanlari Yendiniz...");
                return true;

        }
        if (this.getPlayer().getHealthy() <= 0){
            System.out.println("OLDUNUZ.....!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){
        for (int i=1; i<=obsNumber; i++){
            this.getObstacle().setHealth(this.obstacle.getOrginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealthy()>0 && this.getObstacle().getHealth() > 0){

                System.out.println("<V>ur Veya <K>ac : ");
                String selectCombat =input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    System.out.println("Siz Vurdunuz...");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()- this.getPlayer().getTotalDamage());
                    afterHit();

                    if (this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("Canavar Size Vurdu...");
                        int obstacleDamage= this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();

                        if (obstacleDamage <0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy()-obstacleDamage);
                        afterHit();
                    }
                }else {
                    return false;
                }

            }
            if (this.getObstacle().getHealth()<this.getPlayer().getHealthy()){
                System.out.println("Dusmani Yendiniz...");
                System.out.println(this.getObstacle().getAward()+" Lira Para Kazandiniz...");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Guncel Paraniz: " + this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Caniniz : "+this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName()+" Cani : "+this.getObstacle().getHealth());
        System.out.println( );
    }
    public void playerStats(){
        System.out.println("Oyuncu Degerleri ");
        System.out.println("---------------------------------");
        System.out.println("Saglik: "+this.getPlayer().getHealthy());
        System.out.println("Silah: "+this.getPlayer().getWeapon().getName());
        System.out.println("Hasar: "+this.getPlayer().getTotalDamage());
        System.out.println("Zirh: "+this.getPlayer().getArmor().getName());
        System.out.println("Bloklama: "+this.getPlayer().getArmor().getBlock());
        System.out.println("Para: "+this.getPlayer().getMoney());


    }

    public void obstacleStats(int i){
        System.out.println(i+". "+this.getObstacle().getName()+" Degerleri");
        System.out.println("---------------------------------");
        System.out.println("Saglik: "+this.getObstacle().getHealth());
        System.out.println("Hasar: "+this.getObstacle().getDamage());
        System.out.println("Odul: "+this.getObstacle().getAward());
    }
    public int randomObstacleNumber(){
        Random r =new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
