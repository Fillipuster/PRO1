package service;

import java.time.LocalDate;

import model.PraktikKontrakt;
import model.PraktikOpgave;
import model.PraktikVirksomhed;
import storage.Storage;

public class Service {

    public static void initStorage() {
        PraktikVirksomhed v0 = createPraktikVirksomhed("Vestas", "Godt miljø.", "Peter Jstesen");
        PraktikVirksomhed v1 = createPraktikVirksomhed("Nilfisk", "Udfordrende.", "Peter Justesen");
        PraktikVirksomhed v2 = createPraktikVirksomhed("POWER", "Energisk.", "Margrethe Dybdahl");

        createPraktikKontrakt(v0, "Tester", 37, LocalDate.of(2018, 7, 1), LocalDate.of(2018, 9, 16));
        createPraktikKontrakt(v1, "Udvikler", 27, LocalDate.of(2018, 3, 14), LocalDate.of(2018, 5, 6));
        createPraktikKontrakt(v0, "Programmør", 15, LocalDate.of(2018, 2, 14), LocalDate.of(2018, 6, 6));
        createPraktikKontrakt(v0, "Analytiker", 12, LocalDate.of(2018, 2, 14), LocalDate.of(2018, 4, 6));

        v0.createTekniskOpgave("Flowoptimering", 5, "Java");
        v0.createTekniskOpgave("Test i felten", 5, "C#");
        v1.createAnalyseOpgave("Risikoanalyse", 3, "MUST");
        v2.createTekniskOpgave("Simulering", 5, "Python");
    }

    public static PraktikVirksomhed createPraktikVirksomhed(String navn, String feedback, String kontaktPerson) {
        PraktikVirksomhed p = new PraktikVirksomhed(navn, feedback, kontaktPerson);

        Storage.addPraktikVirksomed(p);

        return p;
    }

    public static void updatePraktikVirksomhed(PraktikVirksomhed praktikVirksomhed, String navn, String feedback,
            String kontaktPerson) {
        praktikVirksomhed.setNavn(navn);
        praktikVirksomhed.setFeedback(feedback);
        praktikVirksomhed.setKontaktPerson(kontaktPerson);
    }

    public static PraktikKontrakt createPraktikKontrakt(PraktikVirksomhed praktikVirksomhed, String opgavebeskrivelse,
            int timerPerUge, LocalDate periodeStart, LocalDate periodeSlut) {
        PraktikKontrakt p = new PraktikKontrakt(opgavebeskrivelse, timerPerUge, periodeStart, periodeSlut);
        praktikVirksomhed.addPraktikKontrakt(p);

        Storage.addPraktikKontrakt(p);

        return p;
    }

    public static PraktikOpgave createAnalyseOpgave(PraktikVirksomhed praktikVirksomhed, String navn, int semester,
            String analyseModel) {
        return praktikVirksomhed.createAnalyseOpgave(navn, semester, analyseModel);
    }

    public static PraktikOpgave createTekniskOpgave(PraktikVirksomhed praktikVirksomhed, String navn, int semester,
            String programmeringsSprog) {
        return praktikVirksomhed.createTekniskOpgave(navn, semester, programmeringsSprog);
    }

    public static void addVirksomhedToKontrakt(PraktikVirksomhed virksomhed, PraktikKontrakt kontrakt) {
        if (kontrakt.getPraktikVirksomhed() != virksomhed || !virksomhed.getPraktikKontrakts().contains(kontrakt)) {
            virksomhed.addPraktikKontrakt(kontrakt);
        }
    }

    public static String getEftertragtetSemesterVirksomhed(int semester) {
        int highest = -1;
        PraktikVirksomhed virksomhed = null;

        for (PraktikVirksomhed v : Storage.getPraktikVirksomheds()) {
            int opgaver = v.praktikOpgaverISemester(semester);
            if (opgaver > highest) {
                highest = opgaver;
                virksomhed = v;
            }
        }

        return virksomhed.getNavn();
    }

}
