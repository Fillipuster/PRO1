package opgave5;

public class ElArtikel extends Vare {

    private double hourlyWattage;

    public ElArtikel(String name, String description, double price, double hourlyWattage) {
        super(name, description, price);
        this.hourlyWattage = hourlyWattage;
    }

    public double getHourlyWattage() {
        return hourlyWattage;
    }

}
