package eksempelcar;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White");
        myCar.setRegistrationNumber("AB 11 123");

        Car yourCar = new Car("Citroén Berlingo", "Yellow");
        yourCar.setRegistrationNumber("PROUDDAD");
        yourCar.setKm(86367);

        myCar.printInfo();
        yourCar.printInfo();
    }

}
