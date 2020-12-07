package Shapes;

public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws IllegalArgumentException {
        if (!(((a + b) > c) && ((a + c) > b) && ((b + c) > a)))
            throw new IllegalArgumentException("Невозможно построить треугольник с такими параметрами!");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = this.getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return (a + b + c);
    }

    public final double getA() {
        return a;
    }

    public void setA(double a) {
        if (!(((a + b) > c) && ((a + c) > b) && ((b + c) > a)))
            throw new IllegalArgumentException("Невозможно построить треугольник с такими параметрами!");
        this.a = a;
    }

    public final double getB() {
        return b;
    }

    public void setB(double b) {
        if (!(((a + b) > c) && ((a + c) > b) && ((b + c) > a)))
            throw new IllegalArgumentException("Невозможно построить треугольник с такими параметрами!");
        this.b = b;
    }

    public final double getC() {
        return c;
    }

    public void setC(double c) {
        if (!(((a + b) > c) && ((a + c) > b) && ((b + c) > a)))
            throw new IllegalArgumentException("Невозможно построить треугольник с такими параметрами!");
        this.c = c;
    }

    @Override
    public String toString() {
        return "Треугольник(" + Double.valueOf(a) + ',' + Double.valueOf(b) + ',' + Double.valueOf(c) + ')';
    }
}
