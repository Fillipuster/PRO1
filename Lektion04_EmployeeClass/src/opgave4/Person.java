package opgave4;

public class Person {
    private String name;
    private String adress;
    private double monthlySalary;
    private int previousFirms;

    public Person(String name, String adress) {
        super();
        this.name = name;
        this.adress = adress;
        this.monthlySalary = 0;
        this.previousFirms = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setMonthlySalary(double salary) {
        this.monthlySalary = salary;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public int getPreviousFirms() {
        return this.previousFirms;
    }

    public void switchFirm() {
        this.previousFirms += 1;
    }

    public double calcYearlySalary(double holidayMoneyPercentage) {
        return (this.monthlySalary * 12) * (holidayMoneyPercentage + 1);
    }

    public void printPerson() {
        System.out.println("****************************");
        System.out.println("Name: " + name);
        System.out.println("Adress : " + adress);
        System.out.println("Salary (M): " + monthlySalary);
        System.out.println("Salary (Y + H2,5): " + calcYearlySalary(0.025));
        System.out.println("Previous Firms: " + previousFirms);
        System.out.println();
    }
}
