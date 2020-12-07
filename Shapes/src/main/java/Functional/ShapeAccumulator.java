package Functional;

import Shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeAccumulator {
    private List<Shape> shapeAccum;

    public void add(Shape shape) {
        shapeAccum.add(shape);
    }

    public ShapeAccumulator() {
        this.shapeAccum = new ArrayList<Shape>();
    }

    public void addAll(List<? extends Shape> shapes) {
        shapeAccum.addAll(shapes);
    }

    public final Shape GetMaxAreaShape() {

        Shape maxAreaShape = shapeAccum.get(0);
        for (Shape shape : shapeAccum) {
            if (maxAreaShape.getArea() < shape.getArea()) {
                maxAreaShape = shape;
            }
        }
        return maxAreaShape;
    }

    public final Shape GetMinAreaShape() {

        Shape minAreaShape = shapeAccum.get(0);
        for (Shape shape : shapeAccum) {
            if (minAreaShape.getArea() > shape.getArea()) {
                minAreaShape = shape;
            }
        }
        return minAreaShape;
    }

    public final Shape GetMaxPerimeterShape() {

        Shape maxAreaShape = shapeAccum.get(0);
        for (Shape shape : shapeAccum) {
            if (maxAreaShape.getPerimeter() < shape.getPerimeter()) {
                maxAreaShape = shape;
            }
        }
        return maxAreaShape;
    }

    public final Shape GetMinPerimeterShape() {

        Shape minAreaShape = shapeAccum.get(0);
        for (Shape shape : shapeAccum) {
            if (minAreaShape.getPerimeter() > shape.getPerimeter()) {
                minAreaShape = shape;
            }
        }
        return minAreaShape;
    }

    public double getTotalArea() {
        double total = 0;
        for (Shape shape : shapeAccum) {
            total += shape.getArea();
        }
        return total;
    }

    public double getTotalPerimeter() {
        double total = 0;
        for (Shape shape : shapeAccum) {
            total += shape.getPerimeter();
        }
        return total;
    }
}
