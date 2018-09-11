package opgave3;

import java.util.ArrayList;

public abstract class Ansat extends Person {

    private double timeløn;
    private double arbejdstimer;
    private static ArrayList<Ansat> ansatte = new ArrayList<>();

    public Ansat(String navn, String adresse, double timeløn, double arbejdstimer) {
        super(navn, adresse);
        this.timeløn = timeløn;
        this.arbejdstimer = arbejdstimer;
        ansatte.add(this);
    }

    public double getTimeløn() {
        return timeløn;
    }

    public void setTimeløn(double timeløn) {
        this.timeløn = timeløn;
    }

    public double getArbejdstimer() {
        return arbejdstimer;
    }

    public void setArbejdstimer(double arbejdstimer) {
        this.arbejdstimer = arbejdstimer;
    }

    public abstract double ugeLøn();

    public static double samletUgeløn() {
        double sum = 0;
        for (Ansat a : ansatte) {
            sum += a.ugeLøn();
        }

        return sum;
    }

}
