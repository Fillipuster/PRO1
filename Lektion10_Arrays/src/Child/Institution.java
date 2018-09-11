package Child;

public class Institution {
    private String name;
    private String adress;
    private Child[] children;
    private int childCount;
    private final int CHILD_CAPACITY = 55;

    public Institution(String name, String adress) {
        this.name = name;
        this.adress = adress;
        this.childCount = 0;
        this.children = new Child[CHILD_CAPACITY];
    }

    public void addChild(Child child) {
        children[childCount++] = child;
    }

    public double averageAge() {
        int sum = 0;
        for (Child child : children) {
            sum += child.getAge();
            System.out.println(child.getAge());
        }

        return (double) sum / childCount;
    }

    public Child[] getChildren() {
        return this.children;
    }

    public int getChildCount() {
        return this.childCount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
