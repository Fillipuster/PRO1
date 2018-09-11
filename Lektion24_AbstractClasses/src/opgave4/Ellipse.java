package opgave4;

public class Ellipse extends GeometricFigure {

    private double radiusA, radiusB;

    public Ellipse(double posX, double posY, double radiusA, double radiusB) {
        super(posX, posY);
        this.radiusA = radiusA;
        this.radiusB = radiusB;
    }

    @Override
    public double getArea() {
        return Math.PI * radiusA * radiusB;
    }

}
