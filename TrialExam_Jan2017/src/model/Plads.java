package model;

import java.util.ArrayList;

public class Plads {
    private int nr;
    private Område område;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Plads(int nr, Område område) {
        setNr(nr);
        setOmråde(område);
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservationer.add(reservation);
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Område getOmråde() {
        return område;
    }

    public void setOmråde(Område område) {
        this.område = område;
    }
}
