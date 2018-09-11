package model;

import java.util.ArrayList;

public class Spiller {

    private String navn;
    private int aargang;

    protected ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Spiller(String navn, int aargang) {
        this.navn = navn;
        this.aargang = aargang;
    }

    public double kampHonorar() {
        int validDeltagelser = 0;
        for (Deltagelse d : deltagelser) {
            if (!d.isAfbud()) {
                validDeltagelser++;
            }
        }

        return validDeltagelser * 10;
    }

    public String getNavn() {
        return navn;
    }

    public int getAargang() {
        return aargang;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse);
        }
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        deltagelser.remove(deltagelse);
    }

}
