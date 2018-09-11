package model;

public abstract class PraktikOpgave {

    private String navn;
    private int semester;

    public PraktikOpgave(String navn, int semester) {
        setNavn(navn);
        setSemester(semester);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

}
