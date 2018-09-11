package model;

public class AnalyseOpgave extends PraktikOpgave {

    private String analyseModel;

    public AnalyseOpgave(String navn, int semester, String analyseModel) {
        super(navn, semester);
        setAnalyseModel(analyseModel);
    }

    public String getAnalyseModel() {
        return analyseModel;
    }

    public void setAnalyseModel(String analyseModel) {
        this.analyseModel = analyseModel;
    }

    @Override
    public String toString() {
        return getNavn() + ": " + getSemester() + " (" + getAnalyseModel() + ")";
    }

}
