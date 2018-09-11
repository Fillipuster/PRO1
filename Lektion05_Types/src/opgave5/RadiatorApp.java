package opgave5;

public class RadiatorApp {

    public static void main(String[] args) {
        Radiator rad1 = new Radiator(20);
        Radiator rad2 = new Radiator();

        rad1.increaseTemperature(2);
        rad2.decreaseTemperature(5);

        System.out.println(rad1.getTemperature());
        System.out.println(rad2.getTemperature());
    }

}
