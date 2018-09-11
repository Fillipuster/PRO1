package storage;

import java.util.ArrayList;

import model.PraktikKontrakt;
import model.PraktikVirksomhed;

public class Storage {

    public static ArrayList<PraktikVirksomhed> praktikVirksomheds = new ArrayList<>();
    public static ArrayList<PraktikKontrakt> praktikKontrakts = new ArrayList<>();

    public static ArrayList<PraktikVirksomhed> getPraktikVirksomheds() {
        return new ArrayList<>(praktikVirksomheds);
    }

    public static void addPraktikVirksomed(PraktikVirksomhed praktikVirksomhed) {
        praktikVirksomheds.add(praktikVirksomhed);
    }

    public static ArrayList<PraktikKontrakt> getPraktikKontrakts() {
        return new ArrayList<>(praktikKontrakts);
    }

    public static void addPraktikKontrakt(PraktikKontrakt praktikKontrakt) {
        praktikKontrakts.add(praktikKontrakt);
    }

}
