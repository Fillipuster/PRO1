package Child;

public class ChildApp {

    public static void main(String[] args) {
        Child child = new Child(10, false,
                new double[] { 4.2, 9.3, 12.4, 17.5, 23.2, 25.3, 28.6, 30.4, 33.9, 35.1, 37.3 });
        System.out.println(String.format("Alder: %s", child.getAge()));
        String inst = child.institution();
        System.out.println(String.format("Appropriate Institution: %s", inst));

        System.out.println("Weight (age 2): " + child.getWeight(2));
        System.out.println("Biggest Weight Gain: " + child.getBiggestWeightGain());

        System.out.println();

        Institution orphanage = new Institution("Flakey Oats Orphanage", "123 Livingwood Alley, 2535 Higgsfield");

        System.out.println("Institution Name: " + orphanage.getName());
        System.out.println("Insitution Adress: " + orphanage.getAdress());

        orphanage.addChild(child);
        orphanage.addChild(new Child(7, true, new double[] { 4.1, 8.3, 14.2, 18.7, 25.0, 32.1, 40.1 }));

        System.out.println("Average Child Age: " + orphanage.averageAge());
    }

}
