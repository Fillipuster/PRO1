package opgave5;

import java.util.ArrayList;

public class Vare {

    private String name;
    private String description;
    private double price;

    private static ArrayList<Vare> vares = new ArrayList<>();

    public Vare(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;

        vares.add(this);
    }

    public double getBruttoPrice() {
        double brutto = price * (getMoms() + 1.0);

        if (this instanceof ElArtikel && price * getMoms() < 3.0) {
            brutto = price + 3;
        }

        return brutto;
    }

    public double getMoms() {
        if (this instanceof Fødevare) {
            return 0.05;
        }

        if (this instanceof ElArtikel) {
            return 0.3;
        }

        if (this instanceof Spiritus) {
            if (price > 90.0) {
                return 1.2;
            } else {
                return 0.8;
            }
        }

        return 0.25;
    }

    @Override
    public String toString() {
        return name + " : \"" + description + "\"\n" + "Netto Price : " + price + "\n" + "Brutto Price : "
                + getBruttoPrice();
    }

    public static double totalVareBruttoPrice() {
        double sum = 0.0;

        for (Vare v : vares) {
            sum += v.getBruttoPrice();
        }

        return sum;
    }

}
