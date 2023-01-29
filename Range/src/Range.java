public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range() {
        this(0, 0);
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

    public Range getIntersection(Range interval1, Range interval2) {
        if (interval1.getFrom() >= interval2.getTo() || interval2.getFrom() >= interval1.getTo()) {
            return null;
        }

        this.from = Math.max(interval1.getFrom(), interval2.getFrom());
        this.to = Math.min(interval1.getTo(), interval2.getTo());
        return new Range(from, to);
    }

    public Range[] getUnification(Range interval1, Range interval2) {
        if (interval1.getFrom() > interval2.getTo() || interval2.getFrom() > interval1.getTo()) {
            return new Range[]{interval1, interval2};
        }

        this.from = Math.min(interval1.getFrom(), interval2.getFrom());
        this.to = Math.max(interval1.getTo(), interval2.getTo());
        return new Range[]{new Range(from, to)};
    }

    public Range[] getDifference(Range interval1, Range interval2) {
        if (interval1.getFrom() >= interval2.getTo() || interval2.getFrom() >= interval1.getTo()) {
            return new Range[]{interval1, interval2};
        }

        if (interval1.getFrom() > interval2.getFrom() && interval2.getTo() == interval1.getTo()) {
            return new Range[]{};
        }

        double minFrom = Math.min(interval1.getFrom(), interval2.getFrom());
        double minTo = Math.min(interval1.getTo(), interval2.getTo());
        double maxFrom = Math.max(interval1.getFrom(), interval2.getFrom());
        double maxTo = Math.max(interval1.getTo(), interval2.getTo());

        return new Range[]{new Range(minFrom, maxFrom), new Range(minTo, maxTo)};
    }
}