package Generics;

import java.util.ArrayList;
import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) {

        try {
            System.out.println("==== Creating List ====");
            CustomDynamicArrayList<Integer> list = new CustomDynamicArrayList<>(5);
            System.out.println(list);

            System.out.println("\n==== add() ====");
            list.add(10);
            list.add(20);
            list.add(30);
            System.out.println(list); // [10, 20, 30]

            System.out.println("\n==== addMultipleElements() ====");
            list.addAll(40, 50);
            System.out.println(list); // [10, 20, 30, 40, 50]

            System.out.println("\n==== addLast() (triggers grow) ====");
            list.addLast(60);
            System.out.println(list); // [10, 20, 30, 40, 50, 60]

            System.out.println("\n==== addFirst() ====");
            list.addFirst(5);
            System.out.println(list); // [5, 10, 20, 30, 40, 50, 60]

            System.out.println("\n==== add(index, element) ====");
            list.add(3, 25);
            System.out.println(list); // [5, 10, 20, 25, 30, 40, 50, 60]

            System.out.println("\n==== get() ====");
            System.out.println("Element at index 0: " + list.get(0)); // 5
            System.out.println("Element at index 4: " + list.get(4)); // 30

            System.out.println("\n==== contains() ====");
            System.out.println("Contains 25? " + list.contains(25)); // true
            System.out.println("Contains 99? " + list.contains(99)); // false

            System.out.println("\n==== size() ====");
            System.out.println("Size: " + list.size()); // correct count

            System.out.println("\n==== removeLast() ====");
            list.removeLast();
            System.out.println(list);

            System.out.println("\n==== removeFirst() ====");
            list.removeFirst();
            System.out.println(list);

            System.out.println("\n==== remove(index) ====");
            list.removeByIndex(2);
            System.out.println(list);

            System.out.println("\n==== Remove all elements one by one ====");
            while (!list.isEmpty()) {
                list.removeLast();
                System.out.println(list);
            }

            System.out.println("\n==== Final State ====");
            System.out.println(list);

        } catch (ArrayListException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
