package opgave2;

public class Gift {
    private String description;
    private double price;
    private Person giver;

    public Gift(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return description + ", with a value of " + price + ".";
    }

    public Person getGiver() {
        return giver;
    }

    public void setGiver(Person giver) {
        this.giver = giver;
    }

}
