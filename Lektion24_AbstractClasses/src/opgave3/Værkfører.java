package opgave3;

public class V�rkf�rer extends Ansat {

    private int udn�vnelse;
    private double ugeTil�g;

    public V�rkf�rer(String navn, String adresse, int udn�vnelse, double timel�n, double arbejdstimer,
            double ugeTill�g) {
        super(navn, adresse, timel�n, arbejdstimer);
        setUdn�vnelse(udn�vnelse);
        setUgeTil�g(ugeTil�g);
    }

    public int getUdn�vnelse() {
        return udn�vnelse;
    }

    public void setUdn�vnelse(int udn�vnelse) {
        this.udn�vnelse = udn�vnelse;
    }

    public double getUgeTil�g() {
        return ugeTil�g;
    }

    public void setUgeTil�g(double ugeTil�g2) {
        this.ugeTil�g = ugeTil�g2;
    }

    @Override
    public double ugeL�n() {
        return getTimel�n() * getArbejdstimer() + ugeTil�g;
    }

}
