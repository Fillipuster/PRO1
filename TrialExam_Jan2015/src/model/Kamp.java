package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Kamp implements Comparable<Kamp> {

    private String sted;
    private LocalDate dato;
    private LocalTime tid;

    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Kamp(String sted, LocalDate dato, LocalTime tid) {
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    public void spillerHonorar(String fileName) {
        PrintWriter out = null;

        try {
            out = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Fejl i læsning af fil. Prøv igen.");
            return;
        }

        for (Deltagelse d : deltagelser) {
            if (!d.isAfbud()) {
                out.write(d.getSpiller().getNavn() + ": " + d.getSpiller().kampHonorar() + "\n");
            }
        }

        out.close();
    }

    public Deltagelse opretDeltagelse(Spiller spiller) {
        Deltagelse d = new Deltagelse(spiller);
        deltagelser.add(d);
        return d;
    }

    public ArrayList<String> afbud() {
        ArrayList<String> afbud = new ArrayList<>();
        for (Deltagelse d : deltagelser) {
            if (d.isAfbud()) {
                afbud.add(d.getSpiller().getNavn() + ": " + d.getBegrundelse());
            }
        }

        return afbud;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }

    @Override
    public int compareTo(Kamp o) {
        int comp0 = dato.compareTo(o.dato);
        if (comp0 == 0) {
            int comp1 = tid.compareTo(o.tid);
            if (comp1 == 0) {
                return sted.compareTo(o.getSted());
            } else {
                return comp1;
            }
        } else {
            return comp0;
        }
    }

    @Override
    public String toString() {
        return sted + "   " + dato.toString() + "   " + tid.toString();
    }

}
