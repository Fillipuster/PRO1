package opgave3;

public class Synsmand extends Mekaniker {

    private int syn;
    private double synstill�g;

    public Synsmand(String navn, String adresse, int svendepr�ve, double timel�n, double arbejdstimer,
            double synstill�g) {
        super(navn, adresse, svendepr�ve, timel�n, arbejdstimer);
        syn = 0;
    }

    public int getSyn() {
        return syn;
    }

    public void setSyn(int syn) {
        this.syn = syn;
    }

    public void setSynstill�g(double synstill�g) {
        this.synstill�g = synstill�g;
    }

    @Override
    public double ugeL�n() {
        return super.ugeL�n() + syn * synstill�g;
    }

}
