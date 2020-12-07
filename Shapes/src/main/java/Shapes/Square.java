package Shapes;

public class Square implements Shape {
    private double length;

    public Square(double length) throws IllegalArgumentException {
        if (length < 0) throw new IllegalArgumentException("Некорректная введёная длина!");
        this.length = length;
    }

    @Override
    public double getArea() {
        return Math.pow(length, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }

    public final double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 0) throw new IllegalArgumentException("Некорректная введёная длина!");
        this.length = length;
    }

    @Override
    public String toString() {
        return "Квадрат(" + length + 'x' + length + ')';
    }
}
