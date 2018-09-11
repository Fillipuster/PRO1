package opgave3;

public class Name {
    private String firstName, middleName, lastName;

    public Name(String firstName, String middleName, String lastName) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
    }

    public String getInit() {
        return firstName.substring(0, 1) + middleName.substring(0, 1) + lastName.substring(0, 1);
    }

    public String getUsername() {
        String username = firstName.substring(0, 2).toUpperCase() + middleName.length()
                + lastName.substring(lastName.length() - 2, lastName.length());
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
