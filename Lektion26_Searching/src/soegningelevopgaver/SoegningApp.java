package soegningelevopgaver;

import java.util.ArrayList;
import java.util.Random;

public class SoegningApp {

    public static Random random = new Random();

    public static void main(String[] args) {

        int[] a1 = { 2, 4, 8, 2 };
        System.out.println("Er der et ulige tal i a1? " + Soegning.findUlige(a1));
        a1[2] = 15;
        System.out.println("Er der et ulige tal i a1? " + Soegning.findUlige(a1));

        int[] a2 = { 7, 2, 0, 62, 46, 13, 14, 17, 88, 3 };
        System.out.println("Første heltal mellem 10 og 15 i a2: " + Soegning.findFørsteInterval(a2, 10, 15));

        int[] a3 = { 0, 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("Er der 2-tals sekvens i a3? " + Soegning.ensTalSekvens(a3));
        a3[6] = 5;
        System.out.println("Er der 2-tals sekvens i a3? " + Soegning.ensTalSekvens(a3));

        System.out.println("Heltalskvadratroden af 287391 er: " + Soegning.heltalsKvadratrod(287391));

        System.out.println();

        int size = 10;
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ints.add(random.nextInt(10));
        }
        int search = random.nextInt(10);

        System.out.println(ints);
        System.out.println("Moving down " + search + " with result: " + Soegning.rykNed(ints, search));
        System.out.println(ints);
    }

}
