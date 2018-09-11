package model;

import java.util.ArrayList;

public class Tutor {
    private String navn, email;

    private Hold hold;
    private ArrayList<Arrangement> arrangements = new ArrayList<>();

    public Tutor(String navn, String email) {
        setNavn(navn);
        setEmail(email);
    }

    public boolean harTidsoverlap(Arrangement arrangement) {
        for (Arrangement a : arrangements) {
            if (a.getDato().equals(arrangement.getDato())) {

                if (arrangement.getStartTid().isAfter(a.getStartTid())
                        && arrangement.getStartTid().isBefore(a.getSlutTid())) {
                    return true;
                }

                if (arrangement.getSlutTid().isAfter(a.getStartTid())
                        && arrangement.getSlutTid().isBefore(a.getSlutTid())) {
                    return true;
                }

                if (arrangement.getStartTid().isAfter(a.getStartTid())
                        && arrangement.getSlutTid().isBefore(a.getSlutTid())) {
                    return true;
                }

                if (arrangement.getStartTid().equals(a.getStartTid())
                        && arrangement.getSlutTid().equals(a.getSlutTid())) {
                    return true;
                }

            }
        }

        return false;
    }

    public double arrangementsPris() {
        double pris = 0.0;

        for (Arrangement a : arrangements) {
            pris += a.getPris();
        }

        return pris;
    }

    public Hold getHold() {
        return hold;
    }

    void setHold(Hold hold) {
        this.hold = hold;
    }

    public ArrayList<Arrangement> getArrangements() {
        return new ArrayList<>(arrangements);
    }

    public void addArrangement(Arrangement arrangement) {
        arrangements.add(arrangement);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
