package Shapes;

public class Rectangle implements Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) throws IllegalArgumentException {
        if (width > 0 && length > 0) {
            this.width = width;
            this.length = length;
        } else throw new IllegalArgumentException("Некорректный введёный размер!");
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    public final double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0)
            throw new IllegalArgumentException("Некорректный введёный размер!");
        this.width = width;
    }

    public final double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0)
            throw new IllegalArgumentException("Некорректный введёный размер!");
        this.length = length;
    }

    @Override
    public String toString() {
        return "Прямоугольник(" + width + 'x' + length + ')';
    }
}
