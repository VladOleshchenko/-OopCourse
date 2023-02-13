package range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        double epsilon = 1.0e-10;
        return to - number > -epsilon && from - number < epsilon;
    }

    public Range getIntersection(Range range) {
        if (this.from >= range.to || range.from >= this.to) {
            return null;
        }

        return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (this.from > range.to || range.from > this.to) {
            return new Range[]{this, range};
        }

        return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
    }

    public Range[] getDifference(Range range) {
        if (this.from >= range.to || range.from >= this.to) {
            return new Range[]{this};
        }

        if (this.from >= range.from && this.to <= range.to) {
            return new Range[]{};
        }

        if (this.from < range.from && this.to <= range.to) {
            return new Range[]{new Range(this.from, range.from)};
        }

        if (this.from >= range.from) {
            return new Range[]{new Range(range.to, this.to)};
        }

        return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
    }
}