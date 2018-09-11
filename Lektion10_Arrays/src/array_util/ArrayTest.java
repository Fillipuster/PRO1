package array_util;

public class ArrayTest {

    public static void main(String[] args) {
        int[] testArray = { 4, 3, 5 };
        System.out.println(ArrayMethods.sum(testArray));

        System.out.println();

        int[] anotherTestArray = { 2, 8, 2 };
        int[] testSum = ArrayMethods.createSum(testArray, anotherTestArray);
        for (int i = 0; i < testSum.length; i++) {
            System.out.println(testSum[i]);
        }

        System.out.println();

        System.out.println(ArrayMethods.hasUneven(testArray));
        System.out.println(ArrayMethods.hasUneven(anotherTestArray));
    }

}
