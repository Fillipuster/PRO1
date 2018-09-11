package model;

import java.util.ArrayList;

public class Hold {
    private String betegnelse, holdleder;

    private Uddannelse uddannelse;
    private ArrayList<Tutor> tutors = new ArrayList<>();

    public Hold(Uddannelse uddannelse, String betegnelse, String holdleder) {
        this.uddannelse = uddannelse;
        setBetegnelse(betegnelse);
        setHoldleder(holdleder);
    }

    public boolean harTidsoverlap(Arrangement arrangement) {
        for (Tutor t : tutors) {
            if (t.harTidsoverlap(arrangement)) {
                return true;
            }
        }

        return false;
    }

    public double arrangementsPris() {
        double pris = 0.0;

        for (Tutor t : tutors) {
            pris += t.arrangementsPris();
        }

        return pris;
    }

    public ArrayList<Tutor> getTutors() {
        return new ArrayList<>(tutors);
    }

    public void addTutor(Tutor tutor) {
        tutors.add(tutor);
        tutor.setHold(this);
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public void setBetegnelse(String betegnelse) {
        this.betegnelse = betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    public void setHoldleder(String holdleder) {
        this.holdleder = holdleder;
    }

    @Override
    public String toString() {
        return betegnelse + " (" + holdleder + ")";
    }
}
