package opgave2;

public class MainApp {

    public static void main(String[] args) {
        Person p1 = new Person("Jonas Præstegaard", 21);
        Person p2 = new Person("Alexander Skou", 22);

        Gift terriblecomputer = new Gift("MacBook Pro");
        terriblecomputer.setPrice(99999999.99);
        terriblecomputer.setGiver(p1);

        Gift tanken = new Gift("Det er tanken der tæller");
        tanken.setPrice(0);
        tanken.setGiver(p2);

        Gift goodpc = new Gift("ASUS Probook");
        goodpc.setPrice(3499.95);
        goodpc.setGiver(p2);

        Gift handjob = new Gift("Handjob");
        handjob.setPrice(0);
        handjob.setGiver(p1);

        p1.addGift(tanken);
        p1.addGift(goodpc);
        p1.addGift(handjob);

        p2.addGift(terriblecomputer);

        System.out.println("The total value of the gifts of " + p1.toString());
        System.out.println(p1.totalGiftsValue() + " kr.");

        System.out.println();

        System.out.println("The total value of the gifts of " + p2.toString());
        System.out.println(p2.totalGiftsValue() + " kr.");

        System.out.println();

        System.out.println(p1.toString() + " has received gifts from:");
        for (Person p : p1.allGifters()) {
            System.out.println(p.toString());
        }
    }

}
