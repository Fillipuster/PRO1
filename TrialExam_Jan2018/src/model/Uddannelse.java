package model;

import java.util.ArrayList;

public class Uddannelse {
    private String navn;

    private ArrayList<Hold> holds = new ArrayList<>();

    public Uddannelse(String navn) {
        this.navn = navn;
    }

    public ArrayList<String> tutorOversigt() {
        ArrayList<String> oversigt = new ArrayList<>();

        for (Hold h : holds) {
            for (Tutor t : h.getTutors()) {
                oversigt.add(t.getNavn() + " " + navn + " " + h.getBetegnelse() + " " + t.getEmail() + " "
                        + h.getHoldleder());
            }
        }

        return oversigt;
    }

    public ArrayList<Hold> getHolds() {
        return new ArrayList<>(holds);
    }

    public Hold createHold(String betegnelse, String holdleder) {
        Hold h = new Hold(this, betegnelse, holdleder);
        holds.add(h);

        return h;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
