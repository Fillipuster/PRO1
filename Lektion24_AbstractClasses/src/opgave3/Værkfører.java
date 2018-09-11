package opgave3;

public class Værkfører extends Ansat {

    private int udnævnelse;
    private double ugeTilæg;

    public Værkfører(String navn, String adresse, int udnævnelse, double timelæn, double arbejdstimer,
            double ugeTillæg) {
        super(navn, adresse, timelæn, arbejdstimer);
        setUdnævnelse(udnævnelse);
        setUgeTilæg(ugeTilæg);
    }

    public int getUdnævnelse() {
        return udnævnelse;
    }

    public void setUdnævnelse(int udnævnelse) {
        this.udnævnelse = udnævnelse;
    }

    public double getUgeTilæg() {
        return ugeTilæg;
    }

    public void setUgeTilæg(double ugeTilæg2) {
        this.ugeTilæg = ugeTilæg2;
    }

    @Override
    public double ugeLøn() {
        return getTimeløn() * getArbejdstimer() + ugeTilæg;
    }

}
