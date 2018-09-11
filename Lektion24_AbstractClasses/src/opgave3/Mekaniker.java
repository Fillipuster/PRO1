package opgave3;

public class Mekaniker extends Ansat {

    private int svendeprøve;

    public Mekaniker(String navn, String adresse, int svendeprøve, double timeløn, double arbejdstimer) {
        super(navn, adresse, timeløn, arbejdstimer);
        setSvendeprøve(svendeprøve);
    }

    public int getSvendeprøve() {
        return svendeprøve;
    }

    public void setSvendeprøve(int svendeprøve) {
        this.svendeprøve = svendeprøve;
    }

    @Override
    public double ugeLøn() {
        return getTimeløn() * getArbejdstimer();
    }

}
