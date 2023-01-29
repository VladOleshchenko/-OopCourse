public class RangeMain {

    public static void main(String[] args) {
        Range range1 = new Range(5, 10);
        System.out.println(range1);

        System.out.println(range1.getTo());
        System.out.println(range1.getFrom());

        Range range2 = new Range(-1, 10);
        System.out.println(range2.getLength());

        range2.setFrom(6);
        range2.setTo(7);

        System.out.println(range2.isInside(5));

        Range intersection = new Range();
        intersection.getIntersection(range1, range2);

        System.out.println(intersection.getIntersection(range1, range2));
        System.out.println(intersection.getFrom());
        System.out.println(intersection.getTo());

        Range unification = new Range();
        Range[] unificationArray = unification.getUnification(range1, range2);

        System.out.println("Координаты интервалов при объединении:");

        for (Range element : unificationArray) {
            System.out.println(element.getFrom());
            System.out.println(element.getTo());
        }

        Range difference = new Range();
        Range[] differenceArray = difference.getDifference(range1, range2);

        System.out.println("Координаты интервалов при вычитании:");

        for (Range element : differenceArray) {
            System.out.println(element.getFrom());
            System.out.println(element.getTo());
        }
    }
}