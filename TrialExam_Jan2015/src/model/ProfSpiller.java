package model;

public class ProfSpiller extends Spiller {

    private double kampHonorar;

    public ProfSpiller(String navn, int aargang, double kampHonorar) {
        super(navn, aargang);
        this.kampHonorar = kampHonorar;
    }

    @Override
    public double kampHonorar() {
        int afbud = 0;
        for (Deltagelse d : deltagelser) {
            if (d.isAfbud()) {
                afbud++;
            }
        }

        return kampHonorar * (1 - (afbud / deltagelser.size()));
    }

    public double getKampHonorar() {
        return kampHonorar;
    }

}
