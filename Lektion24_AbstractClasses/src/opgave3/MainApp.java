package opgave3;

public class MainApp {

    public static void main(String[] args) {

        Mekaniker m1 = new Mekaniker("Johnny Mogensen", "Spangsbergsvej 21B", 1997, 110, 37);
        Mekaniker m2 = new Mekaniker("Peter Larsen", "Horsholmsvej 15", 1999, 105, 39);

        V�rkf�rer v1 = new V�rkf�rer("Ulla Nielsen", "Hjeml�s", 2001, 131, 30, 1500);
        V�rkf�rer v2 = new V�rkf�rer("Rasmus Ramstrup", "Rollevej 9", 1993, 201, 41, 2300);

        Synsmand s1 = new Synsmand("Simon Yttrup", "Kl�mmevej 12", 2000, 111, 37, 200);
        Synsmand s2 = new Synsmand("Ole Larsen", "Hammelvej 90", 1989, 230, 24, 550);

        Arbejdsdreng a1 = new Arbejdsdreng("Alexander Skou", "Drewsensvej 9001", 21, 55);

        s1.setSyn(4);
        s2.setSyn(7);

        System.out.println(Ansat.samletUgel�n());
    }

}
