package opgave3;

public abstract class Person {

    private String navn;
    private String adresse;

    public Person(String navn, String adresse) {
        setNavn(navn);
        setAdresse(adresse);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
