import setPackage.Set;

public class Main {
    public static void main(String[] args) {
        Set set1 = new Set(new Integer[]{1, 3, 5});
        set1.printSet();
        set1 = set1.mergeSets(new Set(new Integer[] {3, 4, 8}));
        set1.printSet();

        System.out.println(set1.isPartOfSet(3));

        set1.addElement(9);
        set1.addElement(1);
        set1.deleteElement(5);
        set1.printSet();

        System.out.println(set1.equals(new Set(new Integer[] {1, 3, 4, 7, 8})));
        System.out.println(set1.equals(new Set(new Integer[] {1, 3, 4, 8, 9})));
        System.out.println(set1.toString());
    }
}