import java.util.Scanner;

public class Game {
    private Scanner input=new Scanner(System.in);

    public void start(){

        System.out.println("Macera Oyununa Hos Geldiniz...");
        System.out.println("Lutfen Bir Isim Giriniz : ");
        String playerName = input.nextLine();
        Player player =new Player(playerName);
        System.out.println("Sayin "+player.getName()+" Bu Karanlik Ve Sisli Adaya Hosgeldiniz... Burada Yasananlarin Hepsi Gercek...");
        System.out.println("Lutfen Bir Karakter Seciniz...");
        player.selectChar();

        Location location=null;
        while (true){
            player.printInfo();

            System.out.println("\n---------------BOLGELER-----------------\n");
            System.out.println("0: ----------CIKIS YAP---------->Oyunu Sonlandir...");
            System.out.println("1: ----------GUVENLI EV--------->Burasi Sizin Icin Guvenli Bir Ev, Dusman Yoktur...");
            System.out.println("2: ----------ESYA STORE--------->Silah Veya Zirh Satin Alabilirsiniz...");
            System.out.println("3: ----------MAGARA------------->Odul: <YEMEK>, Dikkatli Ol Karsina Zombi Cikabilir...");
            System.out.println("4: ----------ORMAN-------------->Odul: <ODUN>, Dikkatli Ol Karsina Vampir Cikabilir...");
            System.out.println("5: ----------NEHIR-------------->Odul: <SU>, Dikkatli Ol Karsina Ayi Cikabilir...");

            System.out.println("\nLutfen Gitmek Istediginiz Bolgeyi Seciniz...\n");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location=null;
                    break;
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location =new Cave(player);
                    break;
                case 4:
                    location =new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    System.out.println("Lutfen Gecerli Bir Bolge Giriniz...");

            }
            if (location == null){
                System.out.println("Oyun Bitti...Yine Bekleriz...:))");
                break;
            }
            if(!location.onLocation())
            {
                System.out.println("----OLDUNUZ----GAME OVER");
                break;
            }
        }


    }
}
