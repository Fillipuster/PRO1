package model;

import java.util.ArrayList;

public class Arrangement {
    private String navn;
    private boolean offentlig;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Arrangement(String navn, boolean offentlig) {
        setNavn(navn);
        setOffentlig(offentlig);
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservationer.remove(reservation);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean isOffentlig() {
        return offentlig;
    }

    public void setOffentlig(boolean offentlig) {
        this.offentlig = offentlig;
    }
}