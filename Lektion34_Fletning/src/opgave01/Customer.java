package opgave01;

import java.util.ArrayList;
import java.util.Random;

public class Customer implements Comparable<Customer> {

    private String name;
    private int age;

    public Customer(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Customer o) {
        int comp0 = name.compareTo(o.getName());
        if (comp0 == 0) {
            return age - o.getAge();
        } else {
            return comp0;
        }
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    private static String[] firstnames = { "David", "Christopher", "Craig", "Scott", "Andrew", "Michael", "James",
            "John", "Ross", "Daniel", "Steven", "Jamie", "Mark", "Paul", "Ryan", "Stephen", "Sean", "Robert", "Stuart",
            "Gary", "Darren", "William", "Kevin", "Thomas", "Martin", "Matthew", "Liam", "Jonathan", "Callum", "Alan",
            "Calum", "Graeme", "Jordan", "Alexander", "Lee", "Richard", "Iain", "Adam", "Fraser", "Lewis", "Colin",
            "Grant", "Peter", "Dean", "Gavin", "Shaun", "Marc", "Ian", "Greg", "Gordon", "Brian", "Graham", "Nicholas",
            "Neil", "Stewart", "Euan", "Anthony", "Joseph", "Kieran", "Kyle", "Jack", "Jason", "Alistair", "Samuel",
            "Allan", "Aaron", "Kenneth", "George", "Barry", "Cameron", "Joshua", "Douglas", "Ewan", "Derek", "Benjamin",
            "Nathan", "Duncan", "Dale", "Blair", "Rory", "Patrick", "Simon", "Alasdair", "Garry", "Alastair", "Martyn",
            "Philip", "Charles", "Sam", "Daryl", "Gregor", "Edward", "Niall", "Donald", "Murray", "Keith", "Ben",
            "Bryan", "Connor", "Luke", "Josh", "Greig", "Robbie", "Angus", "Kristopher", "Gareth", "Bruce", "Declan",
            "Owen", "Stefan", "Raymond", "Mohammed", "Malcolm", "Frazer", "Hugh", "Dominic", "Kristofer", "Robin",
            "Jon", "Russell", "Billy", "Kris", "Antony", "Gerard", "Jonathon", "Aidan", "Oliver", "Wayne", "Marcus",
            "Shane", "Tony", "Drew", "Hamish", "Mathew", "Francis", "Joe", "Ruaridh", "Tom", "Ciaran", "Danny", "Lloyd",
            "Max", "Conor", "Fergus", "Justin", "Louis", "Roy", "Brendan", "Darryl", "Glen", "Glenn", "Keir", "Nicky",
            "Phillip", "Ronald", "Kristoffer", "Struan", "Timothy", "Warren", "Arran", "Bradley", "Calvin", "Finlay",
            "Gregg", "Jake", "Ruairidh", "Damien", "Harry", "Kerr", "Mohammad", "Terry", "Vincent", "Campbell",
            "Elliot", "Keiran", "Ricky", "Terence", "Brett", "Clark", "Chris", "Henry", "Jordon", "Kieron", "Laurence",
            "Omar", "Arron", "Ashley", "Ethan", "Frank", "Jay", "Johnathan", "Muhammad", "Sandy", "Adrian", "Alex",
            "Anton", "Barrie", "Jacob", "Jeff" };

    private static String[] lastnames = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson",
            "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia",
            "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young",
            "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson",
            "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards",
            "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey",
            "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James",
            "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood", "Barnes", "Ross", "Henderson",
            "Coleman", "Jenkins", "Perry", "Powell", "Long", "Patterson", "Hughes", "Flores", "Washington", "Butler",
            "Simmons", "Foster", "Gonzales", "Bryant", "Alexander", "Russell", "Griffin", "Diaz" };

    public static Customer generateRandom(int minAge, int maxAge) {
        Random rand = new Random();
        return new Customer(
                firstnames[rand.nextInt(firstnames.length)] + " " + lastnames[rand.nextInt(lastnames.length)],
                rand.nextInt(maxAge - minAge) + minAge);
    }

    public static ArrayList<Customer> generateRandoms(int amount, int minAge, int maxAge) {
        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            customers.add(generateRandom(minAge, maxAge));
        }

        return customers;
    }

}
