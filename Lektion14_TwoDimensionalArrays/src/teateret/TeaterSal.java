package teateret;

import java.util.Random;

public class TeaterSal {
    private int[][] seats;
    private int rows;
    private int columns;
    private Random rand = new Random();

    public TeaterSal(int seatRows, int seatColumns) {
        seats = new int[seatRows][seatColumns];
        this.rows = seatRows;
        this.columns = seatColumns;
    }

    public void generatePrices() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                seats[row][col] = rand.nextInt((90 - 10) + 1) + 10;
            }
        }
    }

    public void printSal() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(seats[row][col] + " ");
            }
            System.out.println();
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getSeats() {
        return seats;
    }

}
