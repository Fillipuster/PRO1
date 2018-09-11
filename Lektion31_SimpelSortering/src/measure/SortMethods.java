package measure;

public class SortMethods {

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(String[] array) {
        boolean didSwap = true;

        while (didSwap) {
            didSwap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    didSwap = true;
                }
            }
        }
    }

    public static void insertionSort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String value = array[i];

            int j = i;
            while (j > 0 && array[j - 1].compareTo(value) > 0) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = value;
        }
    }

    public static void selectionSort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int low = i;

            for (int j = i; j < array.length; j++) {
                if (array[low].compareTo(array[j]) > 0) {
                    low = j;
                }
            }

            swap(array, low, i);
        }
    }
}
