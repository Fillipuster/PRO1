package opgave02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    public static double average(ArrayList<Double> doubles) {
        double sum = 0;
        for (double d : doubles) {
            sum += d;
        }

        return sum / doubles.size();
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // P10.2
        File f1 = new File("mary.txt");
        Scanner s1 = null;
        PrintWriter pw1 = null;

        try {
            pw1 = new PrintWriter("lamb.txt");
            s1 = new Scanner(f1);
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file(s).");
        }

        int i = 0;
        while (s1.hasNextLine()) {
            String line = s1.nextLine();
            System.out.println(line);
            pw1.write(i + ": " + line + "\n");
            i++;
        }

        pw1.close();

        System.out.println("\n\n");

        // P10.4
        File f2 = new File("float.txt");
        Scanner s2 = null;

        try {
            s2 = new Scanner(f2);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        ArrayList<Double> col1 = new ArrayList<>();
        ArrayList<Double> col2 = new ArrayList<>();
        int j = 0;
        while (s2.hasNext()) {
            double val = s2.nextDouble();
            if (j % 2 == 0) {
                col1.add(val);
            } else {
                col2.add(val);
            }
            j++;
        }

        System.out.println("Average column #1: " + average(col1));
        System.out.println(col1 + "\n");
        System.out.println("Average column #2: " + average(col2));
        System.out.println(col2 + "\n");

        s1.close();
        s2.close();

        // P10.5
        Scanner s3 = new Scanner(System.in);

        System.out.println("What file would you like to know more about?:");
        String ans = s3.nextLine();

        File f3 = new File(ans);
        Scanner s4 = null;

        try {
            s4 = new Scanner(f3);
        } catch (FileNotFoundException e) {
            System.out.println("No such file.");
            return;
        }

        int lines = 0, chars = 0;
        while (s4.hasNextLine()) {
            String line = s4.nextLine();
            chars += line.length();
            lines++;
        }
        System.out.println("The file has " + lines + " lines.");
        s4.reset();

        int words = 0;
        while (s4.hasNext()) {
            s4.next();
            words++;
        }
        System.out.println("The file has " + words + " words.");
        System.out.println("The file has " + chars + " characters.");
    }

}
