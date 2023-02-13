package range;

public class RangeMain {
    public static void main(String[] args) {
        Range range1 = new Range(5, 10);
        System.out.println(range1);

        System.out.println(range1.getTo());
        System.out.println(range1.getFrom());

        Range range2 = new Range(-1, 10);
        System.out.println(range2.getLength());

        range2.setFrom(4);
        range2.setTo(9);

        System.out.println(range2.isInside(5));

        System.out.println(range2.getIntersection(range1));

        Range[] unionArray = range1.getUnion(range2);

        System.out.println("Координаты интервалов при объединении:");

        for (Range element : unionArray) {
            System.out.println(element.getFrom());
            System.out.println(element.getTo());
        }

        Range[] differenceArray = range1.getDifference(range2);

        System.out.println("Координаты интервалов при вычитании:");

        for (Range element : differenceArray) {
            System.out.println(element.getFrom());
            System.out.println(element.getTo());
        }
    }
}