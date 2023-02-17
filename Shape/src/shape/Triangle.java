package shape;

public class Triangle implements Shape, Comparable<Shape> {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }

    public double getArea() {
        double epsilon = 1.0e-10;

        if (Math.abs((x3 - x1) * (y2 - y1) - (x2 - x1) * (y3 - y1)) <= epsilon) {
            return 0;
        }

        double side1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double side2 = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        double side3 = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));

        double halfPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));
    }

    public double getPerimeter() {
        double epsilon = 1.0e-10;

        if (Math.abs((x3 - x1) * (y2 - y1) - (x2 - x1) * (y3 - y1)) <= epsilon) {
            return 0;
        }

        double side1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double side2 = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        double side3 = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));

        return side1 + side2 + side3;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
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
        return "Треугольник с площадью " + this.getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Triangle t = (Triangle) o;
        return x1 == t.x1 && y1 == t.y1 && x2 == t.x2 && y2 == t.y2 && x3 == t.x3 && y3 == t.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }
}