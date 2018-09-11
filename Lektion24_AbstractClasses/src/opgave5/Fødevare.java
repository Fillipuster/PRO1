package opgave5;

import java.time.LocalDate;

public class Fødevare extends Vare {

    LocalDate bestBeforeDate;

    public Fødevare(String name, String description, double price, LocalDate bestBeforeDate) {
        super(name, description, price);
        this.bestBeforeDate = bestBeforeDate;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

}
