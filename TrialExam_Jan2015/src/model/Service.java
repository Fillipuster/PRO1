package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

import storage.Storage;

public class Service {

    public static void createSomeObjects() {
        ArrayList<Spiller> spillere = new ArrayList<>();

        Spiller s0 = createSpiller("Jane Jensen", 1999);
        spillere.add(s0);
        spillere.add(createSpiller("Lene Hansen", 2000));
        spillere.add(createSpiller("Mette Petersen", 1999));

        ProfSpiller s1 = createProfSpiller("Sofia Kjeldsen", 1999, 50);
        spillere.add(s1);
        spillere.add(createProfSpiller("Maria Nielsen", 2000, 55));

        Kamp k0 = createKamp("Herning", LocalDate.of(2015, 01, 26), LocalTime.of(10, 30));
        Kamp k1 = createKamp("Ikast", LocalDate.of(2015, 01, 27), LocalTime.of(13, 30));

        for (Spiller s : spillere) {
            if (s == s0) {
                // Jane
                Deltagelse d0 = createDeltagelse(k0, s);
                d0.setAfbud(true);
                d0.setBegrundelse("Moster Oda har fødselsdag.");

                createDeltagelse(k1, s);
            } else if (s == s1) {
                // Sofia
                createDeltagelse(k0, s);

                Deltagelse d1 = createDeltagelse(k1, s);
                d1.setAfbud(true);
                d1.setBegrundelse("I dårlig form.");
            } else {
                // DEFAULT
                createDeltagelse(k0, s);
                createDeltagelse(k1, s);
            }
        }
    }

    public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2) {
        // Forsøg på at lave fletningsmetode mislykkedes. Følgende er en lappe-løsning
        // for at opretholde funktionaliteten;

        ArrayList<Kamp> l1 = new ArrayList<>(list1);
        ArrayList<Kamp> l2 = new ArrayList<>(list2);

        l1.addAll(l2);
        Collections.sort(l1);

        return l1;
    }

    public static void updateSpillerDeltagelse(Spiller spiller, Deltagelse deltagelse) {
        if (spiller != null && deltagelse != null) {
            deltagelse.setSpiller(spiller);
        }
    }

    public static Deltagelse createDeltagelse(Kamp kamp, Spiller spiller) {
        Deltagelse d = kamp.opretDeltagelse(spiller);
        return d;
    }

    public static Kamp createKamp(String sted, LocalDate dato, LocalTime tid) {
        Kamp k = new Kamp(sted, dato, tid);
        addKamp(k);
        return k;
    }

    public static void updateKamp(Kamp kamp, String sted, LocalDate dato, LocalTime tid) {
        kamp.setSted(sted);
        kamp.setDato(dato);
        kamp.setTid(tid);
    }

    public static Spiller createSpiller(String navn, int aargang) {
        Spiller s = new Spiller(navn, aargang);
        addSpiller(s);
        return s;
    }

    public static ProfSpiller createProfSpiller(String navn, int aargang, double kampHonorar) {
        ProfSpiller ps = new ProfSpiller(navn, aargang, kampHonorar);
        addSpiller(ps);
        return ps;
    }

    public static ArrayList<Kamp> getKampe() {
        return new ArrayList<>(Storage.getKampe());
    }

    public static void addKamp(Kamp kamp) {
        Storage.addKamp(kamp);
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(Storage.getSpillere());
    }

    public static void addSpiller(Spiller spiller) {
        Storage.addSpiller(spiller);
    }

}
