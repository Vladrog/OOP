import Functional.RWHelper;
import Functional.ShapeAccumulator;
import Shapes.*;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        try {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            Square square = new Square(6);
            Triangle triangle = new Triangle(4, 6, 7);
            Triangle triangle1 = new Triangle(5, 5, 5);
            List<Shape> shapes = new ArrayList<>();//Arrays.asList(circle, rectangle, square, triangle);

            shapes.add(square);
            shapes.add(triangle);
            shapes.add(rectangle);
            shapes.add(circle);

            RWHelper.Write(shapes);
            ShapeAccumulator shapeAccumulator = new ShapeAccumulator();

            shapeAccumulator.addAll((List<Shapes.Shape>) (RWHelper.Read()));

            double min_Area = shapeAccumulator.GetMinAreaShape().getArea();
            double max_Area = shapeAccumulator.GetMaxAreaShape().getArea();

            double min_Perimeter = shapeAccumulator.GetMinPerimeterShape().getPerimeter();
            double max_Perimeter = shapeAccumulator.GetMaxPerimeterShape().getPerimeter();

            double totalArea = shapeAccumulator.getTotalArea();

            System.out.println("Максимальная площадь у " + shapeAccumulator.GetMaxAreaShape().getClass().getSimpleName() + " равная " + max_Area);
            System.out.println("Минимальная площадь у " + shapeAccumulator.GetMinAreaShape().getClass().getSimpleName() + " равная " + min_Area);
            System.out.println("Максимальная периметр у " + shapeAccumulator.GetMaxPerimeterShape().getClass().getSimpleName() + " равная " + max_Perimeter);
            System.out.println("Минимальный периметр у " + shapeAccumulator.GetMinPerimeterShape().getClass().getSimpleName() + " равная " + min_Perimeter);
            System.out.println("Сумма всех фигур равна " + totalArea);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
