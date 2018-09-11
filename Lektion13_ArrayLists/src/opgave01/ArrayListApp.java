package opgave01;

import java.util.ArrayList;

public class ArrayListApp {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Hans");
        names.add("Viggo");
        names.add("Jens");
        names.add("Børge");
        names.add("Bent");

        printArrayList(names);

        names.add(2, "Jane");

        printArrayList(names);

        names.remove(1);

        printArrayList(names);

        names.add(0, "Pia");
        names.add(names.size(), "Ib");

        printArrayList(names);

        names.set(2, "Hansi");

        printArrayList(names);

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i).length());
        }

        System.out.println();

        for (String name : names) {
            System.out.println(name.length());
        }
    }

    public static void printArrayList(ArrayList<String> list) {
        for (String value : list) {
            System.out.println(value);
        }
        System.out.println();
    }

}
