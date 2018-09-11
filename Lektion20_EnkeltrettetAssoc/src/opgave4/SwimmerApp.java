package opgave4;

import java.util.ArrayList;

public class SwimmerApp {

    public static void main(String[] args) {

        TrainingPlan tpA = new TrainingPlan('A', 16, 10);
        TrainingPlan tpB = new TrainingPlan('B', 10, 6);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        tpA.createSwimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        tpA.createSwimmer("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        tpB.createSwimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        System.out.println("Training Plan A Swimmers:");
        for (Swimmer s : tpA.getSwimmers()) {
            System.out.println(s.getName() + ":");
            System.out.println(" - Best lap time: " + s.bestLapTime());
        }

        System.out.println();

        System.out.println("Training Plan B Swimmers:");
        for (Swimmer s : tpB.getSwimmers()) {
            System.out.println(s.getName() + ":");
            System.out.println(" - Best lap time: " + s.bestLapTime());
        }

        // Test removal of a swimmer.
        System.out.println();
        System.out.println("Removing swimmer from TP:A...");

        tpA.removeSwimmer(tpA.getSwimmers().get(1));

        System.out.println();

        System.out.println("Training Plan A Swimmers:");
        for (Swimmer s : tpA.getSwimmers()) {
            System.out.println(s.getName() + ":");
            System.out.println(" - Best lap time: " + s.bestLapTime());
        }

        System.out.println();

        System.out.println("Training Plan B Swimmers:");
        for (Swimmer s : tpB.getSwimmers()) {
            System.out.println(s.getName() + ":");
            System.out.println(" - Best lap time: " + s.bestLapTime());
        }

        tpA.removeSwimmerName("Jan");

        System.out.println("Training Plan A Swimmers:");
        for (Swimmer s : tpA.getSwimmers()) {
            System.out.println(s.getName() + ":");
            System.out.println(" - Best lap time: " + s.bestLapTime());
        }

        System.out.println();

        System.out.println("Training Plan B Swimmers:");
        for (Swimmer s : tpB.getSwimmers()) {
            System.out.println(s.getName() + ":");
            System.out.println(" - Best lap time: " + s.bestLapTime());
        }

    }

}
