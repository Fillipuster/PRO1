package opgave4;

public class PersonApp {

    public static void main(String[] args) {
        Person p1 = new Person("Hans Jensen", "Skovvej 21, 7711 Holmgaard");
        p1.setMonthlySalary(42877);

        p1.printPerson();

        p1.switchFirm();
        p1.printPerson();
        p1.switchFirm();
        p1.printPerson();
    }

}
