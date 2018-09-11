package opgave1dobbelarray;

public class DobbelArrayApp {

    public static void main(String[] args) {
        final int ROW = 8;
        final int COL = 8;
        int[][] values = new int[ROW][COL];

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                System.out.print(values[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                values[row][col] = 5;
            }
        }

        printD2IntArray(values);

        System.out.println();

        boolean alternator = true;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                values[row][col] = alternator ? 1 : 0;
                alternator = !alternator;
            }
            if (values.length % 2 == 0) {
                alternator = !alternator;
            }
        }

        printD2IntArray(values);

        System.out.println();

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (row == 0 || row == ROW - 1 || col == 0 || col == COL - 1) {
                    values[row][col] = 5;
                } else {
                    values[row][col] = 2;
                }
            }
        }

        printD2IntArray(values);

        System.out.println();

        int sum = 0;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                sum += values[row][col];
            }
        }

        System.out.println(sum);
    }

    public static void printD2IntArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }

}
