package opgave3;

import java.util.ArrayList;

public abstract class Ansat extends Person {

    private double timel�n;
    private double arbejdstimer;
    private static ArrayList<Ansat> ansatte = new ArrayList<>();

    public Ansat(String navn, String adresse, double timel�n, double arbejdstimer) {
        super(navn, adresse);
        this.timel�n = timel�n;
        this.arbejdstimer = arbejdstimer;
        ansatte.add(this);
    }

    public double getTimel�n() {
        return timel�n;
    }

    public void setTimel�n(double timel�n) {
        this.timel�n = timel�n;
    }

    public double getArbejdstimer() {
        return arbejdstimer;
    }

    public void setArbejdstimer(double arbejdstimer) {
        this.arbejdstimer = arbejdstimer;
    }

    public abstract double ugeL�n();

    public static double samletUgel�n() {
        double sum = 0;
        for (Ansat a : ansatte) {
            sum += a.ugeL�n();
        }

        return sum;
    }

}
