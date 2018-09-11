package model;

import java.util.ArrayList;

public class Plads {
    private int nr;
    private Omr�de omr�de;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Plads(int nr, Omr�de omr�de) {
        setNr(nr);
        setOmr�de(omr�de);
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

    public Omr�de getOmr�de() {
        return omr�de;
    }

    public void setOmr�de(Omr�de omr�de) {
        this.omr�de = omr�de;
    }
}
