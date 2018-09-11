package opgave1;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
    /*
     * Attributter der beskriver den ansattes tilstand
     */
    private String firstName;
    private String lastName;
    private boolean trainee;
    private int age;

    /*
     * Constructor, når den ansatte oprettes, skal den have et navn. Ved oprettelse
     * er den ansatte en trainee
     */
    public Employee(String inputFirstName, String inputLastName, int inputAge) {
        firstName = inputFirstName;
        lastName = inputLastName;
        trainee = true;
        age = inputAge;
    }

    public void setFirstName(String inputFirstName) {
        firstName = inputFirstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String inputLastName) {
        lastName = inputLastName;
    }

    public String getLastName() {
        return lastName;
    }

    /*
     * Den ansattes navn kan ændres ved kald af setName metoden
     */
    public void setName(String inputFirstName, String inputLastName) {
        firstName = inputFirstName;
        lastName = inputLastName;
    }

    /*
     * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /*
     * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
     */
    public void setTrainee(boolean isTrainee) {
        trainee = isTrainee;
    }

    /*
     * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
     * isTrainee
     */
    public boolean isTrainee() {
        return trainee;
    }

    public void setAge(int inputAge) {
        age = inputAge;
    }

    public int getAge() {
        return age;
    }

    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Trainee: " + trainee);
        System.out.println("Age: " + age);
        System.out.println("*******************");
    }

    public void birthday() {
        age += 1;
    }
}
