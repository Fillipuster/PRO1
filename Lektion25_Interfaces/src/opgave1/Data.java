package opgave1;

public class Data {

    public static double max(Measurable[] objects) {
        double max = 0;

        for (Measurable m : objects) {
            if (m.getMeasure() > max) {
                max = m.getMeasure();
            }
        }

        return max;
    }

    public static double average(Measurable[] objects) {
        double sum = 0;

        for (Measurable m : objects) {
            sum += m.getMeasure();
        }

        return sum / objects.length;
    }

}
