package Generics;

public class TestClassArrayList {
    static void main() throws ArrayListException {
        CustomDynamicArrayList<Integer> list = new CustomDynamicArrayList<>();
        CustomDynamicArrayList<String> list1 = new CustomDynamicArrayList<>();
        CustomDynamicArrayList<Double> list2 = new CustomDynamicArrayList<>();

        list.addAll(1,2,3,4,5);
        list.add(6);
        list.addFirst(0);
        list.addLast(7);
        list.add(3, 99);
        System.out.println(list);

        System.out.println("\n=== GET METHODS ===");
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Index 3: " + list.get(3));

        System.out.println("\n=== SIZE / CAPACITY ===");
        System.out.println("Size: " + list.size());
        System.out.println("Capacity: " + list.capacity());

        System.out.println("\n=== CONTAINS ===");
        System.out.println("Contains 99: " + list.contains(99));
        System.out.println("Contains All (0,1,2): " + list.containsAll(0,1,2));

        System.out.println("\n=== INDEX OF ===");
        System.out.println("Index of 99: " + list.indexOf(99));
        System.out.println("Last index of 5: " + list.lastIndexOf(5));

        System.out.println("\n=== SET ===");
        System.out.println("Replaced: " + list.set(100, 3));
        System.out.println(list);

        System.out.println("\n=== REMOVE METHODS ===");
        list.removeFirst();
        list.removeLast();
        list.removeByIndex(2);
        list.removeByValue(5);
        System.out.println(list);

        System.out.println("\n=== REMOVE ALL OCCURRENCES ===");
        list.addAll(3,3,3);
        list.removeAllOccurrences(3);
        System.out.println(list);

        System.out.println("\n=== REMOVE RANGE ===");
        list.addAll(10,11,12,13,14);
        list.removeRange(2,4);
        System.out.println(list);

        System.out.println("\n=== TO ARRAY ===");
        Object[] arr = list.toArray();
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();

        System.out.println("\n=== CLEAR ===");
        list.clear();
        System.out.println("Is Empty: " + list.isEmpty());
        System.out.println(list);

        System.out.println("\n=== TRIM TO SIZE ===");
        list.addAll(1,2,3,4,5);
        System.out.println("Before Trim Capacity: " + list.capacity());
        list.trimToSize();
        System.out.println("After Trim Capacity: " + list.capacity());
    }
}

