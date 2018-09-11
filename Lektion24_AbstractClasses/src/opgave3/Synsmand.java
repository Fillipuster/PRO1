package opgave3;

public class Synsmand extends Mekaniker {

    private int syn;
    private double synstillæg;

    public Synsmand(String navn, String adresse, int svendeprøve, double timeløn, double arbejdstimer,
            double synstillæg) {
        super(navn, adresse, svendeprøve, timeløn, arbejdstimer);
        syn = 0;
    }

    public int getSyn() {
        return syn;
    }

    public void setSyn(int syn) {
        this.syn = syn;
    }

    public void setSynstillæg(double synstillæg) {
        this.synstillæg = synstillæg;
    }

    @Override
    public double ugeLøn() {
        return super.ugeLøn() + syn * synstillæg;
    }

}
