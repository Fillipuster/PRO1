package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {
    private String titel;
    private LocalDate dato;
    private LocalTime startTid, slutTid;
    private double pris;

    public Arrangement(String titel, LocalDate dato, LocalTime startTid, LocalTime slutTid, double pris) {
        this.titel = titel;
        this.setDato(dato);
        this.setStartTid(startTid);
        this.setSlutTid(slutTid);
        this.setPris(pris);
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public void setStartTid(LocalTime startTid) {
        this.startTid = startTid;
    }

    public LocalTime getSlutTid() {
        return slutTid;
    }

    public void setSlutTid(LocalTime slutTid) {
        this.slutTid = slutTid;
    }
}
