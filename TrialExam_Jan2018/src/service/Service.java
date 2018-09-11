package service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.Arrangement;
import model.Hold;
import model.Tutor;
import model.Uddannelse;
import storage.Storage;

public class Service {
    // Utility Methods
    public static void tutorOversigtTilFil(String filnavn) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(filnavn);
        } catch (FileNotFoundException e) {
            System.out.println("Fejl i filsystem. Prøv igen.");
            return;
        }

        for (Uddannelse u : getUddannelses()) {
            out.write("---------- " + u.getNavn() + " ----------\n");
            for (String s : u.tutorOversigt()) {
                out.write(s + "\n");
            }
            out.write("\n");
        }

        out.close();
    }

    public static ArrayList<Hold> holdUdenTutorer() {
        ArrayList<Hold> holds = new ArrayList<>();

        for (Uddannelse u : getUddannelses()) {
            for (Hold h : u.getHolds()) {
                if (h.getTutors().isEmpty()) {
                    holds.add(h);
                }
            }
        }

        return holds;
    }

    // Test Data
    public static void initStorage() {
        Uddannelse u0 = createUddannelse("FINØ");
        Uddannelse u1 = createUddannelse("DMU");

        Hold h0 = u0.createHold("1fiE17B", "Karen Jensen");
        Hold h1 = u1.createHold("1dmE17S", "Margrethe Dybdahl");
        Hold h2 = u1.createHold("1dmE17T", "Kristian Dorland");
        Hold h3 = u1.createHold("1dmE17U", "Kell Ørhøj");

        Tutor t0 = createTutor("Anders Hansen", "aaa@students.eaaa.dk", h1);
        Tutor t1 = createTutor("Peter Jensen", "ppp@students.eaaa.dk", h3);
        Tutor t2 = createTutor("Niels Madsen", "nnn@students.eaaa.dk", h3);
        Tutor t3 = createTutor("Lone Andersen", "lll@students.eaaa.dk", h1);
        Tutor t4 = createTutor("Mads Miller", "mmm@students.eaaa.dk", h0);

        Arrangement a0 = createArrangement("Rusfest", LocalDate.of(2017, 8, 31), LocalTime.of(18, 00),
                LocalTime.of(23, 30), 250);
        Arrangement a1 = createArrangement("Fodbold", LocalDate.of(2017, 8, 30), LocalTime.of(14, 00),
                LocalTime.of(17, 30), 100);
        Arrangement a2 = createArrangement("Brætspil", LocalDate.of(2017, 8, 29), LocalTime.of(12, 00),
                LocalTime.of(16, 30), 25);
        Arrangement a3 = createArrangement("Mindeparken", LocalDate.of(2017, 8, 30), LocalTime.of(18, 00),
                LocalTime.of(22, 00), 25);

        linkTutorArrangement(t0, a0);
        linkTutorArrangement(t1, a0);
        linkTutorArrangement(t4, a0);
        linkTutorArrangement(t2, a1);
        linkTutorArrangement(t3, a2);
        linkTutorArrangement(t2, a2);
        linkTutorArrangement(t4, a3);
        linkTutorArrangement(t0, a3);
    }

    // Model Classes Linking
    public static void linkHoldTutor(Hold hold, Tutor tutor) {
        hold.addTutor(tutor);
    }

    public static void linkTutorArrangement(Tutor tutor, Arrangement arrangement) {
        if (!tutor.harTidsoverlap(arrangement)) {
            tutor.addArrangement(arrangement);
        } else {
            throw new RuntimeException("Tutor har allerede arrangement på givent tidspunkt.");
        }
    }

    // Model Classes Creation
    public static Uddannelse createUddannelse(String navn) {
        Uddannelse u = new Uddannelse(navn);
        addUddannelse(u);

        return u;
    }

    public static Tutor createTutor(String navn, String email) {
        Tutor t = new Tutor(navn, email);
        addTutor(t);

        return t;
    }

    public static Tutor createTutor(String navn, String email, Hold hold) {
        Tutor t = createTutor(navn, email);
        hold.addTutor(t);

        return t;
    }

    public static Arrangement createArrangement(String titel, LocalDate dato, LocalTime startTid, LocalTime slutTid,
            double pris) {
        Arrangement a = new Arrangement(titel, dato, startTid, slutTid, pris);
        addArrangement(a);

        return a;
    }

    // Storage Interfacing
    public static ArrayList<Uddannelse> getUddannelses() {
        return new ArrayList<>(Storage.getUddanelses());
    }

    public static void addUddannelse(Uddannelse uddannelse) {
        Storage.addUddanelse(uddannelse);
    }

    public static ArrayList<Tutor> getTutors() {
        return new ArrayList<>(Storage.getTutors());
    }

    public static void addTutor(Tutor tutor) {
        Storage.addTutor(tutor);
    }

    public static ArrayList<Arrangement> getArrangements() {
        return new ArrayList<>(Storage.getArrangements());
    }

    public static void addArrangement(Arrangement arrangement) {
        Storage.addArrangement(arrangement);
    }
}
