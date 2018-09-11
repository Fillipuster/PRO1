package opgave5;

public class Spiritus extends Vare {

    private double alcoholPercentage;

    public Spiritus(String name, String description, double price, double alcoholPercentage) {
        super(name, description, price);
        this.alcoholPercentage = alcoholPercentage;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

}
