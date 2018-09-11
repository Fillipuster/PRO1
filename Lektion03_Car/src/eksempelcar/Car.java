package eksempelcar;

public class Car {
    private double km;
    private String registrationNumber;
    private String color;
    private String brand;

    public Car(String brand, String color) {
        super();
        this.brand = brand;
        this.color = color;
    }

    public double getKm() {
        return this.km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return this.brand;
    }

    public void printInfo() {
        String odo = "0 (Unknown)";
        if (getKm() > 0) {
            odo = getKm() + "";
        }
        System.out.println("************************************");
        System.out.println("Brand: " + getBrand());
        System.out.println("Plate: " + getRegistrationNumber());
        System.out.println("Color: " + getColor());
        System.out.println("ODOkm: " + odo);
        System.out.println("************************************");
    }

}
