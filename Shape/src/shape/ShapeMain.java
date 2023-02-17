package shape;

import java.util.Arrays;

public class ShapeMain {
    public static Shape findShapeWithMaxArea(Shape[] shapes) {
        Arrays.sort(shapes);
        return shapes[shapes.length - 1];
    }

    public static Shape findShapeWith2ndArea(Shape[] shapes) {
        Arrays.sort(shapes);
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Square(5), new Triangle(1, 1, 13, 19, 5, 17), new Circle(5),
                new Rectangle(5, 10), new Square(3), new Circle(7)};

        System.out.println("Наибольшая площадь:");
        System.out.println(findShapeWithMaxArea(shapes).getArea());

        System.out.println("Вторая по величине площадь:");
        System.out.println(findShapeWith2ndArea(shapes).getArea());

        System.out.println(shapes[5]);

        Shape r = new Rectangle(5, 3);
        System.out.println(r.getPerimeter());

        System.out.printf("%f,%f", r.getHeight(), r.getWidth());

        Shape s = new Square(4);
        System.out.println(s.getPerimeter());

        Shape t = new Triangle(1, 1, 3, 11, 13, 33);
        System.out.println(t.getPerimeter());

        Shape c = new Circle(4);
        System.out.println(c.getPerimeter());
    }
}