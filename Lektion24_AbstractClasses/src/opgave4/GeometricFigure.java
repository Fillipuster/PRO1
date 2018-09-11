package opgave4;

public abstract class GeometricFigure {

    private double posX = 0;
    private double posY = 0;

    public GeometricFigure(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public abstract double getArea();

}
