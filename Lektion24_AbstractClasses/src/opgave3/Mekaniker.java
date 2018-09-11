package opgave3;

public class Mekaniker extends Ansat {

    private int svendepr�ve;

    public Mekaniker(String navn, String adresse, int svendepr�ve, double timel�n, double arbejdstimer) {
        super(navn, adresse, timel�n, arbejdstimer);
        setSvendepr�ve(svendepr�ve);
    }

    public int getSvendepr�ve() {
        return svendepr�ve;
    }

    public void setSvendepr�ve(int svendepr�ve) {
        this.svendepr�ve = svendepr�ve;
    }

    @Override
    public double ugeL�n() {
        return getTimel�n() * getArbejdstimer();
    }

}
