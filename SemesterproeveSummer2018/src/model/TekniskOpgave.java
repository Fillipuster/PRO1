package model;

public class TekniskOpgave extends PraktikOpgave {

    private String programmeringsSprog;

    public TekniskOpgave(String navn, int semester, String programmeringsSprog) {
        super(navn, semester);
        setProgrammeringsSprog(programmeringsSprog);
    }

    public String getProgrammeringsSprog() {
        return programmeringsSprog;
    }

    public void setProgrammeringsSprog(String programmeringsSprog) {
        this.programmeringsSprog = programmeringsSprog;
    }

    @Override
    public String toString() {
        return getNavn() + ": " + getSemester() + " (" + getProgrammeringsSprog() + ")";
    }

}
