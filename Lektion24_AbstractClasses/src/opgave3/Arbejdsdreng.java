package opgave3;

public class Arbejdsdreng extends Ansat {

    public Arbejdsdreng(String navn, String adresse, double timel�n, double arbejdstimer) {
        super(navn, adresse, timel�n, arbejdstimer);
    }

    @Override
    public double ugeL�n() {
        return getTimel�n() * getArbejdstimer();
    }

}
