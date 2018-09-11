package model;

public class Deltagelse {

    private boolean afbud;
    private String begrundelse;

    private Spiller spiller;

    public Deltagelse(Spiller spiller) {
        this.spiller = spiller;
        spiller.addDeltagelse(this);
    }

    public boolean isAfbud() {
        return afbud;
    }

    public void setAfbud(boolean afbud) {
        this.afbud = afbud;
    }

    public String getBegrundelse() {
        return begrundelse;
    }

    public void setBegrundelse(String begrundelse) {
        this.begrundelse = begrundelse;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public void setSpiller(Spiller spiller) {
        if (this.spiller != spiller) {
            this.spiller.removeDeltagelse(this);
        }

        this.spiller = spiller;
        spiller.addDeltagelse(this);
    }

}
