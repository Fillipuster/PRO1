package measure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortTester {

    public static <T> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length - 1) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {

        HashMap<String, Long> times = new HashMap<>();

        int testSize = 300;
        ArrayList<String> bigList = ListGenerator.generateString(testSize, 12);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);
        String[] bigarray4 = bigList.toArray(new String[0]);
        System.out.println(bigList);

        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
        times.put("Bubble", Measurer.durationInNanoSeconds());
        System.out.println();
        System.out.println(String.format("BubbleSort (%d): %d", testSize, Measurer.durationInNanoSeconds()));
        printArray(bigArray1);
        System.out.println();

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
        times.put("Insertion", Measurer.durationInNanoSeconds());
        System.out.println();
        System.out.println(String.format("InsertionSort (%d): %d", testSize, Measurer.durationInNanoSeconds()));
        printArray(bigArray2);
        System.out.println();

        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
        times.put("Selection", Measurer.durationInNanoSeconds());
        System.out.println();
        System.out.println(String.format("SelectionSort (%d): %d", testSize, Measurer.durationInNanoSeconds()));
        printArray(bigArray3);
        System.out.println();

        // Collection Sort Test
        Measurer.start();
        Arrays.sort(bigarray4);
        Measurer.stop();
        times.put("Collection", Measurer.durationInNanoSeconds());
        System.out.println();
        System.out.println(String.format("CollectionSort (%d): %d", testSize, Measurer.durationInNanoSeconds()));
        printArray(bigarray4);
        System.out.println();

        for (Map.Entry<String, Long> entry : times.entrySet()) {
            String key = entry.getKey();
            long value = entry.getValue();

            System.out.println(key + ": " + value);
        }

    }

}
