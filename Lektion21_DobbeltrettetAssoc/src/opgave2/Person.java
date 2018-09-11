package opgave2;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> gifts = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }

    public ArrayList<Gift> getGifts() {
        return new ArrayList<>(gifts);
    }

    public void addGift(Gift gift) {
        gifts.add(gift);
    }

    public void removeGift(Gift gift) {
        gifts.remove(gift);
    }

    public double totalGiftsValue() {
        double total = 0;
        for (Gift g : gifts) {
            total += g.getPrice();
        }

        return total;
    }

    public ArrayList<Person> allGifters() {
        ArrayList<Person> gifters = new ArrayList<>();
        for (Gift g : gifts) {
            gifters.add(g.getGiver());
        }

        return gifters;
    }

}
