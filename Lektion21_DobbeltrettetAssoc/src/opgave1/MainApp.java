package opgave1;

public class MainApp {

    public static void main(String[] args) {
        Car c1 = new Car("YP 81 271", 2001);
        c1.setDayPrice(121.7);
        Car c2 = new Car("UL 93 027", 1997);
        c2.setDayPrice(84.2);
        Car c3 = new Car("II 09 283", 2004);
        c3.setDayPrice(166.0);
        Car c4 = new Car("OD 77 718", 2001);
        c4.setDayPrice(132.8);
        Car c5 = new Car("FU 69 420", 2015);
        c5.setDayPrice(288.87);

        Rental r1 = new Rental(3);
        Rental r2 = new Rental(18);

        r1.addCar(c1);
        r1.addCar(c2);

        r2.addCar(c1);
        r2.addCar(c3);
        r2.addCar(c5);

        System.out.println("Price for R1: " + r1.getPrice());
        System.out.println("Price for R2: " + r2.getPrice());
    }

}
