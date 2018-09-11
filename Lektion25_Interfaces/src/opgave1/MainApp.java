package opgave1;

import java.util.Random;

public class MainApp {

    public static Random random = new Random();

    public static void main(String[] args) {

        Chili[] chilies = new Chili[50];

        for (int i = 0; i < chilies.length; i++) {
            chilies[i] = new Chili("Chili" + i, (random.nextDouble() + 0.1) * 1000);
        }

        for (Chili c : chilies) {
            System.out.println(c.getName() + ": " + c.getScoville());
        }

        System.out.println();
        System.out.println("Highest scoville chili: " + Data.max(chilies));
        System.out.println("Aberage scoville: " + Data.average(chilies));

    }

}
