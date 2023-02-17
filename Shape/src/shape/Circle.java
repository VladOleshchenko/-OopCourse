package shape;

public class Circle implements Shape, Comparable<Shape> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return radius * radius;
    }

    public double getHeight() {
        return radius * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public int compareTo(Shape shape) {
        double epsilon = 1.0e-10;
        if (this.getArea() - shape.getArea() > epsilon) {
            return 1;
        }

        if (shape.getArea() - this.getArea() > epsilon) {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Окружность с радиусом  " + this.radius + " и площадью " + this.getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Circle c = (Circle) o;
        return radius == c.radius;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Double.hashCode(radius);
        return hash;
    }
}