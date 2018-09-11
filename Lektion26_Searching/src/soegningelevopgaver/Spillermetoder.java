package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        for (Spiller s : spillere) {
            if (s.getMaal() == score) {
                return s;
            }
        }

        return null;
    }

    public Spiller findScoreBinær(ArrayList<Spiller> spillere, int score) {
        boolean found = false;
        int left = 0;
        int right = spillere.size() - 1;
        int middle = -1;
        while (!found && left <= right) {
            middle = (left + right) / 2;
            Spiller k = spillere.get(middle);
            if (k.getMaal() == score) {
                found = true;
            } else if (k.getMaal() > score) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (found) {
            return spillere.get(middle);
        } else {
            return null;
        }
    }

    public String godSpiller(ArrayList<Spiller> spillere) {
        for (Spiller s : spillere) {
            if (s.getHoejde() < 170 && s.getMaal() > 50) {
                return s.getNavn();
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));
        spillerListe.add(new Spiller("Jonas", 163, 79, 52));

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreBinær(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreBinær(spillerListe, 30));

        System.out.println(metoder.godSpiller(spillerListe) + " er en god spiller.");
    }

}
