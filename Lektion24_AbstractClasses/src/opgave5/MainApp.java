package opgave5;

public class MainApp {

    public static void main(String[] args) {

        Vare v1 = new Vare("Toiletpapir", "Til numsen.", 25);
        Spiritus s1 = new Spiritus("Jägermeister", "Godt for halsen!", 210, 30);

        System.out.println(Vare.totalVareBruttoPrice());

    }

}
