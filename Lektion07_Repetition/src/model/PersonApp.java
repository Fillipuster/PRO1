package model;

public class PersonApp {

    public static void main(String[] args) {
        Person p = new Person("Bent", "Janus", "Christensen", 27, 12, 1990);
        p.printPerson();
        System.out.println("Initialer: " + p.getInit());
        System.out.println("Username: " + p.getUserName());

        System.out.println("Age: " + p.age(28, 12, 2014));
        int year = 2093;
        System.out.println("Er " + year + " skudår: " + p.leapYear(year));

        System.out.println("\n");

        Person noMiddleName = new Person("Bent", "Christensen", 27, 12, 1990);
        noMiddleName.printPerson();
        System.out.println("User(no middle)name: " + noMiddleName.getUserName());
    }
}
