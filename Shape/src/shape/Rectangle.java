package shape;

public class Rectangle implements Shape, Comparable<Shape> {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return width + width + height + height;
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
        return "Прямоугольник со сторонами " + this.width + " и " + this.height + " и площадью " + this.getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Rectangle r = (Rectangle) o;
        return width == r.width && height == r.height;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);
        return hash;
    }
}