package opgave1;

public class Chili implements Measurable {

    private String name;
    private double scoville;

    public Chili(String name, double scoville) {
        setName(name);
        setScoville(scoville);
    }

    @Override
    public double getMeasure() {
        return scoville;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScoville() {
        return scoville;
    }

    public void setScoville(double scoville) {
        this.scoville = scoville;
    }

}
