package model;

import java.time.LocalDate;

public class PraktikKontrakt implements Comparable<PraktikKontrakt> {

    private String opgavebeskrivelse;
    private int timerPerUge;
    private LocalDate periodeStart, periodeSlut;

    // PraktikVirksomhed is responsible for maintaining the association between
    // PraktikVirksomhed and PraktikKontrakt.
    private PraktikVirksomhed praktikVirksomhed;

    public PraktikKontrakt(String opgavebeskrivelse, int timerPerUge, LocalDate periodeStart, LocalDate periodeSlut) {
        setOpgavebeskrivelse(opgavebeskrivelse);
        setTimerPerUge(timerPerUge);
        setPeriodeStart(periodeStart);
        setPeriodeSlut(periodeSlut);
    }

    public PraktikVirksomhed getPraktikVirksomhed() {
        return praktikVirksomhed;
    }

    public void setPraktikVirksomhed(PraktikVirksomhed praktikVirksomhed) {
        this.praktikVirksomhed = praktikVirksomhed;
    }

    public String getOpgavebeskrivelse() {
        return opgavebeskrivelse;
    }

    public void setOpgavebeskrivelse(String opgavebeskrivelse) {
        this.opgavebeskrivelse = opgavebeskrivelse;
    }

    public int getTimerPerUge() {
        return timerPerUge;
    }

    public void setTimerPerUge(int timerPerUge) {
        this.timerPerUge = timerPerUge;
    }

    public LocalDate getPeriodeStart() {
        return periodeStart;
    }

    public void setPeriodeStart(LocalDate periodeStart) {
        this.periodeStart = periodeStart;
    }

    public LocalDate getPeriodeSlut() {
        return periodeSlut;
    }

    public void setPeriodeSlut(LocalDate periodeSlut) {
        this.periodeSlut = periodeSlut;
    }

    @Override
    public String toString() {
        return getOpgavebeskrivelse() + " (" + getTimerPerUge() + "/uge): " + getPeriodeStart() + " - "
                + getPeriodeSlut();
    }

    @Override
    public int compareTo(PraktikKontrakt o) {
        int comp = getPeriodeStart().compareTo(o.getPeriodeStart());
        if (comp == 0) {
            return getOpgavebeskrivelse().compareTo(o.getOpgavebeskrivelse());
        } else {
            return comp;
        }
    }

}
