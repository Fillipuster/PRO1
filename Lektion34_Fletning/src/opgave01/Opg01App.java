package opgave01;

import java.util.ArrayList;
import java.util.Collections;

public class Opg01App {

    // Weaves the contents of source in to master, provided they are both sorted.
    public static ArrayList<Customer> flet(ArrayList<Customer> master, ArrayList<Customer> source) {
        ArrayList<Customer> result = new ArrayList<>();

        int im = 0; // Iterator for master;
        int is = 0; // Iterator for source;
        while (im <= master.size() - 1 && is <= source.size() - 1) {
            Customer m = master.get(im);
            Customer s = source.get(is);
            if (m.compareTo(s) <= 0) {
                result.add(m);
                im++;
            } else {
                result.add(s);
                is++;
            }
        }

        while (im <= master.size() - 1) {
            result.add(master.get(im++));
            im++;
        }

        while (is <= source.size() - 1) {
            result.add(source.get(is++));
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Customer> l0 = Customer.generateRandoms(3, 12, 90);
        ArrayList<Customer> l1 = Customer.generateRandoms(3, 12, 90);

        Collections.sort(l0);
        Collections.sort(l1);

        System.out.println(l0);
        System.out.println(l1);

        ArrayList<Customer> sorted = new ArrayList<>(l0);
        sorted.addAll(l1);
        Collections.sort(sorted);

        System.out.println();
        System.out.println("Solved via sorting:");
        System.out.println(sorted);
        System.out.println();

        ArrayList<Customer> weaved = flet(l0, l1);

        System.out.println();
        System.out.println("Solved via weaving:");
        System.out.println(weaved);
        System.out.println();
        if (weaved.equals(sorted)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }
    }

}
