package opgave4;

public class Circle extends GeometricFigure {

    private double radius;

    public Circle(double posX, double posY, double radius) {
        super(posX, posY);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

}
