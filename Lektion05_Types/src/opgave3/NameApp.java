package opgave3;

public class NameApp {

    public static void main(String[] args) {
        Name name = new Name("Karl", "Klitmøller", "Karlsson");
        System.out.println(name.getInit());
        System.out.println(name.getUsername());
    }

}
