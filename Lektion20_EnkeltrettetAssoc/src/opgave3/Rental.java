package opgave3;

import java.util.ArrayList;

public class Rental {
    private int days;
    private ArrayList<Car> cars = new ArrayList<>();

    public Rental(int days) {
        this.days = days;
    }

    public double getPrice() {
        double totalPrice = 0.0;
        for (Car c : cars) {
            totalPrice += days * c.getDayPrice();
        }

        return totalPrice;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void addCar(Car car) {
        car.addRental(this);
        cars.add(car);
    }

    public void removeCar(Car car) {
        car.removeRental(this);
        cars.remove(car);
    }

}
