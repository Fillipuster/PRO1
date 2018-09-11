package opgave02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalApp {

    public static void main(String[] args) {
        Rental r1 = new Rental(0, 10, 400, LocalDate.of(2018, 04, 01));
        Rental r2 = new Rental(1, 4, 550, LocalDate.now().plusMonths(10));

        System.out.println("Total price R1: " + r1.getTotalPrice());
        System.out.println("Total price R2: " + r2.getTotalPrice());
        System.out.println();
        System.out.println("End date R1: " + r1.getEndDate());
        System.out.println("End date R2: " + r2.getEndDate());
        System.out.println();
        System.out.println("Day before start date R1: " + r1.getStartDate().minusDays(1));
        System.out.println("Day before start date R2: " + r2.getStartDate().minusDays(1));
        System.out.println();
        System.out.println("Years between R1 and R2: " + r1.getStartDate().until(r2.getStartDate(), ChronoUnit.YEARS));
        System.out
                .println("Months between R1 and R2: " + r1.getStartDate().until(r2.getStartDate(), ChronoUnit.MONTHS));
        System.out.println("Days between R1 and R2: " + r1.getStartDate().until(r2.getStartDate(), ChronoUnit.DAYS));
    }

}
