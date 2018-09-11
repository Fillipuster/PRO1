package array_util;

public class ArrayMethods {
    public static int sum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

    public static int[] createSum(int[] array1, int[] array2) {
        int[] sum = new int[array1.length];

        if (array1.length != array2.length) {
            return sum;
        }

        for (int i = 0; i < sum.length; i++) {
            sum[i] = array1[i] + array2[i];
        }

        return sum;
    }

    public static boolean hasUneven(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                return true;
            }
        }

        return false;
    }
}
