package storage;

import java.util.ArrayList;

import model.Arrangement;
import model.Tutor;
import model.Uddannelse;

public class Storage {
    private static ArrayList<Uddannelse> uddannelses = new ArrayList<>();
    private static ArrayList<Tutor> tutors = new ArrayList<>();
    private static ArrayList<Arrangement> arrangements = new ArrayList<>();

    public static ArrayList<Uddannelse> getUddanelses() {
        return new ArrayList<>(uddannelses);
    }

    public static void addUddanelse(Uddannelse uddannelse) {
        uddannelses.add(uddannelse);
    }

    public static ArrayList<Tutor> getTutors() {
        return new ArrayList<>(tutors);
    }

    public static void addTutor(Tutor tutor) {
        tutors.add(tutor);
    }

    public static ArrayList<Arrangement> getArrangements() {
        return new ArrayList<>(arrangements);
    }

    public static void addArrangement(Arrangement arrangement) {
        arrangements.add(arrangement);
    }
}
