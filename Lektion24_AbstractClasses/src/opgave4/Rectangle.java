package opgave4;

public class Rectangle extends GeometricFigure {

    private double sideA, sideB;

    public Rectangle(double posX, double posY, double sideA, double sideB) {
        super(posX, posY);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getArea() {
        return sideA * sideB;
    }

}
