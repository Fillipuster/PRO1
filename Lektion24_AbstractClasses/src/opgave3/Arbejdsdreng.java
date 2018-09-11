package opgave3;

public class Arbejdsdreng extends Ansat {

    public Arbejdsdreng(String navn, String adresse, double timeløn, double arbejdstimer) {
        super(navn, adresse, timeløn, arbejdstimer);
    }

    @Override
    public double ugeLøn() {
        return getTimeløn() * getArbejdstimer();
    }

}
