package opgave02;

import java.time.LocalDate;

public class Rental {

    private int number;
    private int days;
    private LocalDate startDate;
    private double price;

    public Rental(int number, int days, double price, LocalDate startDate) {
        this.number = number;
        this.days = days;
        this.price = price;
        this.startDate = startDate;
    }

    public Rental(int number, int days, double price) {
        this(number, days, price, LocalDate.now());
    }

    public double getPricePerDay() {
        return price;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return startDate.plusDays(days);
    }

    public double getTotalPrice() {
        return price * days;
    }

}
