package opgave5;

public class Radiator {
    private int temperature;

    public Radiator(int temperature) {
        this.temperature = temperature;
    }

    public Radiator() {
        this.temperature = 0;
    }

    public void increaseTemperature(int amount) {
        this.temperature += amount;
    }

    public void decreaseTemperature(int amount) {
        this.temperature -= amount;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

}
