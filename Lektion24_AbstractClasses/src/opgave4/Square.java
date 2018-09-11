package opgave4;

public class Square extends GeometricFigure {

    private double side;

    public Square(double offsetX, double offsetY, double sideLength) {
        super(offsetX, offsetY);
        this.side = sideLength;
    }

    @Override
    public double getArea() {
        return side * side;
    }

}
