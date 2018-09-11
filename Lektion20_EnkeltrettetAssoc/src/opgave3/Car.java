package opgave3;

import java.util.ArrayList;

public class Car {
    private String license;
    private double pricePerDay;
    private int purchaseYear;
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Car(String license, int purchaseYear) {
        this.license = license;
        this.purchaseYear = purchaseYear;
    }

    public void setDayPrice(double price) {
        pricePerDay = price;
    }

    public double getDayPrice() {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public ArrayList<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    void removeRental(Rental rental) {
        rentals.remove(rental);
    }

    public int longestLeasePeriod() {
        int longest = 0;
        for (Rental r : rentals) {
            if (r.getDays() > longest) {
                longest = r.getDays();
            }
        }

        return longest;
    }

    public int shortestLeasePeriod() {
        int shortest = Integer.MAX_VALUE;
        for (Rental r : rentals) {
            if (r.getDays() < shortest) {
                shortest = r.getDays();
            }
        }

        return shortest;
    }
}
