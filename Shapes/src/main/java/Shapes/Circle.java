package Shapes;

public class Circle implements Shape {
    private double R;

    public Circle(double r) throws IllegalArgumentException {
        if (r < 0)
            throw new IllegalArgumentException("Круг не может иметь отрицательный радиус!");
        this.R = r;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(R, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * R;
    }

    public final double getR() {
        return R;
    }

    public void setR(double r) {
        if (r < 0)
            throw new IllegalArgumentException("Круг не может иметь отрицательный радиус!");
        R = r;
    }

    @Override
    public String toString() {
        return "Круг(" + R + ')';
    }
}
