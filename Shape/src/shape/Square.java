package shape;

public class Square implements Shape, Comparable<Shape> {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public double getPerimeter() {
        return sideLength * 4;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
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
        return "Квадрат со стороной " + this.sideLength + " и площадью " + this.getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Square s = (Square) o;
        return sideLength == s.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);
        return hash;
    }
}