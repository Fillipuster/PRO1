package opgave1;

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
        Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");
        s1.setTrainingPlan(tpA);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");
        s2.setTrainingPlan(tpB);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer s3 = new Swimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");
        s3.setTrainingPlan(tpB);

        ArrayList<Swimmer> swimmers = new ArrayList<>();
        swimmers.add(s1);
        swimmers.add(s2);
        swimmers.add(s3);

        for (Swimmer s : swimmers) {
            System.out.println(s.getName() + ":");
            System.out.println(" - Best lap time: " + s.bestLapTime());
            TrainingPlan tp = s.getTrainingPlan();
            System.out.println(" - Training plan: " + tp.getLevel());
            System.out.println(" - Water hours: " + tp.getWeeklyWaterHours());
            System.out.println(" - Strength hours: " + tp.getWeeklyStrengthHours());
            System.out.println(" - Total training hours: " + s.totalTrainingHours());
        }

    }

}
