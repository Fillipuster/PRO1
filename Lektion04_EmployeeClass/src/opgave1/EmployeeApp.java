package opgave1;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Jens", "Hansen", 43);
        e1.printEmployee();
        e1.birthday();
        e1.printEmployee();
    }

}
