package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class PraktikVirksomhed {

    private String navn;
    private String feedback;
    private String kontaktPerson;

    private ArrayList<PraktikOpgave> praktikOpgaves = new ArrayList<>();

    // PraktikVirksomhed is responsible for maintaining the association between
    // PraktikVirksomhed and PraktikKontrakt.
    private ArrayList<PraktikKontrakt> praktikKontrakts = new ArrayList<>();

    public PraktikVirksomhed(String navn, String feedback, String kontaktPerson) {
        setNavn(navn);
        setFeedback(feedback);
        setKontaktPerson(kontaktPerson);
    }

    public int praktikOpgaverISemester(int semester) {
        int amount = 0;

        for (PraktikOpgave o : praktikOpgaves) {
            if (o.getSemester() == semester) {
                amount++;
            }
        }

        return amount;
    }

    public int getTotalAntalugentligeTimerIPeriode(LocalDate start, LocalDate slut) {
        int sum = 0;

        for (PraktikKontrakt k : praktikKontrakts) {
            if (k.getPeriodeStart().isBefore(start) || k.getPeriodeSlut().isAfter(slut)) {
                continue;
            }

            sum += k.getTimerPerUge();
        }

        return sum;
    }

    public int getTotalAntalUgentligeTimerIPeriode(LocalDate start, LocalDate slut) {
        int sum = 0;

        for (PraktikKontrakt k : praktikKontrakts) {
            if (!k.getPeriodeStart().isBefore(start) && !k.getPeriodeSlut().isAfter(slut)) {
                sum += k.getTimerPerUge();
            }
        }

        return sum;
    }

    public ArrayList<PraktikKontrakt> sorterKontrakter() {
        ArrayList<PraktikKontrakt> contracts = new ArrayList<>(praktikKontrakts);

        for (int i = 0; i < contracts.size(); i++) {
            int low = i;

            for (int j = i; j < contracts.size(); j++) {
                if (contracts.get(low).compareTo(contracts.get(j)) > 0) {
                    low = j;
                }
            }

            // Swap
            PraktikKontrakt temp = contracts.get(low);
            contracts.set(low, contracts.get(i));
            contracts.set(i, temp);
        }

        return contracts;
    }

    public void skrivTilFilKontrakter() {
        PrintWriter out = null;

        try {
            out = new PrintWriter(getNavn() + ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("Fejl i læsning af fil. Prøv igen.");
            return;
        }

        for (PraktikKontrakt k : praktikKontrakts) {
            out.write(k.toString() + "\n");
        }

        out.close();
    }

    public PraktikOpgave createAnalyseOpgave(String navn, int semester, String analyseModel) {
        PraktikOpgave opg = new AnalyseOpgave(navn, semester, analyseModel);
        addPraktikOpgave(opg);

        return opg;
    }

    public PraktikOpgave createTekniskOpgave(String navn, int semester, String programmeringsSprog) {
        PraktikOpgave opg = new TekniskOpgave(navn, semester, programmeringsSprog);
        addPraktikOpgave(opg);

        return opg;
    }

    public ArrayList<PraktikOpgave> getPraktikOpgaves() {
        return new ArrayList<>(praktikOpgaves);
    }

    public void addPraktikOpgave(PraktikOpgave praktikOpgave) {
        praktikOpgaves.add(praktikOpgave);
    }

    public void removePraktikOpgave(PraktikOpgave praktikOpgave) {
        praktikOpgaves.remove(praktikOpgave);
    }

    public ArrayList<PraktikKontrakt> getPraktikKontrakts() {
        return new ArrayList<>(praktikKontrakts);
    }

    public void addPraktikKontrakt(PraktikKontrakt praktikKontrakt) {
        praktikKontrakts.add(praktikKontrakt);
        praktikKontrakt.setPraktikVirksomhed(this);
    }

    public void removePraktikKontrakt(PraktikKontrakt praktikKontrakt) {
        praktikKontrakts.remove(praktikKontrakt);
        praktikKontrakt.setPraktikVirksomhed(null);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getKontaktPerson() {
        return kontaktPerson;
    }

    public void setKontaktPerson(String kontaktPerson) {
        this.kontaktPerson = kontaktPerson;
    }

    @Override
    public String toString() {
        return getNavn() + " (" + getKontaktPerson() + "): " + getFeedback();
    }

}
