package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
    private LocalDateTime start, slut;

    private ArrayList<Plads> pladser = new ArrayList<>();

    public Reservation(LocalDateTime start, LocalDateTime slut) {
        setStart(start);
        setSlut(slut);
    }

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public void addPlads(Plads plads) {
        pladser.add(plads);
    }

    public void removePlads(Plads plads) {
        pladser.remove(plads);
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getSlut() {
        return slut;
    }

    public void setSlut(LocalDateTime slut) {
        this.slut = slut;
    }
}
